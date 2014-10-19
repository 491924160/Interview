package crack_interview;

public class wildcard_matching {
	public boolean isMatch(String s, String p) {
		  boolean[][] result = new boolean[s.length()+1][p.length()+1];
	      result[0][0] = true;
	      for(int i = 0; i < p.length(); i++){
	    	  result[0][i + 1] = p.charAt(i) == '*' ? result[0][i]:false;
	      }
	      if(p.matches("\\*+"))
	          return true;
	      for(int i = 0; i < s.length(); i ++)
	    	  for(int j = 0; j < p.length();j++){
	    		  if(p.charAt(j) == '?' || p.charAt(j) == s.charAt(i)){
	    			  result[i+1][j+1] = result[i][j];
	    			  continue;
	    		  }
	    		  if(p.charAt(j) == '*'){     
	    		      result[i+1][j+1] = result[i+1][j] || result[i][j]||result[i][j+1];
	    		  }else{
	    			  result[i+1][j+1] = false;
	    		  }
	    		  
	    	  }
	      return result[s.length()][p.length()];
    }
	public static void main(String[]args){
		wildcard_matching temp = new wildcard_matching();
		System.out.println(temp.isMatch("aa", "a"));
		System.out.println(temp.isMatch("aa", "aa"));
		System.out.println(temp.isMatch("aaa", "aa"));
		System.out.println(temp.isMatch("aa", "*"));
		System.out.println(temp.isMatch("aa", "a*"));
		System.out.println(temp.isMatch("ab", "?*"));
		System.out.println(temp.isMatch("aab", "c*a*b"));
	}
}
