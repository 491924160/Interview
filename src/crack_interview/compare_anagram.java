package crack_interview;

public class compare_anagram {
	public static boolean compare_anagram(String s, String t){
		int[] numbers = new int[256];
		char[] source = s.toCharArray();
		char[] des = t.toCharArray();
		if(s.length() != t.length())
			return false;
		for(int i = 0; i < s.length(); i++){
			numbers[source[i]]++;
		}
		for(int j = 0; j < des.length; j++){
			if(--numbers[des[j]] < 0)
				return false;
		}
		for(int k : numbers){
			if(k != 0)
				return false;
		}
		return true;
	}
}
