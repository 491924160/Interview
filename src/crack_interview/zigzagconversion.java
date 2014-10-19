package crack_interview;
import java.util.*;
public class zigzagconversion {
	public String convert(String s, int nRows) {
        if(nRows == 1)
        	return s;
        List[] list = new ArrayList[nRows];
        for(int i = 0; i < nRows; i++){
        	list[i] = new ArrayList<Character>();
        }
        int i = 0;
        while(i < s.length()){
        	for(int j = 0; j < nRows;j++){
        		if(i >= s.length())
        			break;
        		list[j].add(s.charAt(i++));
        	}
        	for(int j = nRows - 2; j >= 1; j--){
        		if(i>=s.length())break;
        		list[j].add(s.charAt(i++));
        	}
        }
        StringBuilder builder = new StringBuilder();
        for(int k = 0; k < nRows; k++){
        	List temp = list[k];
        	Iterator iter = temp.iterator();
        	while(iter.hasNext())
        		builder.append(iter.next());
        }
        return builder.toString();
    }
	public static void main(String[]args){
		String test = "abcd";
		System.out.println(new zigzagconversion().convert(test, 3));
	}
}
