package crack_interview;
import java.util.*;
public class maximal_rectangle {
	 public int maximalRectangle(char[][] matrix) {
	        if(matrix == null)
	        return 0;
	        if(matrix[0] == null || matrix[0].length == 0)
	        return 0;
	        int[] height = new int[matrix[0].length + 1];
	        height[matrix[0].length] = 0;
	        int rows = matrix.length;
	        int max = 0;
	        for(int i = 0; i < rows; i++){
	            Stack<Integer> stack = new Stack<Integer>();
	            for(int j = 0; j < height.length;j++){
	                if(j < height.length -1){
	                    if(matrix[i][j] == '1'){
	                    height[i] += 1;
	                     }else{
	                        height[i] = 0;
	                     }
	                }
	                
	                if(stack.isEmpty()||height[i] > height[stack.peek()]){
	                    stack.push(i);
	                    continue;
	                }
	                while(!stack.isEmpty() && height[i] < height[stack.peek()]){
	                    int m = stack.pop(), val = height[m];
	                    int local_max = val * (stack.isEmpty()?i: i-1-stack.peek());
	                    max = Math.max(local_max, max);
	                }
	                stack.push(i);
	            }
	        }
	        return max;
	    }
}
