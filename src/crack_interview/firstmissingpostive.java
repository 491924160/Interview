package crack_interview;

public class firstmissingpostive {
	public static int solution(int[] A) {
			int len = A.length;
			if(len == 0)
				return 1;
			for(int i = 0; i < len; i ++){
				if(A[i] > 0 && A[i] <= len && A[i] != i+1){
					int temp = A[i];
					A[i] = A[A[i] - 1];
					A[temp - 1] = temp;
					i--;
				}
			}
			for(int i = 0; i < len; i++){
			    if(A[i] != i + 1)
			        return i + 1;
			}
			return len + 1;
    }
}
