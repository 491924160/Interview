package crack_interview;

public class reverseBetween {
	public ListNode reverseBetween(ListNode head, int m, int n) {
        if(m == n)
        return head;
        int i = 1;
        ListNode newhead = null, start = head, prev = null, end = null;
        while(i < m){
            prev = start;
            start = start.next;
            i++;
        }
        end = start;
        i = 0;
        while(i <= n-m){
            ListNode temp = start.next;
            start.next = newhead;
            newhead = start;
            start = temp;
            i++;
        }
        if(prev != null){
            prev.next = newhead;
        }else{
            head = newhead;
        }
        end.next = start;
        return head;
        
    }
	public static void main(String[]args){
		ListNode head = new ListNode(1);
		head.next= new ListNode(2);
		head.next.next = new ListNode(3);
		new reverseBetween().reverseBetween(head, 1, 2);
	}
}
