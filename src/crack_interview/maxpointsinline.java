package crack_interview;

import java.util.HashMap;
import java.util.Map;

class Point{
	int x;
	int y;
	Point(){
		x = 0;
		y = 0;
	}
	Point(int x, int y){
		this.x = x;
		this.y = y;
	}
}

class pair{
	int x;
	int y;
	pair(int x, int y){
		this.x = x;
		this.y = y;
	}
}

public class maxpointsinline {
		public static int maxPoints(Point[] points){
			HashMap<Float, Integer> map = new HashMap<Float, Integer>();
			if(points == null)
				return 0;
			if(points.length <= 2)
				return points.length;
			int maxresult = 0;
			for(int i = 0; i < points.length; i++){
				int result  = 0, overlap = 0, vertical = 0;
				map.clear();
				for(int j = i + 1; j < points.length; j++){
					
					if(points[i].x == points[j].x && points[i].y == points[j].y){
						overlap++;
						continue;
					}
					if(points[i].x == points[j].x){
						vertical++;
						continue;
					}
					int a = points[i].x - points[j].x;
					int b = points[i].y - points[j].y;
					Float f = new Float((float)b/a);
					int value = 0;
					if(map.containsKey(f)){
						Integer integer = map.get(f);
						map.put(f, new Integer(integer.intValue() + 1));
						value = integer.intValue() + 1;
					}else{
						map.put(f, new Integer(1));
						value = 1;
					}
					result = Math.max(result, value);
				}
				maxresult = Math.max(maxresult, result + overlap + 1);
				maxresult = Math.max(maxresult, vertical + 1);
			}
			return maxresult;
		}
		public static int maxPoints1(Point[] points){
		    if(points.length <= 2)
					return points.length;
			    int max = 0;
			    Map<Double, Integer> map = new HashMap<Double, Integer>();
			    for(int i = 0; i < points.length; i++){
			      double lean = 0;
			        int samepoints = 0;
			        int vertical = 0;
			        int localmax = 0;
			    for(int j = i+1; j < points.length; j++){
			      
			        if(points[i].x == points[j].x && points[i].y == points[j].y){
			            samepoints++;
			            continue;
			        }
			        if(points[i].x == points[j].x){
			            vertical++;
			            continue;
			        }
			       
			        if(points[i].y == points[j].y)
			        lean = 0;
			        else
			        lean = (points[i].y - points[j].y) /(points[i].x - points[j].x);
			        if(map.containsKey(lean)){
			            int num = map.get(lean);
			            map.put(lean, num+1);
			        }else{
			            map.put(lean, 1);
			        }
			        if(localmax < map.get(lean)){
			            localmax = map.get(lean);
			        }
			    }
			    localmax = localmax + samepoints + 1;
			    max = Math.max(localmax, max);
			    max = Math.max(localmax, vertical + 1);
			    map.clear();
			    }
			    return  max;
		}
		public static void main(String[]args){
			Point[] array = new Point[3];
			array[0] = new Point(0,0);
			array[1] = new Point(1,1);
			array[2] = new Point(1,-1);
			
		}

	public static int GCD(int a, int b){
		if(b == 0)
			return a;
		else{
			return GCD(b, a%b);
		}
	}
}
