package crack_interview;

public class minimumpathsum {
	 public int minPathSum(int[][] grid) {
	        int[] res1 = new int[grid[0].length];
	        int[] res2 = new int[grid[0].length];
	        res1[0] = grid[0][0];
	        for(int i = 1; i < grid[0].length; i++)
	        res1[i] = grid[0][i] + res1[i-1];
	        for(int i = 1; i < grid.length; i++){
	            for(int j = 0; j < grid[0].length; j++){
	                if(j == 0){
	                    res2[0] = res1[0] + grid[i][0];
	                    continue;
	                }
	                res2[j] = res1[j]>res2[j-1]? res2[j-1]+ grid[i][j]:res1[j] + grid[i][j];
	            }
	            for(int j = 0; j < grid[0].length; j++)
	            res1[j] = res2[j];
	        }
	        return res1[grid[0].length-1];
	    }
	  public static void main(String[]args){
		  int[][] array = {{1,3,1},{1,5,1},{4,2,1}};
		  System.out.print(new minimumpathsum().minPathSum(array));
	  }
}
