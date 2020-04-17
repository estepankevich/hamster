package Game;

public class CoordConversion {
	
	
	
	int isI;
	int isJ;
	int isIe;
	int isJe;
	
	int XShift;
	int YShift;
	
	
	public int XInMatrix;	
	public int YInMatrix;
   
	public void ItoX(int isI, int isJ, int X0, int Y0){
		XShift=YShift=0;
		while (isJ!=0)
		{
			if (isJ>0)
			{
				if (isJ%2==1)
				{
					isJ--;
					YShift++;
				}
				else if (isJ%2==0)
				{
					isJ--;
					XShift--;
				}
			}
			else if (isJ<0)
			{
				if (isJ%2==1)
				{
					isJ++;
					YShift--;
				}
				else if (isJ%2==0)
				{
					isJ++;
					XShift++;
				}
			}			
		}
		

		while (isI!=0)
		{
			if (isI>0)
			{
				isI--;
				XShift++;
				YShift++;
			}
			else if (isI<0)
			{
				isI++;
				XShift--;
				YShift--;
			}
		}
		XInMatrix=YInMatrix=0;
		XInMatrix = X0 + XShift;
		YInMatrix = Y0 + YShift;
	}
	
	public void CoordConversionFunc (int X, int Y, int X0, int Y0)
	{
		XShift=YShift=0;
		for(int i=0; i<9; i++)
		{
			for(int j=0; j<23; j++)
			{
				if ((Y>-32+32*(j%2)+(j/2)*64)&&(Y<-32+32*(j%2)+(j/2)*64+64)
					&&(X>150+48*(j%2)+i*96)&&(X<150+48*(j%2)+i*96+96))
				{
					yTemp[0]=-32+32*(j%2)+(j/2)*64;		//   |-*-|
					xTemp[0]=150+48*(j%2)+i*96+48;		//   |___|
					
					yTemp[1]=-32+32*(j%2)+(j/2)*64+32;	//   |---*
					xTemp[1]=150+48*(j%2)+i*96+96;		//   |___|
					
					yTemp[2]=-32+32*(j%2)+(j/2)*64+64;	//   |---|
					xTemp[2]=150+48*(j%2)+i*96+48;		//   |_*_|
					
					yTemp[3]=-32+32*(j%2)+(j/2)*64+32;	//   |---|
					xTemp[3]=150+48*(j%2)+i*96;			//   *___|
					
					for (int o=0; o<4; o++)
					{
						int s=0;
						if (o>=0&&o<=2) s=o+1;
						else if (o==3) s=0;
						linesY[o]=(((X-xTemp[o])*(yTemp[s]-yTemp[o]))/(xTemp[s]-xTemp[o])+yTemp[o]);
					
					}
					
					// <1, <4, >2, >3
						
					if (Y<linesY[1]&&Y<linesY[2]&&Y>linesY[0]&&Y>linesY[3])
					{
						isI=i;
						isJ=j;
					}
				}
			}
			
		}
		

		while (isJ!=0)
		{
			if (isJ>0)
			{
				if (isJ%2==1)
				{
					isJ--;
					YShift++;
				}
				else if (isJ%2==0)
				{
					isJ--;
					XShift--;
				}
			}
			else if (isJ<0)
			{
				if (isJ%2==1)
				{
					isJ++;
					YShift--;
				}
				else if (isJ%2==0)
				{
					isJ++;
					XShift++;
				}
			}			
		}
		

		while (isI!=0)
		{
			if (isI>0)
			{
				isI--;
				XShift++;
				YShift++;
			}
			else if (isI<0)
			{
				isI++;
				XShift--;
				YShift--;
			}
		}
		XInMatrix = X0 + XShift;
		YInMatrix = Y0 + YShift;
		//System.out.println(XInMatrix+ " " + " " + YInMatrix);
	}
	
	
	private int[] linesY = new int[4];
	private int[] xTemp = new int[4];
	private int[] yTemp = new int[4];
		
}
