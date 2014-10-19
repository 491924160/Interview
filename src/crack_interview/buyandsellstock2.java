package crack_interview;

public class buyandsellstock2 {
	 public int maxProfit(int[] prices) {
	        int len = prices.length;
	        if(len <= 1)
	        	return 0;
	        int[][] result = new int[len][len];
	        for(int i = 1; i < len; i++){
	        	for(int j = i-1; j >= 0; j--){
	        		if(result[0][j] + prices[i] - prices[j] > result[0][i])
	        			result[0][j] = result[0][j] + prices[i] - prices[j];
	        	}
	        }
	        return result[0][len - 1];
	    }
}
