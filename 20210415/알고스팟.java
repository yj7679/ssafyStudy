import java.util.*;
import java.io.*;

public class 알고스팟 {
	static int N, M;
	static int[][] map;
	static int[] dr = { -1, 0, 1, 0 };
	static int[] dc = { 0, 1, 0, -1 };

	public static void main(String[] args) throws Exception {
		System.setIn(new FileInputStream("input.txt"));
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		M = Integer.parseInt(st.nextToken());
		N = Integer.parseInt(st.nextToken());
		map = new int[N][M];

		for (int i = 0; i < N; i++) {
			String s = br.readLine();
			for (int j = 0; j < M; j++) {
				map[i][j] = s.charAt(j) - '0';
			}
		}
		System.out.println(bfs());
	}

	private static int bfs() {
		PriorityQueue<int[]> pq = new PriorityQueue<>((o1, o2) -> o1[2] - o2[2]);
		pq.offer(new int[] { 0, 0, 0 });
		boolean[][] v = new boolean[N][M];
		v[0][0] = true;
		while (!pq.isEmpty()) {
			int[] cur = pq.poll();
			for (int d = 0; d < 4; d++) {
				int nr = cur[0] + dr[d];
				int nc = cur[1] + dc[d];
				if (nr < 0 || nr >= N || nc < 0 || nc >= M || v[nr][nc])
					continue;
				if (nr == N - 1 && nc == M - 1)
					return cur[2];
				if (map[nr][nc] == 0) {
					pq.offer(new int[] { nr, nc, cur[2] });
				} else if (map[nr][nc] == 1) {
					pq.offer(new int[] { nr, nc, cur[2] + 1 });
				}
				v[nr][nc] = true;
			}
		}
		return 0;
	}

}
