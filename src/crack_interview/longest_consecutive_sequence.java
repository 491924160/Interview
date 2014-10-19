package crack_interview;

import java.util.*;
public class longest_consecutive_sequence {
	public int longestConsecutive(int[] num){
		int len  = num.length;
		if(len == 0)
			return 0;
		if(len == 1)
			return 1;
		Map<Integer, Integer> map = new HashMap<Integer, Integer>();
		int max = 0;
		for(int i = 0; i < len; i++){
			if(map.containsKey(num[i]))
				continue;
			int up = num[i], low = num[i];
			if(map.containsKey(num[i] - 1)){
				low = map.get(num[i] - 1);
			}
			if(map.containsKey(num[i] + 1))
				up = map.get(num[i] + 1);
			max = Math.max(max, up - low + 1);
			map.put(num[i], num[i]);
			map.put(low, up);
			map.put(up, low);
					
			
		}
		return max;
	}
}
