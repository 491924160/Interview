package crack_interview;
import java.util.*;
public class twosum_unsorted {
	 public int[] twoSum(int[] numbers, int target) {
		 	Map<Integer, Integer> map = new HashMap<Integer, Integer>();
	        for(int i = 0; i < numbers.length; i++){
	        	map.put(numbers[i], i);
	        }
	        for(int i = 0; i < numbers.length; i++){
	        	if(map.containsKey(target - numbers[i]) &&  map.get(target - numbers[i]) != i){
	        		int[] array = new int[2];
	        		array[0] = i;
	        		array[1] = map.get(target - numbers[i]);
	        		return array;
	        	}
	        }
	       
	        return null;
	  }
	 public static void main(String[]args){
		 int[] array = {3, 2, 4};
		 System.out.println(new twosum_unsorted().twoSum(array, 6));
	 }
}
