package BaekJun;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;

public class Bishop {
	static int[][] map;
	static int[] col;
	static int N, result = 0, result2 = 0;
	static int[] dx = { 1, 1, -1, -1 };
	static int[] dy = { 1, -1, -1, 1 };

	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		N = Integer.parseInt(br.readLine());
		map = new int[N][N];
		for (int i = 0; i < N; i++) {
			String s[] = br.readLine().split(" ");
			for (int j = 0; j < N; j++) {
				map[i][j] = Integer.parseInt(s[j]);
			}
		}
		boolean[][] b_visit = new boolean[N][N];
		boolean[][] w_visit = new boolean[N][N];
		b_dfs(0, 0, 0, b_visit);
		w_dfs(0, 0, 1, w_visit);
		System.out.println(result + result2);
	}

	private static void b_dfs(int count, int x, int y, boolean[][] visit) {
		result = Math.max(result, count);
		if (y >= N) {
			x++;
			if (x % 2 == 0) {
				y = 0;
			} else
				y = 1;
		}
		if (x >= N)
			return;

		if (!visit[x][y] && check(x, y, visit) && map[x][y] == 1) {
			visit[x][y] = true;
			b_dfs(count + 1, x, y + 2, visit);
			visit[x][y] = false;
		}
		b_dfs(count, x, y + 2, visit);
	}

	private static void w_dfs(int count, int x, int y, boolean[][] visit) {
		result2 = Math.max(result2, count);
		if (y >= N) {
			x++;
			if (x % 2 == 0) {
				y = 1;
			} else
				y = 0;
		}
		if (x >= N)
			return;

		if (!visit[x][y] && check(x, y, visit) && map[x][y] == 1) {
			visit[x][y] = true;
			w_dfs(count + 1, x, y + 2, visit);
			visit[x][y] = false;
		}
		w_dfs(count, x, y + 2, visit);
	}

	private static boolean check(int x, int y, boolean[][] visit) {
		for (int i = 0; i < 4; i++) {
			int idx = 1;
			while (true) {
				int ax = x + dx[i] * idx;
				int ay = y + dy[i] * idx;
				if (ax >= 0 && ax < N && ay >= 0 && ay < N) {
					if (visit[ax][ay]) {
						return false;
					}
				} else {
					break;
				}
				idx++;
			}
		}
		return true;
	}

}
