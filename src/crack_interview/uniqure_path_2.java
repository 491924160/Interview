package crack_interview;

public class uniqure_path_2 {
	  public int uniquePathsWithObstacles(int[][] obstacleGrid) {
	        int row = obstacleGrid.length, col = obstacleGrid[0].length;
	        int[][] result = new int[row][col];
	        for(int i = 0; i < row; i++)
	        for(int j = 0; j < col; j++){
	            if(obstacleGrid[i][j] == 1)
	            {
	                result[i][j] = 0;
	                continue;
	            }
	             if(i == 0&& j == 0){
	                result[i][j] = 1;
	                continue;
	            }
	             if(i-1>=0)
	            	 result[i][j] +=result[i-1][j];
	             if(j-1>=0)
	            	 result[i][j] +=result[i][j-1];
//	            result[i][j] = i-1>=0?result[i-1][j]:0 + j-1>=0?result[i][j-1]:0;
	        }
	        return result[row-1][col-1];
	    }
	  public static void main(String[]args){
		  int[][] array = {{0,0},{0,0}};
		  System.out.println(new uniqure_path_2().uniquePathsWithObstacles(array));
	  }
}
