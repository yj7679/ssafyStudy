import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class 원판돌리기_변대웅 {
	static int N, M;
	static int[] dr = { -1, 0, 1, 0 };
	static int[] dc = { 0, 1, 0, -1 };
	static int sum, count;
	static boolean hasSame, deleteComplete;

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());
		sum = 0;
		count = 0;
		int T = Integer.parseInt(st.nextToken());
		int[][] circle = new int[N + 1][M + 1];
		for (int i = 1; i <= N; i++) {
			st = new StringTokenizer(br.readLine());
			for (int j = 1; j <= M; j++) {
				circle[i][j] = Integer.parseInt(st.nextToken());
				sum += circle[i][j];
				count++;
			}
		}
		for (int t = 0; t < T; t++) {
			st = new StringTokenizer(br.readLine());
			int x = Integer.parseInt(st.nextToken());
			int d = Integer.parseInt(st.nextToken());
			int k = Integer.parseInt(st.nextToken());
			for (int n = x; n <= N; n += x) {
				rotation(circle, n, d, k);
			}
			check(circle);
		}
		System.out.println(sum);
	}

	private static void check(int[][] circle) {
		deleteComplete = false;
		for (int r = 1; r <= N; r++) {
			for (int c = 1; c <= M; c++) {
				hasSame = false;
				if (circle[r][c] == -1)
					continue;
				deleteSame(circle, r, c);
			}
		}
		if (!deleteComplete) {
			double avg = (double) sum / count;
			for (int r = 1; r <= N; r++) {
				for (int c = 1; c <= M; c++) {
					if (circle[r][c] == -1)
						continue;
					if (circle[r][c] > avg) {
						circle[r][c]--;
						sum--;
					} else if (circle[r][c] < avg) {
						circle[r][c]++;
						sum++;
					}
				}
			}

		}
	}

	private static void deleteSame(int[][] circle, int r, int c) {
		Queue<int[]> q = new LinkedList<>();
		int val = circle[r][c];
		for (int d = 0; d < 4; d++) {
			int nr = r + dr[d];
			int nc = c + dc[d];
			if (nr > N || nr <= 0)
				continue;
			if (nc == 0)
				nc = M;
			if (nc == M + 1)
				nc = 1;
			if (circle[nr][nc] == val) {
				q.offer(new int[] { nr, nc });
				hasSame = true;
				deleteComplete = true;
				sum-= val;
				count--;
				circle[nr][nc] = -1;
			}
		}
		if (hasSame) {
			sum -= val;
			count--;
			circle[r][c] = -1;

		}
		while (!q.isEmpty()) {
			int[] current = q.poll();
			for (int d = 0; d < 4; d++) {
				int nr = current[0] + dr[d];
				int nc = current[1] + dc[d];
				if (nr > N || nr <= 0)
					continue;
				if (nc == 0)
					nc = M;
				if (nc == M + 1)
					nc = 1;
				if (circle[nr][nc] == val) {
					q.offer(new int[] { nr, nc });
					sum-= val;
					count--;
					circle[nr][nc] = -1;
				}
			}
		}
	}

	private static void rotation(int[][] circle, int n, int d, int k) {
		for (int i = 0; i < k; i++) {
			if (d == 0)
				rotationR(circle, n);
			else
				rotationL(circle, n);
		}
	}

	private static void rotationL(int[][] circle, int n) {
		int tmp = circle[n][1];
		for (int i = 1; i < M; i++)
			circle[n][i] = circle[n][i + 1];
		circle[n][M] = tmp;
	}

	private static void rotationR(int[][] circle, int n) {
		int tmp = circle[n][M];
		for (int i = M; i >= 2; i--)
			circle[n][i] = circle[n][i - 1];
		circle[n][1] = tmp;

	}

}
