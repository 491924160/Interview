package crack_interview;

public class rotatematrix {
	public static void rotatematrix(int[][]matrix, int n){
		int layer = 0;
		for(; layer < n/2; layer++){
			int first = layer, last = n - 1 - layer;
			for(int i = first; i <= last; i++){
				int offset = i - first;
				int temp = matrix[first][i];
				matrix[first][i] = matrix[first][last - offset];
				matrix[first][last - offset] = matrix[last][last - offset];
				matrix[last][last - offset] = matrix[i][last];
				matrix[i][last] = temp;
			}
		}
	}
}
