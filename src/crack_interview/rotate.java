package crack_interview;

public class rotate {
	 public void rotate1(int[][] matrix) {
	        int level = matrix.length>>1;
	        for(int i = 0; i < level; i++)
	            for(int j = i; j < matrix.length - i - 1; j++){
	                int size = matrix.length - 2*i;
	                int dis = j - i;
	                int temp = matrix[i][j];            
	                matrix[i][j] = matrix[i + size - dis - 1][i];
	                matrix[i + size - dis - 1][i] = matrix[i + size - 1][i + size - 1- dis];
	                matrix[i + size - 1][i + size - 1- dis] = matrix[i + dis][i + size - 1];
	                matrix[i + dis][i + size - 1] = temp;
	            }
	  }
	 public static void main(String[]args){
		 int[][] array = {{1,2,3,4},{5,6,7,8},{9,10,11,12},{13,14,15,16}};
		new rotate().rotate1(array);
		 int i = 1;
	 }
}
