package crack_interview;

public class validpalindrome {
	public boolean isPalindrome(String s){
		if(s.length() == 0 || s.length() == 1)
			return true;
		String lower = s.toLowerCase();
		int i = 0, j = lower.length() - 1;
		while(i < j){
			while(!(lower.charAt(i) >= 'a' && lower.charAt(i) <='z')){
				i++;
			}
			while(!(lower.charAt(j) >= 'a' && lower.charAt(j) <='z')){
				j--;
			}
			if(lower.charAt(i++) == lower.charAt(j--))
				continue;
			else return false;
		}
		return true;
	}
}
