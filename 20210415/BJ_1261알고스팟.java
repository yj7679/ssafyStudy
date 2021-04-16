package 스터디문제;

import java.util.*;
import java.io.*;

public class BJ_1261알고스팟 {

	static class Point implements Comparable<Point> {
		int r, c, weight;

		public Point(int r, int c, int weight) {
			super();
			this.r = r;
			this.c = c;
			this.weight = weight;
		}

		@Override
		public int compareTo(Point o) {
			return this.weight - o.weight;
		}
		
		
	}
	
	static int M, N, ans;
	static int[][] map, distance;
	
	static int[] dr = { 0, 1, 0, -1 };
	static int[] dc = { 1, 0, -1, 0 };
	
	public static void main(String[] args) throws Exception {
		System.setIn(new FileInputStream("알고스팟.txt"));
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());

		M = Integer.parseInt(st.nextToken());
		N = Integer.parseInt(st.nextToken());
		String str = new String();
		distance = new int[N + 1][M + 1];
		
		map = new int[N + 1][M + 1];
		int idx = 0;
		for (int r = 1; r <= N; r++) {
			Arrays.fill(distance[r], Integer.MAX_VALUE);
			str = br.readLine();
			for (int c = 1; c <= M; c++) {
				map[r][c] = str.charAt(c-1) - '0';
			}
		}
		
		
		bfs();
		
		System.out.println(ans);
		
	}

	private static void bfs() {
		PriorityQueue<Point> pq = new PriorityQueue<>();
		pq.offer(new Point(1, 1, 0));
		distance[1][1] = 0;
		
		while (!pq.isEmpty()) {
			Point p = pq.poll();
			
			if (p.r == N && p.c == M) {
				ans = p.weight;
			}
			
			for (int d = 0; d < 4; d++) {
				int nr = p.r + dr[d];
				int nc = p.c + dc[d];
				
				if (nr < 1 || nr > N || nc < 1 || nc > M) continue;
				
				if (distance[nr][nc] > distance[p.r][p.c] + map[nr][nc]) {
					distance[nr][nc] = distance[p.r][p.c] + map[nr][nc];
					pq.offer(new Point(nr, nc, distance[nr][nc]));
				}
			}
		}
		
	}

	
	
	
	
	
}
