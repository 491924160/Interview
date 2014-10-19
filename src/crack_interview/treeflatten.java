package crack_interview;

public class treeflatten {
	   public void recurseflat(TreeNode node){
	        if(node == null)
	            return ;
	        TreeNode left = node.left, right = node.right, temp = node.left;
	        if(left == null){
	            recurseflat(right);
	            return;
	        }
	        while(temp.right != null){
	                temp = temp.right;
	        }
	        node.left = null;
	        node.right = left;
	        temp.right = right;
	        recurseflat(node.left);
	        recurseflat(node.right);
	    }
	    public void flatten(TreeNode root) {
	        if(root == null)
	        return;
	        recurseflat(root);
	    }
}
