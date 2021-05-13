package BaekJun;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

public class IceBerg {
	static int[] dx = { 0, 0, 1, -1 };
	static int[] dy = { 1, -1, 0, 0 };
	static int N, M;
	static int[][] map;
	static int[][] cmap;
	static boolean[][] visit;
	static boolean zero;

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		String[] s = br.readLine().split(" ");
		N = Integer.parseInt(s[0]);
		M = Integer.parseInt(s[1]);
		map = new int[N][M]; // 기존맵
		cmap = new int[N][M]; // 복사하기

		for (int i = 0; i < N; i++) {
			s = br.readLine().split(" ");
			for (int j = 0; j < M; j++) {
				map[i][j] = Integer.parseInt(s[j]);
				cmap[i][j] = Integer.parseInt(s[j]);
			}
		}
		int result = 0;
		while (Endcheck(map, 0)) { // 두덩어리 체크
//			for(int i=0;i<N;i++)
//			{
//				System.out.println(Arrays.toString(map[i]));
//			}
//			System.out.println("--");
			for (int i = 0; i < N; i++) {
				for (int j = 0; j < M; j++) {
					if (map[i][j] != 0)
						melt(i, j); // 빙산 녹이기
				}
			}
			copymap(map, cmap); // 맵카피
			result++;
		}
		if (zero)
			System.out.println("0");
		else
			System.out.println(result);
	}

	private static boolean Endcheck(int[][] map2, int cnt) { // 두덩이체크
		visit = new boolean[N][M];
		for (int i = 0; i < N; i++) {
			for (int j = 0; j < M; j++) {
				if (map[i][j] != 0 && !visit[i][j]) // 0이 아니면 dfs
				{
					visit[i][j] = true;
					dfs(i, j);
					cnt++; // 덩어리 갯수
				}
			}
		}

		if (cnt > 1) // 두덩어리 이상일때
		{
			return false;
		} else if (cnt == 0) // 맵에 빙산이 없을 때
		{
			zero = true;
			return false;
		}
		return true;
	}

	private static void dfs(int x, int y) {
		for (int i = 0; i < 4; i++) { // 덩어리 체크
			int ax = x + dx[i];
			int ay = y + dy[i];
			if (ax >= 0 && ay >= 0 && ax < N && ay < M) {
				if (map[ax][ay] != 0 && !visit[ax][ay]) {
					visit[ax][ay] = true;
					dfs(ax, ay);
				}
			}
		}
	}

	private static void melt(int x, int y) {
		for (int i = 0; i < 4; i++) { // 상하좌우 인접에 물이 있으면 빙산높이 빼주기
			int ax = x + dx[i];
			int ay = y + dy[i];
			if (ax >= 0 && ay >= 0 && ax < N && ay < M) {
				if (map[ax][ay] == 0) {
					cmap[x][y]--;
					if (cmap[x][y] < 0)
						cmap[x][y] = 0;
				}
			}
		}
	}

	private static void copymap(int[][] map2, int[][] cmap2) {
		for (int i = 0; i < N; i++) {
			for (int j = 0; j < M; j++) {
				map2[i][j] = cmap[i][j];
			}
		}
	}
}
