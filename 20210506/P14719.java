package com.gold;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;

public class P14719 {
	// 빗물
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		String[] input = br.readLine().split(" ");
		int H = Integer.parseInt(input[0]);
		int W = Integer.parseInt(input[1]);
		
		boolean[][] map = new boolean[H][W];
		
		input = br.readLine().split(" ");
		for(int i = 0; i < W; i++) {
			int N = Integer.parseInt(input[i]);
			
			for(int j = H - 1; j >= H - N ; j--) {
				map[j][i] = true;
			}
		}
		
		int result = 0;
		for(int i = 0; i < H; i++) {
			boolean check = false;
			int cnt = 0;
			
			for(int j = 0; j < W; j++) {
				if(check) {
					if(!map[i][j]) {
						cnt++;
					} else {
						result += cnt;
						cnt = 0;
					}
				}
				
				if(!check && map[i][j]) {
					check = true;
					cnt = 0;
				}
			}
		}
		bw.write(Integer.toString(result));
		bw.flush();
	}
}
