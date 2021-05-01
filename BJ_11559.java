import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

public class Main {

	public static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	public static int[] dr = new int[] { 0, 0, -1, 1 };
	public static int[] dc = new int[] { 1, -1, 0, 0 };
	public static char[][] arr;
	public static boolean[][] visited;
	public static List<Node> list;
	public static int N = 12, M = 6, ans = 0;

	public static void main(String[] args) throws Exception {

		arr = new char[N][M];
		visited = new boolean[N][M];
		list = new ArrayList<Node>();

		for (int i = 0; i < N; i++) {
			String str = br.readLine();
			for (int j = 0; j < M; j++) {
				arr[i][j] = str.charAt(j);
			}
		}

//        for (int i = 0; i < N; i++) {
//			for (int j = 0; j < M; j++) {
//				System.out.print(arr[i][j] + " ");
//			}
//			System.out.println("");
//		}

		solve();
		System.out.println(ans);

	}

	public static void solve() {

		while (true) {
			//while 돌때마다 flag, visited배열 초기화 
			boolean flag = true;
			for (int i = 0; i < N; i++)
				Arrays.fill(visited[i], false);

			for (int i = 0; i < N; i++) {
				for (int j = 0; j < M; j++) {
					if (!visited[i][j] && arr[i][j] != '.')
						bfs(i, j);
					
					//4개 이상이면 터트리기
					if (list.size() >= 4) {
						flag = false;
						for (Node node : list) {
							arr[node.x][node.y] = '.';
						}
					}
					// 터트리고 난 후에 list 초기화.
					list.clear();
				}
			}
			//터트린 뒤에 뿌요들을 내려준다.
			down();
			if (flag)
				break;
			else
				ans += 1;

		}
	}
	
	public static void down() {

		for (int i = 0; i < M; i++) {
			for (int j = N - 1; j > 0; j--) {

				if (arr[j][i] == '.') {

					for (int k = j - 1; k >= 0; k--) {
						if (arr[k][i] != '.') {
							arr[j][i] = arr[k][i];
							arr[k][i] = '.';
							break;
						}
					}
				}
			}
		}

	}

	public static void bfs(int x, int y) {

		Queue<Node> q = new LinkedList<Node>();

		visited[x][y] = true;
		char val = arr[x][y];
		
		q.offer(new Node(x, y));
		list.add(new Node(x, y));

		while (!q.isEmpty()) {

			Node node = q.poll();
			int r = node.x;
			int c = node.y;

			for (int i = 0; i < 4; i++) {
				int nr = r + dr[i];
				int nc = c + dc[i];

				if (nr >= 0 && nr < N && nc >= 0 && nc < M && !visited[nr][nc] && arr[nr][nc] == val) {
					list.add(new Node(nr, nc));
					q.offer(new Node(nr, nc));
					visited[nr][nc] = true;
				}
			}
		}

	}
}

class Node {

	int x;
	int y;

	public Node(int row, int col) {
		this.x = row;
		this.y = col;
	}

}