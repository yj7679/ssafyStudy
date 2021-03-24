import java.util.Scanner;

public class 미친로봇_변대웅 {
	static int[] dr = { 0, 0, 1, -1 };
	static int[] dc = { 1, -1, 0, 0 };
	static int K;
	static double result = 0.0;

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		K = sc.nextInt();
		double E = (double) sc.nextInt() / 100;
		double W = (double) sc.nextInt() / 100;
		double S = (double) sc.nextInt() / 100;
		double N = (double) sc.nextInt() / 100;
		double[] percents = {E, W, S, N};
		boolean[][] v = new boolean[30][30];
		v[15][15] = true;
		dfs(15, 15, v, percents, 1, 0);
		System.out.println(1 - result);
	}

	private static void dfs(int r, int c, boolean[][] v, double[] percents, double percent, int move) {
		if(move == K) {
			return;
		}
		for(int d = 0; d < 4; d++) {
			int nr = r + dr[d];
			int nc = c + dc[d];
			if(v[nr][nc]) {
				result += percent * percents[d];
			} else {
				v[nr][nc] = true;
				dfs(nr, nc, v, percents, percent * percents[d], move + 1);
				v[nr][nc] = false;
			}
		}
	}

}
