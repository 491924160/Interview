package crack_interview;

import java.util.*;

public class sum_4 {
	
	public List<List<Integer>> fourSum(int[] num, int target) {
        List<List<Integer>> list = new ArrayList<List<Integer>>();
        Arrays.sort(num);
        for(int i = 0; i < num.length - 3; i++){
            if(i > 0 && num[i-1] == num[i])
                 continue;
                for(int j = num.length -1; j > i +2; j--){
                    if(j < num.length -1 && num[j] == num[j+1])
                    continue;
                int k = i+1, m = j -1;
                while(k < m){
                    int total = num[i] + num[j] + num[k] + num[m];
                    if(total == target){
                        List<Integer> temp = new ArrayList<Integer>();
                        temp.add(num[i]);
                        temp.add(num[k]);
                        temp.add(num[m]);
                        temp.add(num[j]);
                        list.add(temp);
                        k++;
                        m--;
                        while(k < m && num[k-1] == num[k])
                        k++;
                        while(k < m && num[m] == num[m+1])
                        m--;
                    }else if(total > target){
                        m--;
                    }else{
                        k++;
                    }
                }
            }
            
        }
        return list;
    }
	
	public static void main(String[]args){
		sum_4 test = new sum_4();
		int[] array = {1 ,0 ,-1, 0, -2, 2};
		Arrays.sort(array);
		List<List<Integer>> list = test.fourSum(array, 0);
		int k = 1;
	}
}
