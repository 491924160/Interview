package crack_interview;
import java.util.*;
public class largestarea {
	 public int largestRectangleArea(int[] height) {
	       if(height.length == 0)
	       return 0;
	       if(height.length == 1)
	       return height[0];
	       Stack<Integer> stack = new Stack<Integer>();
	       int i = 0;
	       int max = 0;
	       while(i < height.length){
	           if(stack.isEmpty()|| height[i]>height[stack.peek()]){
	               stack.push(i++);
	           }else{
	               int j = stack.pop(), val = height[j];
	               int local = val*(stack.isEmpty()?i:i-1-stack.peek());
	               max = Math.max(local, max);
	           }
	       }
	       while(!stack.isEmpty()){
	           int j = stack.pop(), val = height[j];
	           int local = val*(stack.isEmpty()?i:i-1-stack.peek());
	           max = Math.max(local, max);
	       }
	       return max;
	    }
	 
	  public int max(int[] height, int start, int end){
	        if(start == end)
	            return height[start];
	        int mid = start + (end-start)/2;
	        int left = max(height, start, mid);
	        int right = max(height, mid+1, end);
	        int max = Math.max(left, right);
	        int local_max = Integer.MIN_VALUE;
	        int i = mid, j = mid+1;
	        while(i>= start && j <= end){
	            if(height[i] < height[j]){
	                local_max = Math.max(local_max, (j-i+1)*height[i]);
	                j++;
	            }else{
	                 local_max = Math.max(local_max, (j-i+1)*height[j]);
	                 i--;
	            }
	        }
//	       while(i>= start){
//	           local_max = Math.max(local_max, (end-i +1)*Math.min(height[end], height[i]));
//	           i--;
//	       }
//	        while(j<= end){
//	           local_max = Math.max(local_max, (j-start+1)*Math.min(height[j], height[start]));
//	           j++;
//	       }
	        max = Math.max(max, local_max);
	        return max;
	    }
	     public int largestRectangleArea1(int[] height) {
	       if(height.length == 0)
	       return 0;
	       if(height.length == 1)
	       return height[0];
	         return max(height, 0, height.length-1);
	     }
	     public int largestRectangleArea3(int[] height) {
	         if(height.length == 0)
	         return 0;
	         if(height.length == 1)
	         return height[0];
	         Stack<Integer> stack = new Stack<Integer>();
	       int result = 0;
	       int i = 0;
	       while(i < height.length){
	           if(stack.isEmpty()|| height[stack.peek()]< height[i]){
	               stack.push(i++);
	           }else{
	               while(!stack.isEmpty() && height[stack.peek()] > height[i]){
	                    int index = stack.pop();
	                   int local_max = stack.isEmpty()?i*height[index]: (i-stack.peek()-1)*height[index];
	                   result = Math.max(result, local_max);
	               }
	               stack.push(i++);
	           }
	       }
	       while(!stack.isEmpty()){
	           int index = stack.pop();
	           int local_max = !stack.isEmpty()? (i - stack.peek()-1)*height[index] : (i)*height[index];
	           result = Math.max(local_max, result);
	       }
	       return result;
	       }
	public static void main(String[]args){
		int[] test = {4,2};
		int i = new largestarea().largestRectangleArea3(test);
		System.out.println(i);
	}
}
