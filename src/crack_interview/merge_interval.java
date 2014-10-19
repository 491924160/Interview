package crack_interview;

import java.util.*;
public class merge_interval {
	class IntervalCompare implements Comparator{

		public int compare(Interval a, Interval b){
		    if(a.start < b.start) return -1;
		    else if(a.start == b.start){
		        if(a.end < b.end) return -1;
		        else return 1;
		    }
		    else return 1;
		}
		    @SuppressWarnings("unchecked")
			public List<Interval> merge(List<Interval> intervals) {
		        if(intervals.size() <=1)
		        return intervals;
		        Interval prev = intervals.get(0);
		        List<Interval> sortedlist = new ArrayList<Interval>();
		       Collections.sort(intervals, new IntervalCompare());
		        List<Interval> lists = new ArrayList<Interval>();
		        for(int i = 1; i < sortedlist.size(); i++){
		            Interval temp = sortedlist.get(i);
		            if(temp.start > prev.end){
		                lists.add(prev);
		                prev = temp;
		            }else if(temp.end < prev.start){
		                lists.add(temp);
		            }else{
		                prev.start = Math.min(prev.start, temp.start);
		                prev.end = Math.max(prev.end, temp.end);
		            }
		        }
		        lists.add(prev);
		        return lists;
		    }
			@Override
			public int compare(Object o1, Object o2) {
				// TODO Auto-generated method stub
				return 0;
			}
}
