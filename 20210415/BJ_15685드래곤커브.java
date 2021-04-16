package 스터디문제;

import java.util.*;
import java.io.*;

public class BJ_15685드래곤커브 {

	static int N, ans;
//	x와 y는 드래곤 커브의 시작 점, d는 시작 방향, g는 세대이다. 
//	(0 ≤ x, y ≤ 100, 0 ≤ d ≤ 3, 0 ≤ g ≤ 10)
	static int x, y, d, g;
	static int[][] map;
	static int[] dr = { 0, -1, 0, 1 };
	static int[] dc = { 1, 0, -1, 0 };
	static List<Integer> list;
	
	public static void main(String[] args) throws Exception {
		System.setIn(new FileInputStream("드래곤커브.txt"));
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		
		N = Integer.parseInt(st.nextToken());
		map = new int[101][101];
		list = new ArrayList<>();

		
		for (int i = 0; i < N; i++) {
			st = new StringTokenizer(br.readLine());
			x = Integer.parseInt(st.nextToken());
			y = Integer.parseInt(st.nextToken());
			d = Integer.parseInt(st.nextToken());
			g = Integer.parseInt(st.nextToken());
			
			map[y][x] = 1;
			map[y + dr[d]][x + dc[d]] = 1;
			list.add(d);

			if (g > 0) dragoncurve(x + dc[d], y + dr[d], d, 1);
			list.clear();
		}
		
//		print(map);
		
		for (int r = 0; r <= 100; r++) {
			for (int c = 0; c <= 100; c++) {
				if (map[r][c] == 1 && map[r + 1][c] == 1 
						&& map[r][c + 1] == 1 && map[r + 1][c + 1] == 1) {
					ans++;
				}
			}
		}
		
		System.out.println(ans);
	}

	private static void print(int[][] map) {
		for (int r = 0; r <= 15; r++) {
			for (int c = 0; c <= 15; c++) {
				System.out.print(map[r][c] + " ");
			}
			System.out.println();
		}
		
	}

	private static void dragoncurve(int c, int r, int d, int idx) {
		if (idx > g) return;
		
		int nr = r;
		int nc = c;
		int size = list.size();
		for (int i = (size-1); i >= 0; i--) {
			int nd = (list.get(i) + 1) % 4;
			list.add(nd);
			nr += dr[nd];
			nc += dc[nd];
			
			map[nr][nc] = 1;
		}
		
		dragoncurve(nc, nr, list.get(size * 2 - 1), idx + 1);
		
	}

}
