package crack_interview;

public class longest_palindromic_substring {
	 public String longestPalindrome(String s) {
	        int length = s.length();
	        if(length == 0 || length == 1)
	        	return s;
	        boolean[][] result = new boolean[length][length];
	        for(int i = 0; i < length; i++){
	        	result[i][i] = true;
	        }
	        int low = 0, high = 0, maxlen = 1;
	        for(int i = 1; i < length;i++){
	        	for(int j = i -1; j >= 0; j--){
	        		char a = s.charAt(i), b = s.charAt(j);
	        		if(j == i -1){
	        			result[j][i] = a==b?true:false;
	        			if(maxlen < 2 && result[j][i]){
	        				low = j;
	        				high = i;
	        				maxlen = 2;
	        			}
	        			continue;
	        		}
	        		if(a == b){
	        			result[j][i] = result[j+1][i-1];
	        			if(i - j +1 > maxlen && result[j][i]){
	        				low = j;
	        				high = i;
	        				maxlen = i - j + 1;
	        			}
	        		}else{
	        			result[j][i] = false;
	        		}
	        	}
	        }
	        return s.substring(low, high+1);
	 }
	 public static void main(String[]args){
		 String test = "abb";
		 System.out.println(new longest_palindromic_substring().longestPalindrome(test));
	 }
}
