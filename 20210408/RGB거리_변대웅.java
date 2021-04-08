import java.util.*;
import java.io.*;
public class RGB거리_변대웅{

	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int N = Integer.parseInt(br.readLine());
		int[][] cost = new int[N][3];
		int[][] dp = new int[N][3];
		for(int i = 0; i < N; i++) {
			StringTokenizer st = new StringTokenizer(br.readLine());
			for(int j = 0; j < 3; j++) {
				cost[i][j] = Integer.parseInt(st.nextToken());
			}
		}
		for(int i = 0; i < 3; i++)
			dp[0][i] = cost[0][i];
		
		for(int i = 1; i < N; i++) {
			dp[i][0] = Math.min(dp[i-1][1], dp[i-1][2]) + cost[i][0];
			dp[i][1] = Math.min(dp[i-1][0], dp[i-1][2]) + cost[i][1];
			dp[i][2] = Math.min(dp[i-1][1], dp[i-1][0]) + cost[i][2];
		}
		System.out.println(Math.min(dp[N-1][2], Math.min(dp[N-1][0], dp[N-1][1])));
		
	}

}
