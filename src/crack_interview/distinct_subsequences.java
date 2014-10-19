package crack_interview;

public class distinct_subsequences {
	public static int numDistinct(String s, String t){
		if(s.length() < t.length())
			return 0;
		if(s.length() == t.length())
			return s.equals(t) == true? 1: 0;
		int[][] array = new int[s.length() + 1][t.length() + 1];
		array[0][0] = 1;
		for(int i = 0; i < t.length(); i++)
			for(int j = i; j < s.length(); j++)
				for(int m = j; m >=i; m--){
					if(s.charAt(m) == t.charAt(i)){
						array[j + 1][i + 1] += array[m ][i];
				}
				}
		return array[s.length()][t.length()];
	}
	public static int numDistinct1(String s, String t){
		int m = s.length(), n = t.length();
		if(m < n)
			return 0;
		int[] result1 = new int[s.length()];
		int[] result2 = new int[s.length()];
		for(int i = 0; i < s.length(); i++){
			result2[i] = 1;
		}
		for(int i = 0; i < t.length(); i++){
			for(int j = i; j < s.length();j++){
				if(t.charAt(i) == s.charAt(j)){
					if(j - 1 < 0)
						result1[j] = 1;
					else{
						result1[j] = result2[j - 1] + result2[j];
					}
				}else{
					if(j - 1 < 0)
						result1[j] = 0;
					else{
						result1[j] = result2[j-1];
					}
				}
			}
			for(int h = 0; m < s.length(); m++)
			{
				result2[h] = result1[h];
				result1[h] = 0;
			}
		}
		return result2[s.length()-1];
	}
	public static void main(String[]args){
		String s = "rabbit", t = "rabbbit";
		System.out.println(distinct_subsequences.numDistinct1(t, s));
	}
}
