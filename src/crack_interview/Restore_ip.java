package crack_interview;
import java.math.BigInteger;
import java.util.*;
public class Restore_ip {
	 
	  List<String> lists;
	    public void createIP(String s, int start, int level, List<Integer> list){
	        if(level == 3){
	            if(start == s.length())
	            return;
	            String temp = s.substring(start);
//	            int m = 0;
//	            for(; m < temp.length(); m++){
//	                if(temp.charAt(m) == '0')
//	                m++;
//	            }
//	            if(m >= temp.length())
//	            return;
//	           temp = temp.substring(m);
//	           if(temp.length() >3)
//	           return;
	           int i = Integer.parseInt(temp);
	            if(i<=255){
	                StringBuilder bd = new StringBuilder();
	                for(int j = 0; j < list.size();j++){
	                    if(j == 0){
	                        bd.append(list.get(0));
	                    }else{
	                        bd.append("." + list.get(j));
	                    }
	                }
	                bd.append("."+i);
	                lists.add(bd.toString());
	            }
	            return;
	        }
	        for(int i = 1; i <= 3; i++){
	            if(start + i <= s.length()){
	                 String temp = s.substring(start, start+i);
	            int ip = Integer.parseInt(temp);
	            if(ip >=0 && ip <=255){
	                list.add(ip);
	                createIP(s, start + i, level +1, list);
	                list.remove(list.size()-1);
	            }
	        }
	            else{
	                return;
	            }
	        }
	           
	    }
	    public List<String> restoreIpAddresses(String s) {
	        lists = new ArrayList<String>();
	        if(s == null || s.isEmpty())
	        return lists;
	        createIP(s, 0, 0, new ArrayList<Integer>());
	        return lists;
	    }
	    public static void main(String[]args){
	    	String s = "0000";
	    	
	    	List<String> list = new Restore_ip().restoreIpAddresses(s);
	    	for(String temp: list)
	    		System.out.println(temp);
	    }
}
