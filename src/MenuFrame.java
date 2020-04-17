package Game;

import java.awt.*;
import java.io.*;

import javax.imageio.*;
import javax.swing.*;

import java.awt.event.*;


class MenuFrame extends JFrame
{
	private static final long serialVersionUID = 1L;
	public WindowMenuPanel panel = new WindowMenuPanel();
	public WindowNewGamePanel panel2 = new WindowNewGamePanel();
	public WindowUserGamePanel panel3 = new WindowUserGamePanel();
	public WinPassPanel panel4 = new WinPassPanel();
	public About panel5 = new About();
	
	public MenuFrame()
	{
		setTitle("Hamster M.D.");
		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		Toolkit kit = Toolkit.getDefaultToolkit();
		Image menuIcon = kit.getImage("C:/project/menu_icon.png");
		setIconImage(menuIcon);
		
		Dimension screenSize = kit.getScreenSize();
		int screenWidth = screenSize.width;
		int screenHeight = screenSize.height;
		setLocation(screenWidth/2-400, screenHeight/2-300);
		
		setSize(800+6, 600+28);
		setResizable(false);
		add(panel);
        
}

class WindowMenuPanel extends AbstractClass
{
	private static final long serialVersionUID = 1L;
	public WindowMenuPanel()
	{  
		
		try
		{
			
			
			buttonNewGameM = ImageIO.read(new File("./main_menu/png/buttons/button_ng_moved.png"));
			buttonUserGameM = ImageIO.read(new File("./main_menu/png/buttons/button_ug_moved.png"));
			buttonSettingsM = ImageIO.read(new File("./main_menu/png/buttons/button_st_moved.png"));
			buttonPasswordM = ImageIO.read(new File("./main_menu/png/buttons/button_ps_moved.png"));
			buttonQuitGameM = ImageIO.read(new File("./main_menu/png/buttons/button_qg_moved.png"));
			buttonAuthM = ImageIO.read(new File("./main_menu/png/buttons/button_auth_moved.png"));
			
			buttonNewGameCl = ImageIO.read(new File("./main_menu/png/buttons/button_ng_clicked.png"));
			buttonUserGameCl = ImageIO.read(new File("./main_menu/png/buttons/button_ug_clicked.png"));
			buttonSettingsCl = ImageIO.read(new File("./main_menu/png/buttons/button_st_clicked.png"));
			buttonPasswordCl = ImageIO.read(new File("./main_menu/png/buttons/button_ps_clicked.png"));
			buttonQuitGameCl = ImageIO.read(new File("./main_menu/png/buttons/button_qg_clicked.png"));
			buttonAuthCl = ImageIO.read(new File("./main_menu/png/buttons/button_auth_clicked.png"));
			
			mainHeroNG = ImageIO.read(new File("./main_hero/hamster_ng_small.png"));
			mainHeroUG = ImageIO.read(new File("./main_hero/hamster_ug_small.png"));
			mainHeroSt = ImageIO.read(new File("./main_hero/hamster_st_small.png"));
			mainHeroPs = ImageIO.read(new File("./main_hero/hamster_ps_small.png"));
			mainHeroQG = ImageIO.read(new File("./main_hero/hamster_qg_small.png"));
			mainHeroAuth = ImageIO.read(new File("./main_hero/hamster_auth_small.png"));
			mainHeroNone = ImageIO.read(new File("./main_hero/hamster_none_small.png"));
						
			ring = ImageIO.read(new File("./main_menu/png/ring.png"));
			buttons = ImageIO.read(new File("./main_menu/png/buttons/buttons_none.png"));
			
			mainMenu = ImageIO.read(new File("./main_menu/png/center_picture_usual_wh.png"));
			
			settingsMenu = ImageIO.read(new File("./settings/settings_frame.png"));
			buttonOkMoved = ImageIO.read(new File("./settings/buttons_ok_moved.png"));
			buttonOkClicked = ImageIO.read(new File("./settings/buttons_ok_clicked.png"));

			buttonSoundMoved = ImageIO.read(new File("./settings/yes_moved.png"));
			buttonSoundClicked = ImageIO.read(new File("./settings/yes.png"));
			buttonSoundNone = ImageIO.read(new File("./settings/yes_none.png"));
			
			buttonMusicMoved = ImageIO.read(new File("./settings/yes_moved.png"));
			buttonMusicClicked = ImageIO.read(new File("./settings/yes.png"));
			buttonMusicNone = ImageIO.read(new File("./settings/yes_none.png"));		
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
		gr.drawImage(mainMenu, 0, 0, null);
		gr.drawImage(mainHeroNone, 225, 225, null);
		gr.drawImage(ring, 23, 8, null);
		gr.drawImage(buttons, 0, 0, null);
				
  		if (!settings){
		if (moved && X>=439 && X<=439+329 && Y>=28 && Y<=28+44) {
			gr.drawImage(mainMenu, 0, 0, null);
			
			gr.drawImage(mainHeroNG, 225, 225, null);
			gr.drawImage(ring, 23, 8, null);
			gr.drawImage(buttons, 0, 0, null);
						
			gr.drawImage(buttonNewGameM, 439, 28, null);
				//dragged=false;
		}
		if (moved&&X>=519&&X<=567+249&&Y>=84&&Y<=84+44) {
			gr.drawImage(mainMenu, 0, 0, null);
			
			gr.drawImage(mainHeroUG, 225, 225, null);
			gr.drawImage(ring, 23, 8, null);
			gr.drawImage(buttons, 0, 0, null);
						
			gr.drawImage(buttonUserGameM, 519, 84, null);
			//dragged=false;
		}
		if (moved&&X>=568&&X<=568+200&&Y>=140&&Y<=140+44) {
			gr.drawImage(mainMenu, 0, 0, null);
			gr.drawImage(mainHeroSt, 225, 225, null);
			gr.drawImage(ring, 23, 8, null);
			gr.drawImage(buttons, 0, 0, null);
						
			gr.drawImage(buttonSettingsM, 568, 140, null);
			//dragged=false;
		}
		if (moved&&X>=597&&X<=597+171&&Y>=196&&Y<=196+44) {
			gr.drawImage(mainMenu, 0, 0, null);
			gr.drawImage(mainHeroPs, 225, 225, null);
			gr.drawImage(ring, 23, 8, null);
			gr.drawImage(buttons, 0, 0, null);
						
			gr.drawImage(buttonPasswordM, 597, 196, null);
			//dragged=false;
		}
		if (moved&&X>=622&&X<=622+146&&Y>=252&&Y<=252+44) {
			gr.drawImage(mainMenu, 0, 0, null);
			gr.drawImage(mainHeroQG, 225, 225, null);
			gr.drawImage(ring, 23, 8, null);
			gr.drawImage(buttons, 0, 0, null);
						
			gr.drawImage(buttonQuitGameM, 622, 252, null);
			//dragged=false;
		}
		if (moved&&X>=568&&X<=568+200&&Y>=528&&Y<=528+44) {
			gr.drawImage(mainMenu, 0, 0, null);
			gr.drawImage(mainHeroAuth, 225, 225, null);
			gr.drawImage(ring, 23, 8, null);
			gr.drawImage(buttons, 0, 0, null);
						
			gr.drawImage(buttonAuthM, 568, 528, null);
			//dragged=false;
		}
	
		
		
		if (clicked&&X>=439&&X<=439+329&&Y>=28&&Y<=28+44) {
			gr.drawImage(mainMenu, 0, 0, null);
			gr.drawImage(mainHeroNG, 225, 225, null);
			gr.drawImage(ring, 23, 8, null);
			gr.drawImage(buttons, 0, 0, null);
						
			gr.drawImage(buttonNewGameCl, 439, 28, null); 
			PushButton = 1;
			//dragged=false;
		}
		if (clicked&&X>=519&&X<=567+249&&Y>=84&&Y<=84+44) {
			gr.drawImage(mainMenu, 0, 0, null);
			gr.drawImage(mainHeroUG, 225, 225, null);
			gr.drawImage(ring, 23, 8, null);
			gr.drawImage(buttons, 0, 0, null);
						
			gr.drawImage(buttonUserGameCl, 519, 84, null);
			PushButton = 2;
			//dragged=false;
		}
		if (clicked&&X>=568&&X<=568+200&&Y>=140&&Y<=140+44) {
			gr.drawImage(mainMenu, 0, 0, null);
			gr.drawImage(mainHeroSt, 225, 225, null);
			gr.drawImage(ring, 23, 8, null);
			gr.drawImage(buttons, 0, 0, null);
						
			gr.drawImage(buttonSettingsCl, 568, 140, null);
			PushButton = 3;
			//dragged=false;
		}
		if (clicked&&X>=597&&X<=597+171&&Y>=196&&Y<=196+44) {
			gr.drawImage(mainMenu, 0, 0, null);
			gr.drawImage(mainHeroPs, 225, 225, null);
			gr.drawImage(ring, 23, 8, null);
			gr.drawImage(buttons, 0, 0, null);
						
			gr.drawImage(buttonPasswordCl, 597, 196, null);
			PushButton = 4;
			//dragged=false;
		}
		if (clicked&&X>=622&&X<=622+146&&Y>=252&&Y<=252+44) {
			gr.drawImage(mainMenu, 0, 0, null);
			gr.drawImage(mainHeroQG, 225, 225, null);
			gr.drawImage(ring, 23, 8, null);
			gr.drawImage(buttons, 0, 0, null);
			gr.drawImage(buttonQuitGameCl, 622, 252, null);
			PushButton = 5;
			//dragged=false;
		}
		if (clicked&&X>=568&&X<=568+200&&Y>=528&&Y<=528+44) {
			gr.drawImage(mainMenu, 0, 0, null);
			gr.drawImage(mainHeroAuth, 225, 225, null);
			gr.drawImage(ring, 23, 8, null);
			gr.drawImage(buttons, 0, 0, null);
						
			gr.drawImage(buttonAuthCl, 568, 528, null);
			PushButton = 6;
			//dragged=false;
		}
  		}
  		else{
  			gr.drawImage(settingsMenu, 0, 0, null);
  			
  			
  			if (moved&&(X>=300)&&(X<=499)&&(Y>=333)&&(Y<=376)){
  				gr.drawImage(buttonOkMoved, 300, 333, null);
  				moved=false;
  			}
  			if (moved&&(X>=280)&&(X<=332)&&(Y>=220)&&(Y<=263)){
  				gr.drawImage(buttonSoundMoved, 280, 220, null);
  				moved=false;
  			}
  			if (moved&&(X>=280)&&(X<=332)&&(Y>=269)&&(Y<=312)){
  				gr.drawImage(buttonMusicMoved, 280, 269, null);
  				moved=false;
  			}
  			

  			if (clicked&&(X>=300)&&(X<=499)&&(Y>=333)&&(Y<=376)){
  				gr.drawImage(buttonOkClicked, 300, 333, null);
  				clicked=false;
  				settings = false;
  				repaint();
  				}
  			
  			
  			if (effects_on&&clicked&&(X>=280)&&(X<=332)&&(Y>=220)&&(Y<=263)){
  				gr.drawImage(buttonSoundNone, 280, 220, null);
  				clicked=false;
  				effects_on=false;
  			}
  			if (!effects_on&&clicked&&(X>=280)&&(X<=332)&&(Y>=220)&&(Y<=263)){
  				gr.drawImage(buttonSoundClicked, 280, 220, null);
  				clicked=false;
  				effects_on=true;
  			}
  			
  			if (music_on&&clicked&&(X>=280)&&(X<=332)&&(Y>=269)&&(Y<=312)){
  				gr.drawImage(buttonMusicNone, 280, 269, null);
  				clicked=false;
  				music_on=false;
  				song1.pause();
  			}
  			if (!music_on&&clicked&&(X>=280)&&(X<=332)&&(Y>=269)&&(Y<=312)){
  				gr.drawImage(buttonMusicClicked, 280, 269, null);
  				clicked=false;
  				music_on=true;
  				song1.stop();
  				song1.play();
  			}
  			
  			if (!effects_on)
  				gr.drawImage(buttonSoundNone, 280, 220, null);
  			if (effects_on)
  				gr.drawImage(buttonSoundClicked, 280, 220, null);
  			if (!music_on)
  				gr.drawImage(buttonMusicNone, 280, 269, null);
  			if (music_on)
  				gr.drawImage(buttonMusicClicked, 280, 269, null);
  			
  		}
		clicked=false;
		moved=false;
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
	
	private Image buttonNewGameM;
	private Image buttonUserGameM;
	private Image buttonSettingsM;
	private Image buttonPasswordM;
	private Image buttonQuitGameM;
	private Image buttonAuthM;
	
	private Image buttonNewGameCl;
	private Image buttonUserGameCl;
	private Image buttonSettingsCl;
	private Image buttonPasswordCl;
	private Image buttonQuitGameCl;
	private Image buttonAuthCl;

	private Image mainHeroNone;
	private Image mainHeroNG;
	private Image mainHeroUG;
	private Image mainHeroSt;
	private Image mainHeroPs;
	private Image mainHeroQG;
	private Image mainHeroAuth;
	
	private Image settingsMenu;
	private Image buttonOkMoved;
	private Image buttonMusicMoved;
	private Image buttonMusicClicked;
	private Image buttonOkClicked;
	private Image buttonSoundMoved;
	private Image buttonSoundClicked;
	private Image buttonSoundNone;
	private Image buttonMusicNone;
	
	private Image ring;
	private Image buttons;

	private Image mainMenu;
	private int X=0;
	private int Y=0;
}
}
