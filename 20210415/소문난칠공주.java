import java.util.*;
import java.io.*;

public class 소문난칠공주 {
	static char[][] map = new char[5][5];
	static int[][] locs = new int[25][2];
	static boolean[][] v = new boolean[5][5];
	static int result = 0;
	static int[] dr = { -1, 0, 1, 0 };
	static int[] dc = { 0, 1, 0, -1 };

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		for (int i = 0; i < 5; i++)
			map[i] = br.readLine().toCharArray();

		for (int i = 0; i < 5; i++) {
			for (int j = 0; j < 5; j++) {
				locs[i * 5 + j] = new int[] { i, j };
			}
		}

		combi(0, 0, 0);
		System.out.println(result);
	}

	private static void combi(int start, int s, int y) {
		if (y == 4)
			return;
		if (s + y == 7) {
			if (check())
				result++;
			return;
		}
		for (int i = start; i < 25; i++) {
			int[] loc = locs[i];
			v[loc[0]][loc[1]] = true;
			if (map[loc[0]][loc[1]] == 'S')
				combi(i + 1, s + 1, y);
			else
				combi(i + 1, s, y + 1);
			v[loc[0]][loc[1]] = false;
		}
	}

	private static boolean check() {
		for (int i = 0; i < 5; i++) {
			for (int j = 0; j < 5; j++) {
				if (v[i][j]) {
					int result = bfs(i, j);
					if(result == 7)
						return true;
					else
						return false;
				}
			}
		}
		return false;
	}

	private static int bfs(int i, int j) {
		Queue<int[]> q = new LinkedList<int[]>();
		boolean[][] visited = new boolean[5][5];
		int count = 1;
		visited[i][j] = true;
		q.offer(new int[] {i, j});
		while(!q.isEmpty()) {
			int[] c = q.poll();
			for(int d = 0; d < 4; d++) {
				int nr = c[0] + dr[d];
				int nc = c[1] + dc[d];
				if(nr >= 0 && nr < 5 && nc >= 0 && nc < 5 && v[nr][nc] && !visited[nr][nc]) {
					count++;
					visited[nr][nc] = true;
					q.offer(new int[] {nr, nc});
				}
			}
		}
		
		return count;
	}


}
