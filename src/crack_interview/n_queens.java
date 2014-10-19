package crack_interview;
import java.util.*;
public class n_queens {
	 List<String[]> lists;
	    public void create(boolean[] isUsed, List<String> list, int level, Map<Integer, Integer> map ){
	        if(level == isUsed.length){
	           String[] temp = new String[list.size()];
	           for(int i = 0; i < list.size(); i++)
	        	   temp[i] = list.get(i);
	           lists.add(temp);
	           return;
	        }
	        int size = isUsed.length;
	        for(int i = 0; i < size; i++){
	        	if(!isUsed[i] ){
	        		boolean flag = true;
	        		for(int j = 0; j < level; j++){
	        			int h = map.get(j);
	        			if(Math.abs(i-h) == Math.abs(j - level)){
	        				flag = false;
	        				break;
	        			}
	        		}
	        		if(flag){
	        			isUsed[i] = true;
		        		StringBuilder bd = new StringBuilder();
		        		map.put(level, i);
		        		for(int j = 0; j < size; j++){
		        			if(j == i)
		        				bd.append("Q");
		        			else
		        				bd.append(".");
		        		}
		        		list.add(bd.toString());
		        		create(isUsed, list, level +1, map);
		        		list.remove(list.size() - 1);
		        		map.remove(level);
		        		isUsed[i] = false;
	        		}
	        		
	        	}
	        }
	    }
	    public List<String[]> solveNQueens1(int n) {
	    	Map<Integer, Integer> map = new HashMap<Integer, Integer>();
	        boolean[] isUsed = new boolean[n];
	        lists = new ArrayList<String[]>();
	        create(isUsed, new ArrayList<String>(), 0, map);
	        return lists;
	    }
	    
	    public void create1(boolean[][] isUsed, List<String[]> list, int level){
	        if(level == isUsed.length){
	        	String[] temp = list.get(0);
	            String [] array = Arrays.copyOf(temp, temp.length);
	            lists.add(array);
	            return;
	        }
	        int col = isUsed.length;
	        for(int i = 0; i < col; i++){
	            boolean isOK = true;
	            for(int j = 0; j < level; j++){
	                if(isUsed[j][i]){
	                    isOK = false;
	                    break;
	                }
	                int diff = level - j;
	                int left = i-diff;
	                int right = i + diff;
	                if(left >= 0 && isUsed[j][left]){
	                    isOK = false;
	                    break;
	                }
	                if(right < col && isUsed[j][right]){
	                    isOK = false;
	                    break;
	                }
	            }
	            if(isOK){
	                isUsed[level][i] = true;
	                StringBuilder sb = new StringBuilder();
	                for(int h = 0; h < col; h++){
	                    if(h == i)
	                    sb.append("Q");
	                    else
	                    sb.append(".");
	                }
	                String[] temp = list.get(0);
	                temp[level] = sb.toString();
	                create1(isUsed, list, level+1);
	                temp[level] = null;
	                isUsed[level][i] = false;
	            }
	        }
	        
	    }
	    public List<String[]> solveNQueens(int n) {
	        boolean[][] isUsed = new boolean[n][n];
	        lists = new ArrayList<String[]>();
	        List<String[]> newlist = new ArrayList<String[]>();
	        String[] array = new String[n];
	        newlist.add(array);
	        create1(isUsed, newlist, 0);
	        return lists;
	    }
	    public static void main(String[]args){
	    	List<String[]> temp = new n_queens().solveNQueens(4);
	    	Iterator<String[]> iter = temp.iterator();
	    	while(iter.hasNext()){
	    		String[]temp1 = iter.next();
	    		for(String str : temp1)
	    			System.out.println(str);
	    	}
	    }
}
