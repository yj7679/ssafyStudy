import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.util.Scanner;

public class Solution {

	public static void main(String[] args) throws FileNotFoundException {
		System.setIn(new FileInputStream("input.txt"));
		Scanner sc = new Scanner(System.in);

		int t = sc.nextInt();
		int[] dr = {-1, -1, 0, 1, 1, 1, 0, -1};
		int[] dc = {0, 1, 1, 1, 0, -1, -1, -1};
		
		for (int test_case = 1; test_case <= t; test_case++) {
			int n = sc.nextInt();
			int m = sc.nextInt();
			int[][] board = new int[n][n];
			board[n / 2 - 1][n / 2 - 1] = 2;
			board[n / 2 - 1][n / 2] = 1;
			board[n / 2][n / 2 - 1] = 1;
			board[n / 2][n / 2] = 2;

			for (int i = 0; i < m; i++) {
//				print(board);
				int r = sc.nextInt() - 1;
				int c = sc.nextInt() - 1;
				int color = sc.nextInt();
				board[r][c] = color;
				int[][] changes = new int[7][2];
				int count;
				for(int k = 0; k < 8; k++) {
					count = 0;
					int nr = r + dr[k];
					int nc = c + dc[k];
					if(nr < 0 || nr >= n || nc < 0 || nc >= n || board[nr][nc] == 0 || board[nr][nc] == board[r][c])
						continue;
					while(true) {
						changes[count][0] = nr;
						changes[count++][1] = nc;
						nr = nr + dr[k];
						nc = nc + dc[k];
						if(nr < 0 || nr >= n || nc < 0 || nc >= n || board[nr][nc] == 0)
							break;
						if(color == board[nr][nc]) {
							for(int change = 0; change < count; change++) {
								board[changes[change][0]][changes[change][1]] = color;
							}
							break;
						}
					}
					
				}
			}
			int countWhite = 0;
			int countBlack = 0;
			for(int i = 0; i < n; i++) {
				for(int j = 0; j < n; j++) {
					if(board[i][j] == 1)
						countBlack++;
					else if(board[i][j] == 2)
						countWhite++;
				}
			}
			System.out.println("#" + test_case + " " + countBlack + " " + countWhite);
		}
	}
	
	public static void print(int[][] board) {
		for(int i = 0; i < board.length; i++) {
			for(int j = 0; j < board[i].length; j++) {
				System.out.print(board[i][j]);
			}
			System.out.println();
		}
		System.out.println();
	}
}
