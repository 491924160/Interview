package crack_interview;
import java.util.*;
public class valid_parentheses {
    public boolean isValid(String s) {
    	if(s.length() == 0)
    		return true;
    	Deque<Character> stack = new LinkedList<Character>();
    	char[] array = s.toCharArray();
    	if(array.length % 2 != 0)
        	return false;
    	for(int i = 0; i < array.length;i++){
    		if(array[i] == '{' || array[i] == '[' || array[i] == '(' ){
    			stack.push(array[i]);
    			continue;
    		}else{
    			if(stack.isEmpty())
    				return false;
    			char temp = stack.pop();
    			if(array[i] == '}'){
    				if(temp != '{')
    					return false;
    			}else if(array[i] == ']'){
    				if(temp != '[')
    					return false;
    			}else{
    				if(temp != '(')
    					return false;
    			}
    			
    		}
    			
    	}
    	return true;
    }
    public static void main(String[]args){
    	String test = "{}[]";
    	System.out.println(new valid_parentheses().isValid(test));
    }
}
