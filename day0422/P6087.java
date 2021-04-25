package com.gold;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.LinkedList;
import java.util.Queue;

public class P6087 {
	// 레이저 통신
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		String[] input = br.readLine().split(" ");
		int W = Integer.parseInt(input[0]);
		int H = Integer.parseInt(input[1]);
		
		boolean[][] map = new boolean[H][W];
		boolean flag = true;
		int sr = 0;
		int sc = 0;
		int er = 0;
		int ec = 0;
		
		for(int i = 0; i < H; i++) {
			char[] text = br.readLine().toCharArray();
			
			for(int j = 0; j < W; j++) { 
				map[i][j] = (text[j] == '*') ? false : true;
				if(flag && text[j] == 'C') {
					sr = i;
					sc = j;
					flag = false;
					
				} else if(text[j] == 'C') {
					er = i;
					ec = j;

				}
			}
		}
		
		int[] dr = { -1, 0, 1, 0 };
		int[] dc = { 0, 1, 0, -1 };
		
		Queue<int[]> queue = new LinkedList<int[]>();
		int[][] L = new int[H][W];
		boolean[][] v = new boolean[H][W];	
		queue.offer(new int[] { sr, sc, 0, 1000 });
		L[sr][sc] = 0;
		v[sr][sc] = true;
				
		while(!queue.isEmpty()) {
			int[] x = queue.poll();
			
			for(int i = 0; i < 4; i++) {
				int diff = Math.abs(x[3] - i);
				if(diff == 2) continue;
				
				int nr = x[0] + dr[i];
				int nc = x[1] + dc[i];
				
				if(nr < 0 || nr >= H || nc < 0 || nc >= W || !map[nr][nc]) continue;
				int nCnt = x[2] + ((diff == 1 || diff == 3) ? 1 : 0);
				
				if((v[nr][nc] && L[nr][nc] >= nCnt) || !v[nr][nc]) {
					if(nr != er || nc != ec) queue.offer(new int[] { nr, nc, nCnt, i });
					L[nr][nc] = nCnt;
					v[nr][nc] = true;
				}
			}
		}
		
		bw.write(Integer.toString(L[er][ec]));
		bw.flush();
	}
}
