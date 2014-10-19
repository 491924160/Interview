package crack_interview;

public class postorder_buildtree {
	 public TreeNode rec_build(int[] inorder, int[] postorder, int pos, int left, int right){
	        if(left == right)
	        return new TreeNode(postorder[pos]);
	        TreeNode par = new TreeNode(postorder[pos]);
	        int pos1 = left;
	        for(int i = left; i <= right; i++){
	            if(inorder[i] == postorder[pos]){
	                pos1 = i;
	                break;
	            }
	        }
	        int len = pos1 - left;
	        if(pos1 > left)
	         par.left = rec_build(inorder,  postorder, pos - len, left, pos1-1);
	        if(right > pos1)
	        par.right = rec_build(inorder,  postorder, pos-1, pos1+1, right );
	        return par;
	    }
	    public TreeNode buildTree(int[] inorder, int[] postorder) {
	        if(inorder.length == 0)
	        return null;
	        return rec_build(inorder, postorder,  inorder.length - 1, 0, inorder.length - 1);
	    }
	    public static void main(String[]args){
	    	int[] inorder = {3,2,1};
	    	int[] postorder = {3,2,1};
	    	TreeNode par = new postorder_buildtree().buildTree(inorder, postorder);
	    }
}
