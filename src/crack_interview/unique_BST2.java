package crack_interview;
import java.util.*;
public class unique_BST2 {
	public List<TreeNode> genTree(int start, int end){
		
		List<TreeNode> list = new ArrayList<TreeNode>();
		if(start > end)
			{
			list.add(null);
			return list;
			}
		if(start == end){
			TreeNode temp = new TreeNode(start);
			list.add(temp);
			return list;
		}
		for(int i = start; i <= end; i++){
			List<TreeNode> left = genTree(start, i-1);
			List<TreeNode> right = genTree(i+1, end);
			 for(TreeNode lnode: left)
	            {
	                for(TreeNode rnode: right)
	                {
	                    TreeNode root = new TreeNode(i);
	                    root.left = lnode;
	                    root.right = rnode;
	                    list.add(root);
	                }
	            }
		}
		return list;
			
	}
	public List<TreeNode> generateTrees(int n) {
        return genTree(1, n);
    }
}
