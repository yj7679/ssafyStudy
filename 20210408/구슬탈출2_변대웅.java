import java.util.*;
import java.io.*;

public class 구슬탈출2_변대웅 {
	static int N, M;
	static char[][] map;
	static int[] dr = { -1, 0, 1, 0 };
	static int[] dc = { 0, 1, 0, -1 };
	static int[] red;
	static int[] blue;

	public static void main(String[] args) throws IOException {
		System.setIn(new FileInputStream("input.txt"));
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());
		map = new char[N][M];
		for (int i = 0; i < N; i++) {
			map[i] = br.readLine().toCharArray();
			for (int j = 0; j < M; j++) {
				if (map[i][j] == 'R')
					red = new int[] { i, j };
				if (map[i][j] == 'B')
					blue = new int[] { i, j };
			}
		}

		System.out.println(bfs());
	}

	private static int bfs() {
		boolean[][][][] v = new boolean[N][M][N][M];
		Queue<int[]> q = new LinkedList<>();
		v[red[0]][red[1]][blue[0]][blue[1]] = true;
		q.offer(new int[] { red[0], red[1], blue[0], blue[1] });
		int count = 0;
		while (!q.isEmpty()) {
			int size = q.size();
			for (int i = 0; i < size; i++) {
				int[] cur = q.poll();
				for (int d = 0; d < 4; d++) {
					setMap(cur);
					int[] result = go(d);
					if (result[0] == -1) {
						continue;
					}
					if (v[result[0]][result[1]][result[2]][result[3]])
						continue;
					if (result[0] == 0) {
						return count + 1;
					} else {
						v[result[0]][result[1]][result[2]][result[3]] = true;
						q.offer(new int[] { result[0], result[1], result[2], result[3] });
					}
				}
			}
			count++;
			if(count == 10)
				return -1;
		}
		return -1;
	}

	private static void setMap(int[] cur) {
		map[red[0]][red[1]] = '.';
		map[blue[0]][blue[1]] = '.';
		map[cur[0]][cur[1]] = 'R';
		map[cur[2]][cur[3]] = 'B';
		red[0] = cur[0];
		red[1] = cur[1];
		blue[0] = cur[2];
		blue[1] = cur[3];
	}

	private static int[] go(int d) {
		int[] result = new int[4];
		int[] locR = new int[2];
		int[] locB = new int[2];
		if (d == 0) {
			if ((red[1] == blue[1]) && blue[0] < red[0]) {
				locB = goBlue(d);
				locR = goRed(d);
			} else {
				locR = goRed(d);
				locB = goBlue(d);
			}
		} else if (d == 1) {
			if ((red[0] == blue[0]) && blue[1] > red[1]) {
				locB = goBlue(d);
				locR = goRed(d);
			} else {
				locR = goRed(d);
				locB = goBlue(d);
			}
		} else if (d == 2) {
			if ((red[1] == blue[1]) && blue[0] > red[0]) {
				locB = goBlue(d);
				locR = goRed(d);
			} else {
				locR = goRed(d);
				locB = goBlue(d);
			}
		} else if (d == 3) {
			if ((red[0] == blue[0]) && blue[1] < red[1]) {
				locB = goBlue(d);
				locR = goRed(d);
			} else {
				locR = goRed(d);
				locB = goBlue(d);
			}
		}
		result[0] = locR[0];
		result[1] = locR[1];
		result[2] = locB[0];
		result[3] = locB[1];

		// 파란구슬이 구멍에 들어갔을때
		if (locB[0] == 0) {
			return new int[] { -1, -1, -1, -1 };
		}
		return result;
	}

	private static int[] goRed(int d) {
		int nr = red[0];
		int nc = red[1];
		boolean intoHole = false;
		int[] result = new int[2];
		while (true) {
			nr += dr[d];
			nc += dc[d];
			if (map[nr][nc] == '#' || map[nr][nc] == 'B') {
				nr -= dr[d];
				nc -= dc[d];
				break;
			} else if (map[nr][nc] == 'O') {
				intoHole = true;
				break;
			}
		}
		if(!intoHole) {
			result[0] = nr;
			result[1] = nc;
		}
		setMapRed(result);
		return result;
	}


	private static int[] goBlue(int d) {
		int nr = blue[0];
		int nc = blue[1];
		boolean intoHole = false;
		int[] result = new int[2];
		while (true) {
			nr += dr[d];
			nc += dc[d];
			if (map[nr][nc] == '#' || map[nr][nc] == 'R') {
				nr -= dr[d];
				nc -= dc[d];
				break;
			} else if (map[nr][nc] == 'O') {
				intoHole = true;
				break;
			}
		}
		if(!intoHole) {
			result[0] = nr;
			result[1] = nc;
		}
		setMapBlue(result);
		return result;
	}
	private static void setMapRed(int[] result) {
		if(result[0] == 0) {
			map[red[0]][red[1]] = '.';
			return;
		}
		map[red[0]][red[1]] = '.';
		map[result[0]][result[1]] = 'R';
		red[0] = result[0];
		red[1] = result[1];
	}
	private static void setMapBlue(int[] result) {
		if(result[0] == 0) {
			map[blue[0]][blue[1]] = '.';
			return;
		}
		map[blue[0]][blue[1]] = '.';
		map[result[0]][result[1]] = 'B';
		blue[0] = result[0];
		blue[1] = result[1];
	}

}
