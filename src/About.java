package Game;

import java.awt.Graphics;
import java.awt.Image;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.io.File;
import java.io.IOException;
import javax.imageio.ImageIO;


class About extends AbstractClass
{
	private static final long serialVersionUID = 1L;
	public About()
	{  
		
		try
		{
			
			
			About = ImageIO.read(new File("./author.png"));
			buttonQuitGameM = ImageIO.read(new File("./main_menu/png/buttons/button_qg_moved.png"));
			buttonQuitGameCl = ImageIO.read(new File("./main_menu/png/buttons/button_qg_clicked.png"));
			
		}
		catch (IOException e)
		{
			e.printStackTrace();
		}
		
		addMouseListener(new MouseHandler());
		addMouseMotionListener(new MouseMotionHandler());
	
	}
	  public  void  paintComponent (Graphics  gr) {
		super.paintComponent(gr);
		gr.drawImage(About, 0, 0, null);
		
		if (moved&&X>=612&&X<=757&&Y>=507&&Y<=550) {
			gr.drawImage(buttonQuitGameM, 612, 507, null);
			moved = false;
			
		}
		if (clicked&&X>=612&&X<=757&&Y>=507&&Y<=550) {
			gr.drawImage(buttonQuitGameCl, 612, 507, null);
			clicked = false;
			MenuFrame.remove(MenuFrame.panel5);
			PushButton = 0;
			}
		else clicked = false;
	  }
	 
	class MouseHandler extends MouseAdapter
	   {
		 
	      public void mouseReleased(MouseEvent event)
	      {
	    	if (event.getButton()==1){
	    	X=event.getX();
	    	Y=event.getY();
	    	clicked=true;
	    	repaint();
	    	}
	      }
	   }
	 
	 class MouseMotionHandler extends MouseAdapter
	   {
	      public void mouseMoved(MouseEvent event)
	      {
	    	X=event.getX();
	    	Y=event.getY();
	    	moved=true;
	    	repaint();
	      }
	   }
	
	private boolean moved;
	private boolean clicked;
	
	
	private Image buttonQuitGameM;
	private Image buttonQuitGameCl;
	
   
	private Image About;
	private int X=0;
	private int Y=0;
	  
}
