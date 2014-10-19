package crack_interview;
import java.util.*;
public class permutation {
	 static List<List<Integer>> lists;
	    public void create(int[] num, boolean[] res, int level, List<Integer> list){
	        if(level == num.length){
	            lists.add(new ArrayList<Integer>(list));
	            return;
	        }
	        for(int i = 0; i < num.length; i++){
	             if (res[i] == false)
	             continue;
	            if (i > 0 && num[i]==num[i-1]&& res[i-1])//Not needed for Permutation I
	                continue;//Not needed for Permutation I
	                res[i] =false;
	                list.add(num[i]);
	                create(num, res, level+1, list);
	                list.remove(list.size()-1);
	                res[i] = true;
	        }
	    }
	 
	    public List<List<Integer>> permuteUnique(int[] num) {
	        Arrays.sort(num);
	         boolean[] res = new boolean[num.length];
	        for(int i = 0; i < num.length; i++)
	        res[i] = true;
	        lists = new ArrayList<List<Integer>>();
	        create(num, res, 0, new ArrayList<Integer>());
	        return lists;
	    }
	    
	    public void permutation(int[] num, int start){
	        if(start == num.length){
	           List<Integer> temp = new ArrayList<Integer>();
		            for(int num1: num)
		            	temp.add(num1);
		            lists.add(temp);
		            return;
	        }
	         permutation(num, start+1);
	        for(int i = start; i < num.length; i++){
	            int a = num[start], b = num[i];
	            if(a != b){
	                num[start] = b;
	                num[i] = a;
	                permutation(num, start+1);
	                num[start] = a;
	                num[i] = b;
	            }
	        }
	    }
	    public static void main(String[]args){
	    	int[]array = {-1,-1,3,-1};
	    	List<List<Integer>> list = new permutation().permuteUnique(array);
	    	lists = new ArrayList<List<Integer>>();
//	    	new permutation().permutation(array, 0);
	    	for(List<Integer> temp: list){
	    		Iterator iter = temp.iterator();
	    		while(iter.hasNext()){
	    			System.out.print(iter.next());
	    		}
	    		System.out.println("\n");
	    	}
	    }
}
