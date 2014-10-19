package crack_interview;

public class rotatelist {
	 public ListNode rotateRight(ListNode head, int n) {
	        if(n == 0)
	        return head;
	        if(head == null || head.next == null)
	        return head;
	        int len = 1;
	        ListNode cur = head;
	        while(cur.next != null){
	            len++;
	            cur = cur.next;
	        }
	        n = n % len;
	        cur.next = head;
	        for(int i = 0; i < len - n; i++)
	             cur = cur.next;
	        head = cur.next;
	        cur.next = null;
	        return head;
	    }
	 public static void main(String[]args){
		 ListNode head = new ListNode(1);
		 head.next = new ListNode(2);
		 head = new rotatelist().rotateRight(head, 2);
	 }
}
