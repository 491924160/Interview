package crack_interview;
import java.util.*;
public class generate_parenthese {
	public void recureseGenerate(List<String> list, int left, int right, List<Character> stack){
		if(left == 0 && right == 0){
			StringBuilder builder = new StringBuilder();
			for(char a: stack)
				builder.append(a);
			list.add(builder.toString());
			return;
		}
		if(left == right){
			stack.add('(');
			recureseGenerate(list, left-1,right, stack);
			stack.remove(stack.size()-1);
		}
		if(left < right){
			if(left > 0){
				stack.add('(');
				recureseGenerate(list, left -1, right, stack);
				stack.remove(stack.size()-1);
			}
			stack.add(')');
			recureseGenerate(list, left, right-1, stack);
			stack.remove(stack.size()-1);
		}
			
	}
	 public List<String> generateParenthesis(int n) {
	       List<String> list = new ArrayList<String>();
	       List<Character> stack = new ArrayList<Character>();
	       recureseGenerate(list, n, n, stack);
	       return list;   
	 }
	 public static void main(String[]args){
		List<String> list = new generate_parenthese().generateParenthesis(3);
		for(String temp: list)
			System.out.println(temp);
	 }
}
