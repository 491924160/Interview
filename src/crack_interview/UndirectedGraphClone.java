package crack_interview;

import java.util.*;

class UndirectedNode{
	int label;
	List<UndirectedNode> neighbors;
	UndirectedNode(int x){
		label = x;
		neighbors = new ArrayList<UndirectedNode>();
	}
	
}
public class UndirectedGraphClone {
	public UndirectedNode cloneGraph(UndirectedNode node){
		if(node == null)
			return null;
		/*UndirectedNode head = null;
		Queue<UndirectedNode> queue = new LinkedList<UndirectedNode>();
		Map<Integer, UndirectedNode> map = new HashMap<Integer, UndirectedNode>();
		Map<Integer, Boolean> map1 = new Hashmap<Integer, UndirectedNode>();
		queue.add(node);
		while(!queue.isEmpty()){
			UndirectedNode temp = queue.poll();
			Iterator<UndirectedNode> iter = temp.neighbors.iterator();
			if(head == null){
				head = new UndirectedNode(temp.label);
				map.put(head.label, head);
				while(iter.hasNext()){
					UndirectedNode temp2 = iter.next();
					if(!map.containsKey(temp2.label)){
						
					}
				}
			}else{
				
			}
		}
		*/
		Map<Integer, UndirectedNode> map = new HashMap<Integer, UndirectedNode>();
		
		
	}
	public UndirectedNode 
}
