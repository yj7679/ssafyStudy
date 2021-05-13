import java.util.*;
import java.io.*;

public class 미로만들기 {
	static int N;
	static int[][] map;
	static int[] dr = { -1, 0, 1, 0 };
	static int[] dc = { 0, 1, 0, -1 };

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		N = Integer.parseInt(br.readLine());
		map = new int[N][N];
		for (int i = 0; i < N; i++) {
			String s = br.readLine();
			for (int j = 0; j < N; j++) {
				map[i][j] = s.charAt(j) - '0';
			}
		}
		System.out.println(bfs());
	}

	private static int bfs() {
		PriorityQueue<int[]> pq = new PriorityQueue<>((o1, o2) -> o1[2] - o2[2]);
		pq.offer(new int[] { 0, 0, 0 });
		boolean[][] v = new boolean[N][N];
		v[0][0] = true;
		while (!pq.isEmpty()) {
			int[] cur = pq.poll();
			int cnt = cur[2];
			if(cur[0] == N-1 && cur[1] == N-1)
				return cnt;
			for(int d = 0; d < 4; d++) {
				int nr = cur[0] + dr[d];
				int nc = cur[1] + dc[d];
				if(nr >= 0 && nr < N && nc >= 0 && nc < N && !v[nr][nc]) {
					if(map[nr][nc] == 1) {
						v[nr][nc] = true;
						pq.offer(new int[] {nr, nc, cnt});
					} else {
						v[nr][nc] = true;
						pq.offer(new int[] {nr, nc, cnt + 1});
					}
				}
			}
		}
		return -1;
	}
}
