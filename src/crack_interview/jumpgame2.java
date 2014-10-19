package crack_interview;

public class jumpgame2 {
	 public int jump(int[] A) {
	        if(A.length == 1)
	        return 0;
	        int[] res = new int[A.length];
	        res[0] = 0;
	        for(int i = 1; i< A.length; i++)
	        res[i] = Integer.MAX_VALUE;
	        for(int i = 1; i < A.length; i++){
	            for(int j = i-1; j>=0; j--){
	                if(A[j] >= i-j && res[i] > res[j] + 1)
	                res[i] = res[j] + 1;
	            }
	            
	        }
	        return res[A.length -1];
	   }
}
