package crack_interview;
import java.util.*;
public class combinations {
	 static List<List<Integer>> lists;
	    public void res(int level, int n, List<Integer> list, int start ){
	        if(level == 0){
	            lists.add(new ArrayList(list));
	            return;
	        }
	        if(start > n)
	             return;
	        for(int i = start; i <= n;i++){
	             list.add(i);
	             res(level-1, n, list, i+1);
	             list.remove(list.size()-1);
	        }
	        return;
	    }
	    public List<List<Integer>> combine(int n, int k) {
	        lists = new ArrayList<List<Integer>>();
	        res(k, n, new ArrayList<Integer>(), 1);
	        return lists;
	    }
	    public static void main(String[]args){
	    	lists = new ArrayList<List<Integer>>();
	    	 new combinations().combine(4, 2);
	    }
}
