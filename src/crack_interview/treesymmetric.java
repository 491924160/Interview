package crack_interview;

public class treesymmetric {
	public boolean  check(TreeNode left, TreeNode right){
		if(left == null && right == null)
			return true;
		if(left == null || right == null)
			return false;
		if(left.val != right.val)
			return false;
		boolean left_val = check(left.left, right.right);
		boolean right_val = check(left.right, right.left);
		if(left_val  == false || right_val == false)
			return false;
		else return true;
	}
	 public boolean isSymmetric(TreeNode root) {
	     if(root == null)
	    	 return true;
	     return check(root.left, root.right); 
	 }
}
