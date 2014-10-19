package crack_interview;

public class remove_nth_node {
	public ListNode removeNthFromEnd(ListNode head, int n) {
        if(head == null)
        return null;
        ListNode prev = head, fast = head;
        int i = 0;
        while(i++ < n - 1){
            fast = fast.next;
            if(fast == null)
            return null;
        }
        while(fast.next != null){
            prev = prev.next;
            fast = fast.next;
        }
        return prev;
    }
	public static void main(String[]args){
		ListNode node = new ListNode(1);
		System.out.println(new remove_nth_node().removeNthFromEnd(node, 1).val);
	}
}
