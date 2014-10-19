package crack_interview;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

public class Number_Four_equal {
	void Calculate_number(int[] A){
		Map<Integer, Integer> map = new HashMap<Integer, Integer>();
		for(int i = 0; i < A.length; i++){
			map.put(A[i], i);
		}
		Arrays.sort(A);

	
		if(A.length < 4)
			return;
		int i = 0;
		while(i < A.length - 3){
			int j = A.length - 1;
			while(j - i >= 3){
				int m = i + 1, n = j - 1;
				while(m < n){
					int outside = A[i] + A[j];
					int inside = A[m] + A[n];
					if(outside == inside){
						System.out.println(map.get(A[i]) + "\t" + map.get(A[m]) + "\t" + map.get(A[n]) + "\t" + map.get(A[j]) + "\n");
						while( m < n && A[m] == A[++m]);
						while(m < n && A[n] == A[--n]);
					}else if (outside < inside){
						while(m < n && A[n] == A[--n]);
					}else{
						while( m < n && A[m] == A[++m]);
					}
				}
				while(j-i >=3 && A[j] == A[--j]);
			}
			while(i < A.length - 3 && A[i] == A[++i]);
		}
	}
	public static void main(String[]args){
		int[] array = {3,4,17,1,-22,9,8};
		new Number_Four_equal().Calculate_number(array);
	}
}
