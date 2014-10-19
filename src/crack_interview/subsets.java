package crack_interview;
import java.util.*;

public class subsets {
	  public void subset(int[] s, List<Integer> list, int start, List<List<Integer>> lists){
	        lists.add(new ArrayList<Integer>(list));
//	        for(int i = start; i < s.length; i++){
//	            if(i > start && s[i] == s[i-1])
//	            continue;
//	            list.add(s[i]);
//	            subset(s, list, i+1, lists);
//	            list.remove(list.size()-1);
//	        }
	        
	    }
	    public List<List<Integer>> subsets1(int[] S) {
	        Arrays.sort(S);
	        List<List<Integer>> lists = new ArrayList<List<Integer>>();
	        List<Integer> list = new ArrayList<Integer>();
	        subset(S, list, 0, lists);
	        return lists;
	    }
	    public List<List<Integer>> subsets2(int[] S) {
	        Arrays.sort(S);
	        List<List<Integer>> lists = new ArrayList<List<Integer>>();
	        List<Integer> list = new ArrayList<Integer>();
	        subset(S, list, 0, lists);
	        return lists;
	    }
	    
	    public static void main(String[]args){
	    	int[]array = {1,1,3};
	    	List<List<Integer>> list = new subsets().subsets1(array);
	    	int i = 1;
	    }
}
