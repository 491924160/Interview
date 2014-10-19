package crack_interview;
import java.util.*;
public class treemap_test {
	public static void main(String[]args){
		TreeSet<Integer> tree = new TreeSet<Integer>();
		int[] array = {1,5,2,11,-2,90};
		for(int i: array){
			tree.add(i);
		}
		while(!tree.isEmpty())
			System.out.println(tree.pollFirst());
	}
}
