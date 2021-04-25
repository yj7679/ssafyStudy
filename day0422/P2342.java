package com.gold;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;

public class P2342 {
	// Dance Dance Revolution
	public static int price(int s, int e) {
		if(s == e) return 1;
		else if(s == 0) return 2;
		else if(Math.abs(s - e) == 2) return 4;
		else return 3;
	}
	
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		String[] input = br.readLine().split(" ");
		int size = input.length;
		
		int[][][] dp = new int[size][5][5];
		
		int x = Integer.parseInt(input[0]);
		dp[0][0][x] = price(0, x);
		dp[0][x][0] = price(0, x);
		
		for(int i = 0; i < 5; i++) {
			for(int j = 0; j < 5; j++) {
				if(dp[0][i][j] == 0) dp[0][i][j] = 1000000; 
			}
		}
		
		for(int idx = 1; idx < size - 1; idx++) {
			x = Integer.parseInt(input[idx]);
			
			for(int i = 0; i < 5; i++) {
				for(int j = 0; j < 5; j++) {
					dp[idx][i][j] = 1000000;
					if(i != x && j != x) continue;
					if(i == j) continue;
					
					for(int k = 0; k < 5; k++) {
						dp[idx][i][j] = Math.min(dp[idx][i][j], dp[idx - 1][i][k] + price(k, j));
						dp[idx][i][j] = Math.min(dp[idx][i][j], dp[idx - 1][k][j] + price(k, i));
					}
				}
			}
		}
		
		int result = Integer.MAX_VALUE;
		
		for(int i = 0; i < 5; i++) {
			for(int j = 0; j < 5; j++) {
				result = Math.min(result, (size - 2) < 0 ? 0 : dp[size - 2][i][j]);			
			}
		}
		bw.write(Integer.toString(result));
		bw.flush();
	}
}
