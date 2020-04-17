package Game;

import java.awt.*;
import java.io.*;
import java.util.Random;

import javax.imageio.*;


import java.awt.event.*;


class WindowNewGamePanel extends AbstractClass 
{
	
	public WindowNewGamePanel() 
	{  
		
		try
		{
            tempMenu = ImageIO.read(new File("./temp_menu/temp_menu.png"));
			buttonMenuMoved = ImageIO.read(new File("./temp_menu/button_main_menu_moved.png"));
			buttonMenuClicked = ImageIO.read(new File("./temp_menu/button_main_menu_clicked.png"));
			buttonSettingsMoved = ImageIO.read(new File("./temp_menu/button_st_moved.png"));
			buttonSettingsClicked = ImageIO.read(new File("./temp_menu/button_st_clicked.png"));
		    buttonReturnMoved = ImageIO.read(new File("./temp_menu/button_return_moved.png"));
			buttonReturnClicked = ImageIO.read(new File("./temp_menu/button_return_clicked.png"));
			heroIcon = ImageIO.read(new File("./game/hero_icon.png"));
			gameOverMenu = ImageIO.read(new File("./game_over_frame/game_over_frame.png"));
			buttonOkMoved2 = ImageIO.read(new File("./game_over_frame/buttons_ok_moved.png"));
			buttonOkClicked2 = ImageIO.read(new File("./game_over_frame/buttons_ok_clicked.png"));
			minus = ImageIO.read(new File("./game/png/letters/-.png"));
			mainMenu = ImageIO.read(new File("./game/png/values.png"));
			tileMeadow = ImageIO.read(new File("./game/png/tile_meadow_1.png"));
			tileNut = ImageIO.read(new File("./game/png/tile_nut.png"));
			tileArmor = ImageIO.read(new File("./game/png/tile_head.png"));
			tileNone = ImageIO.read(new File("./game/png/tile_none_1.png"));
			tileNone2 = ImageIO.read(new File("./game/meadow.png"));
			tileLetter = ImageIO.read(new File("./game/png/tile_letter.png"));
			tileHouse = ImageIO.read(new File("./game/png/house.png"));
			tileFlag = ImageIO.read(new File("./game/png/flag.png"));
			
			int j=0;
			for(int i='A'; i<'Z'+1; i++)
			{
				letter[j] = ImageIO.read(new File("./game/png/letters/"+ ((char) i) +".png"));
				j++;
			}
			
			
			
			for (int i=0; i<10; i++)
			{
				digits[i] = ImageIO.read(new File("./game/png/digits/"+ i +".png"));
			}
			
			for (int i=0; i<6; i++)
			{
				tile[i] = ImageIO.read(new File("./game/png/tile"+ ((int)(i+1)) +".png"));
			}
		
			tileMine = ImageIO.read(new File("./game/png/tile_mine.png"));
			tileQuestion = ImageIO.read(new File("./game/png/tile_question.png"));
			
			settingsMenu = ImageIO.read(new File("./settings/settings_frame.png"));
			buttonOkMoved = ImageIO.read(new File("./settings/buttons_ok_moved.png"));
			buttonOkClicked = ImageIO.read(new File("./settings/buttons_ok_clicked.png"));

			buttonSoundMoved = ImageIO.read(new File("./settings/yes_moved.png"));
			buttonSoundClicked = ImageIO.read(new File("./settings/yes.png"));
			buttonSoundNone = ImageIO.read(new File("./settings/yes_none.png"));
			
			buttonMusicMoved = ImageIO.read(new File("./settings/yes_moved.png"));
			buttonMusicClicked = ImageIO.read(new File("./settings/yes.png"));
			buttonMusicNone = ImageIO.read(new File("./settings/yes_none.png"));
			
			for (int i=0; i<10; i++)
			{
				boom[i] = ImageIO.read(new File("./main_hero/anim/byshch"+ i +".png"));
				boom2[i] = ImageIO.read(new File("./main_hero/anim/byshchch"+ i +".png"));
			}
			    congratulateMenu = ImageIO.read(new File("./win_frame/win_frame.png"));
			
			for (int i=0;i<13;i++){
				ham_down[i] = ImageIO.read(new File("./main_hero/anim/ham_d"+ i +".png"));
			}
			for (int i=0;i<13;i++){
				ham_left[i] = ImageIO.read(new File("./main_hero/anim/ham_l"+ i +".png"));
			}
			for (int i=1;i<9;i++){
		        ham_right[i-1] = ImageIO.read(new File("./main_hero/anim/ham_r"+ i +".png"));
			}
			for (int i=0;i<9;i++){
		        ham_up[i] = ImageIO.read(new File("./main_hero/anim/ham_u"+ i +".png"));
				}
			if (HamWay==3 || HamWay==0) tileHam = ham_down[0];
			if (HamWay==4) tileHam = ham_left[0];
			if (HamWay==1) tileHam = ham_up[0];
			if (HamWay==2) tileHam = ham_right[0];
			
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
	    int temp=1;
	    CoordConversion coordconversion = new CoordConversion();
	    int i2=-1, j2 =-1;
	    if (!ESC && !settings){
	    
	    Analys T = new Analys();
	    Analys.M temp2;
	    if ((clicked && !yes) || right_clicked || (direction>0) ){
	    		
	    		  if (direction>0){
	    			  clicked = true;
	    			  is_go = false;
	    			  switch (direction){
	    			  case 1: y_= MainMatrix.coordinate_horiz - 1;
	    			          x_= MainMatrix.coordinate_vert;
	    			          break;
	    			  case 2: y_= MainMatrix.coordinate_horiz;
	    				  	  x_= MainMatrix.coordinate_vert + 1;
	    			          break;
	    			  case 3: y_= MainMatrix.coordinate_horiz + 1;
	    			  		  x_= MainMatrix.coordinate_vert;
	    			          break;
	    			  case 4: y_= MainMatrix.coordinate_horiz;
	    			  		  x_= MainMatrix.coordinate_vert - 1;
	    			          break;
	    			  }
	    			  direction=0;
	    		  	   }
	    		  else{
	    			  	coordconversion.CoordConversionFunc(X,Y,X0,Y0);
	    			  	x_ = coordconversion.XInMatrix;
	    			  	y_ = coordconversion.YInMatrix;
		    	  	   }
		          if(x_<MainMatrix.vert && x_>=0 && y_<MainMatrix.horiz && y_>=0) exist=true;
		          else exist=false;
		        	 
		    	 //System.out.println("x= " + x_ + " " + y_);
	    			
	    	}
	    	
	    	if (clicked && MainMatrix.coordinate_vert==1001 && MainMatrix.coordinate_horiz==1001 && exist) {
                  MainMatrix.setPlayerCoordinates(x_, y_);
		    	  MainMatrix.MatrixGenerate();
		    	  MainMatrix.MatrixCellOpen(x_, y_);
		    	  MainMatrix.GetCurrentPosition();
		    	  (new Thread (new Runnable(){
		  			   public void run(){
		  				   try{
		  				   Thread.sleep(300);
		  				   } catch (InterruptedException ex){};
		  				 if (X0<4) X0=4;
		  		       if (X0>(MainMatrix.vert-2)) X0=MainMatrix.vert-2; 
		  		    	  
		  		       Y0=MainMatrix.coordinate_horiz -8;
		  		       if (Y0<-6) Y0=-6;
		  		       if (Y0>MainMatrix.horiz-11) Y0=MainMatrix.horiz-11;
						 repaint();
		  			   
		  		   }
		  		    } )).start();
		    	  clicked = false;
		    	}
	    	
	    	else if (!clicked && !right_clicked && !moved && MainMatrix.coordinate_vert==1000 && MainMatrix.coordinate_horiz==1000){
	    		MainMatrix.coordinate_vert=1001;
	    		MainMatrix.coordinate_horiz=1001;
	    		}
	    	     
	    	 
	    	     if (moved) moved = false;
	    		 if(right_clicked==true){
	    			 right_clicked=false;
	    			 if (exist && MainMatrix.coordinate_horiz!=1001 && MainMatrix.coordinate_vert!=1001  ) {
	    				 MainMatrix.MatrixMinePoint(x_,y_);
	    			 }
	    		 }
	    		 if (!exist) clicked = false;
	    		 if (clicked==true && exist) { 
	    		 if ( (MainMatrix.coordinate_vert!=x_ || MainMatrix.coordinate_horiz!=y_) && HamWay==0 )
	    	  {
	    	  
	    	  MainMatrix.GetCurrentPosition(); 
	    	  int x1=0,y1=0;
	    	  T.SetMatrix(MainMatrix.matrix2(), MainMatrix.vert, MainMatrix.horiz, MainMatrix.coordinate_vert, MainMatrix.coordinate_horiz, x_, y_);
	    	  
	    	  if(MainMatrix.coordinate_horiz<1000 && MainMatrix.coordinate_vert<1000){
	    	  temp2 = T.labirint();		 
	    								
	    	   x1 = temp2.getVert();
	    	   y1 = temp2.getHoriz();
	    	  }
	    	  else {
	    		  MainMatrix.coordinate_horiz=1001;
	    		  MainMatrix.coordinate_vert=1001;
	    		  repaint();
	    		 }
	    	   if (x1==MainMatrix.coordinate_vert && y1==MainMatrix.coordinate_horiz ){
	    		   clicked=false;
	    		   yes=false;
	    	   }
	    	   else{
//	    		   if(MainMatrix.matrix[x1][y1]/10==10) HamWay=0;
//	    		   else{
	    	   if(x1==(MainMatrix.coordinate_vert-1)) HamWay = 2;
	    	   if(y1==(MainMatrix.coordinate_horiz-1)) HamWay = 3;
	    	   if(x1==(MainMatrix.coordinate_vert+1)) HamWay = 4;
	       	   if(y1==(MainMatrix.coordinate_horiz+1)) HamWay = 1;
	    		  // }
	    	   
	    	   T.setEnter(x1, y1);
	    	  
	    	   MainMatrix.matrix[MainMatrix.coordinate_vert][MainMatrix.coordinate_horiz]-=1000;
	    	   if(effects_on){
	    	   song2.stop();
	    	   song2.play();
	    	   }
	    	   MainMatrix.MatrixBoxOpen(x1, y1);
	    	   MainMatrix.MatrixCellOpen(x1, y1);
	    	   MainMatrix.matrix[x1][y1]+=1000;
	    	   MainMatrix.GetCurrentPosition();
	    	   X0=MainMatrix.coordinate_vert+1; 
		       if (X0<4) X0=4;
		       if (X0>(MainMatrix.vert-2)) X0=MainMatrix.vert-2; 
		    	  
		       Y0=MainMatrix.coordinate_horiz -8;
		       if (Y0<-6) Y0=-6;
		       if (Y0>MainMatrix.horiz-11) Y0=MainMatrix.horiz-11;
		       yes=true;

    	   }
		      
		       }
	    	  else if(HamWay==0) {
	    		  clicked=false;
	    		  yes=false;
	    	  }
	    	}
	    
	    }
	
	    if (HamWay==1) tileHam = ham_down[0];
		if (HamWay==2) tileHam = ham_left[0];
		if (HamWay==3) tileHam = ham_up[0];
		if (HamWay==4) tileHam = ham_right[0];
		
	   int i1=-1,j1=-1;
	   int rand=0;
	   
	   if (MainMatrix.bang){
		   Random random = new Random();
		   rand=Math.abs(random.nextInt())%15;
		   if(rand%2==0) rand*=-1;
	   }
	   else rand = 0;
	   
	   for(int i=0; i<9; i++)
		{
			for(int j=0; j<23; j++)
			 {
				
				coordconversion.ItoX(i, j, X0, Y0);
				if    (coordconversion.XInMatrix>=0 && coordconversion.XInMatrix<MainMatrix.horiz
					   && coordconversion.YInMatrix>=0 && coordconversion.YInMatrix<MainMatrix.vert &&
					   MainMatrix.matrix2()[coordconversion.XInMatrix][coordconversion.YInMatrix]!=0)
					switch(MainMatrix.matrix2()[coordconversion.XInMatrix][coordconversion.YInMatrix]){
					case 1: gr.drawImage(tileMeadow, 150+48*(j%2)+i*96 + rand, -32+32*(j%2)+(j/2)*64 + rand, null);
					        break;
					case -1: gr.drawImage(tileFlag, 150+48*(j%2)+i*96 + rand, -32+32*(j%2)+(j/2)*64 + rand, null);
					         break;
					case -2: gr.drawImage(tileQuestion, 150+48*(j%2)+i*96 + rand, -32+32*(j%2)+(j/2)*64 + rand, null);
					          break;
					}
				else{
				    
					if(coordconversion.XInMatrix>=0 && coordconversion.XInMatrix<MainMatrix.horiz
					&& coordconversion.YInMatrix>=0 && coordconversion.YInMatrix<MainMatrix.vert)
					temp=MainMatrix.matrix()[coordconversion.XInMatrix][coordconversion.YInMatrix];
			 		else temp = -1;
					
					if (temp%10!=0 && temp>0)
				 	gr.drawImage(tile[temp%10-1], 150+48*(j%2)+i*96 + rand, -32+32*(j%2)+(j/2)*64 + rand, null);
					else if (temp==-1) gr.drawImage(tileNone2, 150+48*(j%2)+i*96 + rand, -32+32*(j%2)+(j/2)*64 + rand, null);
					
					if (temp==0) gr.drawImage(tileNone, 150+48*(j%2)+i*96 + rand, -32+32*(j%2)+(j/2)*64 + rand, null);
				 
					switch (temp/10)
					{
						case 1: 
							gr.drawImage(tileMine, 150+48*(j%2)+i*96 + rand, -32+32*(j%2)+(j/2)*64 + rand, null);
								break;
						case 2:  
							    gr.drawImage(tileNut, 150+48*(j%2)+i*96 + rand, -32+32*(j%2)+(j/2)*64 + rand, null);
								break;
						case 3: 
							case 4: 
								case 5: 
									case 6: 
										case 7: 
											gr.drawImage(tileLetter, 150+48*(j%2)+i*96 + rand, -32+32*(j%2)+(j/2)*64 + rand, null);
								break;
						case 9: 
							gr.drawImage(tileArmor, 150+48*(j%2)+i*96 + rand, -32+32*(j%2)+(j/2)*64 + rand, null);
								break;
						case 100:
							i2 = i;
							j2 = j;
							 if(temp%10==0)
									gr.drawImage(tileNone, 150+48*(j%2)+i*96 + rand, -32+32*(j%2)+(j/2)*64 + rand, null);
							if(HamWay==0) gr.drawImage(tileHam, 150+48*(j%2)+i*96 + rand, -32+32*(j%2)+(j/2)*64 + rand, null);
						     break;
						 case 10:
							 if(temp%10==0)
									gr.drawImage(tileNone, 150+48*(j%2)+i*96 + rand, -32+32*(j%2)+(j/2)*64 + rand, null);
							       
									i1=i;
									j1=j;
						   break;
						 case 110:
							if(temp%10==0) gr.drawImage(tileNone, 150+48*(j%2)+i*96 + rand, -32+32*(j%2)+(j/2)*64 + rand, null);
						    if(HamWay==0)  gr.drawImage(tileHam, 150+48*(j%2)+i*96 + rand, -32+32*(j%2)+(j/2)*64 + rand, null);
						    i2=i;
						    j2=j;
							i1=i;
							j1=j;
								break;
						 default:		break;
					}
					
				}
				
			}
		}
	   if(MainMatrix.bang){
		  if (++animation_time>9) {
			  animation_time = -1;
			  MainMatrix.boom_matrix = new boolean[MainMatrix.vert][MainMatrix.horiz];
			  MainMatrix.bang = false;
			  repaint();
		  }
		
	   for(int i=0; i<9; i++)
		{
			for(int j=0; j<23; j++)
			 {  
				
				coordconversion.ItoX(i, j, X0, Y0);
				if    (coordconversion.XInMatrix>=0 && coordconversion.XInMatrix<MainMatrix.horiz
					   && coordconversion.YInMatrix>=0 && coordconversion.YInMatrix<MainMatrix.vert &&
					   MainMatrix.boom_matrix[coordconversion.XInMatrix][coordconversion.YInMatrix]==true){
					   gr.drawImage(boom[animation_time], 150+48*(j%2)+i*96 + rand, -32+32*(j%2)+(j/2)*64 + rand, null);
					   gr.drawImage(boom2[animation_time], 150+48*(j%2)+i*96 + rand, -32+32*(j%2)+(j/2)*64 + rand, null);
					}
			 }
		  }
	  }

	   
	  
	 if( HamWay>0 ){
		   switch (HamWay){
		   case 1: 
			  
			   if (DOWN++>12) {
				   HamWay = 0;
				   DOWN = 0;
				   gr.drawImage(ham_down[DOWN], 150+48*(j2%2)+i2*96 + rand, -32+32*(j2%2)+(j2/2)*64 + rand, null);
				   break;
				}
		   else if(DOWN>0){
		         try{
					   Thread.sleep(21);
				   } catch(InterruptedException ex){};
				   
				  gr.drawImage(ham_down[DOWN-1], 150+48*(j2%2)+i2*96 -48/DOWN + rand, -32+32*(j2%2)+(j2/2)*64 -32/DOWN + rand, null);
				  
			       break;
		   }
			   case 2: 
				
				   if(LEFT++>12){
				   HamWay = 0;
				   LEFT = 0;
				   gr.drawImage(ham_left[LEFT], 150+48*(j2%2)+i2*96 + rand, -32+32*(j2%2)+(j2/2)*64 + rand, null);
				   break;
				
			   }
			   else if(LEFT>0){
			   
				   try{
					   Thread.sleep(21);
				   } catch(InterruptedException ex){};
				  
				   gr.drawImage(ham_left[LEFT-1], 150+48*(j2%2)+i2*96 + 48/LEFT + rand, -32+32*(j2%2)+(j2/2)*64 - 32/LEFT + rand, null);
				  
			       break;
			   }
			   case 3:
				
				   if(UP++>8){
				   HamWay = 0;
				   UP = 0;
				   gr.drawImage(ham_up[UP], 150+48*(j2%2)+i2*96 + rand, -32+32*(j2%2)+(j2/2)*64 + rand, null);
				   break;
				
			   }
			   else if(UP>0){
				   try{
					   Thread.sleep(31);
				   } catch(InterruptedException ex){};
				   gr.drawImage(ham_up[UP-1], 150+48*(j2%2)+i2*96 + 48/UP + rand, -32+32*(j2%2)+(j2/2)*64 + 32/UP + rand, null);
				   break;
			   }
			   case 4: 
				
				   if(RIGHT++>7){
				   HamWay = 0;
				   RIGHT = 0;
				   gr.drawImage(ham_right[RIGHT], 150+48*(j2%2)+i2*96 + rand, -32+32*(j2%2)+(j2/2)*64 + rand, null);
				   break;
				
			   }
			   else if(RIGHT>0){
				   try{
					   Thread.sleep(36);
				   } catch(InterruptedException ex){};
				   gr.drawImage(ham_right[RIGHT-1], 150+48*(j2%2)+i2*96 - 48/RIGHT + rand, -32+32*(j2%2)+(j2/2)*64 + 32/RIGHT + rand, null);
				   
			       break;
			   }
		   }
	   }
	   if (i1>=0 && i1<9 && j1>=0 && j1<23) 
		   gr.drawImage(tileHouse, 150+48*(j1%2)+i1*96 + rand, -96+32*(j1%2)+(j1/2)*64 + rand, null);
	   
	  
	   
		gr.drawImage(mainMenu, 0, 0, null);
		
		if (MainMatrix.levelNumber<=9)
			gr.drawImage(digits[MainMatrix.levelNumber], 186, 23, null);
		else if (MainMatrix.levelNumber>9 && MainMatrix.levelNumber<=16)
		{
			gr.drawImage(digits[MainMatrix.levelNumber/10], 176, 23, null);
			gr.drawImage(digits[MainMatrix.levelNumber%10], 193, 23, null);
		}
		armN=0;
		nutN=0;
		minN=0;
		
		int tempArm=MainMatrix.health_level;
		while (tempArm!=0)
		{
		armN++;
		tempArm=tempArm/10;
		}
		
		int tempNut=MainMatrix.nutes_taken;
		while (tempNut!=0)
		{
		nutN++;
		tempNut=tempNut/10;
		}
	
		int tempMin=MainMatrix.mins_number;
		while (tempMin!=0)
		{
		minN++;
		tempMin=tempMin/10;
		}
		
		
		tcX[0]=120-((20*armN)/2);
		tcX[1]=120-((20*nutN)/2);
		tcX[2]=120-((20*minN)/2);
		
		tcY[0]=280;
		tcY[1]=330;
		tcY[2]=385;
		
		
		tempArm=MainMatrix.health_level;
		tempNut=MainMatrix.nutes_taken;
		tempMin=MainMatrix.mins_number;
		if(armN!=0)
		for (int p=0; p<armN; p++)
		{
			gr.drawImage(digits[tempArm%10], tcX[0]+(armN-p)*20, tcY[0], null);
			tempArm/=10;
		}
		else gr.drawImage(digits[0], tcX[0]+(armN)*20, tcY[0], null);
		
		if(nutN!=0)
		for (int p=0; p<nutN; p++)
		{
			gr.drawImage(digits[tempNut%10], tcX[1]+(nutN-p)*20, tcY[1], null);
			tempNut/=10;
		}
		else gr.drawImage(digits[0], tcX[0]+(armN)*20, tcY[1], null);
		
		if(minN>0 && MainMatrix.mins_number>0)
		for (int p=0; p<minN; p++)
		{
			gr.drawImage(digits[tempMin%10], tcX[2]+(minN-p)*20, tcY[2], null);
			tempMin/=10;
		}
		else if(minN==0) gr.drawImage(digits[0], tcX[0]+(armN)*20, tcY[2], null);
		else if (minN>0 && MainMatrix.mins_number<0){
			gr.drawImage(minus, -30+tcX[0]+(armN)*20, tcY[2], null);
			for (int p=0; p<minN; p++)
			{
				
				gr.drawImage(digits[Math.abs(tempMin%10)], tcX[2]+(minN-p)*20, tcY[2], null);
				tempMin/=10;
			}
		}
		
		if(MainMatrix.levelNumber>0){
		for (int p=0; p<5-MainMatrix.letters_number; p++)
		{
			for (int j=0; j<26; j++)
			{
				char tmp = (char) ('A'+j);
				
				if (strings[MainMatrix.levelNumber-1].charAt(p)==tmp)  //char
				{
					gr.drawImage(letter[j], 29+p*(34+p-1), 525, null);
					continue;
					
					
				}
				
			}
		}
		}
		gr.drawImage(heroIcon, 83, 150, null);
if(MainMatrix.bang)  repaint();

if (GameOver){
	
	gr.drawImage(gameOverMenu, 0, 0, null);
	
	if (moved2&&(X>=300)&&(X<=499)&&(Y>=313)&&(Y<=356)){
		gr.drawImage(buttonOkMoved2, 300, 313, null);
		moved2=false;
	}
	
	if (clicked2&&(X>=300)&&(X<=499)&&(Y>=313)&&(Y<=356)){
		gr.drawImage(buttonOkClicked2, 300, 313, null);
		GameOver=false;
		clicked2=false;
		Win = false;
		clicked = false;
		moved = false;
		ESC = false;
		settings = false;
		yes = false;
		is_go = false;
		HamWay=0;
		animation_time=-1;
		animation_time=-1;
		MenuFrame.remove(MenuFrame.panel2);
		PushButton = 0; 
		}
}
if (Win){
	gr.drawImage(congratulateMenu, 0, 0, null);
	
	if(MainMatrix.levelNumber>0){
	for (int p=0; p<5; p++)
	{
		for (int j=0; j<26; j++)
		{
			char tmp = (char) ('A'+j);
			
			if (strings[MainMatrix.levelNumber-1].charAt(p)==tmp)  //char
			{
				gr.drawImage(letter[j], 315+p*(34+p-1), 290, null);
			    continue;
				
				
			}
			
		}
	}
	}
	if (moved2&&(X>=300)&&(X<=499)&&(Y>=343)&&(Y<=386)){
		gr.drawImage(buttonOkMoved, 300, 343, null);
		moved2=false;
	}
	
	if (clicked2&&(X>=300)&&(X<=499)&&(Y>=343)&&(Y<=386)){
		gr.drawImage(buttonOkClicked, 300, 343, null);
		clicked2=false;
		Win = false;
		clicked = false;
		moved = false;
		ESC = false;
		settings = false;
		HamWay=0;
		yes = false;
		is_go = false;
		animation_time=-1;
		if(MainMatrix.levelNumber == 0){
		MenuFrame.remove(MenuFrame.panel2);
		PushButton = 0;
		}
		int l=MainMatrix.levelNumber;
		if (MainMatrix.levelNumber <16 && MainMatrix.levelNumber>0 ){
			MainMatrix = new Matrix();
			MainMatrix.SetByPassword(strings[l]);
			clicked2=false;
			Win = false;
			clicked = false;
			moved = false;
			ESC = false;
			HamWay=0;
			settings = false;
			yes = false;
			is_go = false;
			animation_time=-1;
			MainMatrix.IsSet = true;
			PushButton = 1;
			}
		if(MainMatrix.levelNumber==16) {
			clicked2=false;
			Win = false;
			clicked = false;
			HamWay=0;
			moved = false;
			ESC = false;
			settings = false;
			yes = false;
			is_go = false;
			animation_time=-1;
			MenuFrame.remove(MenuFrame.panel2);
			PushButton = 6;
		}
	}
}

if (ESC && !MainMatrix.bang && !GameOver){
	   backgame=false;
	   mainmenu=false;
	   settings=false;
	gr.drawImage(tempMenu, 0, 0, null);
		
	    if(moved2){
	    if  ((X>=314)&&(X<=484)&&(Y>=230)&&(Y<=273)){
			gr.drawImage(buttonMenuMoved, 314, 230, null);
		 }
		else if ((X>=300)&&(X<=499)&&(Y>=278)&&(Y<=321)){
			gr.drawImage(buttonSettingsMoved, 300, 278, null);
			}
		else if ((X>=314)&&(X<=484)&&(Y>=326)&&(Y<=369)){
			gr.drawImage(buttonReturnMoved, 314, 326, null);
			}
	    moved2=false;
	    }
		
	   if(clicked2){
	   if ((X>=314)&&(X<=484)&&(Y>=230)&&(Y<=273)){
		 gr.drawImage(buttonMenuClicked, 314, 230, null);
			mainmenu = true;
		    }
		else if ((X>=300)&&(X<=499)&&(Y>=278)&&(Y<=321)){
			gr.drawImage(buttonSettingsClicked, 300, 278, null);
			settings = true;
			}
		else if ((X>=314)&&(X<=484)&&(Y>=326)&&(Y<=369)){
			gr.drawImage(buttonReturnClicked, 314, 326, null);
			backgame = true;
	      }
	   clicked2=false;
	   }
		if (mainmenu || backgame || settings){
			if (backgame) {
				ESC = false;
				repaint();
				}
			else if (mainmenu){
				ESC = false;
				clicked2=false;
				Win = false;
				HamWay=0;
				clicked = false;
				moved = false;
				ESC = false;
				settings = false;
				yes = false;
				is_go = false;
				animation_time=-1;
				MenuFrame.remove(MenuFrame.panel2);
				PushButton = 0;
				MainMatrix.IsSet=false;
				PushButton = 0;
			}
			else if (settings) {
				ESC = false;
				repaint();
				}
			}
		
		}

if (settings && !MainMatrix.bang && !Win && !GameOver){
	gr.drawImage(settingsMenu, 0, 0, null);
		
		
		if (moved2&&(X>=300)&&(X<=499)&&(Y>=333)&&(Y<=376)){
			gr.drawImage(buttonOkMoved, 300, 333, null);
			moved2=false;
		}
		if (moved2&&(X>=280)&&(X<=332)&&(Y>=220)&&(Y<=263)){
			gr.drawImage(buttonSoundMoved, 280, 220, null);
			moved2=false;
		}
		if (moved2&&(X>=280)&&(X<=332)&&(Y>=269)&&(Y<=312)){
			gr.drawImage(buttonMusicMoved, 280, 269, null);
			moved2=false;
		}
		

		if (clicked2&&(X>=300)&&(X<=499)&&(Y>=333)&&(Y<=376)){
			gr.drawImage(buttonOkClicked, 300, 333, null);
			ESC = true;
			clicked2=false;
			settings = false;
			repaint();
			}
		
		
		if (effects_on&&clicked2&&(X>=280)&&(X<=332)&&(Y>=220)&&(Y<=263)){
			gr.drawImage(buttonSoundNone, 280, 220, null);
			clicked2=false;
			effects_on=false;
		}
		if (!effects_on&&clicked2&&(X>=280)&&(X<=332)&&(Y>=220)&&(Y<=263)){
			gr.drawImage(buttonSoundClicked, 280, 220, null);
			clicked2=false;
			effects_on=true;
		}
		
		if (music_on&&clicked2&&(X>=280)&&(X<=332)&&(Y>=269)&&(Y<=312)){
			gr.drawImage(buttonMusicNone, 280, 269, null);
			clicked2=false;
			music_on=false;
			song1.pause();
		}
		if (!music_on&&clicked2&&(X>=280)&&(X<=332)&&(Y>=269)&&(Y<=312)){
			gr.drawImage(buttonMusicClicked, 280, 269, null);
			clicked2=false;
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
    
  if (clicked && !ESC && !settings && !Win && !GameOver) repaint();
	
}
	 
	class MouseHandler extends MouseAdapter
	   {
		  CoordConversion coordconversion = new CoordConversion();
	      public void mouseReleased(MouseEvent event)
	      {
	    	     int T;
	    	     if((T=event.getButton())==1){
	    	     X=event.getX();
		    	 Y=event.getY();
		    	 if (!ESC) clicked=true;
		    	 if (ESC || settings || Win || GameOver) clicked2=true;
	     	     repaint();
	     	     }
	    	     else if (T==3){
	    	     X=event.getX();
	    	     Y=event.getY();
	    	     right_clicked=true;
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
	    	if (!ESC) moved=true;
	    	if  (ESC || settings || Win || GameOver) moved2=true;
	    	repaint();
	      }
	   }
	    
        private boolean moved;
        private boolean moved2;
	    private boolean clicked;
	    private boolean clicked2;
		private boolean right_clicked;
		private Image tileMeadow, tileFlag, tileHouse, tileNut, tileMine, tileArmor, tileQuestion, tileHam, tileNone, tileNone2, tileLetter;
		private Image gameOverMenu;
		private Image[] digits = new Image[10];
        private Image[] boom = new Image[10];
        private Image[] boom2 = new Image[10];
        
        private Image[] ham_down = new Image[13];
        private Image[] ham_left = new Image[13];
        private Image[] ham_right = new Image[8];
        private Image[] ham_up = new Image[9];
        private Image[] letter = new Image[26];
        private Image tempMenu;
		private Image buttonReturnMoved;
		private Image buttonMenuMoved;
		private Image buttonMenuClicked;
		private Image buttonReturnClicked;
		private Image buttonSettingsMoved;
		private Image buttonSettingsClicked;
		private Image minus;
		private Image settingsMenu;
		private Image buttonOkMoved;
		private Image buttonMusicMoved;
		private Image buttonMusicClicked;
		private Image buttonOkClicked;
		private Image buttonSoundMoved;
		private Image buttonSoundClicked;
		private Image buttonSoundNone;
		private Image buttonMusicNone;
		private Image congratulateMenu;
		 private Image heroIcon;
		private Image[] tile = new Image[9];
		@SuppressWarnings("unused")
		private Image[] ham = new Image[6];
		
		private Image mainMenu;
		private boolean exist;
		private int armN=0;
		private int nutN=0;
		private int minN=0;
		private Image buttonOkMoved2, buttonOkClicked2;
		private int X=0;
		private int Y=0;
		private int[] tcX = new int[3];
		private int[] tcY = new int[3];
		private static final long serialVersionUID = 1L;
	
}
