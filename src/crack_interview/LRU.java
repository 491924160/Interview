package crack_interview;
import java.util.*;
public class LRU {
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
   public LRU(int capacity) {
       head = new Linklist(capacity);
       map = new HashMap<Integer, Node>();
   }
   public int get(int key){
       if(map.containsKey(key)){
           Node node = map.get(key);
           if(head.load == 1){
               return node.value;
           }
           if(head.first == node)
           return node.value;
           if(node == head.last){
               head.last = node.prev;
               node.prev.next = null;
           }else{
        	   Node prev = node.prev;
        	   prev.next = node.next;
        	   node.next.prev = prev;
           }
           head.first.prev = node;
           node.next = head.first;
           node.prev = null;
           head.first = node;
           return node.value;
       }else{
           return -1;
       }
   }

   public void set(int key, int value) {
       if(map.containsKey(key)){
           get(key);
           Node temp = map.get(key);
           temp.value = value;
           map.put(key, temp);
           return;
       }else{
            Node node = new Node();
               node.key = key; 
               node.value = value;
               map.put(key, node);
           if(head.load == 0){
               head.first = node;
               head.last = node;
               head.load++;
               return;
           }
           if(head.load < head.cap){
        	   head.first.prev = node;
               node.next = head.first;
               node.prev = null;
               head.first = node;
               head.load++;
               return;
           }else{
               map.remove(head.last.key);
               head.load--;
               if(head.load == 0){
                   head.first = head.last = node;
               }else{
                     Node prev = head.last.prev;
                   prev.next = null;
                   head.last = prev;
                   node.next = head.first;
                   node.prev = null;
                   head.first = node;
               }
             head.load++;
               return;
           }
       }
   }
   public static void main(String[]args){
	   LRU lr = new LRU(2);
	   lr.set(2,1);
	   lr.set(1, 1);
	   lr.get(2);
//	   lr.set(1, 1);
	   lr.set(4, 1);
	   lr.get(1);
	   lr.get(2);
   }
}