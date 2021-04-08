package com.gold;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;

public class P12865 {
	// 평범한 배낭
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		String[] input = br.readLine().split(" ");
		int N = Integer.parseInt(input[0]);
		int K = Integer.parseInt(input[1]);
		int[] dp = new int[K + 1];
		
		for(int i = 0; i < N; i++) {
			input = br.readLine().split(" ");
			int W = Integer.parseInt(input[0]);
			int V = Integer.parseInt(input[1]);
			
			for(int j = K; j > 0; j--) {
				dp[j] = Math.max(dp[j], (j - W) >= 0 ? dp[j - W] + V : 0);
			}
		}
		
		int result = 0;
		for(int i = 1; i <= K; i++) {
			result = Math.max(result, dp[i]);
		}
		
		bw.write(Integer.toString(result));
		bw.flush();
	}
}
