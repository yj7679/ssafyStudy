package 스터디문제;

import java.util.*;
import java.io.*;


/*4 ≤ N ≤ 12
4 ≤ K ≤ 10*/
public class BJ_17837새로운게임2 {

	static class Point {
		int r, c, d;

		public Point(int r, int c, int d) {
			super();
			this.r = r;
			this.c = c;
			this.d = d;
		}
		
	}
	
	static int N, K, ans;
	static int[][] map;
	static List<Integer>[][] chess;
	static Point[] pieces;
	static int[] dr = { 0, 0, 0, -1, 1 };
	static int[] dc = { 0, 1, -1, 0, 0 };
	static boolean flag;
	
	public static void main(String[] args) throws Exception {
		System.setIn(new FileInputStream("새로운게임2.txt"));
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());

		N = Integer.parseInt(st.nextToken());
		K = Integer.parseInt(st.nextToken());
		pieces = new Point[K + 1];
		map = new int[N + 1][N + 1];
		chess = new ArrayList[N + 1][N + 1];
		for (int r = 1; r <= N; r++) {
			for (int c = 1; c <= N; c++) {
				chess[r][c] = new ArrayList<>();
			}
		}
		
		// 0은 흰색, 1은 빨간색, 2는 파란색이다.
		for (int r = 1; r <= N; r++) {
			st = new StringTokenizer(br.readLine());
			for (int c = 1; c <= N; c++) {
				map[r][c] = Integer.parseInt(st.nextToken());
			}
		}
		
		for (int i = 1; i <= K; i++) {
			st = new StringTokenizer(br.readLine());
			int r = Integer.parseInt(st.nextToken());
			int c = Integer.parseInt(st.nextToken());
			int d = Integer.parseInt(st.nextToken());
			pieces[i] = new Point(r, c, d);
			chess[r][c].add(i);
		}

		
		
		int idx = 0;
		while (idx <= 1000) {
			turn();
			idx++;
			// 한 칸에 말이 4개 이상 있는 경우 flag = true
			if (flag) break;
		}
		
		if (idx == 1001) ans = -1;
		else ans = idx;
		
		System.out.println(ans);
	}

	private static void print_map(int[][] map) {
		for (int r = 1; r <= N; r++) {
			for (int c = 1; c <= N; c++) {
				System.out.print(map[r][c] + "\t");
			}
			System.out.println();
		}
		
	}

	private static void print(List<Integer>[][] chess) {
		for (int r = 1; r <= N; r++) {
			for (int c = 1; c <= N; c++) {
				System.out.print(chess[r][c] + "\t");
			}
			System.out.println();
		}
		
	}

	// 말을 이동할 때마다 말이 4개 쌓였는지 체크
	private static boolean check() {
		for (int r = 1; r <= N; r++) {
			for (int c = 1; c <= N; c++) {
				if (chess[r][c].size() >= 4)
					return true;
			}
		}
		
		return false;
	}

	private static void turn() {
		for (int i = 1; i <= K; i++) {
	
			int r =  pieces[i].r;
			int c =  pieces[i].c;
			int d =  pieces[i].d;
			int nr = r + dr[d];
			int nc = c + dc[d];
			
			// idx : 한 칸에 있는 말들 리스트 중에 이동할 말의 위치 (인덱스)
			// ex) 2 1 3 이고 1번말 이동하면 1, 3 이 이동해야 하므로 1의 idx = 1을 알 필요있다
			int idx = 0;
			
			int size = chess[r][c].size();
			if (size > 1) {
				for (int j = 0; j < size; j++) {
					if (chess[r][c].get(j) == i) {
						idx = j;
					}
				}
			}
			
			// 맵의 경계선 밖이거나 파란색이면
			if (nr < 1 || nr > N || nc < 1 || nc > N || map[nr][nc] == 2) {
				// 방향을 반대로 바꾸고 이동하기 위한 nr, nc 새롭게 지정
				if (d == 1) pieces[i].d = 2;
				if (d == 2) pieces[i].d = 1;
				if (d == 3) pieces[i].d = 4;
				if (d == 4) pieces[i].d = 3;
				nr = r - dr[d];
				nc = c - dc[d];
				
				// 이동하려는 반대방향의 칸도 맵 밖이거나 파란색이면 멈춤
				if (nr < 1 || nr > N || nc < 1 || nc > N || map[nr][nc] == 2) 
					continue;
				
				// 흰색이면
				if (map[nr][nc] == 0) {
					white(r, c, nr, nc, idx, size);
				}
				// 빨간색이면
				if (map[nr][nc] == 1) {
					red(r, c, nr, nc, idx, size);
				}
				
				if (check()) {
					flag = true;
					return;
				}
				
				continue;
			}

			
			// 흰색이면
			if (map[nr][nc] == 0) {
				white(r, c, nr, nc, idx, size);
			}
			
			// 빨간색이면
			if (map[nr][nc] == 1) {
				red(r, c, nr, nc, idx, size);
			}
			
			// 말을 한 번 움직일때마다 4개 이상의 말이 겹쳐있는지 체크
			if (check()) {
				flag = true;
				return;
			}
		}
		
	}

	// 이동한 칸이 흰색이면 말을 nr, nc에 순서대로 추가하고 r, c에서 제거
	// list의 특성상 인덱스를 idx로 고정하고 추가, 삭제해주면 순서대로 됨
	private static void white(int r, int c, int nr, int nc, int idx, int size) {
		for (int i = idx; i < size; i++) {
			chess[nr][nc].add(chess[r][c].get(idx));
			pieces[chess[r][c].get(idx)].r = nr;
			pieces[chess[r][c].get(idx)].c = nc;
			chess[r][c].remove(idx);
		}
		
	}

	// 이동한 칸이 빨간색이라면 말을 nr, nc 에 역순으로 추가하고 r, c에서 제거
	// 역순으로 제거, 추가해주기 때문에 인덱스를 가변적인 i로 해준다
	private static void red(int r, int c, int nr, int nc, int idx, int size) {
		for (int i = size - 1; i >= idx; i--) {
			chess[nr][nc].add(chess[r][c].get(i));
			pieces[chess[r][c].get(i)].r = nr;
			pieces[chess[r][c].get(i)].c = nc;
			chess[r][c].remove(i);
		}
		
	}

	
	
	
	
	
}
