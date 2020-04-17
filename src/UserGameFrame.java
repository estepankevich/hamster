package Game;

import java.awt.*;
import java.io.*;
import javax.imageio.*;
import javax.swing.*;
import java.awt.event.*;


class WindowUserGamePanel extends JPanel
{
	public boolean ok=false;
	public int[] deg = new int[4];	
	public boolean cancel=false;
	
	private static final long serialVersionUID = 1L;
	public WindowUserGamePanel()
	{  	
		try
		{
			userMenu = ImageIO.read(new File("./user_game/png/main_window.png"));
			textFieldCl = ImageIO.read(new File("./user_game/png/field_for_text_click.png"));
			
			buttonOkNone = ImageIO.read(new File("./user_game/png/buttons_ok_none.png"));
			buttonOkMoved = ImageIO.read(new File("./user_game/png/buttons_ok_moved.png"));
			buttonOkClicked = ImageIO.read(new File("./user_game/png/buttons_ok_clicked.png"));

			buttonCancelNone = ImageIO.read(new File("./user_game/png/buttons_cancel_none.png"));
			buttonCancelMoved = ImageIO.read(new File("./user_game/png/buttons_cancel_moved.png"));
			buttonCancelClicked = ImageIO.read(new File("./user_game/png/buttons_cancel_clicked.png"));
			
			for(int i=0; i<10; i++)
			{
				digit[i] = ImageIO.read(new File("./user_game/png/digit_"+i+".png"));
			}
		}
		catch (IOException e)
		{
			e.printStackTrace();
		}
		addMouseListener(new MouseHandler());
		addMouseMotionListener(new MouseMotionHandler());
		}
	public void checkDigit(int d)
	{
		
		
			for (int i=0; i<10; i++)
			{
				if (d==i) pressed[i]=true;
			}
			if ((d>=0)&&(d<=9))
			{
				for (int k=0; k<4; k++)
					if (inputs[k] && deg[k]<=(k==0?99:999)) deg[k] = deg[k]*10 + d;	
			}
			
			
			
		
		 if (d==-1)
			{	
				for (int k=0; k<4; k++)
					if (inputs[k]) deg[k] = deg[k]/10;	
			}
		 repaint();
	}
	
	public  void  paintComponent (Graphics  gr) {
		super.paintComponent(gr);
		gr.drawImage(userMenu, 0, 0, null);
		
		gr.drawImage(buttonOkNone, 170, 530, null);
		gr.drawImage(buttonCancelNone, 425, 530, null);
		
		
		if (clicked){
			
			if ( (inputs[0] && ((X<=717)&&(X>=544)&&(Y<=180)&&(Y>=128))) ||
			     (inputs[1] && ((X<=717)&&(X>=544)&&(Y<=277)&&(Y>=225))) ||
			     (inputs[2] && ((X<=717)&&(X>=544)&&(Y<=370)&&(Y>=318))) ||
			     (inputs[3] && ((X<=717)&&(X>=544)&&(Y<=486)&&(Y>=434)))) {
				clicked = false;
				choose = true;
			}
			else if( ((X<=717)&&(X>=544)&&(Y<=180)&&(Y>=128)) || ((X<=717)&&(X>=544)&&(Y<=277)&&(Y>=225)) || 
					((X<=717)&&(X>=544)&&(Y<=370)&&(Y>=318)) ||  ((X<=717)&&(X>=544)&&(Y<=486)&&(Y>=434)))
			{ 
				for (int h=0;h<4;h++) inputs[h]=false;	
				if ((X<=717)&&(X>=544)&&(Y<=180)&&(Y>=128))	{
					inputs[0] = true;
					choose = true;
				}
				if ((X<=717)&&(X>=544)&&(Y<=277)&&(Y>=225)) {
					inputs[1] = true;
					choose = true;
				}
				if ((X<=717)&&(X>=544)&&(Y<=370)&&(Y>=318)) {
					inputs[2] = true;
					choose = true;
				}
				if ((X<=717)&&(X>=544)&&(Y<=486)&&(Y>=434)) {
					inputs[3] = true;
					choose = true;
				}
				clicked = false;
			}
			
			else if ( !((X>=170)&&(X<=370)&&(Y>=530)&&(Y<=574)) && !((X>=425)&&(X<=625)&&(Y>=530)&&(Y<=574)))
			{ 
				for (int h=0;h<4;h++) inputs[h]=false;
				clicked = false;
				choose = false;
			}
			
		}
		if (!choose) for (int h=0;h<4;h++) inputs[h]=false;
		if (!inputs[0] && !inputs[1] && !inputs[2] && !inputs[3] && moved && !choose){
			
			if ((X<=717)&&(X>=544)&&(Y<=180)&&(Y>=128))	inputs[0] = true;
			if ((X<=717)&&(X>=544)&&(Y<=277)&&(Y>=225)) inputs[1] = true;
			if ((X<=717)&&(X>=544)&&(Y<=370)&&(Y>=318)) inputs[2] = true;
			if ((X<=717)&&(X>=544)&&(Y<=486)&&(Y>=434)) inputs[3] = true;
			if (inputs[0] || inputs[1] || inputs[2] || inputs[3]) moved = false;
		}
		if (inputs[0]) gr.drawImage(textFieldCl, 544, 128, null);
		if (inputs[1]) gr.drawImage(textFieldCl, 544, 225, null);
		if (inputs[2]) gr.drawImage(textFieldCl, 544, 318, null);
		if (inputs[3]) gr.drawImage(textFieldCl, 544, 434, null);
		if(!choose) for(int j=0;j<4;j++) inputs[j]=false;
		
		if (moved&&(X>=170)&&(X<=370)&&(Y>=530)&&(Y<=574)){
			gr.drawImage(buttonOkMoved, 170, 530, null);
			moved=false;
		}
		if (moved&&(X>=425)&&(X<=625)&&(Y>=530)&&(Y<=574)){
			gr.drawImage(buttonCancelMoved, 425, 530, null);
			moved=false;
		}
		

		if (clicked&&(X>=170)&&(X<=370)&&(Y>=530)&&(Y<=574)){
			gr.drawImage(buttonOkClicked, 170, 530, null);
			clicked=false;
			ok = true;
			for(int j=0;j<4;j++) inputs[j]=false;
//			for (int k=0; k<4; k++)
//			System.out.println(deg[k]);
		}
		if (clicked&&(X>=425)&&(X<=625)&&(Y>=530)&&(Y<=574)){
			gr.drawImage(buttonCancelClicked, 425, 530, null);
			cancel = true;
			for(int j=0;j<4;j++) inputs[j]=false;
			clicked=false;
		}
		
		int temp=0;
        for (int i=0; i<4; i++)
		degNum[i]=0;
		for (int i=0; i<4; i++)
		{
			temp=deg[i];
			while (temp>0)
			{
				temp=temp/10;
				degNum[i]++;
			}	
		}
		
		
		int widthL = 27;
		for (int i=0; i<4; i++)
		{
			tempX[i]=545+(174/2 - (widthL*degNum[i])/2);
			tempY[0]=141;
			tempY[1]=237;
			tempY[2]=330;
			tempY[3]=446;
			
			temp=deg[i];
			for (int j=0; j<degNum[i]; j++)
			{
				
				rest[i]=temp%(10);
				temp=temp/(10);
				
				switch (rest[i]) {
				
				  case 1: if (!full[i])
				        gr.drawImage(digit[1], tempX[i]+degNum[i]*widthL-(j+1)*widthL, tempY[i], null);
				        break;
				  case 2: if (!full[i])
					  	gr.drawImage(digit[2], tempX[i]+degNum[i]*widthL-(j+1)*widthL, tempY[i], null);
					  	break;
				  case 3: if (!full[i])
					  	gr.drawImage(digit[3], tempX[i]+degNum[i]*widthL-(j+1)*widthL, tempY[i], null);
					  	break;
				  case 4: if (!full[i])
					  	gr.drawImage(digit[4], tempX[i]+degNum[i]*widthL-(j+1)*widthL, tempY[i], null);
					  	break;
				  case 5: if (!full[i])
					  	gr.drawImage(digit[5], tempX[i]+degNum[i]*widthL-(j+1)*widthL, tempY[i], null);
					  	break;
				  case 6: if (!full[i])
					  	gr.drawImage(digit[6], tempX[i]+degNum[i]*widthL-(j+1)*widthL, tempY[i], null);
					  	break;
				  case 7: if (!full[i])
					  	gr.drawImage(digit[7], tempX[i]+degNum[i]*widthL-(j+1)*widthL, tempY[i], null);
					  	break;
				  case 8: if (!full[i])
					  	gr.drawImage(digit[8], tempX[i]+degNum[i]*widthL-(j+1)*widthL, tempY[i], null);
					  	break;
				  case 9: if (!full[i])
					  	gr.drawImage(digit[9], tempX[i]+degNum[i]*widthL-(j+1)*widthL, tempY[i], null);
					  	break;
				  case 0: if (!full[i])
					  	gr.drawImage(digit[0], tempX[i]+degNum[i]*widthL-(j+1)*widthL, tempY[i], null);
					  	break;
				  default:

					  	break;
				}
				
			}
		
		}
	}
	
	private int[] degNum = new int[5];
	
	private int[] rest = new int[4];
	
	private boolean[] pressed = new boolean[10];
	
	private class MouseHandler extends MouseAdapter
	   {
		 
	      public void mousePressed(MouseEvent event)
	      {
	    	if (event.getButton()==1){
	    	X=event.getX();
	    	Y=event.getY();
	    	clicked=true;
	    	repaint();
	    	}
	      }
	   }
	 
	private class MouseMotionHandler extends MouseAdapter
	   {
	      public void mouseMoved(MouseEvent event)
	      {
	    		X=event.getX();
		    	Y=event.getY();
		    	moved=true;
		    	repaint();
		    
	      }
	   }
	public boolean[] inputs = new boolean[4];	
	private boolean[] full = new boolean[4];
	private boolean moved;
	private boolean clicked;
	private boolean choose=false;
	private Image textFieldCl;
	private Image userMenu;
	private Image buttonOkNone;
	private Image buttonOkMoved;
	private Image buttonOkClicked;
	private Image buttonCancelNone;
	private Image buttonCancelMoved;
	private Image buttonCancelClicked;

	private Image[] digit = new Image[10];
	
	private int[] tempX = new int[4];
	private int[] tempY = new int[4];
	
	private int X;
	private int Y;
}
