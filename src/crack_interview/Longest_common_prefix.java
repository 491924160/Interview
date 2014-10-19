package crack_interview;

public class Longest_common_prefix {
	public String longestCommonPrefix(String[] strs) {
		if(strs.length == 0)
			return null;
	   int min = Integer.MAX_VALUE;
       for(String temp: strs){
    	   if(temp.length() < min){
    		   min = temp.length();
    	   }
       }
       int high = Integer.MIN_VALUE;
       for(int i = 0; i < min; i++){
    	   char a = strs[0].charAt(i);
    	   for(String temp: strs){
    		   if(temp.charAt(i) == a)
    			   continue;
    		   else{
    			   if(high >=0){
    				   return strs[0].substring(0, high + 1);
    			   }else{
    				   return null;
    			   }
    		   }
    	   }
    	   high = i;
       }
       return strs[0].substring(0, high + 1);
    }
}
