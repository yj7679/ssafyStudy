package 스터디문제;

import java.util.*;
import java.io.*;

public class BJ_9657돌게임3 {

	static int N;
	static String ans;
	static boolean[] dp;
	
	public static void main(String[] args) throws Exception {
		System.setIn(new FileInputStream("돌게임3.txt"));
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		
		N = Integer.parseInt(st.nextToken());
		ans = new String();
		
		dp = new boolean[N + 1];
		
		// 상근이가 true
		// 창영이가 false
		
		if (N >= 5) {
			dp[1] = true;
			dp[3] = true;
			dp[4] = true;
			
			for (int i = 5; i <= N; i++) {
				if (dp[i - 1] && dp[i - 3] && dp[i - 4]) {
					dp[i] = false;
				} else {
					dp[i] = true;
				}
			}			
		} else {
			if (N == 2) dp[2] = false;
			else dp[N] = true;
		}
		
		if (dp[N]) ans = "SK";
		else ans = "CY";
		
		System.out.println(ans);
	}

}
