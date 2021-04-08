package 스터디문제;

import java.util.*;
import java.io.*;

/*입력의 첫 줄에는 테스트 케이스의 개수 T(1 ≤ T ≤ 10)가 주어진다. 
각 테스트 케이스의 첫 번째 줄에는 동전의 가지 수 N(1 ≤ N ≤ 20)이 주어지고 두 번째 줄에는 N가지 동전의 각 금액이 오름차순으로 정렬되어 주어진다. 
각 금액은 정수로서 1원부터 10000원까지 있을 수 있으며 공백으로 구분된다. 
세 번째 줄에는 주어진 N가지 동전으로 만들어야 할 금액 M(1 ≤ M ≤ 10000)이 주어진다.

편의를 위해 방법의 수는 231 - 1 보다 작고, 같은 동전이 여러 번 주어지는 경우는 없다.*/
public class BJ_9084동전 {

	static int T, N, M;
	static int[] coins, dp;

	public static void main(String[] args) throws Exception {
		System.setIn(new FileInputStream("동전.txt"));
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		T = Integer.parseInt(st.nextToken());

		for (int tc = 0; tc < T; tc++) {
			st = new StringTokenizer(br.readLine());
			N = Integer.parseInt(st.nextToken());

			coins = new int[N + 1];
			st = new StringTokenizer(br.readLine());
			for (int i = 1; i <= N; i++) {
				coins[i] = Integer.parseInt(st.nextToken());
			}
			st = new StringTokenizer(br.readLine());
			M = Integer.parseInt(st.nextToken());

			dp = new int[M + 1];

			// dp[0]을 저장하는 순간이 생기므로 1로 초기화
			dp[0] = 1;
			for (int i = 1; i <= N; i++) {
				for (int j = coins[i]; j <= M; j++) {
					dp[j] += dp[j - coins[i]];
				}
			}
			System.out.println(dp[M]);
		}

		br.close();
	}

}
