package com.gold;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;

public class P2448 {
	// 별 찍기 - 11
	public static int[][] text = { { 0, 0, 1, 0, 0 }, { 0, 1, 0, 1, 0 }, { 1, 1, 1, 1, 1 } };
	
	public static void cal(int[][] map, int N, int r, int c) {
		if(N == 3) {
			for(int i = 0; i < 3; i++) {
				for(int j = 0; j < 5; j++) {
					map[i + r][j + c] = text[i][j]; 
				}
			}
			return;
		}
		
		cal(map, N / 2, r, c + N / 2);
		cal(map, N / 2, r + N / 2, c);
		cal(map, N / 2, r + N / 2, c + N);
	}
	
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		int N = Integer.parseInt(br.readLine());
		int[][] map = new int[N][N * 2];
		
		cal(map, N, 0, 0);
		for(int i = 0; i < N; i++) {
			for(int j = 0; j < N * 2; j++) {
				bw.write(map[i][j] == 0 ? " " : "*");
			}
			bw.write("\n");
		}
		
		bw.flush();
	}
}
