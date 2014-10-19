package crack_interview;

public class pathsum1 {
	public boolean checkpath(TreeNode node, int remains){
        if(node == null)
            return remains == 0? true:false;
        if(node.left == null && node.right  == null && node.val == remains)
            return true;
        boolean left = false, right = false;
        if(node.left != null){
            left = checkpath(node.left, remains - node.val);
        }
        if(node.right != null){
            right = checkpath(node.right, remains - node.val);
        }
        if(left)
            return true;
        if(right)
            return true;
        return false;
    }
    public boolean hasPathSum(TreeNode root, int sum) {
        if(root == null)
        return false;
        return checkpath(root, sum);
    }
    public static void main(String[]args){
    	TreeNode root = new TreeNode(-2);
    	TreeNode right = new TreeNode(-3);
    	root.right = right;
    	System.out.println(new pathsum1().hasPathSum(root, -5));
    }
}
