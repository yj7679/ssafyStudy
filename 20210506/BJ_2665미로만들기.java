package 스터디문제;

import java.io.*;
import java.util.*;

public class BJ_2665미로만들기 {
	
	static class Point	{
		int r, c;

		public Point(int r, int c) {
			super();
			this.r = r;
			this.c = c;
		}
		
	}
	
	static int N, ans;
	static int[][] map;
	static int[][] costs;

	static int dr[] = { -1, 1, 0, 0 };
	static int dc[] = { 0, 0, 1, -1 };
	public static void main(String[] args) throws Exception {
//		System.setIn(new FileInputStream("미로만들기.txt"));
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		N = Integer.parseInt(st.nextToken());
		map = new int[N][N];
		costs = new int[N][N];
		
		for (int r = 0; r < N; r++)
			Arrays.fill(costs[r], Integer.MAX_VALUE);
		
		for (int r = 0; r < N; r++) {
			st = new StringTokenizer(br.readLine());
			for (int c = 0; c < N; c++) {
				map[r][c] = Integer.parseInt(st.nextToken());
			}
		}
		
		bfs();
		
		ans = costs[N - 1][N - 1];
		
		System.out.println(ans);
	}
	
	private static void bfs() {
		Queue<Point> q = new LinkedList<>();
		q.add(new Point(0, 0));
		costs[0][0] = 0;
		
		while (!q.isEmpty()) {
			
			Point p = q.poll();
			
			for (int d = 0; d < 4; d++) {
				int nr = p.r + dr[d];
				int nc = p.c + dc[d];
				
				if (nr >= 0 && nr < N && nc >= 0 && nc < N) {
					
					int cost = costs[p.r][p.c];
					
					int next = map[nr][nc] == 0 ? cost + 1 : cost;
					if (next < costs[nr][nc]) {
						costs[nr][nc] = next;
						q.add(new Point(nr, nc));
					}
				}
			}
		}
		
	}
}
