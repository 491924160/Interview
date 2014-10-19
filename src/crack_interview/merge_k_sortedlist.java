package crack_interview;
import java.util.*;
public class merge_k_sortedlist {
	public ListNode merge(List<ListNode> lists, int start, int end){
		if(start == end)
			return lists.get(start);
		int mid = start + (end - start)/2;
		ListNode left = merge(lists, start, mid);
		ListNode right = merge(lists, mid+1, end);
		if(left == null)
			return right;
		if(right == null)
			return left;
		ListNode head = null;
		if(left.val < right.val){
			head = left;
			left = left.next;
		}else{
			head = right;
			right = right.next;
		}
		ListNode cur = head;
		while(left != null && right != null){
			if(left.val < right.val){
				cur.next = left;
				cur = cur.next;
				left = left.next;
			}else{
				cur.next = right;
				cur = cur.next;
				right = right.next;
			}
		}
		while(left != null){
			cur.next = left;
			cur = cur.next;
			left = left.next;
		}
		while(right != null){
			cur.next = right;
			cur = cur.next;
			right = right.next;
		}
		return head;
	}
	public ListNode mergeKLists(List<ListNode> lists) {
		int length = lists.size();
		if(length == 0)
			return null;
		ListNode head = merge(lists, 0, length - 1);
		return head;
    }
} 
