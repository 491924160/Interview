package crack_interview;
import java.util.*;
public class binary_zigzag {
	public List<List<Integer>> zigzagLevelOrder(TreeNode root) {
        List<List<Integer>> list = new ArrayList<List<Integer>>();
        if(root == null)
        return list;
        Deque<TreeNode> stack1 = new ArrayDeque<TreeNode>(), stack2 = new ArrayDeque<TreeNode>();
        stack1.push(root);
        boolean flag = true;
        while(!stack1.isEmpty()||!stack2.isEmpty()){
            if(flag){
                flag = false;
                List<Integer> temp_list = new ArrayList<Integer>();
                while(!stack1.isEmpty()){
                   
                    TreeNode temp = stack1.pop();
                    temp_list.add(temp.val);
                    if(temp.left !=null)
                    stack2.push(temp.left);
                    if(temp.right !=null)
                    stack2.push(temp.right);
                 
                }
                list.add(temp_list);
            }else{
                flag = true;
                List<Integer> temp_list = new ArrayList<Integer>();
                while(!stack2.isEmpty()){
                 
                    TreeNode temp = stack2.pop();
                    temp_list.add(temp.val);
                    if(temp.right != null)
                    stack1.push(temp.right);
                    if(temp.left != null)
                    stack1.push(temp.left);     
                }
                list.add(temp_list);
            }
            
        }
        return list;
    }
	public static void main(String[]args){
		TreeNode root = new TreeNode(1);
		root.left = new TreeNode(2);
		root.right = new TreeNode(3);
		List<List<Integer>> list = new binary_zigzag().zigzagLevelOrder(root);
		int i = 1;
	}
}
