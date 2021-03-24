import java.util.ArrayList;
import java.util.Scanner;

public class 감시_변대웅 {
	static int N, M;
	static int[][] map;
	static int[][] map2;
	static ArrayList<int[]> list = new ArrayList<>();
	static int result = Integer.MAX_VALUE;
	static int[] dr = { -1, 0, 1, 0 };
	static int[] dc = { 0, 1, 0, -1 };

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		N = sc.nextInt();
		M = sc.nextInt();
		map = new int[N][M];
		map2 = new int[N][M];
		for (int i = 0; i < N; i++) {
			for (int j = 0; j < M; j++) {
				map[i][j] = sc.nextInt();
				if (map[i][j] > 0 && map[i][j] < 6)
					list.add(new int[] { i, j });
			}
		}

		solve(0);
		System.out.println(result);
	}

	private static void solve(int idx) {
		if (idx == list.size()) {
			result = Math.min(result, getResult());
			return;
		}
		int[] current = list.get(idx);
		int type = map[current[0]][current[1]];
		if (type == 1) {
			check(current[0], current[1], 0);
			solve(idx + 1);
			unCheck(current[0], current[1], 0);
			check(current[0], current[1], 1);
			solve(idx + 1);
			unCheck(current[0], current[1], 1);
			check(current[0], current[1], 2);
			solve(idx + 1);
			unCheck(current[0], current[1], 2);
			check(current[0], current[1], 3);
			solve(idx + 1);
			unCheck(current[0], current[1], 3);
		} else if (type == 2) {
			check(current[0], current[1], 0);
			check(current[0], current[1], 2);
			solve(idx + 1);
			unCheck(current[0], current[1], 0);
			unCheck(current[0], current[1], 2);
			check(current[0], current[1], 1);
			check(current[0], current[1], 3);
			solve(idx + 1);
			unCheck(current[0], current[1], 1);
			unCheck(current[0], current[1], 3);
		} else if (type == 3) {
			check(current[0], current[1], 0);
			check(current[0], current[1], 1);
			solve(idx + 1);
			unCheck(current[0], current[1], 0);
			unCheck(current[0], current[1], 1);
			check(current[0], current[1], 1);
			check(current[0], current[1], 2);
			solve(idx + 1);
			unCheck(current[0], current[1], 1);
			unCheck(current[0], current[1], 2);
			check(current[0], current[1], 2);
			check(current[0], current[1], 3);
			solve(idx + 1);
			unCheck(current[0], current[1], 2);
			unCheck(current[0], current[1], 3);
			check(current[0], current[1], 3);
			check(current[0], current[1], 0);
			solve(idx + 1);
			unCheck(current[0], current[1], 3);
			unCheck(current[0], current[1], 0);

		} else if (type == 4) {
			check(current[0], current[1], 0);
			check(current[0], current[1], 1);
			check(current[0], current[1], 2);
			solve(idx + 1);
			unCheck(current[0], current[1], 0);
			unCheck(current[0], current[1], 1);
			unCheck(current[0], current[1], 2);
			check(current[0], current[1], 1);
			check(current[0], current[1], 2);
			check(current[0], current[1], 3);
			solve(idx + 1);
			unCheck(current[0], current[1], 1);
			unCheck(current[0], current[1], 2);
			unCheck(current[0], current[1], 3);
			check(current[0], current[1], 2);
			check(current[0], current[1], 3);
			check(current[0], current[1], 0);
			solve(idx + 1);
			unCheck(current[0], current[1], 2);
			unCheck(current[0], current[1], 3);
			unCheck(current[0], current[1], 0);
			check(current[0], current[1], 3);
			check(current[0], current[1], 0);
			check(current[0], current[1], 1);
			solve(idx + 1);
			unCheck(current[0], current[1], 3);
			unCheck(current[0], current[1], 0);
			unCheck(current[0], current[1], 1);

		} else if (type == 5) {
			check(current[0], current[1], 3);
			check(current[0], current[1], 0);
			check(current[0], current[1], 1);
			check(current[0], current[1], 2);
			solve(idx + 1);
			unCheck(current[0], current[1], 3);
			unCheck(current[0], current[1], 0);
			unCheck(current[0], current[1], 1);
			unCheck(current[0], current[1], 2);
		}
	}

	private static int getResult() {
		int count = 0;
		for(int i = 0; i < N; i++) {
			for(int j = 0; j < M; j++) {
				if(map[i][j] == 0)
					count++;
			}
		}
		return count;
	}

	private static void unCheck(int r, int c, int dir) {
		r = r + dr[dir];
		c = c + dc[dir];
		while(r >= 0 && r < N && c >= 0 && c < M) {
			if(map[r][c] == 6)
				break;
			if(map[r][c] < 0)
				map[r][c] += 1;
			r += dr[dir];
			c += dc[dir];
		}
	}

	private static void check(int r, int c, int dir) {
		r = r + dr[dir];
		c = c + dc[dir];
		while(r >= 0 && r < N && c >= 0 && c < M) {
			if(map[r][c] == 6)
				break;
			if(map[r][c] <= 0)
				map[r][c] -= 1;
			r += dr[dir];
			c += dc[dir];
		}
	}

}
