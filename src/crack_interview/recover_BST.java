package crack_interview;
import java.util.*;
public class recover_BST {
	 List<TreeNode> list;
	    public void recurse(TreeNode node, TreeNode parent){
	        if(node == null)
	            return;
	        recurse(node.left, node);
	        recurse(node.right, node);
	        if(parent != null){
	            if(parent.left == node){
	            if(parent.val < node.val){
	                list.add(node);
	                list.add(parent);
	            }
	           
	        }else{
	            if(parent.val > node.val){
	                list.add(node);
	                list.add(parent);
	            }
	        }
	        }
	        
	        
	    }
	    public void recoverTree(TreeNode root) {
	        list = new ArrayList<TreeNode>();
	        if(root == null)
	        return;
	        recurse(root, null);
	        int size = list.size();
	        if(size == 2){
	            TreeNode a = list.get(0);
	            TreeNode b = list.get(1);
	            int val = a.val;
	            a.val = b.val;
	            b.val = val;
	        }else{
	            TreeNode a = list.get(0);
	            TreeNode b = list.get(3);
	            int val = a.val;
	            a.val = b.val;
	            b.val = val;
	        }
	    }
}
