package com.gold;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;

public class P1405 {
	// 미친 로봇
	public static double simple = 0;

	public static void cal(boolean[][] map, int[] dr, int[] dc, int N, int[] p, int k, double cp, int r, int c) {
		if(k == N) {
			simple += cp;
			return;
		}
		
		for(int i = 0; i < 4; i++) {
			if(p[i] == 0) continue;
			
			int nr = r + dr[i];
			int nc = c + dc[i];
			
			if(!map[nr][nc]) {
				double np = cp * (double)p[i] * 0.01d;
				
				map[nr][nc] = true;
				cal(map, dr, dc, N, p, k + 1, np, nr, nc);
				map[nr][nc] = false;
			}
		}
	}
	
	
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		boolean[][] map = new boolean[29][29];
		int[] dr = { 0, 0, 1, -1 };
		int[] dc = { 1, -1, 0, 0 };
		String[] input = br.readLine().split(" ");
		int N = Integer.parseInt(input[0]);
		int[] p = new int[input.length - 1];
		
		for(int i = 0; i < input.length - 1; i++) {
			p[i] = Integer.parseInt(input[i + 1]);
		}
		
		map[14][14] = true;
		cal(map, dr, dc, N, p, 0, 1, 14, 14);
		
		bw.write(String.format("%.9f", simple));
		bw.flush();
	}
}
