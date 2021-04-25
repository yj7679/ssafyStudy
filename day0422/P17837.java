package com.gold;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.LinkedList;

public class P17837 {
	// 새로운 게임 2
	public static class Data {
		public int idx, r, c, d;

		public Data(int idx, int r, int c, int d) {
			super();
			this.idx = idx;
			this.r = r;
			this.c = c;
			this.d = d;
		}
	}
	
	public static void cal(LinkedList<Data>[][] pieceMap, Data item, int cr, int cc, int nr, int nc, boolean reverse) {
		LinkedList<Data> tmp = new LinkedList<Data>();
		boolean flag = true;
		int size = pieceMap[nr][nc].size();
		
		for(Data p : pieceMap[item.r][item.c]) {
			if(p.idx == item.idx) flag = false;
			
			if(flag) {
				tmp.addLast(p);
				
			} else {
				if(reverse) {
					pieceMap[nr][nc].add(size, p);					
				} else {
					pieceMap[nr][nc].addLast(p);
				}
				
				p.r = nr;
				p.c = nc;
				
			}
		}
		
		pieceMap[cr][cc] = tmp;
	}
	
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		String[] input = br.readLine().split(" ");
		int N = Integer.parseInt(input[0]);
		int K = Integer.parseInt(input[1]);
		
		int[][] map = new int[N][N];
		LinkedList<Data>[][] pieceMap = new LinkedList[N][N];
		Data[] piece = new Data[K];
		
		int[] dr = { 0, 0, -1, 1 };
		int[] dc = { 1, -1, 0, 0 };
		
		for(int i = 0; i < N; i++) {
			input = br.readLine().split(" ");
			
			for(int j = 0; j < N; j++) {
				map[i][j] = Integer.parseInt(input[j]);
				pieceMap[i][j] = new LinkedList<Data>();
			}
		}
		
		for(int i = 0; i < K; i++) {
			input = br.readLine().split(" ");
			int r = Integer.parseInt(input[0]) - 1;
			int c = Integer.parseInt(input[1]) - 1;
			int d = Integer.parseInt(input[2]) - 1;
			
			Data item = new Data(i, r, c, d);
			pieceMap[r][c].offer(item);
			piece[i] = item;
		}

		int cnt = 0;
		
		E:while(true) {
			cnt++;
			
			for(Data item : piece) {
				int cr = item.r;
				int cc = item.c;
				int nr = cr + dr[item.d];
				int nc = cc + dc[item.d];
				
				if(nr < 0 || nr >= N || nc < 0 || nc >= N || map[nr][nc] == 2) {
					int nd = (item.d < 2) ? 1 - item.d : 5 - item.d;
					int nnr = cr + dr[nd];
					int nnc = cc + dc[nd];
					item.d = nd;
					
					if(nnr < 0 || nnr >= N || nnc < 0 || nnc >= N || map[nnr][nnc] == 2) continue;
					
					cal(pieceMap, item, cr, cc, nnr, nnc, (map[nnr][nnc] == 1) ? true : false);
					if(pieceMap[nnr][nnc].size() >= 4) break E;
					
				} else if(map[nr][nc] == 1) {
					cal(pieceMap, item, cr, cc, nr, nc, true);
					if(pieceMap[nr][nc].size() >= 4) break E;
					
				} else {
					cal(pieceMap, item, cr, cc, nr, nc, false);
					if(pieceMap[nr][nc].size() >= 4) break E;
				}
			}
			
			if(cnt > 1000) break;
		}
		
		bw.write(Integer.toString((cnt > 1000) ? -1 : cnt));
		bw.flush();
	}
}
