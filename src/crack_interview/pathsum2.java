package crack_interview;
import java.util.*;

public class pathsum2 {
	Queue<Integer> queue;
	public void checkpath(TreeNode node, int remains,  List<List<Integer>> list){
		if(node == null)
            return;
		queue.add(node.val);
        if(node.left == null && node.right  == null && node.val == remains){
        	
        	List<Integer> temp = new ArrayList<Integer>();
        	for(int i : queue){
        		temp.add(i);
        	}
        	list.add(temp);
        	queue.poll();	
        }
        if(node.left != null){
            checkpath(node.left, remains - node.val, list );
        }
        if(node.right != null){
            checkpath(node.right, remains - node.val, list);
        }
       
	}
	public List<List<Integer>> pathSum(TreeNode root, int sum) {
        List<List<Integer>> list = new ArrayList<List<Integer>>(); 
        queue = new LinkedList<Integer>();
        if(root == null)
        	return null;
        checkpath(root, sum,  list);
        return list;
    }
}
