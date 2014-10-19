package crack_interview;
 class ListNode {
     int val;
     ListNode next;
     ListNode(int x) { val = x; next = null; }
 }
public class listtoBST {
	public TreeNode sortedListToBST(ListNode head){
		if(head == null) return null;
		if(head.next == null) return new TreeNode(head.val);
		ListNode slow = head, fast = head.next;
		while(fast.next != null && fast.next.next != null){
			slow = fast.next;
			fast = fast.next.next;
		}
		TreeNode parent = new TreeNode(slow.next.val);
		ListNode head2 = slow.next.next;
		slow.next = null;
		parent.left = sortedListToBST(slow);
		parent.right = sortedListToBST(head2);
		return parent;
	}
}
