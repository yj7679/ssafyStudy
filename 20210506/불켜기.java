import java.util.*;
import java.io.*;

public class 불켜기 {
	static class Location {
		Queue<int[]> switches;
		boolean light;

		public Location() {
			switches = new LinkedList<>();
			light = false;
		}

		public int on() {
			if (!light) {
				light = true;
				return 1;
			} else
				return 0;
		}

	}

	static Location[][] map;
	static int N, M;
	static int[] dr = { -1, 0, 1, 0 };
	static int[] dc = { 0, 1, 0, -1 };

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());
		map = new Location[N + 1][N + 1];
		for (int i = 1; i <= N; i++) {
			for (int j = 1; j <= N; j++) {
				map[i][j] = new Location();
			}
		}
		map[1][1].light = true;
		for (int i = 0; i < M; i++) {
			st = new StringTokenizer(br.readLine());
			int x = Integer.parseInt(st.nextToken());
			int y = Integer.parseInt(st.nextToken());
			int a = Integer.parseInt(st.nextToken());
			int b = Integer.parseInt(st.nextToken());
			map[x][y].switches.offer(new int[] { a, b });
		}
		System.out.println(search());
	}

	private static int search() {
		int lightOnRoom = 1;
		Queue<int[]> q = new LinkedList<>();
		q.offer(new int[] { 1, 1 });
		boolean[][] v = new boolean[N + 1][N + 1];
		v[1][1] = true;

		while (!q.isEmpty()) {
			int[] cur = q.poll();
			Location l = map[cur[0]][cur[1]];
			
			// 사용하지 않은 스위치가 있음
			if(!l.switches.isEmpty()) {
				while(!l.switches.isEmpty()) {
					int[] loc = l.switches.poll();
					lightOnRoom += map[loc[0]][loc[1]].on();
				}
				v = new boolean[N + 1][N + 1];
				v[cur[0]][cur[1]] = true;
				q.clear();
				q.offer(new int[] {cur[0], cur[1]});
			} else {
				for(int d = 0; d < 4; d++) {
					int nr = cur[0] + dr[d];
					int nc = cur[1] + dc[d];
					if(nr >= 1 && nr <= N && nc >= 1 && nc <= N && !v[nr][nc] && map[nr][nc].light) {
						v[nr][nc] = true;
						q.offer(new int[] {nr, nc});
					}
				}
			}
		}

		return lightOnRoom;
	}
}
