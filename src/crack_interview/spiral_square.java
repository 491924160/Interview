package crack_interview;

public class spiral_square {
	 public int[][] spiralOrder( int len) {
		 int[][] matrix = new int[len][len];
	     int size = matrix.length * matrix.length;
	     int count = 1;
	     int barrier = 0;
	     int i = 0, j = 0;
	     while(count <= size){
	         for( j = barrier; j < matrix.length - barrier; j++)
	            matrix[barrier][j] = count++;
	         if(count > size)
	        	 break;
	        for( i = barrier+1; i < matrix.length - barrier; i++)
	        matrix[i][matrix.length-barrier-1] = count++;
	        if(count > size)
	        	 break;
	        for( j = matrix.length - barrier -2; j >= barrier; j--)
	        matrix[matrix.length - 1- barrier][j] = count++;
	        if(count > size)
	        	 break;
	        for(i = matrix.length -1 -  barrier - 1 ; i >= barrier + 1; i--)
	        matrix[i][barrier] = count++;
	        if(count > size)
	        	 break;
	        barrier++;
	     }
	     return matrix;
	    }
	 public static void main(String[]args){
		 int[][] array;
		 array = new spiral_square().spiralOrder( 2);
		 for(int i = 0; i < array.length; i ++){
			 for(int j = 0; j < array.length; j++)
			 System.out.print(array[i][j]+ ' ');
			 System.out.println('\n');
		 }
	 }
}
