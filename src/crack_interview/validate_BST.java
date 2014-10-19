package crack_interview;

public class validate_BST {
	public boolean recurseCheck(TreeNode node, int min, int max){
        if(node == null)
        return true;
        if(node.val > max || node.val < min)
        return false;
        return recurseCheck(node.left, min, node.val -1) & recurseCheck(node, node.val + 1, max);
    }
    public boolean isValidBST(TreeNode root) {
        return recurseCheck(root, Integer.MIN_VALUE, Integer.MAX_VALUE);
            
    }
    public static void main(String[]args){
    	TreeNode node = new TreeNode(0);
    	System.out.println(new validate_BST().isValidBST(node));
    }
}
