package Game;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.util.*;
public class Main extends AbstractClass {
	private static final long serialVersionUID = 1L;
	private static int index=0;
		public static void main(String[] args){
		Timer      timer1 = new java.util.Timer();
		TimerTask  TaimerAndMusicTask = new TimerTask(){
			public  void run(){
			     index++;
				 is_go = true;
				 if( (index-1)%107 ==0 && music_on ) {
					 song1.stop();
					 song1.play(); 
					}
				}
			};
       timer1.schedule (TaimerAndMusicTask, 1000, 1000);

	  
	
       MenuFrame.addKeyListener(new KeyListener(){
			public void keyPressed(KeyEvent event)
			{  
				int keyCode = event.getKeyCode();
				System.out.println(keyCode);
				if(PanelActive==1 || PanelActive==0){
				switch (keyCode){
				case (KeyEvent.VK_UP):
				  case(KeyEvent.VK_W):
					direction = 1;
					MenuFrame.repaint();
					break;
				
				case (KeyEvent.VK_RIGHT):
				  case(KeyEvent.VK_D):
					direction = 2;
					MenuFrame.repaint();
					break;
			
				case (KeyEvent.VK_DOWN):
				  case(KeyEvent.VK_S):
					direction = 3;
					MenuFrame.repaint();
					break;
				case (KeyEvent.VK_LEFT):
			    	case(KeyEvent.VK_A):
					direction = 4;
					MenuFrame.repaint();
					break;
				case (KeyEvent.VK_ESCAPE):
			    if (ESC) ESC = false;
				else ESC = true;
				if (settings) settings = false;
				MenuFrame.repaint();
	        break;
				}
				}
				if(PanelActive==2){
	    
	      
				if ( keyCode == KeyEvent.VK_SPACE  ){
					
					if (MenuFrame.panel3.inputs[3]){
						MenuFrame.panel3.inputs[3]=false;
						MenuFrame.panel3.inputs[0]=true;
						MenuFrame.repaint();
					}
					else
					for (int i=0; i<3;i++) if (MenuFrame.panel3.inputs[i]){
						System.out.println("   " + i + "");
						MenuFrame.panel3.inputs[i]=false;
						MenuFrame.panel3.inputs[i+1]=true;
						MenuFrame.repaint();
						break;
						}
					
				}
				
				for (int i=0; i<10; i++)
					if (keyCode == KeyEvent.VK_0 + i) MenuFrame.panel3.checkDigit(i);
				    if (keyCode == KeyEvent.VK_BACK_SPACE) MenuFrame.panel3.checkDigit(-1);
			}
			if(PanelActive==4){
			  for (int j=0; j<26; j++)
				{
					if (keyCode == (65+j)) {
						MenuFrame.panel4.checkLetter(j);
					}
				}
				
				if (keyCode == KeyEvent.VK_BACK_SPACE) 
					{
					MenuFrame.panel4.checkLetter(-1);
						}
				}
			}

			@Override
			public void keyReleased(KeyEvent arg0) {
				// TODO Auto-generated method stub
				
			}

			@Override
			public void keyTyped(KeyEvent arg0) {
				// TODO Auto-generated method stub
				
			}
		}
		);
	
	  while(true){
	    	  while (PushButton>=0) func();
	    	  try  {
					Thread.sleep(50);
				 } catch (InterruptedException e) { }
				}	
		}
	}



	

	
	
	
	
		


