package 스터디문제;

import java.util.*;
import java.io.*;

public class BJ_1915가장큰정사각형 {

	static int N, M, ans, max;
	static int[][] dp;

	// 북, 북서, 서
	static int[] dr = { -1, -1, 0 };
	static int[] dc = { 0, -1, -1 };

	public static void main(String[] args) throws Exception {
		System.setIn(new FileInputStream("가장큰정사각형.txt"));
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());

		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());
		dp = new int[N][M];

		String str = new String();
		int cnt = 0;
		for (int r = 0; r < N; r++) {
			str = br.readLine();
			for (int c = 0; c < M; c++) {
				dp[r][c] = str.charAt(c) - '0';
				if (dp[r][c] == 1) cnt++;
			}
		}
		
		// N이나 M이 1인 경우 함수를 들어갈 필요없이 답은 1 or 0
		if (N == 1 || M == 1) {
			if (cnt > 0) ans = 1;
			else ans = 0;
		} else {
			// dp 시작
			solution();
			ans = max * max;
		}
		
		System.out.println(ans);
	}

	private static void print(int[][] dp) {
		for (int r = 0; r < N; r++) {
			for (int c = 0; c < M; c++) {
				System.out.print(dp[r][c] + " ");
			}
			System.out.println();
		}
	}

	private static void solution() {
		// 현재 좌표에서 북, 북서, 서 방향으로 정사각형을 그릴 수 있는지 판단하는 변수
		boolean flag;
		
		// 1, 1부터 시작
		for (int r = 1; r < N; r++) {
			for (int c = 1; c < M; c++) {
				// 처음엔 true로 시작
				flag = true;
				if (dp[r][c] == 0)
					continue;

				// 3방 탐색할 때 가장 작은 값을 현재 좌표에 찍어주기 위해 필요한 변수
				int min = Integer.MAX_VALUE;
				for (int d = 0; d < 3; d++) {
					int nr = r + dr[d];
					int nc = c + dc[d];

					// 경계체크
					if (nr < 0 || nr >= N || nc < 0 || nc >= M) {
						flag = false;
						continue;
					}
					
					// 3방탐색시 0을 만나면 1보다 큰 정사각형이 될 수 없으므로 false
					if (dp[nr][nc] == 0) {
						flag = false;
						continue;
					}
					
					// 3방탐색한 곳에서 가장 작은 값을 저장
					min = Math.min(min, dp[nr][nc]);
				}

				// flag가 false면 정사각형을 그릴 수 없으므로 continue
				if (!flag)
					continue;

				// 현재 좌표에 min을 저장
				dp[r][c] += min;
				// dp 에 저장된 값 중 가장 큰 값을 max에 저장
				// ans = max * max
				max = Math.max(max, dp[r][c]);
			}
		}
	}

}
