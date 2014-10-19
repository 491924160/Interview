package crack_interview;

import java.util.HashMap;

 class LRUcache {
    class Node{
        Node  next, prev;
        int key;
        int value;
    }
    class Linklist{
        Node first, last;
        int cap;
        int load;
        Linklist(int cap){
            first = last = null;
            this.cap = cap;
            load = 0;
        }
    }
    Linklist head;
    HashMap<Integer, Node> map;
    public LRUcache(int capacity) {
        head = new Linklist(capacity);
        map = new HashMap<Integer, Node>();
    }
    
    public int get(int key) {
        if(map.containsKey(key)){
        	Node temp = map.get(key);
        	if(head.load == 1)
        		return temp.value;
        	if(temp == head.last){
        		return temp.value;
        	}else if(temp == head.first){
        		head.first = temp.next;
        		head.first.prev = null;
        		head.last.next = temp;
        		temp.prev = head.last;
        		head.last = temp;
        		temp.next = null;		
        	}else{
        		temp.prev.next = temp.next;
        		temp.next.prev = temp.prev;
        		head.last.next = temp;
        		temp.prev = head.last;
        		temp.next = null;
        		head.last = temp;
        	}
        	return temp.value;
        }else{
            return -1;
        }
    }
    
    public void set(int key, int value) {
        if(map.containsKey(key)){
        	Node temp = map.get(key);
        	temp.value = value;
        	get(key);
        	return;
        }else{
        	Node node = new Node();
        	node.key = key;
        	node.value = value;
        	if(head.load < head.cap){
        		if(head.load == 0){
        			head.first = node;
        			head.last = node;
        			node.prev = null;
        			node.next = null;
        		}else{
        			head.last.next = node;
        			node.prev = head.last;
        			head.last = node;
        			node.next = null;
        		}
        		head.load++;
        	}else{
        		head.first = head.first.next;
        		head.first.prev = null;
        		head.last.next = node;
        		node.prev = head.last;
        		head.last = node;	
        	}
        	map.put(key, node);
        }
    }
}