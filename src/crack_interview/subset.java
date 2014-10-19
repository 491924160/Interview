package crack_interview;
import java.util.*;
public class subset {
    public void recurse(int[]num, int start, int end, List<List<Integer>> list, List<Integer> queue){
        if(start > end)
        return;
        if(start == end){
            List<Integer> temp = new ArrayList<Integer>(queue);
            temp.add(num[start]);
            list.add(temp);
            return;
        }
        for(int i = start; i <= end; i++){
            queue.add(num[i]);
            List<Integer> temp = new ArrayList<Integer>(queue);
            list.add(temp);
            if(i + 1<= end && num[i+1] == num[i]){
                recurse(num, i+1, end, list, queue);
            }
            while(num[++i] == num[i] && i <=end);
            if(i <= end)
            recurse(num, i, end, list, queue);
            queue.remove(queue.size()-1);
            i = i-1;
        }
    }
    
    public List<List<Integer>> subsetsWithDup(int[] num) {
        Arrays.sort(num);
        List<List<Integer>> list = new ArrayList<List<Integer>>();
        ArrayList<Integer> queue = new ArrayList<Integer>();
        list.add(new ArrayList<Integer>());
        recurse(num, 0, num.length-1, list, queue);
        return list;
    }
    public static void main(String[]args){
    	int[]array = {1,1,2};
    	List<List<Integer>> list = new subset().subsetsWithDup(array);
    	
    }
}
