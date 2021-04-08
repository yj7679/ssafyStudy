package com.gold;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.ArrayList;

public class P19237 {
	// 어른 상어
	public static void change(int[][][] map, int N) {
		for(int i = 0; i < N; i++) {
			for(int j = 0; j < N; j++) {
				if(map[i][j][1] == 0) continue;
				map[i][j][2]--;
				if(map[i][j][2] == 0) map[i][j][1] = 0;
			}
		}
	}
	
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		String[] input = br.readLine().split(" ");
		int N = Integer.parseInt(input[0]);
		int M = Integer.parseInt(input[1]);
		int K = Integer.parseInt(input[2]);
		
		int[][][] map = new int[N][N][3];
		ArrayList<int[]> shark = new ArrayList<int[]>();
		
		for(int i = 0; i < N; i++) {
			input = br.readLine().split(" ");
			
			for(int j = 0; j < N; j++) {
				int x = Integer.parseInt(input[j]);
				if(x != 0) {
					map[i][j][0] = x;
					map[i][j][1] = x;
					map[i][j][2] = K;
					shark.add(new int[] { x, i, j });
				}
			}
		}
		
		shark.sort((o1, o2) -> { return o1[0] - o2[0]; });
		
		int[] direction = new int[M];
		input = br.readLine().split(" ");
		for(int i = 0; i < M; i++) {
			direction[i] = Integer.parseInt(input[i]) - 1;
		}
		
		int[][][] p = new int[M][4][4];
		for(int i = 0; i < M; i++) {
			for(int j = 0; j < 4; j++) {
				input = br.readLine().split(" ");
				for(int k = 0; k < 4; k++) {
					p[i][j][k] = Integer.parseInt(input[k]) - 1;
				}
			}
		}
		
		int[] dr = { -1, 1, 0, 0 };
		int[] dc = { 0, 0, -1, 1 };
		int time = 0;
		int sharkCnt = shark.size();
		
		while(true) {
			time++;
			
			for(int[] nrc : shark) {
				if(nrc[0] == -1) continue;
				map[nrc[1]][nrc[2]][0] = 0;
				boolean check = false;
				
				for(int i = 0; i < 4; i++) {
					int r = nrc[1] + dr[p[nrc[0] - 1][direction[nrc[0] - 1]][i]];
					int c = nrc[2] + dc[p[nrc[0] - 1][direction[nrc[0] - 1]][i]];
					
					if(r < 0 || r >= N || c < 0 || c >= N || map[r][c][1] != 0) continue;
					check = true;
					
					if(map[r][c][0] != 0) {
						nrc[0] = -1;
						sharkCnt--;
						break;
					}
					
					map[r][c][0] = nrc[0];
					direction[nrc[0] - 1] = p[nrc[0] - 1][direction[nrc[0] - 1]][i];
					nrc[1] = r;
					nrc[2] = c;
					break;
				}
				
				if(check) continue;
				
				for(int i = 0; i < 4; i++) {
					int r = nrc[1] + dr[p[nrc[0] - 1][direction[nrc[0] - 1]][i]];
					int c = nrc[2] + dc[p[nrc[0] - 1][direction[nrc[0] - 1]][i]];
					
					if(r < 0 || r >= N || c < 0 || c >= N || map[r][c][1] != nrc[0]) continue;
					map[r][c][0] = nrc[0];
					direction[nrc[0] - 1] = p[nrc[0] - 1][direction[nrc[0] - 1]][i];
					nrc[1] = r;
					nrc[2] = c;
					break;
				}
			}
			
			if(sharkCnt == 1) break;
			
			change(map, N);
			for(int[] nrc : shark) {
				if(nrc[0] == -1) continue;
				map[nrc[1]][nrc[2]][1] = nrc[0];
				map[nrc[1]][nrc[2]][2] = K;
			}
			
			if(time >= 1000) {
				time = -1;
				break;
			}
		}
		bw.write(Integer.toString(time));
		bw.flush();
	}
}
