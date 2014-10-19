package crack_interview;

public class Unique_BST {
	public int numTrees(int n) {
        if(n == 1)
        	return 1;
        int[]result = new int[n];
        result[0] = 1;
        for(int i = 1; i < n; i++){
        	int total = 0;
        	for(int j = 0; j <= i; j++){
        		if(j -1>=0)
        			total += result[j-1];
        		if(i >= j+1)
        			total += result[i-j - 1];
        	}
        	result[i] = total;
        }
        return result[n-1];
    }
	public static void main(String[]args){
		System.out.println(new Unique_BST().numTrees(2));
	}
}
