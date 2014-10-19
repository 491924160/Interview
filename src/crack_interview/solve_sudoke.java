package crack_interview;

import java.util.Arrays;

public class solve_sudoke {
	 public boolean recsolve(char[][]board, int[]row, int[]col, int[]square, int pos){
	        if(pos == board.length * board.length)
	        return true;
	        int i = pos / board.length;
	        int j = pos % board.length;
	        if(board[i][j] == '.'){
	            for(int m = 1; m <= 9; m++){
	                if((row[i]&(1<<m)) > 0 || (col[j]&(1<<m)) > 0 || (square[(int)(i/3) * 3 + j/3]&(1<<m)) >0)
	                continue;
	                else{
	                    board[i][j] = (char)('0' + m);
	                    row[i]|= 1<<m;
	                    col[j] |= 1<<m;
	                    square[(int)(i/3) * 3 + j/3]|= 1<<m;
	                    boolean flag = recsolve(board, row, col, square, pos+1);
	                    if(flag)
	                    return true;
	                    else{
	                        board[i][j] = '.';
	                         row[i]^= 1<<m;
	                    col[j] ^= 1<<m;
	                    square[(int)(i/3) * 3 + j/3] ^= 1<<m;
	                    }
	                }
	            }
	            return false;
	        }else{
	            return recsolve(board, row, col, square, pos+1);
	        }
	    }
	    public void solveSudoku(char[][] board) {
	        int count = 0;
	        int[] row = new int[9];
	        int[] col = new int[9];
	        int[] square = new int[9];
	        Arrays.fill(row,0);
	        Arrays.fill(col,0);
	        Arrays.fill(square,0);
	        for(int i = 0; i < 9; i++)
	        for(int j = 0; j < 9; j++){
	            if(board[i][j] == '.')
	            count++;
	            else{
	                int num = board[i][j] - '0';
	                row[i] |= 1<<num;
	                col[j] |= 1<<num;
	            }
	        }
	        recsolve(board, row, col, square, 0);
	    }
	public static void main(String[]args){
		solve_sudoke test = new solve_sudoke();
		String[] array  = 	{"..9748...","7........",".2.1.9...","..7...24.",".64.1.59.",".98...3..","...8.3.2.","........6","...2759.."};
		char[][] array1 = new char[9][9];
		for(int i = 0; i < 9; i++)
			array1[i] = array[i].toCharArray();
		test.solveSudoku(array1);
		for(int i = 0; i < 9; i++){
			System.out.println(Arrays.toString(array1[i]));
		}

	}
}
