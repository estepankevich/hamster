package Game;
import javax.swing.JPanel;


public class AbstractClass extends JPanel {
	
	private static final long serialVersionUID = 1L;
	public static int MINA = 10;
	public static int NUT = 20;
	public static int LETTER1 = 30;
	public static int LETTER2 = 40;
	public static int LETTER3 = 50;
	public static int LETTER4 = 60;
	public static int LETTER5 = 70;
	public static int ARMOR = 90;
	public static int CURRENT_POSITION = 1000;
	public static int HOUSE = 100;
	public static int OPEN = 0;
	public static int CLOSE = 1;
	public static int POINT = -1;
	public static int QUESTION = -2;
	public static int X0=1000, Y0=1000; 
	public static int x_=0, y_=0;
	public static int HamWay = 0;
	public static int UP = 0;
	public static int RIGHT = 0;
	public static int DOWN = 0;
	public static int LEFT = 0;
	public static boolean GameOver = false;
	public static boolean ESC = false;
	public static boolean yes=false;
	public static boolean music_on=true, effects_on=true;
	public static boolean Win = false;
	public static int direction = 0;
	public static boolean is_go = false;
	public static boolean mainmenu = false;
	public static boolean settings = false;
	public static boolean backgame = false;
	public static int PanelActive =-1;
	public static int PushButton = 0;
	public static int animation_time=-1;
	static Play song1 = new Play("./sound/enotik From Mp35.wav"); 
	static Play song2 = new Play("./sound/REGISTER.wav");   
	static Play song3 = new Play("./sound/bomb2_16bitMono.wav"); 
    static Play song4 = new Play("./sound/NEWBANK.wav");
    public static Matrix MainMatrix = new Matrix(); 
    public static String strings[] = {"JSKYF","GSUME","CBISM", "ISDAO", "MFKNP", "VFPUS", "JINZY", "HXGBG", "HUNJK",
    	"GVOPU", "HOUOI", "JPQYF", "CDOAA", "JYRLB", "FSJWJ", "DDVCF"};
    public static MenuFrame MenuFrame = new MenuFrame();
    
   
    
  
     
    
    	public static void func(){
		
    	switch(PushButton){
    	case 0:  
    		PanelActive=0;
    		MenuFrame.add(MenuFrame.panel);
    		MenuFrame.setVisible(true);
    		MenuFrame.repaint();
			     while (PushButton == 0){	
    		 			try{
    		 				Thread.sleep(50);
					} catch (InterruptedException ex){};
				}
    		   break;
    		   
         case 1:
        	 PanelActive=1;
        	 x_=0; y_=0;
        	 if(!MainMatrix.IsSet){
            MainMatrix.SetByPassword("JSKYF");
            }
        	MainMatrix.health_level = 1;
        	MainMatrix.nutes_taken = 0;
        	MainMatrix.IsSet = false;
    		X0=MainMatrix.horiz/2+1; 
    		Y0=MainMatrix.vert/2-8;
    		MainMatrix.coordinate_vert=1000;
    		MainMatrix.coordinate_horiz=1000;
    		MenuFrame.remove(MenuFrame.panel); 
    		MenuFrame.remove(MenuFrame.panel2);
    		HamWay = 0;
    		MenuFrame.panel2 = new WindowNewGamePanel();
    		MenuFrame.add(MenuFrame.panel2);
    		MenuFrame.setVisible(true);
    		MenuFrame.panel2.repaint();
    		PushButton = -1;
    		break;
    	case 2:
    		PanelActive=2;
    		MainMatrix.levelNumber=0;
    		MenuFrame.remove(MenuFrame.panel); 
    		MenuFrame.remove(MenuFrame.panel2); 
    		MenuFrame.add(MenuFrame.panel3);
    	    MenuFrame.setVisible(true);
    		for(int j=0;j<4;j++) MenuFrame.panel3.deg[j]=0;
    		while ( !MenuFrame.panel3.ok && !MenuFrame.panel3.cancel){
    			try{
    				Thread.sleep(50);
    			} catch (InterruptedException ex){};
    		};
    		
    		if (MenuFrame.panel3.cancel) {
    			MenuFrame.panel3.cancel=false;
    			MenuFrame.remove(MenuFrame.panel3);
    			PushButton = 0;
    	    		break;
    	    		}
    		if (MenuFrame.panel3.ok){
    			MenuFrame.panel3.ok=false;
    		MainMatrix.setElements(MenuFrame.panel3.deg[0], MenuFrame.panel3.deg[0], MenuFrame.panel3.deg[1],
    				MenuFrame.panel3.deg[2], 5, MenuFrame.panel3.deg[3]);
    		MainMatrix.IsSet=true;
    		MenuFrame.remove(MenuFrame.panel3);
    	    PushButton = 1;
    		break;
    		}
    	case 3:
    		PanelActive=3;
    		settings = true;
    		MenuFrame.repaint();
    		PushButton = -1;
    		break;
    	case 4: 
    		PanelActive=4;
    		MenuFrame.panel4.pass=new String();
    		MenuFrame.panel4.pass=null;
    		MenuFrame.remove(MenuFrame.panel);
    		MenuFrame.add(MenuFrame.panel4);
    		MenuFrame.setVisible(true);
    		MenuFrame.repaint();
            while ( !MenuFrame.panel4.ok && !MenuFrame.panel4.cancel){
    			try{
    				Thread.sleep(50);
    			} catch (InterruptedException ex){};
    		};
    		if (MenuFrame.panel4.cancel) {
    			MenuFrame.remove(MenuFrame.panel4);
    			MenuFrame.panel4.cancel=false;
    			PushButton = 0;
    	    		break;
    	    		}
    		if (MenuFrame.panel4.ok){
    			MenuFrame.panel4.ok=false;
    			MenuFrame.panel4.incorrect = 0;
    			for (int i=0;i<16;i++) if( strings[i].equals(MenuFrame.panel4.pass) && MenuFrame.panel4.incorrect == 0) 
    				MenuFrame.panel4.incorrect = 1; 
    		//System.out.println("incorrect = " + MenuFrame.panel4.incorrect);
    		if(MenuFrame.panel4.incorrect==1){
    			MainMatrix.SetByPassword(MenuFrame.panel4.pass);
        		MainMatrix.IsSet=true; 
        		MenuFrame.remove(MenuFrame.panel4);
        		PushButton = 1;
        	    break;
        		}
    		 
    		else {
    			MenuFrame.panel4.incorrect=-1;
    			MenuFrame.repaint();
    			//System.out.println (MenuFrame.panel4.incorrect);
    			while ( MenuFrame.panel4.incorrect == -1){
        			try{
        				Thread.sleep(50);
        			} catch (InterruptedException ex){};
        		};
                PushButton = 4;
    			break;
    		}
    		}
    	case 5: 
    		
    	System.exit(0);
    	break;
    	case 6:
    		MenuFrame.remove(MenuFrame.panel);
    		MenuFrame.add(MenuFrame.panel5);
    		MenuFrame.setVisible(true);
    		PushButton = -1;
    	}
    	
    	}
}
