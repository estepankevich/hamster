package Game;
import java.util.*;

public class Analys {

private int matrix_l[][], vert, horiz, x1,x2,y1,y2;
public byte m=0; //1 = есть путь, 0 = пути нет  
 

public class M{
	int vert=0;
	int horiz=0;
	
	public int getVert() {
		return vert;
	}
	
	public int getHoriz() {
		return horiz;
	}
	}

public void SetMatrix(int matrix_l[][], int vert, int horiz, int x2, int y2, int x1, int y1 ) {

	this.vert = vert;
	this.horiz = horiz;
	this.matrix_l = matrix_l;
    this.x1=x1;
	this.x2=x2;
	this.y1=y1;
	this.y2=y2;
	
}

public void setEnter(int x2, int y2){
	this.x2 = x2;
	this.y2 = y2;
}

public M labirint(){
	M temp = new M();
	int t=0, min=65536;
	if (matrix_l[x1][y1]==-1) {
		temp.vert = x2;
		temp.horiz = y2;
		return temp;
	}
	for(int i=0; i<vert; i++)
		for(int j=0; j<horiz; j++){
			if (matrix_l[i][j]==-1) matrix_l[i][j]=30000;
			if (matrix_l[i][j]==1 || matrix_l[i][j]==-2) matrix_l[i][j]=30000;
			if (matrix_l[i][j]==0) matrix_l[i][j]=10000;
	}

	if (x1==x2 && y1==y2){
		temp.vert = x2;
		temp.horiz = y2;
		return temp;
	}
	
	matrix_l[x2][y2]=50000;
	matrix_l[x1][y1]=1;
	t= 3*(Math.abs(x1-x2) + Math.abs(y1-y2)); //подсчет необходимого количества проходов по циклу

	while (t--!=0) {
		
		for (int i=0; i<vert; i++)
			for (int j=0; j<horiz; j++)
			{
				if (i>0 && matrix_l[i-1][j]>matrix_l[i][j] &&  matrix_l[i-1][j]<30000){
					if (matrix_l[i-1][j]==50000) break;
					matrix_l[i-1][j]=matrix_l[i][j]+1;
					}
				if (j>0 && matrix_l[i][j-1]>matrix_l[i][j] &&  matrix_l[i][j-1]<30000) {
					if (matrix_l[i][j-1]==50000) break;
					matrix_l[i][j-1]=matrix_l[i][j]+1;
					}
				if (i<(vert-1) && matrix_l[i+1][j]>matrix_l[i][j] &&  matrix_l[i+1][j]<30000){
					if (matrix_l[i+1][j]==50000) break;
					matrix_l[i+1][j]=matrix_l[i][j]+1;
					}
				if (j<(horiz-1) && matrix_l[i][j+1]>matrix_l[i][j] &&  matrix_l[i][j+1]<30000){
					if (matrix_l[i][j+1]==50000) break;
					matrix_l[i][j+1]=matrix_l[i][j]+1;
					}
			}
	}

	//System.out.print(x2 + " " + y2 + " " + " " + x1 + " " + y1);
	t=0;
	
	if(x2>0 && matrix_l[x2-1][y2]!=30000 && matrix_l[x2-1][y2]!=10000 ) min = matrix_l[x2-1][y2];
    if(x2<(vert-1) && matrix_l[x2+1][y2]!=30000 && matrix_l[x2+1][y2]!=10000 && min>matrix_l[x2+1][y2]) min=matrix_l[x2+1][y2];
    if(y2>0 && matrix_l[x2][y2-1]!=30000 && matrix_l[x2][y2-1]!=10000 && min>matrix_l[x2][y2-1]) min=matrix_l[x2][y2-1] ;
	if(y2<(horiz-1)&& matrix_l[x2][y2+1]!=30000 && matrix_l[x2][y2+1]!=10000 && min>matrix_l[x2][y2+1]) min=matrix_l[x2][y2+1];
	
	if(x2>0 && matrix_l[x2-1][y2]!=30000 && matrix_l[x2-1][y2]!=10000 && matrix_l[x2-1][y2]==min  ) t++;
    if(x2<(vert-1) && matrix_l[x2+1][y2]!=30000 && matrix_l[x2+1][y2]!=10000 && matrix_l[x2+1][y2]==min) t++;
    if(y2>0 && matrix_l[x2][y2-1]!=30000 && matrix_l[x2][y2-1]!=10000 && matrix_l[x2][y2-1]==min) t++;
	if(y2<(horiz-1)&& matrix_l[x2][y2+1]!=30000 && matrix_l[x2][y2+1]!=10000 && matrix_l[x2][y2+1]==min) t++;
	
	
	if (t==0) {
		temp.vert = x2;
		temp.horiz = y2;
		//System.out.print("   =   " + temp.vert + " " + temp.horiz);
		return temp;
	}
		
	if (t!=0){
		Random random = new Random();
		int rand;
		rand = Math.abs(random.nextInt())%t;
		if(x2>0 && matrix_l[x2-1][y2]!=30000 && matrix_l[x2-1][y2]!=10000 && matrix_l[x2-1][y2]==min && rand--==0) 
			{
			 temp.vert = x2-1;
			 temp.horiz = y2;
		}
	    if(x2<(vert-1) && matrix_l[x2+1][y2]!=30000 && matrix_l[x2+1][y2]!=10000 && matrix_l[x2+1][y2]==min && rand--==0) {
	    	 temp.vert = x2+1;
			 temp.horiz = y2;
		}
	    if(y2>0 && matrix_l[x2][y2-1]!=30000 && matrix_l[x2][y2-1]!=10000 && matrix_l[x2][y2-1]==min && rand--==0){
	    	  temp.vert = x2;
			 temp.horiz = y2-1;
			}
		if(y2<(horiz-1)&& matrix_l[x2][y2+1]!=30000 && matrix_l[x2][y2+1]!=10000 && matrix_l[x2][y2+1]==min && rand--==0) {
			 temp.vert = x2;
			 temp.horiz = y2+1;
			}
		}
		
	
	//System.out.print("   =   " + temp.vert + " " + temp.horiz);
	return temp;
	
}
}
