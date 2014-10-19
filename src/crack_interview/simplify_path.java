package crack_interview;
import java.util.*;
public class simplify_path {
	 public String simplifyPath(String path) {
	        List<String> s = new ArrayList<String>();
	        String[] arrays = path.split("/");
	        for(String temp: arrays){
	            if(temp.equals("."))
	            continue;
	            if(temp.equals("..")){
	                 if(!s.isEmpty())
	                 s.remove(s.size() -1);
	                 continue;
	            }
	            if(!temp.isEmpty())
	            	s.add(temp);
	        }
	        StringBuilder bd = new StringBuilder();
	        for(String temp: s){
	            bd.append("/" + temp);
	        }
	        return bd.toString();
	    }
	 public static void main(String[]args){
		 String temt = "/a/./b/../../c/";
		 System.out.print(new simplify_path().simplifyPath(temt));
	 }
}
