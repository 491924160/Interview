package crack_interview;
import java.util.*;
public class spiral_2 {
	public List<Integer> spiralOrder(int[][] matrix) {
	    List<Integer> list = new ArrayList<Integer>();
	        int size = matrix.length*matrix[0].length;
	        int count = 0;
	        int level = 0;
	        int i = 0, j = 0;
	        while(count < size){
	            for(j = level; j < matrix[0].length - level; j++){
	                  list.add(matrix[level][j]);
	                  count++;
	            }
	          
	            if(count >= size)
	            break;
	            for(i = level + 1; i <= matrix.length - 1 - level; i++){
	                list.add(matrix[i][matrix[0].length - 1- level]);
	                count++;
	            }
	            
	            if(count >= size)
	            break;
	            for(j = matrix[0].length - 1 - level-1; j >= level; j--){
	                list.add(matrix[matrix.length - 1- level][j]);
	                count++;
	            }
	            
	             if(count >= size)
	            break;
	            for(i = matrix.length - 1- level -1; i >= level + 1; i--){
	                   list.add(matrix[i][level]);
	                   count++;
	            }
	            level++;
	        }
	        return list;
	     
	    }
	public static void main(String[]args){
		int[][] array = {{1,2,3},{4,5,6},{7,8,9}};
		List<Integer> list = new spiral_2().spiralOrder(array);
	}
}
