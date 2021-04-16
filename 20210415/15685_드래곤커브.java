import java.io.*;
import java.util.*;

// 드래곤 커브

class Main {
	static int[] dr = {0, -1, 0, 1};
	static int[] dc = {1, 0, -1, 0};
	
	static int[] inpArr = new int[4];
	static boolean[][] board = new boolean[101][101];
	
	public static void main(String[] args) throws Exception {
		int cnt = 0;
		
		//System.setIn(new FileInputStream("input.txt"));
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		int input = Integer.parseInt(st.nextToken());
		
		for (int i = 0; i < input; i++) {
			st = new StringTokenizer(br.readLine());
			for (int j = 0; j < 4; j++) {
				inpArr[j] = Integer.parseInt(st.nextToken());
			}
			board[inpArr[1]][inpArr[0]] = true;
			
			ArrayList<Integer> list = new ArrayList<>();
			list.add(inpArr[2]);
			for (int k = 0; k < inpArr[3]; k++) {
				ArrayList<Integer> nextList = new ArrayList<>();
				for (int j = list.size() - 1; j >= 0; j--) {
					nextList.add((list.get(j) + 1) % 4);
				}
				list.addAll(nextList);
			}
			
			for (int j = 0, sz = list.size(); j < sz; j++) {
				int d = list.get(j);
				int nr = inpArr[1] + dr[d];
				int nc = inpArr[0] + dc[d];
				board[nr][nc] = true;

				inpArr[1] = nr;
				inpArr[0] = nc;
				
			}
			
		}
		// 정사각형 구하기
		for (int i = 0; i <= 100; i++) {
			for (int j = 0; j <= 100; j++) {
				if(board[i][j]) {
					if(i+1 <= 100 && j+1 <= 100 && board[i][j+1] && board[i+1][j] && board[i+1][j+1])
						++cnt;
				}
			}
		}
		System.out.println(cnt);
	}
}