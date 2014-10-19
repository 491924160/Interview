package crack_interview;

import java.util.*;
public class Sum_3 {
	 public List<List<Integer>> threeSum(int[] num) {
	    Arrays.sort(num);
	    List<List<Integer>> list = new ArrayList<List<Integer>>();
	    Set<Integer> set = new HashSet<Integer>();
	    for(int i: num){
	    	if(!set.contains(i))
	    		set.add(i);
	    }
	    for(int i = 0; i < num.length; i++){
	    	for(int j = i + 1; j < num.length; j++){
	    		if(num[i] > 0)
	    			return list;
	    		while(num[j] == num[i])
	    			j++;
	    		int count = j - i;
	    		if(count >1){
	    			
	    		}else{
	    			
	    		}
	    	}
	    }
	 }
}
