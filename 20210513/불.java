import java.util.*;
import java.io.*;

public class 불 {
	static int N, M;
	static char[][] map;
	static int[] start = new int[2];
	
	static Queue<int[]> fires = new LinkedList<>();
	
	static int[] dr = { -1, 0, 1, 0 };
	static int[] dc = { 0, 1, 0, -1 };

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());
		map = new char[N][M];
		for (int i = 0; i < N; i++) {
			map[i] = br.readLine().toCharArray();
			for (int j = 0; j < M; j++) {
				if (map[i][j] == 'J') {
					start[0] = i;
					start[1] = j;
				} else if (map[i][j] == 'F')
					fires.offer(new int[] { i, j });
			}
		}
		int result = bfs();
		System.out.println(result == -1 ? "IMPOSSIBLE" : result);
	}

	private static int bfs() {
		Queue<int[]> q = new LinkedList<>();
		q.offer(new int[] { start[0], start[1], 0 });
		boolean[][] v = new boolean[N][M];
		v[start[0]][start[1]] = true;
		
		while (!q.isEmpty()) {
			spreadFire();
			int size = q.size();
			for (int i = 0; i < size; i++) {
				int[] cur = q.poll();
				if (cur[0] == 0 || cur[0] == N - 1 || cur[1] == 0 || cur[1] == M - 1)
					return cur[2] + 1;
				for (int d = 0; d < 4; d++) {
					int nr = cur[0] + dr[d];
					int nc = cur[1] + dc[d];
					if (nr < 0 || nr >= N || nc < 0 || nc >= M || v[nr][nc] || map[nr][nc] == '#' || map[nr][nc] == 'F')
						continue;
					v[nr][nc] = true;
					q.offer(new int[] {nr, nc, cur[2] + 1});
				}
			}
		}
		return -1;
	}

	private static void spreadFire() {
		int size = fires.size();
		for(int i = 0; i < size; i++) {
			int[] cur = fires.poll();
			for (int d = 0; d < 4; d++) {
				int nr = cur[0] + dr[d];
				int nc = cur[1] + dc[d];
				if (nr < 0 || nr >= N || nc < 0 || nc >= M || map[nr][nc] == '#' || map[nr][nc] == 'F')
					continue;
				fires.offer(new int[] {nr, nc});
				map[nr][nc] = 'F';
			}
		}
	}

}
