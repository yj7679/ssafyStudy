import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class 벽부수고_변대웅 {
	static int N, M;
	static char[][] map;
	static int result = -1;
	static boolean[][][] v;
	static int[] dr = { -1, 0, 1, 0 };
	static int[] dc = { 0, 1, 0, -1 };

	static class Location {
		int r, c, k;

		public Location(int r, int c, int k) {
			super();
			this.r = r;
			this.c = c;
			this.k = k;
		}

	}

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());
		map = new char[N][M];
		v = new boolean[2][N][M];
		for (int i = 0; i < N; i++) {
			map[i] = br.readLine().toCharArray();
		}
		result = bfs();
		System.out.println(result);
	}

	private static int bfs() {
		if(N == 1 && M == 1)
			return 1;
		Location current = new Location(0, 0, 1);
		Queue<Location> q = new LinkedList<>();
		q.offer(current);
		v[0][0][0] = true;
		v[1][0][0] = true;
		int dist = 1;
		while (!q.isEmpty()) {
			int size = q.size();
			for (int i = 0; i < size; i++) {
				current = q.poll();
				for (int d = 0; d < 4; d++) {
					int nr = current.r + dr[d];
					int nc = current.c + dc[d];
					if (nr < 0 || nr >= N || nc < 0 || nc >= M)
						continue;
					if (nr == N - 1 && nc == M - 1)
						return dist + 1;
					if (current.k == 1) {
						if (map[nr][nc] == '1' && !v[1][nr][nc]) {
							v[1][nr][nc] = true;
							q.offer(new Location(nr, nc, 0));
						} else if (map[nr][nc] == '0' && !v[0][nr][nc]) {
							v[0][nr][nc] = true;
							q.offer(new Location(nr, nc, 1));
						}
					} else {
						if (map[nr][nc] == '0' && !v[1][nr][nc]) {
							v[1][nr][nc] = true;
							q.offer(new Location(nr, nc, 0));
						}
					}
				}
			}
			dist++;
		}
		return -1;
	}

}
