import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class 미세먼지_변대웅 {
	static int r, c, t;
	static int airRU = 0, airRD = 0;
	static int[] dr = { -1, 0, 1, 0 };
	static int[] dc = { 0, 1, 0, -1 };

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		r = Integer.parseInt(st.nextToken());
		c = Integer.parseInt(st.nextToken());
		t = Integer.parseInt(st.nextToken());
		int[][] map = new int[r][c];
		for (int i = 0; i < r; i++) {
			st = new StringTokenizer(br.readLine());
			for (int j = 0; j < c; j++) {
				map[i][j] = Integer.parseInt(st.nextToken());
				if (map[i][j] == -1) {
					if (airRU == 0)
						airRU = i;
					else
						airRD = i;
				}
			}
		}
		for (int i = 0; i < t; i++) {
			spread(map);
			airCleaning(map);
		}
		System.out.println(count(map));
	}

	private static int count(int[][] map) {
		int count = 0;
		for (int i = 0; i < map.length; i++) {
			for (int j = 0; j < map[i].length; j++) {
				if (map[i][j] > 0)
					count += map[i][j];
			}
		}
		return count;
	}

	private static void airCleaning(int[][] map) {
		// 위
		for (int i = airRU - 1; i > 0; i--) {
			map[i][0] = map[i - 1][0];
		}
		for (int i = 0; i < c - 1; i++) {
			map[0][i] = map[0][i + 1];
		}
		for (int i = 0; i < airRU; i++) {
			map[i][c - 1] = map[i + 1][c - 1];
		}
		for (int i = c - 1; i > 1; i--) {
			map[airRU][i] = map[airRU][i - 1];
		}
		map[airRU][1] = 0;
		// 아래
		for (int i = airRD + 1; i < r - 1; i++) {
			map[i][0] = map[i + 1][0];
		}
		for (int i = 0; i < c - 1; i++) {
			map[r - 1][i] = map[r - 1][i + 1];
		}
		for (int i = r - 1; i > airRD; i--) {
			map[i][c - 1] = map[i - 1][c - 1];
		}
		for (int i = c - 1; i > 1; i--) {
			map[airRD][i] = map[airRD][i - 1];
		}
		map[airRD][1] = 0;
	}

	private static void spread(int[][] map) {
		int[][] tmp = new int[r][c];
		for (int i = 0; i < r; i++) {
			for (int j = 0; j < c; j++) {
				if (map[i][j] >= 5) {
					int amount = map[i][j] / 5;
					for (int d = 0; d < 4; d++) {
						int nr = i + dr[d];
						int nc = j + dc[d];
						if (nr >= 0 && nr < r && nc >= 0 && nc < c && map[nr][nc] != -1) {
							tmp[nr][nc] += amount;
							map[i][j] -= amount;
						}
					}
				}
			}
		}
		for (int i = 0; i < r; i++) {
			for (int j = 0; j < c; j++) {
				map[i][j] += tmp[i][j];
			}
		}
	}

	private static void print(int[][] map) {
		for (int i = 0; i < map.length; i++) {
			for (int j = 0; j < map[i].length; j++) {
				System.out.print(map[i][j] + " ");
			}
			System.out.println();
		}
		System.out.println();
	}

}
