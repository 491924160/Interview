package crack_interview;
import java.util.*;
public class MINWINDOW {
	public String minWindow(String S, String T) {
        Set<Character> set = new HashSet<Character>();
        char[] array = T.toCharArray();
        int[] counts = new int[256];
        Arrays.fill(counts, 0);
        for(char temp: array){
            counts[temp ]++;
            if(!set.contains(temp))
                set.add(temp);
        }
        int counter = 0;
        int limit = set.size();
        int prev = 0, len = Integer.MAX_VALUE, start = 0;
        for(int i = 0; i < S.length(); i++){
            if(set.contains(S.charAt(i))){
                counts[S.charAt(i)]--;
                if(counts[S.charAt(i)] == 0)
                counter++;
            }else{
                continue;
            }
            if(counter == limit){
                int k = prev;
                for(; k <= i; k++){
                    if(!set.contains(S.charAt(k)) )
                    continue;
                    else{
                        if(counts[S.charAt(k)]<0){
                            counts[S.charAt(k)]++;
                        }else{
                            break;
                        }
                    }
                }
                if(i - k + 1 <= len)
                {
                    len = i - k + 1;
                   start = k;
                }
                prev = k;
            }
        }
        if(len == Integer.MAX_VALUE)
        return new String("");
        else{
            return S.substring(start, start+ len);
        }
    }
    
	public static void main(String[]args){
		String s = "cabefgecdaecf";
		String  t = "cae";
		System.out.println(new MINWINDOW().minWindow(s, t));
		
	}
	
}
