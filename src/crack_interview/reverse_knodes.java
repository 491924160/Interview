package crack_interview;

import java.util.Stack;

public class reverse_knodes {
	  public ListNode reverseKGroup(ListNode head, int k) {
	        if(k == 1)
	        return head;
	     Stack<ListNode> stack = new Stack<ListNode>();
	     ListNode newhead = null, prev = null;
	     ListNode cur = head,  ptr1 = null;
	     int count  = 0;
	     while(cur != null){
	         stack.push(cur);
	         count++;
	         cur = cur.next;
	         if(count == k){
	             ptr1 = cur;
	             ListNode ptr = null;
	             if(newhead == null){
	                 newhead = stack.pop();
	                 ptr = newhead;
	                 while(!stack.isEmpty()){
	                     ptr.next = stack.pop();
	                     ptr = ptr.next;
	                 }
	                 prev = ptr;
	             }else{
	                 while(!stack.isEmpty()){
	                     prev.next = stack.pop();
	                     prev = prev.next;
	                 }
	             }
	             count = 0;
	         }
	     }
	     if(newhead == null)
	     return head;
	     if(stack.size()< 5)
	     {
	         prev.next = ptr1;
	         return newhead;
	     }else{
	         while(stack.isEmpty()){
	             prev.next = stack.pop();
	             prev = prev.next;
	         }
	         return newhead;
	     }
	    
	    }
	  public static void main(String[]args){
		  ListNode head = new ListNode(1);
		  ListNode ptr = head;
		  for(int i = 0; i <100; i++){
			  ptr.next = new ListNode(i + 2);
			  ptr =ptr.next;
		  }
		  head = new reverse_knodes().reverseKGroup(head, 30);
		  while(head != null){
			  System.out.println(head.val);
			  head = head.next;
		  }
			 
	  }
}
