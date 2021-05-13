package com.silver;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;

public class P9657 {
	// 돌 게임 3
	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		int N = Integer.parseInt(br.readLine());
		
		boolean[][] dp = new boolean[N + 1][2];
		dp[0][0] = false;
		dp[0][1] = true;
		dp[1][0] = true;
		dp[1][1] = false;
		
		for(int i = 2; i <= N; i++) {
			boolean a = dp[i - 1][1];
			boolean b = (i - 3) >= 0 ? dp[i - 3][1] : false;
			boolean c = (i - 4) >= 0 ? dp[i - 4][1] : false;
			dp[i][0] = a | b | c;
			
			a = dp[i - 1][0];
			b = (i - 3) >= 0 ? dp[i - 3][0] : true;
			c = (i - 4) >= 0 ? dp[i - 4][0] : true;
			dp[i][1] = a & b & c;
		}
		
		bw.write(dp[N][0] ? "SK" : "CY");
		bw.flush();
	}
}
