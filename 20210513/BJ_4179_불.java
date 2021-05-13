import java.io.*;
import java.util.*;

public class BJ_4179_불 {
	static class Point {
		int r, c;

		public Point(int r, int c) {
			super();
			this.r = r;
			this.c = c;
		}

	}

	static char[][] maze;
	static int R, C;
	static int[] dr = { -1, 0, 1, 0 };
	static int[] dc = { 0, 1, 0, -1 };

	public static void main(String[] args) throws Exception {
		System.setIn(new FileInputStream("input.txt"));
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		R = Integer.parseInt(st.nextToken());
		C = Integer.parseInt(st.nextToken());
		maze = new char[R][C];

		for (int i = 0; i < R; i++) {
			char[] c = br.readLine().toCharArray();
			maze[i] = c;
		}

		bfs();
		System.out.println("IMPOSSIBLE");
	}

	private static void bfs() {
		Queue<Point> jq = new LinkedList<>();
		Queue<Point> fq = new LinkedList<>();
		int[][] v = new int[R][C];

		for (int i = 0; i < R; i++) {
			for (int j = 0; j < C; j++) {
				if (maze[i][j] == 'J') {
					jq.offer(new Point(i, j));
					v[i][j] = 1;
				}
				if (maze[i][j] == 'F')
					fq.offer(new Point(i, j));
			}
		}

		while (!jq.isEmpty()) {
			for (int i = 0, sz = jq.size(); i < sz; i++) {
				// 지훈이가 움직인다
				Point jp = jq.poll();
				for (int d = 0; d < 4; d++) {
					int nr = jp.r + dr[d];
					int nc = jp.c + dc[d];
					if (maze[jp.r][jp.c] == 'J' && (nr < 0 || nr >= R || nc < 0 || nc >= C)) {
						System.out.println(v[jp.r][jp.c]);
						System.exit(0);
					}
					if (maze[jp.r][jp.c] == 'J' && maze[nr][nc] == '.') {
						jq.offer(new Point(nr, nc));
						v[nr][nc] = v[jp.r][jp.c] + 1;
						maze[nr][nc] = 'J';
					}
				}
			}

			for (int i = 0, sz = fq.size(); i < sz; i++) {
				// 불이 퍼진다
				Point fp = fq.poll();
				maze[fp.r][fp.c] = 'F';
				for (int d = 0; d < 4; d++) {
					int nr = fp.r + dr[d];
					int nc = fp.c + dc[d];
					if (nr < 0 || nr >= R || nc < 0 || nc >= C) {
						continue;
					}
					if (maze[nr][nc] != '#' && maze[nr][nc] != 'F') {
						fq.offer(new Point(nr, nc));
						maze[nr][nc] = 'F';
					}

				}
			}
		}

	}
}
