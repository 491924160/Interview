package crack_interview;

public class merge_twosortedarray {
	 public void merge(int[]A, int m, int B[], int n){
	        int i = m-1, j = n-1, pos = m+n-1;
	        while(i>=0 && j >=0){
	            if(A[i] > B[j]){
	                A[pos--] = A[i--];
	            }else{
	                A[pos--] = B[j--];
	            }
	        }
	        while(i>=0){
	            A[pos--] = A[i--];
	        }
	        while(j>=0){
	            A[pos--] = B[j--];
	        }
	    }
}
