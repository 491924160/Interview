package crack_interview;
import java.util.*;
 class Interval {
      int start;
      int end;
     Interval() { start = 0; end = 0; }
      Interval(int s, int e) { start = s; end = e; }
  }
public class insert_interval {
	public boolean iscovered(int start1, int end1, int start2, int end2){
        if(end1 < start2)
        return false;
        if(start1 > end2)
        return false;
        return true;
    }
    public List<Interval> insert(List<Interval> intervals, Interval newInterval) {
        List<Interval> lists = new ArrayList<Interval>();
        if(intervals.isEmpty()){
            lists.add(newInterval);
            return lists;
        }
        int start = newInterval.start, end = newInterval.end;
        Iterator<Interval> iter = intervals.iterator();
        Interval prev = null;
        while(iter.hasNext()){
            Interval temp = iter.next();
            if(iscovered(start, end, temp.start, temp.end)){
                Interval temp1 = new Interval(Math.min(start, temp.start), Math.max(end, temp.end));
                if(prev == null){
                    prev = temp1;
                    lists.add(temp1);
                }else{
                    if(prev.end>= temp1.start){
                    	prev.end = Math.max(temp1.end, prev.end);
                        prev.start = Math.min(prev.start, temp1.start);
                        continue;
                    }else{
                    	lists.add(temp1);
                    	prev = temp1;
                    }   
                }
            }else{         	
                if(end < temp.start){          
                    Interval temp1 = new Interval(start, end);
                    if(prev == null)
                    lists.add(temp1);
                    else{
                    	if(iscovered(start, end, prev.start, prev.end)){
                    		prev.end = Math.max(end, prev.end);
                            prev.start = Math.min(start, prev.start);
        
                    	}else{
                    		lists.add(temp1);
                    		prev = temp1;
                    	}
                    }
                    lists.add(temp);
                    break;
                }else{
                  lists.add(temp);
                  Interval temp1 = new Interval(start, end);
                  lists.add(temp1);
                  prev = temp1;
                  continue;
                }

//                }
            }
        }
        while(iter.hasNext())
        lists.add(iter.next());
        return lists;   
    }
    
    public List<Interval> insert1(List<Interval> intervals, Interval newInterval) {
        List<Interval> lists = new ArrayList<Interval>();
        for(int i = 0; i < intervals.size();i++){
            Interval temp = intervals.get(i);
            if(temp.end < newInterval.start){
                lists.add(temp);
            }else if(temp.start > newInterval.end){
                lists.add(newInterval);
                newInterval = temp;
            }else{
                newInterval.start = Math.min(newInterval.start, temp.start);
                newInterval.end = Math.max(newInterval.end, temp.end);
            }
        }
        lists.add(newInterval);
        return lists;
    }
    public static void main(String[]args){
    	List<Interval> list = new ArrayList<Interval>();
    	list.add(new Interval(1,2));
    	list.add(new Interval(3,5));
    	list.add(new Interval(6,7));
    	list.add(new Interval(8,10));
    	list.add(new Interval(12,16));
    	list = new insert_interval().insert(list, new Interval(4, 9));
    	for(Interval temp: list){
    		System.out.println(temp.start + "-" + temp.end+ "\n");
    	}
    }
}
