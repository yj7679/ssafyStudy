package 스터디문제;

import java.util.*;
import java.io.*;

public class BJ_6087레이저통신 {

	static class Point {
		int r, c, d, mirror;

		Point(int r, int c, int d, int mirror) {
			this.r = r;
			this.c = c;
			this.d = d;
			this.mirror = mirror;
		}
	}
	
	static Point startPoint, endPoint;
	static int W, H, ans;
	static int min = Integer.MAX_VALUE;
	static char[][] map;
	static int[][] v;
	static int[] dx = {-1, 0, 1, 0};
	static int[] dy = {0, 1, 0, -1};

	public static void main(String[] args) throws Exception {
		System.setIn(new FileInputStream("레이저통신.txt"));
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());

		W = Integer.parseInt(st.nextToken());
		H = Integer.parseInt(st.nextToken());

		map = new char[H][W];

		for(int r = 0; r < H; r++) {
			String str = br.readLine();
			for(int c = 0; c < W; c++) {
				map[r][c] = str.charAt(c);

				if(map[r][c] == 'C') {
					if(startPoint == null)
						startPoint = new Point(r, c, -1, 0);
					else 
						endPoint = new Point(r, c, -1, 0);
				}
			}
		}

		bfs();
		ans = min;
		System.out.println(ans);
	}

	public static void bfs() {
		Queue<Point> queue = new LinkedList<>();
		queue.add(startPoint);

		v = new int[H][W];
		v[startPoint.r][startPoint.c] = 1;

		while(!queue.isEmpty()) {
			int cr = queue.peek().r;
			int cc = queue.peek().c;
			int cd = queue.peek().d;
			int cm = queue.poll().mirror;

			if(cr == endPoint.r && cc == endPoint.c) {
				min = Math.min(min, cm);
				continue;
			}

			for(int d = 0; d < 4; d++) {
				int nr = cr + dx[d];
				int nc = cc + dy[d];
				int nd = d;

				if(nr < 0 || nr >= H || nc < 0 || nc >= W || map[nr][nc] == '*')
					continue;

				int nm = cm; // 새로운 거울 개수 저장할 변수

				if(cd != -1 && cd != nd) { 
					nm += 1;
				}

				if(v[nr][nc] == 0) { // 방문하지 않은 경우 
					v[nr][nc] = nm; // 구해진 거울 값으로 초기화 
					queue.add(new Point(nr, nc, nd, nm));
				} else if(v[nr][nc] >= nm) { 
					// 이미 방문한 곳이지만 새롭게 구해진 거울 개수가 더 작은 경우 
					v[nr][nc] = nm; // 새롭게 구해진 값으로 변경 
					queue.add(new Point(nr, nc, nd, nm)); 
				}
			}
		}
	}

}
