package crack_interview;
import java.util.*;
public class Triangle {
	 public int minimumTotal(List<List<Integer>> triangle) {
	      int len = triangle.size();
	      if(len == 0)
	    	  return 0;
	      int[] result = new int[len];
	      result[0] = triangle.get(0).get(0);
	      for(int i = 1; i < triangle.size();i++){
	    	  List<Integer> temp = triangle.get(i);
	    	  for(int j = temp.size() - 1; j >= 0; j--){
	    		  if(j == 0){
	    			  result[j] = result[j] + temp.get(j);
	    			  continue;
	    		  }
	    		  if(j == temp.size()-1){
	    			  result[j] = result[j - 1] + temp.get(j);
	    			  continue;
	    		  }
	    		  if(result[j] > result[j-1])
	    			  result[j] = result[j-1] + temp.get(j);
	    		  else
	    			  result[j] = result[j] + temp.get(j);
	    	  }
	      }
	      int min = Integer.MAX_VALUE;
	      for(int i: result){
	    	  if(i < min)
	    		  min = i;
	      }
	      return min;
	 }
	 public static void main(String[]args){
		 List<Integer> list = new ArrayList<Integer>();
		 list.add(-1);
		 List<List<Integer>> lists = new ArrayList<List<Integer>>();
		 lists.add(list);
		 List<Integer> list2 = new ArrayList<Integer>();
		 List<Integer> list3 = new ArrayList<Integer>();
		 list2.add(2);
		 list2.add(3);
		 lists.add(list2);
		 list3.add(1);
		 list3.add(-1);
		 list3.add(-1);
		 lists.add(list3);
		 System.out.println(new Triangle().minimumTotal(lists));
	 }
}
