package Game;

import java.awt.event.*;
import java.awt.*;
import java.io.*;
import javax.imageio.*;
import javax.swing.*;

	
	
class WinPassPanel extends JPanel
{
	public boolean ok=false;
	public boolean cancel = false;
	public String pass;
	public int incorrect=0;
	
	private static final long serialVersionUID = 1L;

	public WinPassPanel()
	{
		try
		{
			passMenu = ImageIO.read(new File("./password/png/main_window.png"));
			textFieldCl = ImageIO.read(new File("./password/png/field_for_text_click.png"));
			
			buttonCM = ImageIO.read(new File("./password/png/buttons_moved.png"));
			buttonCCl = ImageIO.read(new File("./password/png/buttons_clicked.png"));
			
			buttonRM = ImageIO.read(new File("./password/png/button_return_moved.png"));
			buttonRCl = ImageIO.read(new File("./password/png/button_return_clicked.png"));
			buttonRN = ImageIO.read(new File("./password/png/button_return_none.png"));
			
		     OkClicked = ImageIO.read(new File("./password/png/buttons_ok_clicked.png"));
			 OkMoved   = ImageIO.read(new File("./password/png/buttons_ok_moved.png"));
			 InMenu    = ImageIO.read(new File("./password/png/incorrect.png"));
			 textLight = ImageIO.read(new File("./password/png/field_for_text_click.png"));
			int j=0;
			for(int i='A'; i<'Z'+1; i++)
			{
				letter[j] = ImageIO.read(new File("./password/png/"+ ((char) i) +".png"));
				j++;
			}
		}
		catch(IOException e)
		{
			e.printStackTrace();
		}
		addMouseListener(new MouseHandler());
		addMouseMotionListener(new MouseMotionHandler());
		
		setFocusable(true);
	}
	
	public Image passMenu;
	public Image textFieldCl;
	public Image buttonCM;
	public Image buttonCCl;
	public Image buttonRM;
	public Image buttonRCl;
	public Image buttonRN;
	public Image OkClicked;
	public Image OkMoved;
	public Image InMenu ;
	public Image textLight;
	
	public Image[] letter = new Image[26];

	public void checkLetter(int d)
	{
		if ((d>=0)&&(d<=25)&& focused )
			{
			char ch = (char) ('A' + d);
			if (pass==null)
			{
				length=0;
				pass = "";
			} 
			if ((length<5))
			{
				length++;
				pass = pass + ch;
			}	
			repaint();
			}
		else if ((d==-1)&& focused )
		{
			if (length>=1)
			{
				String ps=null;
				ps=pass.substring(0, length-1);
				pass=ps;
				length--;
				repaint();
				
			}
		}

	}
	
	
	public int length;
	
	public  void  paintComponent (Graphics  gr) {
		super.paintComponent(gr);
		gr.drawImage(passMenu, 0, 0, null);
		if (pass!=null) gr.drawString(pass, 25, 25);
		else{
			tempX=0;
			tempY=0;
			length=0;
		}
		
	if (incorrect!=-1){
		
			tempX=322+(110-((length*30)/2));   
			tempY=318;
			
			for (int i=0; i<length; i++)
				{
					for (int j=0; j<26; j++)
					{
						char temp = (char) ('A'+j);
						
						if (pass.charAt(i)==temp)  //char
						{
							gr.drawImage(letter[j], tempX+i*30, tempY, null);
							continue;
							
						}
						
					}
				}
			
			
				gr.drawImage(buttonRN, 330, 464, null);
				
		if ( ((moved&&(X>=322)&&(X<=537)&&(Y>=304)&&(Y<=350)) && !focused) ){
				    gr.drawImage(textLight, 322, 304, null);
				    moved=false;
				}
				
		
		if (moved&&(X>=246)&&(X<=574)&&(Y>=404)&&(Y<=447)){
			gr.drawImage(buttonCM, 246, 404, null);
			moved=false;
		}
		
		if (moved&&(X>=330)&&(X<=501)&&(Y>=464)&&(Y<=508)){
			gr.drawImage(buttonRM, 330, 464, null);
			moved=false;
		}
	
		
		if (pressed&&(X>=322)&&(X<=537)&&(Y>=304)&&(Y<=350)){
			 focused = true;
			 pressed = false;
		}
	    if (pressed&&(X>=246)&&(X<=574)&&(Y>=404)&&(Y<=447)){
			gr.drawImage(buttonCCl, 246, 404, null);
			ok = true;
			focused = false;
			pressed=false;
		}
		if (pressed&&(X>=330)&&(X<=501)&&(Y>=464)&&(Y<=508)){
			gr.drawImage(buttonRCl, 330, 464, null);
			cancel = true;
			focused = false;
			pressed=false;
		}
		if (pressed){
			pressed = false;
			if (focused) focused = false;
		}
		if (focused) gr.drawImage(textLight, 322, 304, null); 
	}
	else {
			gr.drawImage(InMenu, 0, 0, null);
			
			if (moved&&(X>=300)&&(X<=499)&&(Y>=343)&&(Y<=386)){
				gr.drawImage(OkMoved, 300, 343, null);
				moved=false;
			}
			
			if (pressed&&(X>=300)&&(X<=499)&&(Y>=343)&&(Y<=386)){
				gr.drawImage(OkClicked, 300, 343, null);
				pressed=false;
				incorrect = 0;
				repaint();
				}
			
	}
	}
	
	private int tempX;
	private int tempY;
	
	private class MouseHandler extends MouseAdapter
	   {
		 
	      public void mousePressed(MouseEvent event)
	      {
	    	X = event.getX();
	    	Y = event.getY();
	    	pressed=true;
	    	repaint();
	      }
	    }
	 
	private class MouseMotionHandler extends MouseAdapter
	   {
	      public void mouseMoved(MouseEvent event)
	      {
	    	    X = event.getX();
		    	Y = event.getY();
		    	moved=true;
		    	repaint();	  
	      }
	   }
	
	private boolean focused;
	private boolean moved;
	private boolean pressed;
	public int X;
	public int Y;
	
  }


