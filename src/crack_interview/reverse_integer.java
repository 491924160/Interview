package crack_interview;
import java.util.*;
public class reverse_integer {
	 public int reverse(int x) {
	        boolean flag = true;
	        if(x < 0){
	            flag = false;
	            x = -x;
	        }
	        ArrayDeque<Integer> stack = new ArrayDeque<Integer>();
	        while(x != 0){
	            int i = x % 10;
	            stack.push(i);
	            x = x / 10;
	        }
	        int total = 0;
	        while(!stack.isEmpty()){
	            total = total * 10 + stack.pollLast();
	        }
	        return flag == true? total: -total;
	    }
}
