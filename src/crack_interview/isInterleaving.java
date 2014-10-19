package crack_interview;

public class isInterleaving {
	 public boolean check(String s1, String s2, String s3, int start1, int start2, int start3){
	        if(start3 == s3.length())
	        return true;
	        for(int i = 1; i <= s1.length() - start1; i++){
	            String sub1 = s1.substring(start1, start1+i);
	            String sub2 = s3.substring(start3, start3+i);
	            if(sub1.equals(sub2)){
	                if(check(s1,s2,s3,start1+i, start2, start3+i))
	                return true;
	            }
	        }
	        for(int i = 1; i <= s2.length() - start2; i++){
	            String sub1 = s2.substring(start2, start2+i);
	            String sub2 = s3.substring(start3, start3+i);
	            if(sub1.equals(sub2)){
	                if(check(s1,s2,s3,start1, start2+i, start3+i))
	                return true;
	            }
	        }
	        return false;
	    }
	    public boolean isInterleave(String s1, String s2, String s3) {
	         return check(s1, s2, s3, 0, 0, 0);
	    }
	    public static void main(String[]args){
	    	isInterleaving test = new isInterleaving();
	    	System.out.println(test.isInterleave("aabcc", "dbbca", "aadbbbaccc"));
	    }
}
