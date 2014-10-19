package crack_interview;

public class searchinsertposition {
	public int binarysearch(int[]A, int target, int start, int end){
        if(start == end){
            if(A[start] == target)
            return start;
            if(A[start] > target)
            return start;
            else
            return start+1;
        }
        int mid = start + (end-start)/2;
        if(A[mid] == target)
        return mid;
        if(A[mid] > target)
        return binarysearch(A, target, start, mid);
        else 
        return binarysearch(A, target, mid, end);
    }
    public int searchInsert(int[] A, int target) {
        if(target< A[0])
        return 0;
        return binarysearch(A, target, 0, A.length-1);
    }
    public static void main(String[]args){
    	int[] a ={3,5,7,9,10};
    	System.out.println(new searchinsertposition().searchInsert(a, 8));
    }
}
