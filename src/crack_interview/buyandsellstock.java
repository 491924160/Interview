package crack_interview;

public class buyandsellstock {
	public int maxprofit(int[] prices, int start, int end){
		if(start == end)
			return 0;
		int mid = (start + end) / 2;
		int leftmax = maxprofit(prices, start, mid);
		int rightmax = maxprofit(prices, mid + 1, end);
		int max = Math.max(leftmax, rightmax);
		int leftmin = Integer.MAX_VALUE, rightmost = Integer.MIN_VALUE;
		for(int i = start; i <= mid; i++){
			if(prices[i] < leftmin)
				leftmin = prices[i];
		}
		for(int i = mid + 1; i <= end; i++){
			if(prices[i] > rightmost)
				rightmost = prices[i];
		}
		return Math.max(rightmost - leftmin, max);
	}
	public int maxProfit(int[] prices){
		int len = prices.length;
		if(len <= 1)
			return 0;
		return maxprofit(prices, 0, len - 1);
	}
}
