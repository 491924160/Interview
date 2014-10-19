package crack_interview;

public class longest_numberstring {
	public String longest(String s){
		if(s == null)
			return null;
		int cur = 0, max = 0, start = 0;
		while(cur < s.length()){
			int temp =  cur;
			while(cur < s.length() && s.charAt(cur) >='0' && s.charAt(cur)<='9')
				cur++;
			if(cur - temp > max){
				start = temp;
				max = cur-start;
			}
			if(cur == temp)
				cur++;
		}
		return s.substring(start, start + max);
	}
	
	public static void main(String[]args){
		 System.out.println(new longest_numberstring().longest("12345"));
		 System.out.println(new longest_numberstring().longest("asdasfd45"));
	}
}
