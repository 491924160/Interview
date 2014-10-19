package crack_interview;

import java.util.ArrayList;
import java.util.List;

public class reoder_list {
	public void reorderList(ListNode head){
        if(head == null || head.next == null)
        return ;
        List<ListNode> list = new ArrayList<ListNode>();
        int count = 0;
        while(head != null){
            list.add(head);
            count++;
            head = head.next;
        }
        ListNode newhead = null, cur= null;
        for(int i = 0; i < count / 2; i++){
             ListNode node1 = list.get(i);
             ListNode node2 = list.get(count-i-1);
             node1.next = node2;
             node2.next = null;
             if(newhead == null){
                 newhead = node1;
             }else{
                 cur.next = node1;
             }
             cur = node2;
        }
        if(count%2 == 1){
            ListNode temp = list.get(count/2);
            cur.next = temp;
            temp.next = null;
        }
        head = newhead;
    }
	public static void main(String[]args){
		ListNode head = new ListNode(1);
		head.next = new ListNode(3);
		head.next.next = new ListNode(2);
		new reoder_list().reorderList(head);
		while(head != null){
			System.out.println(head.val);
			head = head.next;
		}
		}
}
