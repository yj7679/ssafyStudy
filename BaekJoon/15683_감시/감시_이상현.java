package com.gold;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.ArrayList;

public class P15683 {
	// 감시
	public static int result = Integer.MAX_VALUE;
	public static int N;
	public static int M;
	public static int size;
	public static void cal(int[] dr, int[] dc, int[][][] camera, int[][] map, ArrayList<int[]> points, int k) {
		if(k == size) {
			int cnt = 0;
			
			for(int i = 0; i < N; i++) {
				for(int j = 0; j < M; j++) {
					if(map[i][j] == 0) cnt++;
				}
			}
			result = Math.min(result, cnt);
			
			return;
		}
		
		int[] rc = points.get(k);
		int x = map[rc[0]][rc[1]] - 1;
		
		for(int i = 0; i < camera[x].length; i++) {
			for(int j = 0; j < camera[x][i].length; j++) {
				fill(dr, dc, map, 7 + k, rc[0], rc[1], camera[x][i][j], 7 + k);
			}
			cal(dr, dc, camera, map, points, k + 1);
			
			for(int j = 0; j < camera[x][i].length; j++) {
				fill(dr, dc, map, 0, rc[0], rc[1], camera[x][i][j], 7 + k);
			}
		}
	}
	
	public static void fill(int[] dr, int[] dc, int[][] map, int value, int r, int c, int angle, int k) {
		while(true) {
			r += dr[angle];
			c += dc[angle];
			
			if(r < 0 || r >= N || c < 0 || c >= M || map[r][c] == 6) {
				return;
			}
			
			if(map[r][c] == 0 || map[r][c] == k) {
				map[r][c] = value;
			}
		}
	}
	
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		int[] dr = { 0, 1, 0, -1 };
		int[] dc = { 1, 0, -1, 0 };
		int[][][] camera = {{{ 0 }, { 1 }, { 2 }, { 3 }},
							{{ 0, 2 }, { 1, 3 }},
							{{ 0, 1 }, { 1, 2 }, { 2, 3 }, { 3, 0 }},
							{{ 0, 1, 2 }, { 1, 2, 3 }, { 2, 3, 0 }, { 3, 0, 1 }},
							{{ 0, 1, 2, 3 }}};
		
		ArrayList<int[]> points = new ArrayList<int[]>();
		String[] input = br.readLine().split(" ");
		N = Integer.parseInt(input[0]);
		M = Integer.parseInt(input[1]);
		int[][] map = new int[N][M];
		
		for(int i = 0; i < N; i++) {
			input = br.readLine().split(" ");
			
			for(int j = 0; j < M; j++) {
				map[i][j] = Integer.parseInt(input[j]);
				if(map[i][j] != 0 && map[i][j] != 6) points.add(new int[] { i, j });
			}
		}
		size = points.size();
		
		cal(dr, dc, camera, map, points, 0);
		bw.write(Integer.toString(result));
		bw.flush();
	}
}
