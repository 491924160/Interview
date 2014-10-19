package crack_interview;

public class isMatch {
	  public boolean checkValid(String s, int start1, String p, int start2){
	        if(start1 == s.length() && start2 == p.length())
	        return true;
	        if(start2 == p.length())
	        return false;
	        if(start1 == s.length()){
	            if(p.charAt(start2) == '*')
	            return checkValid(s, start1, p, start2+1);
	            else return false;
	        }
	        char a = s.charAt(start1), b = p.charAt(start2);
	        if(b == '*'){
	            while(start1 <= s.length()){
	                if( checkValid(s, start1++, p, start2 + 1))
	                	return true;
	            }
	            return false;
	        }
	        if(a == b || b == '.'){
	            return checkValid(s, start1+1, p, start2+1) || checkValid(s, start1, p, start2+1);
	        }
	        return checkValid(s, start1, p, start2+1);
	        
	    }
	    public boolean isMatch1(String s, String p) {
	        if(s == null || p == null)
	        return false;
	        return checkValid(s,0, p, 0);
	    }
	    public static void main(String[]args){
	    	System.out.println(new isMatch().isMatch1("aa", "a"));
	    	System.out.println(new isMatch().isMatch1("aa", "aa"));
	    	System.out.println(new isMatch().isMatch1("aaa", "aa"));
	    	System.out.println(new isMatch().isMatch1("aa", "a*"));
	    	System.out.println(new isMatch().isMatch1("aaa", "a*"));
	    	System.out.println(new isMatch().isMatch1("aa", ".a"));
	    	System.out.println(new isMatch().isMatch1("ab", ".*"));
	    	System.out.println(new isMatch().isMatch1("aab", "c*a*b"));
	    }
	    
}
