package crack_interview;

import java.util.Arrays;
import java.util.Random;

 class PriorityQueue {
	private int[] array;
	private int count;
	private int capacity;
	PriorityQueue(int size){
		array = new int[size + 1];
		Arrays.fill(array, 0);
		count = 0; 
		capacity = size;
	}
	void add(int a){
		if(count == 0){
			array[1] = a;
			count++;
			return;
		}
		if(count >= capacity)
			resize();
		array[count + 1] = a;
		count++;
		siftup(count);
	}
	int peek(){
		if(count == 0)
			return -1;
		else
			return array[1];
	}
	int pop(){
		if(count == 0){
			return -1;
		}else{
			if(count == 1){
				count --;
				int temp = array[1];
				array[1] = 0;
				return temp;
			}else{
				int temp = array[1];
				array[1] = array[count];
				array[count] = 0;
				count--;
				siftdown(1);
				return temp;
			}
		}
	}
	void siftup(int index){
		if(index <= 1)
			return;
		int par = index/2;
		if(array[par] <= array[index])
			return;
		else{
			int temp = array[par];
			array[par] = array[index];
			array[index] = temp;
			siftup(par);
		}
	}
	void siftdown(int index){
		if(index*2 > count){
			return;
		}
		int left = index*2, right = index * 2 + 1;
		if(right <= count){
			int min = Math.min(array[left], array[right]);
			int index1 = array[left] <= array[right]? left: right;
			if(array[index] <= min)
				return;
			else{
				array[index1] = array[index];
				array[index] = min;
				siftdown(index1);
			}
		}else{
			if(array[index] <= array[left])
				return;
			else{
				int temp = array[left];
				array[left] = array[index];
				array[index] = temp;
			}
		}
		
	}
	void resize(){
		int[] array1 = new int[2*array.length + 1];
		for(int i = 1; i <array.length;i++){
			array1[i] = array[i];
		}
		array = array1;
		capacity = array1.length - 1;
		return;
	}
	public static void main(String[]args){
		PriorityQueue queue = new PriorityQueue(5);
		int i = queue.peek();
		queue.add(10);
		queue.add(1);
		queue.add(-2);
		int j = queue.pop();
		Random rm = new Random();
		for(int h =0;  h < 10; h++ )
		{
			int k = rm.nextInt(100);
			queue.add(k);
		}
		for(int h =0;  h < 10; h++ )
		{
			System.out.println(queue.pop());
		}
	}
}
