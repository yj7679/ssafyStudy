import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Deque;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class 뱀_변대웅 {
	static int N, K, L;
	static int[][] map;
	static int[] dr = { -1, 0, 1, 0 };
	static int[] dc = { 0, 1, 0, -1 };
	static int time, dir;
	static Deque<int[]> snakes = new LinkedList<>();

	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		N = Integer.parseInt(br.readLine());
		K = Integer.parseInt(br.readLine());
		map = new int[N][N];
		for (int i = 0; i < K; i++) {
			StringTokenizer st = new StringTokenizer(br.readLine());
			map[Integer.parseInt(st.nextToken()) - 1][Integer.parseInt(st.nextToken()) - 1] = 2;
		}
		L = Integer.parseInt(br.readLine());
		time = 0;
		dir = 1;
		map[0][0] = 1;
		snakes.offer(new int[] { 0, 0 });
		L: for (int i = 0; i < L; i++) {
			StringTokenizer st = new StringTokenizer(br.readLine());
			int X = Integer.parseInt(st.nextToken());
			char C = st.nextToken().charAt(0);
			while (time < X) {
				if (!move())
					break L;
			}
			changeDir(C);
			if (i == L - 1) {
				while (true) {
					if (!move())
						break;
				}
			}
		}
		System.out.println(time + 1);
	}

	private static void changeDir(char c) {
		if (c == 'L')
			dir = (dir + 3) % 4;
		else
			dir = (dir + 1) % 4;
	}

	private static boolean move() {
		int[] head = snakes.peekFirst();
		int[] tail = snakes.peekLast();
		int nr = head[0] + dr[dir];
		int nc = head[1] + dc[dir];
		if (nr < 0 || nr >= N || nc < 0 || nc >= N)
			return false;
		if (map[nr][nc] == 1)
			return false;
		if (map[nr][nc] == 0) {
			map[tail[0]][tail[1]] = 0;
			snakes.pollLast();
		}
		map[nr][nc] = 1;
		snakes.offerFirst(new int[] { nr, nc });
		time++;
		return true;
	}
}
