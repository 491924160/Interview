package crack_interview;
import java.util.*;
public class isbalancedtree {
	 int max, min;
	    public void rectraverse(TreeNode node, int level){
	        if(node == null)
	        	return;
	        if(node.left == null && node.right == null){
	        	if(level > max)
	        		max = level;
	        	if(level < min)
	        		min = level;
	        	return;
	        }
	        rectraverse(node.right, level+1);
	        rectraverse(node.left, level+1);
	    }
	    public boolean isBalanced(TreeNode root) {
	        max = Integer.MIN_VALUE;
	        min = Integer.MAX_VALUE;
	        if(root == null)
	            return true;
	        rectraverse(root, 0);
	        if(max - min > 1)
	        	return false;
	        else return true;
	    }
	    boolean flag = true;
	    public int checkbalanced(TreeNode node){
	    	if(node == null)
	    		return 0;
	    	int left = checkbalanced(node.left);
	    	int right = checkbalanced(node.right);
	    	if(Math.abs(left- right) > 1)
	    		flag = false;
	    	return Math.max(left, right) + 1;
	    }
	    public boolean isBalanced1(TreeNode root){
	    	if(root == null)
	    		return true;
	    	
	    }
}
