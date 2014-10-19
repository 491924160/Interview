package crack_interview;

public class isPalindrome {
	 public boolean isPalindrome1(String s) {
	        if(s.length() == 0 || s.length() == 1)
				return true;
			String lower = s.toLowerCase();
			StringBuilder bd = new StringBuilder();
			for(int i = 0; i < lower.length(); i++){
			    char temp = lower.charAt(i);
			    if((temp >= 'a' && temp <='z') ||(temp >='0' && temp <='9'))
			    bd.append(temp);
			}
	        String test = bd.toString();
	        int i = 0, j = test.length()-1;
	        while(i < j){
	            char a = test.charAt(i++), b = test.charAt(j--);
	            if(a != b)
	            return false;
	        }
	        return true;
	    }
	 public static void main(String[]args){
		 String temp = "aa";
		 new isPalindrome().isPalindrome1(temp);
	 }
	 
}
