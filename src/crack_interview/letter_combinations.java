package crack_interview;
import java.util.*;
public class letter_combinations {
	 Map<Character,Character[]> map; 
	    char[] array;
	    char[] cons;
	    List<String> result;

	   public letter_combinations(){
	        map = new HashMap<Character,Character[]>();
	        map.put('2', new Character[]{'a','b','c'});
	        map.put('3', new Character[]{'d','e','f'});
	        map.put('4', new Character[]{'g','h','i'});
	        map.put('5', new Character[]{'j','k','l'});
	        map.put('6', new Character[]{'m','n','o'});
	        map.put('7', new Character[]{'p','q','r','s'});
	        map.put('8', new Character[]{'t','u','v'});
	        map.put('9', new Character[]{'w','x','y','z'});
	    }
	    public List<String> letterCombinations(String digits){
	        result = new ArrayList<String>();
	        recusive_add(digits, 0, new ArrayList<Character>());
	        return result;
	    }
	    
	    public void recusive_add(String digits, int level, List<Character> list){
	        if(level == digits.length())
	        {
	           StringBuilder sb = new StringBuilder();
	           for(char a: list){
	               sb.append(a);
	           }
	            result.add(sb.toString());
	            return;
	        }
	        char a = digits.charAt(level);
	        Character[] array = map.get(a);
	        if(array != null){
	            for(char b: array){
	                list.add(b);
	                recusive_add(digits, level+1, list);
	                list.remove(list.size()-1);
	            }
	        }else{
	            recusive_add(digits, level+1, list);
	        
}
	    }
	    public static void main(String[]args){
	    	letter_combinations test = new letter_combinations();
	    	List<String> list1 = test.letterCombinations("23");
	    	for(String temp: list1){
	    		System.out.println(temp);
	    	}
	    }

}
