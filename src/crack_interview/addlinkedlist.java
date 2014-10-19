package crack_interview;

public class addlinkedlist {
	public static LinkNode addlinkedlist(LinkNode a, LinkNode b){
		if(a == null && b == null)
			return null;
		if(a == null)
			return b;
		if(b == null)
			return a;
		boolean flag = false;
		LinkNode ptr = new LinkNode();
		LinkNode head = ptr;
		ptr.val = a.val + b.val;
		if(ptr.val > 10){
			flag = true;
			ptr.val = ptr.val % 10;
		}
		a = a.next;
		b = b.next;
		while(a != null && b != null){
			LinkNode newnode = new LinkNode();
			if(flag){
				newnode.val = 1 + a.val + b.val;
			}else{
				newnode.val = a.val + b.val;
			}
			if(newnode.val > 10){
				newnode.val = newnode.val % 10;
				flag = true;
			}else{
				flag = false;
			}
			ptr.next = newnode;
			ptr = ptr.next;
			a = a.next;
			b = b.next;
		}
		while(a != null){
			LinkNode newnode = new LinkNode();
			newnode.val = a.val;
			a = a.next;
			ptr.next = newnode;
			ptr = ptr.next;
		}
		while(b != null){
			LinkNode newnode = new LinkNode();
			newnode.val = b.val;
			b = b.next;
			ptr.next = newnode;
			ptr = ptr.next;
		}
		return head;
			
	}
}
