package crack_interview;

import java.util.Arrays;

public class sum3_closest {
	 public int threeSumClosest(int[] num, int target) {
         Arrays.sort(num);
         int min = Integer.MAX_VALUE;
         int i = 0;
         while(i < num.length - 2){
        	 int j = i+1, k = num.length - 1;
        	 while(j < k){
        		 int total = num[i] + num[j] + num[k];
        		 if(Math.abs(total - target) < min){
        			 min = Math.abs(total- target);
        		 }
        		 if(total <= target)
        		 while(num[j] == num[++j] && j < k);
        		 else
        		 while(num[k] == num[--k] && j < k);
        	 }
        	 while(num[i] == num[++i] && i < num.length -2);
         }
         return min;
	 }
	 public static void main(String[]args){
		 int[] array = {-1, 2, 1, -4};
		 System.out.println(new sum3_closest().threeSumClosest(array,1));
	 }
}
