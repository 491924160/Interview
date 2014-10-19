package crack_interview;
import java.util.*;
public class longest_substring_withoutrepeatingcharactr {
	public int lengthOfLongestSubstring(String s) {
		if(s == null)
			return 0;
		Map<Integer, Integer> map = new HashMap<Integer, Integer>();
		int count = 0, max = 0;
		for(int i = 0; i < s.length(); i++){
			count++;
			if(map.containsKey(s.codePointAt(i)) && map.get(s.codePointAt(i)) > i - count)
				count = i - map.get(s.codePointAt(i));
			map.put(s.codePointAt(i), i);
			max = Math.max(max, count);
		}
		return max;
		
    }
}
