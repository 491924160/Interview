package crack_interview;
  class TreeNode {
	    int val;
	      TreeNode left;
	     TreeNode right;
	    TreeNode(int x) { val = x; }
	 }
 class maxPathSum1 {
	int max;
    public int recurseNode(TreeNode node, int total){
        if(node == null)
            return 0;
        int leftmax = recurseNode(node.left, total + node.val);
        int rightmax = recurseNode(node.right, total + node.val);
        int big = Math.max(leftmax, rightmax);
        int ret = 0;
        if(big >=0){
        	ret = big + node.val;
        }else{
        	ret = node.val;
        }
        max = Math.max(ret, leftmax+rightmax+node.val);
        return ret;
    }
     int maxPathSum(TreeNode root) {
        max = Integer.MIN_VALUE;
        if(root == null)
            return 0;
        recurseNode(root, 0);
        return max;
    }
}
