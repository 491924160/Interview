package crack_interview;
import java.util.*;
public class inorderTraversal {
	public void recTrav(TreeNode node, List<Integer> list){
		if(node == null)
			return ;
		recTrav(node.left, list);
		list.add(node.val);
		recTrav(node.right, list);
		return;
	}
	public List<Integer> inorderTraversal(TreeNode root) {
		List<Integer> list = new ArrayList<Integer>();
		if(root == null)
			return list;
		return list;
    }
}
