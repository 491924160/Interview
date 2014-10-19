package crack_interview;

public class nth_element {
	public static LinkNode last_n_element(LinkNode head, int n){
		if(head == null)
			return null;
		LinkNode f_ptr = head, n_ptr = head;
		for(int i = 0; i < n - 1; i++){
			if(n_ptr == null)
				return null;
			n_ptr = n_ptr.next;
		}
		while(n_ptr.next != null){
			f_ptr = f_ptr.next;
			n_ptr = n_ptr.next;
		}
		return f_ptr;
	}
}
