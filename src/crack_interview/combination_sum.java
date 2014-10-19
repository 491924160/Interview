package crack_interview;
import java.util.*;
public class combination_sum {
	 List<List<Integer>> lists;
	 public void recadd(int[] A, int target, List<Integer> list, int start){
	        if(target == 0){
	            lists.add(new ArrayList<Integer>(list));
	            return;
	        }
	        for(int i = start; i < A.length; i++){
	            if(i > start && A[i] == A[i - 1])
	                continue;
	            if(target - A[i] >= 0){
	                list.add(A[i]);
	                recadd(A, target - A[i], list, i);
	                list.remove(list.size()-1);
	            }else{
	                return;
	            }
	        }
	    }
	    public List<List<Integer>> combinationSum(int[] candidates, int target) {
	        Arrays.sort(candidates);
	        lists = new ArrayList<List<Integer>>();
	        recadd(candidates, target, new ArrayList<Integer>(), 0);
	        return lists;
	    }
	    public static void main(String[]args){
	    	combination_sum  test = new combination_sum();
	    	int[] array = {1,2};
	    	List<List<Integer>> lsit1 = test.combinationSum(array, 3);
	    	int i = 0;
	    }
}
