package crack_interview;

public class allocate_negativepositive {
	public void sort(int[] A){
		if(A == null || A.length == 1)
			return;
		int small = 0, large = A.length-1;
		int cur = 0;
		while(cur < A.length){
			if(A[cur]< 0){
				int temp = A[small];
				A[small] = A[cur];
				A[cur] = temp;
				small++;
			}
			cur++;
		}
	}
	public static void main(String[]args){
		int[] array = {1,5,-2,-1,6,-2,10};
		 new allocate_negativepositive().sort(array);
		for(int temp : array){
			System.out.println(temp);
		}
	}
	
}
