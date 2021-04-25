import java.io.*;
import java.util.*;

// 색상환

public class Main {
	static int N, K;
	static int[][] dp;
	
	public static void main(String args[]) throws IOException {
		//System.setIn(new FileInputStream("input.txt"));
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		N = Integer.parseInt(st.nextToken());
		st = new StringTokenizer(br.readLine());
		K = Integer.parseInt(st.nextToken());
		dp = new int[N+1][N+1];
		
		for (int i = 1; i <= N; i++) {
			dp[i][1] = i;
			dp[i][0] = 1;
		}
		
		for (int i = 3; i <= N; i++) {
			for (int j = 2; j <= (i+1)/2; j++) {
				dp[i][j] = (dp[i-1][j] + dp[i-2][j-1]) % 1000000003;
			}
		}
		System.out.println((dp[N-3][K-1] + dp[N-1][K]) % 1000000003);
	}
}