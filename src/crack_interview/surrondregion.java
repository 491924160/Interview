package crack_interview;

import java.util.LinkedList;
import java.util.Queue;

class point{
	int x;
	int y;
	point(int x, int y){
		this.x = x;
		this.y = y;
	}
}

public class surrondregion {
	public static void traverseboard(char[][] board, int x, int y){
		board[x][y] = 'a';
		point pt = new point(x, y);
		Queue<point> queue = new LinkedList<point>();
		queue.add(pt);
		while(!queue.isEmpty()){
			point pt_temp = queue.poll();
			int x1 = pt_temp.x, y1 = pt_temp.y;
			point[] array = {new point(x1, y1-1), new point(x1, y1+1), new point(x1-1, y1), new point(x1+1, y1)};
			for(point pt1 : array){
				if(pt1.x >=0 && pt1.y >=0 && pt1.x <board.length && pt1.y <board[0].length && board[pt1.x][pt1.y] == 'o'){
					board[pt1.x][pt1.y] = 'a';
					queue.add(pt1);
				}
			}
		}
	}
	public static void solution(char[][] board){
		int width = board.length;
		int length = board[0].length;
		if(width == 0 || length == 0)
			return;
		for(int i = 0; i < length; i++){
			if(board[0][i] == 'o'){
				traverseboard(board, 0, i);
			}
			if(board[width - 1][i] == 'o'){
				traverseboard(board, width - 1, i);
			}
		}
		for(int i = 0; i < width; i++){
			if(board[i][0] == 'o')
				traverseboard(board, i, 0);
			if(board[i][length-1] == 'o')
				traverseboard(board, i, length-1);
		}
		for(int i = 0; i < width; i++)
			for(int j = 0; j < length; j++){
				if(board[i][j] == 'a')
					board[i][j] = 'o';
				else if(board[i][j] == 'o')
					board[i][j] = 'x';
			}
	}
}
