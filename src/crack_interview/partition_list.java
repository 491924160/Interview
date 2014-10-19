package crack_interview;
import java.util.*;
public class partition_list {
	 public ListNode partition(ListNode head, int x) {
	        if(head == null)
	        return null;
	        List<ListNode> list1 = new ArrayList<ListNode>(), list2 = new ArrayList<ListNode>();
	        ListNode cur = head, node = null;
	        while(cur != null){
	            if(cur.val < x){
	                list1.add(cur);
	                cur = cur.next;
	                continue;
	            }else if(cur.val > x){
	                list2.add(cur);
	                cur = cur.next;
	                continue;
	            }else{
	                node = cur;
	                cur = cur.next;
	            }
	        }
	        if(node != null)
	        list1.add(node);
	        ListNode newhead = null, ptr = null;
	        for(ListNode temp: list1){
	            if(newhead == null){
	                newhead = temp;
	                ptr = temp;
	                continue;
	            }
	            ptr.next = temp;
	            ptr = temp;
	        }
	    
	        for(ListNode temp: list2){
	            if(newhead == null){
	                newhead = temp;
	                ptr = temp;
	                continue;
	            }
	            ptr.next = temp;
	            ptr = temp;
	        }
	        ptr.next = null;
	        return newhead;
	    }
	 public ListNode partition1(ListNode head, int x){
		
	        if(head == null)
	        return null;
	        ListNode lefthead = null, leftend = null, righthead = null, rightend = null, cur = head;
	        while(cur != null){
	            if(cur.val < x){
	                if(lefthead == null){
	                    lefthead = leftend = cur;
	                    cur = cur.next;
	                    continue;
	                }
	                leftend.next = cur;
	                leftend = cur;
	                cur = cur.next;
	            }else{
	                if(righthead == null){
	                    righthead = rightend = cur;
	                    cur = cur.next;
	                    continue;
	                }
	                rightend.next = cur;
	                cur = cur.next;
	            }
	        }
	        if(lefthead != null){
	            leftend.next = righthead;
	            if(rightend != null)
	            rightend.next = null;
	            return lefthead;
	        }else{
	            return righthead;
	        }
	    }
	 public static void main(String[]args){
		 ListNode head = new ListNode(1);
		 head.next = new ListNode(1);
		 new partition_list().partition1(head, 2);
	 }
}
