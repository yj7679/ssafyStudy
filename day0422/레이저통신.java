import java.util.*;
import java.io.*;

public class 레이저통신 {
	static int N, M;
	static char[][] map;
	static int[][] numMirrors;
	static int[] dr = { -1, 0, 1, 0 };
	static int[] dc = { 0, 1, 0, -1 };
	static int[] start = { -1, -1 };
	static int[] end;

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		M = Integer.parseInt(st.nextToken());
		N = Integer.parseInt(st.nextToken());
		map = new char[N][M];
		numMirrors = new int[N][M];
		
		for (int i = 0; i < N; i++) {
			map[i] = br.readLine().toCharArray();
			Arrays.fill(numMirrors[i], -2);
		}
		L: for (int i = 0; i < N; i++) {
			for (int j = 0; j < M; j++) {
				if (map[i][j] == 'C') {
					if (start[0] == -1) {
						start = new int[] { i, j };
					} else {
						end = new int[] { i, j };
						break L;
					}
				}
			}
		}
		
		bfs();
		System.out.println(numMirrors[end[0]][end[1]]);
	}

	private static void bfs() {
		Queue<int[]> q = new LinkedList<>();
		q.offer(start);
		numMirrors[start[0]][start[1]] = -1;
		while(!q.isEmpty()) {
			int[] cur = q.poll();
			for(int d = 0; d < 4; d++) {
				int nr = cur[0] + dr[d];
				int nc = cur[1] + dc[d];
				while(nr >= 0 && nr < N && nc >= 0 && nc < M) {
					if(map[nr][nc] == '*')
						break;
					if(numMirrors[nr][nc] == -2) {
						numMirrors[nr][nc] = numMirrors[cur[0]][cur[1]] + 1;
						q.offer(new int[] {nr, nc});
					}
					nr += dr[d];
					nc += dc[d];
				}
			}
		}
	}

}
