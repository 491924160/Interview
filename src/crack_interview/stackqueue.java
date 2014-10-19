package crack_interview;
class Node{
	Node next;
	int val;
}

public class stackqueue {
	class stack{
		Node top;
		stack(){
			top = null;
		}
		void push(int val){
			Node item = new Node();
			item.val = val;
			if(top == null){
				top = item;
			}else{
				item.next = top;
				top = item;
			}
		}
		Node pop(){
			if(top == null){
				return null;
			}
			Node temp = top;
			top = top.next;
			return temp;
		}
	}
	class queue{
		
	}
}
