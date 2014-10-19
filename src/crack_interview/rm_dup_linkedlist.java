package crack_interview;
class LinkNode{
	LinkNode next;
	int val;
	LinkNode(int val){
		this.val = val;
	}
	LinkNode(){
		next = null;
		val = 0;
	}
}
public class rm_dup_linkedlist {
	public static void rmduplicate(LinkNode head){
		if(head == null)
			return;
		LinkNode prev = head, current = head.next;
		while(current != null){
			LinkNode ptr = head;
			boolean flag = false;
			while(ptr != current){
				if(ptr.val == current.val)
				{
					prev.next = current.next;
					current = current.next;
					flag = true;
					break;
				}
				ptr = ptr.next;
			}
			if(flag){
				prev = current;
				current = current.next;	
			}		
		}
	}
}
