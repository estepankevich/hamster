package Game;
import java.util.*;
 
public class Matrix extends AbstractClass {
	
	public boolean IsSet=false;
	private static final long serialVersionUID = 1L;
	public int matrix[][];
	private int matrix2[][];
	public boolean boom_matrix[][];
	public boolean bang=false;
	protected int horiz, vert;
	protected int mins_number, nuts_number, letters_number, armor_number, coordinate_vert, coordinate_horiz ;
	protected int levelNumber=0;
	protected int nutes_taken=0;
	protected int health_level=2;
	public int[][] matrix2(){
		int matrix3[][] = new int[vert][horiz];
		for(int i=0;i<vert;i++)
			for(int j=0;j<horiz;j++)
				matrix3[i][j] = matrix2[i][j];
		return matrix3;
	}
	public int[][] matrix(){
		int matrix3[][] = new int[vert][horiz];
		for(int i=0;i<vert;i++)
			for(int j=0;j<horiz;j++)
				matrix3[i][j] = matrix[i][j];
		return matrix3;
	}
	
	public void setA() { }
	
	public void setElements(int vert, int horiz, int mins_number, 
		int nuts_number, int letters_number, int armor_number) {
		
		if (horiz>64) horiz = 64;
		if (horiz<3) horiz =3;
		if (vert>64) vert = 64;
		if (vert<3) vert = 3;
		if(letters_number>5) letters_number = 5;
		if (vert*horiz<mins_number + nuts_number + armor_number + letters_number + 2){
			double temp=0;
		    temp = (double)(vert*horiz - letters_number - 2)/(mins_number + nuts_number + armor_number);
		    //System.out.println("temp: " + temp);
		    nuts_number = (int) ( nuts_number*temp);
		    //System.out.println("Nuts: " + nuts_number);
		    mins_number = (int) ( mins_number*temp);
		    //System.out.println("Mins: " + mins_number);
		    armor_number= (int) (armor_number*temp);
		    //System.out.println("Armor: " + armor_number);
		    while (vert*horiz<(mins_number + nuts_number + armor_number + letters_number +2)) mins_number--; 
		}
		this.mins_number = mins_number;
		this.nuts_number = nuts_number;
		this.letters_number = letters_number;
		this.armor_number = armor_number;
		this.horiz = horiz;
		this.vert = vert;
		this.matrix = new int[vert][horiz];
		this.matrix2 = new int[vert][horiz];
		this.boom_matrix = new boolean[vert][horiz];
		for (int i=0; i<vert; i++)
			for (int j=0;j<horiz; j++){
				this.matrix2[i][j]=1;
			}
}
	public void setPlayerCoordinates(int coordinate_vert, int coordinate_horiz){
		this.coordinate_vert =  coordinate_vert;
		this.coordinate_horiz = coordinate_horiz;
	}
	
	public boolean SetByPassword(String password){
	int i;	
	boolean equal=false;
	for (  i=0; i<16; i++ ){
	
		if (password.equals(strings[i]) && (equal=true)){
			this.levelNumber = i+1;
			break;
		}
		
	}
	if (equal) switch(i){
		case 0: this.setElements(5,5,7,2,5,1);
		        break;
		case 1: this.setElements(6,6,8,2,5,1);
				break;
		case 2: this.setElements(8,8,10,2,5,1);
				break;
		case 3: this.setElements(10,10,12,3,5,2);
				break;
		case 4: this.setElements(12,12,25,4,5,2);
				break;
		case 5: this.setElements(15,15,35,4,5,2);
				break;
		case 6: this.setElements(17,17,45,5,5,3);
				break;
		case 7: this.setElements(19,19,70,6,5,4);  // прототип (VERT, HORIZ, MINS, NUTS, LETTERS, ARMOR)
				break;
		case 8: this.setElements(22,22,90,8,5,5);
				break;
		case 9: this.setElements(25,25,110,10,5,7);
				break;
		case 10: this.setElements(28,28,160,12,5,8);
				break;
		case 11: this.setElements(32,32,210,15,5,9);
				break;
		case 12: this.setElements(37,37,305,18,5,12);
				break;
		case 13: this.setElements(44,44,430,22,5,14);
			     break;
		case 14: this.setElements(50,50,600,26,5,16);
				break;
		case 15: this.setElements(64,64,1000,30,5,20);
			
	}
	return equal;
		}
	
    public void MineStep(int i, int j){
		
    	if ( matrix2[i][j]==-1 ) return;
    	boom_matrix[i][j]=true;
		mins_number--;
		
		matrix[i][j]%=10;
		if (matrix[i][j]%10==0) MatrixCellOpen(i,j);
		if(effects_on){
		song2.stop();
		song4.stop();
		song3.stop();
		song3.play();
		}
		if(i>0 && j>0){
			matrix[i-1][j-1]--;
			if (matrix[i-1][j-1]/10 == 1) MineStep(i-1, j-1);
			else if (matrix[i-1][j-1]%10==0 && matrix2[i-1][j-1]==0) MatrixCellOpen(i-1,j-1);
		}
		if(j>0){
			matrix[i][j-1]--;
			if (matrix[i][j-1]/10 == 1) MineStep(i, j-1); 
			else if (matrix[i][j-1]%10==0 && matrix2[i][j-1]==0) MatrixCellOpen(i,j-1);
		}
		if(i<(vert-1) && j>0){
			matrix[i+1][j-1]--;
			if (matrix[i+1][j-1]/10 == 1) MineStep(i+1, j-1);
			else if (matrix[i+1][j-1]%10==0 && matrix2[i+1][j-1]==0) MatrixCellOpen(i+1,j-1);
		}
		if(i>0){
			matrix[i-1][j]--;
			if (matrix[i-1][j]/10 == 1) MineStep(i-1, j); 
			else if (matrix[i-1][j]%10==0 && matrix2[i-1][j]==0) MatrixCellOpen(i-1,j);
		}
		if(i<(vert-1)){
			matrix[i+1][j]--;
			if (matrix[i+1][j]/10 == 1) MineStep(i+1, j); 
			else if (matrix[i+1][j]%10==0 && matrix2[i+1][j]==0) MatrixCellOpen(i+1,j);
			}
		if(j<(horiz-1)&&(i>0)){ 
			matrix[i-1][j+1]--;
	        if (matrix[i-1][j+1]/10 == 1) MineStep(i-1, j+1); 
	        else if (matrix[i-1][j+1]%10==0 && matrix2[i-1][j+1]==0) MatrixCellOpen(i-1,j+1);
		}
		if(j<(horiz-1)){
			matrix[i][j+1]--;
			if (matrix[i][j+1]/10 == 1) MineStep(i, j+1); 
			else if (matrix[i][j+1]%10==0 && matrix2[i][j+1]==0) MatrixCellOpen(i,j+1);
		}
		if(j<(horiz-1)&&i<(vert-1)){
			matrix[i+1][j+1]--;
			if (matrix[i+1][j+1]/10 == 1) MineStep(i+1, j+1); 
			else if (matrix[i+1][j+1]%10==0 && matrix2[i+1][j+1]==0) MatrixCellOpen(i+1,j+1);
		}
	}
	public void MatrixBoxOpen(int i, int j){
	
		if (matrix[i][j]/10 == 1) {
			MineStep(i,j);
			if(--health_level==0) GameOver=true;
			bang=true;
			//for (int i1=0; i1<vert; i1++){
			////       for(int j1=0; j1<horiz; j1++) if (boom_matrix[i1][j1]==true) 
			    	//   System.out.print(1+" ");
			     //  else System.out.print(0+" ");
			    //   System.out.println();
			//}
		}
		if (matrix[i][j]/10 == 2) {
			nuts_number--;
			nutes_taken++;
			if(effects_on){
			song2.stop();
			song4.stop();
			song4.play();
			}
			matrix[i][j]%=10;
		}
		if ( matrix[i][j]/10 == 9){
			health_level++;
			armor_number--;
			if(effects_on){
			song2.stop();
			song4.stop();
			song4.play();
			}
			matrix[i][j]%=10;
		}
		if (matrix[i][j]/10>=3 && matrix[i][j]/10<=8){
			letters_number--;
			if(effects_on){
			song2.stop();
			song4.stop();
			song4.play();
			}
			matrix[i][j]=matrix[i][j]%10;
		}
		if (matrix[i][j]/100==1 && letters_number==0) Win=true;
}
	public void MatrixCellOpen(int i, int j){
	 
		int temp[][]=new int[vert][horiz];
		if (temp[i][j]==1) return;
		matrix2[i][j] = matrix2[i][j]==-1?-1:0;
		temp[i][j] = 1;
	    if (matrix[i][j]%10==0){ 
	    	
	    	if(i>0 && j>0 && (matrix2[i-1][j-1]!=0)) {
	    		if (matrix2[i-1][j-1]==-1 && matrix[i-1][j-1]/10!=1) mins_number++;
	    	    matrix2[i-1][j-1]=0;
	    		if(matrix[i-1][j-1]%10==0) MatrixCellOpen(i-1, j-1); 
	    	}
			
	    	if(j>0 && (matrix2[i][j-1]!=0)){
	    		if (matrix2[i][j-1]==-1 && matrix[i][j-1]/10!=1) mins_number++;
	    		matrix2[i][j-1]=0;
	    		if(matrix[i][j-1]%10==0) MatrixCellOpen(i, j-1); 
	    	}
			
	    	if(i<(vert-1) && j>0 && (matrix2[i+1][j-1]!=0)){
	    		if (matrix2[i+1][j-1]==-1 && matrix[i+1][j-1]/10!=1) mins_number++;
	    		matrix2[i+1][j-1]=0;
	    		if(matrix[i+1][j-1]%10==0) MatrixCellOpen(i+1, j-1); 
	    	}
			
	    	if(i>0 && (matrix2[i-1][j]!=0)){
	    		if (matrix2[i-1][j]==-1 && matrix[i-1][j]/10!=1) mins_number++;
	    		matrix2[i-1][j]=0;
	    		if(matrix[i-1][j]%10==0) MatrixCellOpen(i-1, j); 
	    	}
			
	    	if(i<(vert-1) && (matrix2[i+1][j]!=0)){
	    		if (matrix2[i+1][j]==-1 && matrix[i+1][j]/10!=1) mins_number++;
	    		matrix2[i+1][j]=0;
	    		if(matrix[i+1][j]%10==0) MatrixCellOpen(i+1, j); 
	    	}
			
	    	if(j<(horiz-1) && (i>0) && (matrix2[i-1][j+1]!=0)){
	    		if (matrix2[i-1][j+1]==-1 && matrix[i-1][j+1]/10!=1) mins_number++;
	    		matrix2[i-1][j+1]=0;
	    		if(matrix[i-1][j+1]%10==0) MatrixCellOpen(i-1, j+1); 
	    	}
			
	    	if(j<(horiz-1) && (matrix2[i][j+1]!=0)){
	    		if (matrix2[i][j+1]==-1 && matrix[i][j+1]/10!=1) mins_number++;
	    	    matrix2[i][j+1]=0;
	    		if(matrix[i][j+1]%10==0) MatrixCellOpen(i, j+1); 
	    	}
	    	
			if(j<(horiz-1) && i<(vert-1) && (matrix2[i+1][j+1]!=0)){
				if (matrix2[i+1][j+1]==-1 && matrix[i+1][j+1]/10!=1) mins_number++;
				matrix2[i+1][j+1]=0;
				if(matrix[i+1][j+1]%10==0) MatrixCellOpen(i+1, j+1); 
			}
	 
	    }
}
	public void MinsPrint(){
		for (int i=0; i<vert; i++){
			for (int j=0; j<horiz; j++){
				System.out.print( (matrix[i][j]/10==1? 0:1)+" ");
			}
			System.out.println();
		}
	}
	public void MatrixMinePoint(int i, int j){
	    if (matrix2[i][j]==1)    {
	    	matrix2[i][j]=-1;
	    	mins_number--;
	    	return;
	    }
		if (matrix2[i][j]==-1)   {
			matrix2[i][j]=-2;
			mins_number++;
			return;
		}
		if (matrix2[i][j]==-2) {
			matrix2[i][j]=1;
			return;
		}
	}
	public void Matrix1Print(){
		for (int i=0; i<vert; i++){
	       for(int j=0; j<horiz; j++) if (matrix[i][j]/10!=0) System.out.print(matrix[i][j]+" ");
	       							  else System.out.print(matrix[i][j]+ "  ");
	       System.out.println();
    }
	}
	public void Matrix2Print(){
		for (int i=0; i<vert; i++){
	       for(int j=0; j<horiz; j++) {
	    	   System.out.print(matrix2[i][j]+" ");
	       }
	       	System.out.println();
    }
	}
	public void MatrixNumberFill(){
		for (int i=0;i<vert;i++)
			for (int j=0; j<horiz; j++)
				if (matrix[i][j]==1) matrix[i][j]=0;
		
		for (int i=0;i<vert;i++)
			for (int j=0; j<horiz; j++){
		if (matrix[i][j]/10==1){
		if(i>0 && j>0) 				matrix[i-1][j-1]++;
		if(j>0) 					matrix[i][j-1]++;
		if(i<(vert-1) && j>0) 		matrix[i+1][j-1]++;
		if(i>0) 					matrix[i-1][j]++;
		if(i<(vert-1)) 				matrix[i+1][j]++;
		if(j<(horiz-1)&&(i>0))  	matrix[i-1][j+1]++;
		if(j<(horiz-1)) 			matrix[i][j+1]++;
		if(j<(horiz-1)&&i<(vert-1)) matrix[i+1][j+1]++;
		}
		}
	}
	public void CheckEmptyCells(int i, int j){
		
		if(i>0 && j>0 && matrix2[i-1][j-1]<0) 			    matrix2[i-1][j-1]=0;
		if(j>0 && matrix2[i][j-1]<0) 				    	matrix2[i][j-1]=0;
		if(i<(vert-1) && j>0 && matrix2[i+1][j-1]<0) 	    matrix2[i+1][j-1]=0;
		if(i>0 && matrix2[i-1][j]<0) 					    matrix2[i-1][j]=0;
		if(i<(vert-1) && matrix2[i+1][j]<0) 				matrix2[i+1][j]=0;
		if(j<(horiz-1)&&(i>0) && matrix2[i-1][j+1]<0)  	    matrix2[i-1][j+1]=0;
		if(j<(horiz-1) && matrix2[i][j+1]<0) 				matrix2[i][j+1]=0;
		if(j<(horiz-1)&&i<(vert-1) && matrix2[i+1][j+1]<0)  matrix2[i+1][j+1]=0;
		
		}
	
	public void MatrixLetterFill(){
	int i=0,j=0, rand,t=0, h=letters_number, temp=0;
	Random random = new Random();
	while(t!=h){
	rand = Math.abs(random.nextInt())%(h - t);
	for(i=0; i<vert; i++){
		for(j=0; j<horiz; j++)
		{
		  if( (matrix[i][j]/10==3) && (temp++==rand)){
			  matrix[i][j]+=10*t;
			  t++;
			  break;
		  }
		}
		if ((temp-1)==rand && (temp=0)==0) break;  
}
}
}
    public void ObjectGenerate(){
	int rand=0, temp=0, house=1, elements_count = nuts_number + armor_number + letters_number + 1, free_size = vert*horiz - mins_number - 1;
	matrix[coordinate_vert][coordinate_horiz] = CURRENT_POSITION;
	int nuts_number_temp = nuts_number;
	int armor_number_temp = armor_number;
	int letters_number_temp = letters_number;
	Random random = new Random();
	for(int i=0; i<vert; i++)
		for (int j=0; j<horiz; j++) 
			if (matrix[i][j]==0) matrix[i][j]=MINA;

	while(elements_count-->0){
	rand = Math.abs(random.nextInt())%(free_size--);
	temp=0;
	 for(int i=0; i<vert; i++)
		for (int j=0; j<horiz; j++){
			if(matrix[i][j]==1 && temp++==rand ){
				if (nuts_number_temp!=0){
					matrix[i][j]=NUT;
					nuts_number_temp--;
					break;
				}
				else if (armor_number_temp!=0){
					matrix[i][j]=ARMOR;
					armor_number_temp--;
					break;
				}
				else if (letters_number_temp!=0){
					matrix[i][j]=LETTER1;
					letters_number_temp--;
					break;
				}
				else if (house!=0){
					matrix[i][j]=HOUSE;
					house--;
					break;
				}
				}
			if ((temp-1)==rand)  break;  
		}
		
	}
	 
}    
	public void MatrixGenerate(){
	
		int element_number = mins_number, temp3=0, rand=0, cell_number[], counter=0;
		Random random = new Random();
	    cell_number = new int[9];
		while(element_number--!=0){
			matrix[coordinate_vert][coordinate_horiz]=0;
		
			temp3=0;
			for(int t=0; t<9;t++) cell_number[t]=0;
		 
			for(int i=0; i<vert; i++)
				for(int j=0; j<horiz; j++) if ( matrix[i][j]==0 ){
					    temp3=0;
					    if( Math.abs(i-coordinate_vert)<=1 && Math.abs(j-coordinate_horiz)<=1);
					    else{
					    if ( i==0 || matrix[i-1][j]==0) temp3++; 
					    if ( j==0 || matrix[i][j-1]==0) temp3++;
					    if ( i==(vert-1) || matrix[i+1][j]==0) temp3++;
					    if ( j==(horiz-1) || matrix[i][j+1]==0) temp3++;
					    if( (i==0 || j==0) || (i!=0 && j!=0 && matrix[i-1][j-1]==0)) temp3++;
						if( (i==(vert-1) || j==0) || (i!=(vert-1) && j!=0 && matrix[i+1][j-1]==0))temp3++;
						if( (j==(horiz-1) || i==0) || (j!=(horiz-1) && i!=0 && matrix[i-1][j+1]==0))temp3++;
						if( (j==(horiz-1) || i==(vert-1)) ||(j!=(horiz-1) && i!=(vert-1) && matrix[i+1][j+1]==0))temp3++;
					    }
						for(int t=0;t<9;t++) if(temp3==t) cell_number[t]++;
				}
			
		   for(int t=8;t>=0;t--){
			if(cell_number[t]==0) continue;
			if (t==8 && counter++==3) counter = 0;
			else if(t==8 && cell_number[7]!=0) {t=7;}
			  rand=Math.abs(random.nextInt())%cell_number[t];
	    
				for(int i=0; i<vert; i++){
				for(int j=0; j<horiz; j++){
					if(matrix[i][j]==0){
				    temp3=0;
				    if( Math.abs(i-coordinate_vert)<=1 && Math.abs(j-coordinate_horiz)<=1);
				    else{
				    if ( i==0 || matrix[i-1][j]==0) temp3++; 
				    if ( j==0 || matrix[i][j-1]==0) temp3++;
				    if ( i==(vert-1) || matrix[i+1][j]==0) temp3++;
				    if ( j==(horiz-1) || matrix[i][j+1]==0) temp3++;
				    if( (i==0 || j==0) || (i!=0 && j!=0 && matrix[i-1][j-1]==0)) temp3++;
					if( (i==(vert-1) || j==0) || (i!=(vert-1) && j!=0 && matrix[i+1][j-1]==0))temp3++;
					if( (j==(horiz-1) || i==0) || (j!=(horiz-1) && i!=0 && matrix[i-1][j+1]==0))temp3++;
					if( (j==(horiz-1) || i==(vert-1)) ||(j!=(horiz-1) && i!=(vert-1) && matrix[i+1][j+1]==0))temp3++;
				    }
				    if(temp3==t  && rand--==0){
				    	matrix[i][j]=10;
				    	break;
				    }
					
					}
				
				}
				if(rand==-1) break;
			}
			
				if(rand==-1) break;
		
			
	}
	}
		
		for(int i=0;i<vert; i++)
			for(int j=0; j<horiz; j++) if(matrix[i][j]==0) matrix[i][j]=1;
									   else matrix[i][j]=0;
	    matrix[coordinate_vert][coordinate_horiz]=1;
		
		 for(int l=0; l<Math.max(vert/2, horiz/2); l++){
		
	    
		/* Убираем случаи  |*                *|
		                   |0 *     и      * 0|
		                   |*                *|
		 */
			
		
		for (int i=1; i<(vert-1); i++){
		
	    	if ( matrix[i][0]==1 && (matrix[i-1][0]==0 || matrix[i+1][0]==0) && matrix[i][1]==0 ) {
	    		matrix[i][1]=1;
	    		matrix[i][0]=0;
	    	}
	    	if ( matrix[i][horiz-1]==1 &&  (matrix[i-1][horiz-1]==0 || matrix[i+1][horiz-1]==0)  && matrix[i][horiz-2]==0){
	    		matrix[i][horiz-2] = 1;
	    		matrix[i][horiz-1]=0;
	    	}
	    
	    }
		
		
		/* Убираем случаи     _____     	  *
        				      * 0 *   и     * 0 *
        				        *           -----  
         */
		 
		for (int i=1; i<(horiz-1); i++){
				
		    	if ( matrix[0][i]==1 && (matrix[0][i-1]==0 || matrix[0][i+1]==0) && matrix[1][i]==0 ) {
		    		matrix[1][i]=1;
		    		matrix[0][i]=0;
		    	}
		    	if ( matrix[vert-1][i]==1 && (matrix[vert-1][i-1]==0 || matrix[vert-1][i+1]==0) && matrix[vert-2][i]==0 ) {
		    		matrix[vert-2][i]=1;
		    		matrix[vert-1][i]=0;
		    	}
		    }
	    
		
		/* Убираем случаи  	|* *             * *|
        					|0      и      	   0|
        					|* *             * *|
        */
		
		for (int i=1; i<(vert-1); i++){
			
	    	if ( matrix[i][0]==1 && matrix[i-1][0]==0 && matrix[i+1][0]==0 && matrix[i-1][1]==0 && matrix[i+1][1]==0 ) {
	    		matrix[i+1][1]=1;
	    		matrix[i][0]=0;
	    	}
	    	if ( matrix[i][horiz-1]==1 && matrix[i-1][horiz-1]==0 && matrix[i+1][horiz-1]==0 && matrix[i-1][horiz-2]==0 && matrix[i+1][horiz-2]==0){
	    		matrix[i-1][horiz-2] = 1;
	    		matrix[i][horiz-1]=0;
	    	}
	    
	    }
		
		
		/* Убираем случаи     _____     	*   *
		 					  * 0 *   и     * 0 *
	                          *   *         -----  
*/
	     
		for (int i=1; i<(horiz-1); i++){
				
		    	if ( matrix[0][i]==1 && matrix[0][i-1]==0 && matrix[0][i+1]==0 && matrix[1][i-1]==0 && matrix[1][i+1]==0 ) {
		    		matrix[1][i-1]=1;
		    		matrix[0][i]=0;
		    	}
		    	if ( matrix[vert-1][i]==1 && matrix[vert-1][i-1]==0 && matrix[vert-1][i+1]==0 && matrix[vert-2][i-1]==0 && matrix[vert-2][i+1]==0 ) {
		    		matrix[vert-2][i+1]=1;
		    		matrix[vert-1][i]=0;
		    	}
		    }
		}
			
		 if(matrix[0][0]==1 && matrix[0][1]==0 && matrix[1][0]==0) {
				matrix[0][0]=0;
				matrix[1][0]=1;
			}
			if(matrix[0][horiz-1]==1 && matrix[0][horiz-2]==0 && matrix[1][horiz-1]==0) {
				matrix[0][horiz-1]=0;
				matrix[0][horiz-2]=1;
			}
			if(matrix[vert-1][0]==1 && matrix[vert-2][0]==0 && matrix[vert-1][1]==0) {
				matrix[vert-1][0]=0;
				matrix[vert-1][1]=1;
			}
			if(matrix[vert-1][horiz-1]==1 && matrix[vert-2][horiz-1]==0 && matrix[vert-1][horiz-2]==0) {
				matrix[vert-1][horiz-1]=0;
				matrix[vert-2][horiz-1]=1;
			}
	   	 ObjectGenerate();
	     MatrixLetterFill();
	     MatrixNumberFill();
	
	}
	public void GetCurrentPosition(){
    	for(int i = 0; i < vert; i++)
    		for(int j = 0; j <horiz; j++) if(matrix[i][j]/1000 == 1 && i==(coordinate_vert=i) && j==(coordinate_horiz=j)) return; 
    }
	
	public void matrix2open(int i, int j){
	matrix2[i][j]=0;	
	}
	
}

	

