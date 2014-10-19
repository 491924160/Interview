package crack_interview;
import java.util.*;
public class check_stack {
	public boolean checkstack(int[]A, int[] B){
		int size = A.length;
		int a = 0, b = 0;
		Stack<Integer> stack = new Stack<Integer>();
		while(b < size){
			while(stack.isEmpty() || stack.peek() != B[b]){
				if(a >= size)
					return false;
				stack.push(A[a++]);
			}
			while(!stack.isEmpty() && stack.peek() == B[b])
			{
				stack.pop();
				b++;
			}
		}
		return true;
	}
}
