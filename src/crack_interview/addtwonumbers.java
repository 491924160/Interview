package crack_interview;
import java.util.*;
public class addtwonumbers {
	public ListNode addTwoNumbers(ListNode l1, ListNode l2) {
		if(l1 == null && l2 == null)
			return null;
		if(l1 == null)
			return l2;
		if(l2 == null)
			return l1;
		ArrayDeque<Integer> s1 = new ArrayDeque<Integer>();
		ArrayDeque<Integer> s2 = new ArrayDeque<Integer>();
		ArrayDeque<Integer> s3 = new ArrayDeque<Integer>();
		while(l1!= null){
			s1.push(l1.val);
			l1 = l1.next;
		}
		while(l2 != null){
			s2.push(l2.val);
			l2 = l2.next;
		}
		boolean flag = false;
		while(!s1.isEmpty() && !s2.isEmpty()){
			int i = s1.poll(), j = s2.poll();
			int total = flag == true? i + j + 1: i + j;
			if(total >= 10){
				flag = true;
				
			}else{
				flag = false;
			}
			s3.push(total % 10);
			
		}
		while(!s1.isEmpty()){
			int j = s1.poll();
			int total = flag == true? j + 1: j;
			if(total >= 10){
				flag = true;
			}else flag = false;
			s3.push(total %10);
		}
		while(!s2.isEmpty()){
			int j = s2.poll();
			int total = flag == true? j + 1: j;
			if(total >= 10){
				flag = true;
			}else flag = false;
			s3.push(total %10);
		}
		if(flag){
			s3.push(1);
		}
		ListNode head = null, prev = null;
		while(!s3.isEmpty()){
			int i = s3.pollLast();
			ListNode temp = new ListNode(i);
			if(head == null)
				head = temp;
			if(prev == null)
				prev = temp;
			else{
				prev.next=temp;
				prev = temp;
			}
		}
		return head;
    }
	public ListNode addTwoNumbers2(ListNode l1, ListNode l2){
		int num1 = 0, num2 = 0;
		while(l1 != null){
			num1 = num1 * 10;
			num1 += l1.val;
			l1 = l1.next;
		}
		while(l2 != null){
			num2 = num2 * 10;
			num2 += l2.val;
			l2 = l2.next;
		}
		int total = num1 + num2;
		if(total == 0)
			return new ListNode(0);
		
	}
}
