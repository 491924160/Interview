package crack_interview;

public class count_say {
	public String countAndSay(int n) {
		if(n < 10)
			return new String("" + n);
        String temp = new String("" + n);
        StringBuilder bd = new StringBuilder();
        int cur = 0;
        while(cur < temp.length()){
            int prev = cur; 
            cur = cur +1;
            while(cur < temp.length() && temp.charAt(cur) == temp.charAt(prev))
            cur++;
            int len = cur - prev;
            bd.append("" + len + temp.charAt(prev));
        }
        return bd.toString();
    }
	public static void main(String[]args){
		count_say test = new count_say();
		System.out.println(test.countAndSay(11));
	}
}
