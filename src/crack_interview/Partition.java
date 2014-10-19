package crack_interview;

public class Partition {
	public void quicksort(int[]array, int start, int end){
		if(start >= end)
			return;
		int pivot = array[start];
		int i = 0, j = array.length - 1;
		while(i < j){
			while(j > i){
				if(array[j] <= pivot){
					array[i++] = array[j];
					break;
				}
				j--;
			}
			while(i < j){
				if(array[i] > pivot){
					array[j--] = array[i];
					break;
				}
				i++;
			}
		}
		array[j] = pivot;
		quicksort(array, start, j-1);
		quicksort(array, j+1, end);
	}
	public static void main(String[]args){
		int[] array = {10,1,5,1,22,-33};
		new Partition().quicksort(array, 0, array.length-1);
		int i = 0;
	}
}
