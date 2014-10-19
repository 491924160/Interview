package crack_interview;

import java.util.Arrays;

public class isScramble {
	 public boolean isScramble(String s1, String s2) {
	        if(s1.length() != s2.length())
	        return false;
	        if(s1.equals(s2))
	        return true;
	        char[] string1 = s1.toCharArray();
	        char[] string2 = s2.toCharArray();
	        Arrays.sort(string1);
	        Arrays.sort(string2);
	        if(!Arrays.equals(string1, string2))
	        	return false;
	        for(int i = 1; i < s1.length() -1; i++){
	            if(isScramble(s1.substring(0,i), s2.substring(0, i)) && isScramble(s1.substring(i), s2.substring( i)) )
	            return true;
	            if(isScramble(s1.substring(0,i), s2.substring(s2.length()- i)) && isScramble(s1.substring(i), s2.substring(0, s2.length() - i) ))
	            return true;
	        }
	        return false;
	    }
	  public boolean isScramble1(String s1, String s2) {
	      if(s1.length() != s2.length())
	      return false;
	      if(s1.equals(s2))
	      return true;
	      return check(s1, 0, s1.length(), s2,0, s2.length());
	  }       
	  public boolean check(String s1, int start1, int end1, String s2, int start2, int end2){
	      if(start1+1 == end1){
	          char temp1 = s1.charAt(start1);
	          char temp2 = s2.charAt(start2);
	          if(temp1 == temp2)
	          return true;
	          else return false;
	      }
	      if(s1.substring(start1, end1).equals(s2.substring(start2, end2)))
	      return true;
	      char[] string1 = s1.substring(start1, end1).toCharArray();
	        char[] string2 =  s2.substring(start2, end2).toCharArray();
	        Arrays.sort(string1);
	        Arrays.sort(string2);
	        if(!Arrays.equals(string1, string2))
	        	return false;
	       for(int end = start1+1; end < end1; end++){
	           int len = end - start1;
	           if(check(s1, start1, end, s2, start2, start2 + len)&& check(s1, end1-len, end1, s2, end2- len, end2))
	           return true;
	           if(check(s1, start1, end, s2, end2-len, end2) && check(s1, end, end1, s2, start2, end2-len))
	           return true;
	       }
	       return false;
	  }
	  public static void main(String[]args){
		  System.out.println(new isScramble().isScramble("sqksrqzhhmfmlmqvlbnaqcmebbkqfy", "abbkyfqemcqnblvqmlmfmhhzqrskqs"));
	  }
}
