import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class 스타트택시_변대웅 {
	static int N, M, K;
	static int[][] map;
	static int[][] list;
	static int[] dr = { -1, 0, 1, 0 };
	static int[] dc = { 0, 1, 0, -1 };

	public static void main(String[] args) throws IOException {
		System.setIn(new FileInputStream("input.txt"));
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());
		K = Integer.parseInt(st.nextToken());
		map = new int[N + 1][N + 1];
		list = new int[M][4];
		for (int i = 1; i <= N; i++) {
			st = new StringTokenizer(br.readLine());
			for (int j = 1; j <= N; j++) {
				map[i][j] = Integer.parseInt(st.nextToken());
			}
		}
		int[] start = new int[2];
		st = new StringTokenizer(br.readLine());
		start[0] = Integer.parseInt(st.nextToken());
		start[1] = Integer.parseInt(st.nextToken());
		for (int i = 0; i < M; i++) {
			st = new StringTokenizer(br.readLine());
			for (int j = 0; j < 4; j++) {
				list[i][j] = Integer.parseInt(st.nextToken());
			}
		}
		System.out.println(solve(start));
	}

	private static int solve(int[] start) {
		for (int i = 0; i < M; i++) {
			int[] nearest = getNearest(start);
			if(nearest == null)
				return -1;
			if (nearest[1] > K) {
				return -1;
			}
			K -= nearest[1];
			int[] from = { list[nearest[0]][0], list[nearest[0]][1] };
			int[] to = { list[nearest[0]][2], list[nearest[0]][3] };
			int need = getNeed(from, to);
			if(need == -1)
				return -1;
			if (need > K) {
				return -1;
			}
			K += need;
			start = to;
			list[nearest[0]][0] = -1;
		}
		return K;
	}

	private static int getNeed(int[] from, int[] to) {
		int[][] dis = new int[N + 1][N + 1];
		dis[from[0]][from[1]] = 1;
		Queue<int[]> q = new LinkedList<>();
		q.offer(from);
		while (!q.isEmpty()) {
			int[] current = q.poll();
			for (int d = 0; d < 4; d++) {
				int nr = current[0] + dr[d];
				int nc = current[1] + dc[d];
				if (nr < 1 || nr > N || nc < 1 || nc > N || dis[nr][nc] > 0 || map[nr][nc] == 1)
					continue;
				if(nr == to[0] && nc == to[1])
					return dis[current[0]][current[1]];
				dis[nr][nc] = dis[current[0]][current[1]] + 1;
				q.offer(new int[] { nr, nc });
			}
		}
		return -1;
	}

	private static int[] getNearest(int[] start) {
		for (int k = 0; k < M; k++) {
			if (start[0] == list[k][0] && start[1] == list[k][1]) {
				return new int[] {k, 0};
			}
		}
		int minIdx = -1;
		int[] min = { N + 1, N + 1 };
		int[][] dis = new int[N + 1][N + 1];
		dis[start[0]][start[1]] = 1;
		Queue<int[]> q = new LinkedList<>();
		q.offer(start);
		while (!q.isEmpty()) {
			int size = q.size();
			for (int i = 0; i < size; i++) {
				int[] current = q.poll();
				for (int d = 0; d < 4; d++) {
					int nr = current[0] + dr[d];
					int nc = current[1] + dc[d];
					if (nr < 1 || nr > N || nc < 1 || nc > N || dis[nr][nc] > 0 || map[nr][nc] == 1)
						continue;
					for (int k = 0; k < M; k++) {
						if (nr == list[k][0] && nc == list[k][1]) {
							if (nr < min[0]) {
								minIdx = k;
								min[0] = nr;
								min[1] = nc;
							} else if (nr == min[0]) {
								if (nc < min[1]) {
									minIdx = k;
									min[1] = nc;
								}
							}
						}
					}
					dis[nr][nc] = dis[current[0]][current[1]] + 1;
					q.offer(new int[] { nr, nc });
				}
			}
			if (minIdx != -1)
				return new int[] { minIdx, dis[min[0]][min[1]] - 1 };
		}
		return null;
	}
}
