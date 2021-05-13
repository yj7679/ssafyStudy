package 스터디문제;

import java.util.*;
import java.io.*;

public class BJ_4179불 {

	static class Point {
		int r, c;

		public Point(int r, int c) {
			super();
			this.r = r;
			this.c = c;
		}
		
	}
	
	static int R, C, ans;
	static char[][] map;
	static Point start;
	static boolean flag;
	static List<Point> fire_list, list;
	static int[] dr = { -1, 0, 1, 0 };
	static int[] dc = { 0, 1, 0, -1 };
	
	public static void main(String[] args) throws Exception {
		System.setIn(new FileInputStream("불.txt"));
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		R = Integer.parseInt(st.nextToken());
		C = Integer.parseInt(st.nextToken());
		
		map = new char[R][C];
		fire_list = new ArrayList<>();
		list = new ArrayList<>();
		
		String str = new String();
		for (int r = 0; r < R; r++) {
			str = br.readLine();
			for (int c = 0; c < C; c++) {
				map[r][c] = str.charAt(c);
				if (map[r][c] == 'J') {
					start = new Point(r, c);					
				}
				if (map[r][c] == 'F') {
					fire_list.add(new Point(r, c));
				}
			}
		}
		bfs(start.r, start.c);
		
//		print(map);
		
		if (flag) {
			System.out.println(ans);
		} else {
			System.out.println("IMPOSSIBLE");
		}
	}

	private static void print(char[][] map) {
		for (int r = 0; r < R; r++) {
			for (int c = 0; c < C; c++) {
				System.out.print(map[r][c] + " ");
			}
			System.out.println();
		}
	}

	private static void bfs(int r, int c) {
		Queue<Point> q = new LinkedList<>();
		boolean[][] v = new boolean[R][C];
		q.offer(new Point(r, c));
		v[r][c] = true;
		
		int cnt = 0;
		while (!q.isEmpty()) {
			int size = q.size();
			cnt++;
			
			fireSpread();
			for (int i = 0; i < size; i++) {
				Point p = q.poll();
				
				for (int d = 0; d < 4; d++) {
					int nr = p.r + dr[d];
					int nc = p.c + dc[d];
					
					if (nr < 0 || nr >= R || nc < 0 || nc >= C || v[nr][nc]) continue;
					if (map[nr][nc] == '#' || map[nr][nc] == 'F') continue;
					
					if (nr == 0 || nr == R - 1 || nc == 0 || nc == C - 1) {
						flag = true;
						ans = cnt + 1;
						return;
					}
					
					q.offer(new Point(nr, nc));
					v[nr][nc] = true;
				}				
			}
			
		}
		
		
	}

	private static void fireSpread() {
		int size = fire_list.size();
		
		for (int i = 0; i < size; i++) {
			
			for (int d = 0; d < 4; d++) {
				int nr = fire_list.get(i).r + dr[d];
				int nc = fire_list.get(i).c + dc[d];
				
				if (nr < 0 || nr >= R || nc < 0 || nc >= C) continue;
				if (map[nr][nc] == '#' || map[nr][nc] == 'F') continue;
				
				list.add(new Point(nr, nc));
			}
		}
		
		size = list.size();
		for (int i = 0; i < size; i++) {
			map[list.get(i).r][list.get(i).c] = 'F';
		}
		
		fire_list.clear();
		
		for (int i = 0; i < size; i++) {
			fire_list.add(new Point(list.get(i).r, list.get(i).c));
		}
		list.clear();
	}

}
