package crack_interview;
import java.util.*;
public class Decode_ways {
	 public int numDecodings1(String s) {
		 int len = s.length();
		 int[] array = new int[len];
		 int[] result = new int[len];
		 result[0] = 1;
		 char[] string = s.toCharArray();
		 int i = 0;
		 for(char a: string){
			 array[i] = a - 'A' + 1; 
		 }
		 for(i = 1; i < s.length(); i++){
			 int m = array[i-1], j = array[i];
			 if(m*10 + j <=26 && i-2>=0){
				 array[i] += array[i-2];
			 }else{
				 array[i] +=1;
			 }
			 array[i] += array[i-1];
		 }
		 return result[s.length()-1];			 		
	 }
	 public int numDecodings(String s) {
	        int res = Integer.parseInt(s);
	        if(res <10)
	            return 1;
	        Deque<Integer> stack = new ArrayDeque<Integer>();
	        while(res != 0){
	            stack.push(res % 10);
	            res /= 10;
	        }
	        int[] array = new int[stack.size()];
	        int[] result = new int[stack.size()];
	        result[0] = 1;
	        int count = 0;
	        while(!stack.isEmpty()){
	            array[count++] = stack.pop();
	        }
	        for(int i = 1; i < array.length; i++){
	            int m = array[i-1], n = array[i];
	            if(m*10 + n <=26){
	                if(i-2>=0){
	                    result[i] += result[i-2];
	                }else{
	                    result[i] += 1;
	                }
	            }
	            result[i] += result[i-1];
	        }
	        return result[result.length-1];
	    }
	 public static void main(String[]args){
		 String test = "1211";
		 int i = new Decode_ways().numDecodings(test);
	 }
}
