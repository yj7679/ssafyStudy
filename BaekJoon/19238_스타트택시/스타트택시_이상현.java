package com.gold;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.Queue;

public class P19238 {
	// 스타트 택시
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		String[] input = br.readLine().split(" ");
		int N = Integer.parseInt(input[0]);
		int M = Integer.parseInt(input[1]);
		int F = Integer.parseInt(input[2]);
		
		int[][] map = new int[N][N];
		
		for(int i = 0; i < N; i++) {
			input = br.readLine().split(" ");
			
			for(int j = 0; j < N; j++) {
				map[i][j] = Integer.parseInt(input[j]);
			}
		}
		
		HashMap<String, int[]> destination = new HashMap<String, int[]>();
		input = br.readLine().split(" ");
		int r = Integer.parseInt(input[0]) - 1;
		int c = Integer.parseInt(input[1]) - 1;
		
		for(int i = 0; i < M; i++) {
			input = br.readLine().split(" ");
			int sr = Integer.parseInt(input[0]) - 1;
			int sc = Integer.parseInt(input[1]) - 1;
			int er = Integer.parseInt(input[2]) - 1;
			int ec = Integer.parseInt(input[3]) - 1;
			
			map[sr][sc] = 2;
			destination.put(sr + "|" + sc, new int[] { er, ec });
		}
		
		int[] dr = { 0, 0, -1, 1 };
		int[] dc = { -1, 1, 0, 0 };
		
		// 메인 루프
		while(true) {
			ArrayList<int[]> next = new ArrayList<int[]>();
 			Queue<int[]> queue = new LinkedList<int[]>();
			boolean[][] v = new boolean[N][N];
			queue.offer(new int[] { r, c });
			v[r][c] = true;
			
			int L = -1;
			
			// bfs
			while(!queue.isEmpty()) {
				L++;
				int size = queue.size();
				
				for(int i = 0; i < size; i++) {
					int[] rc = queue.poll();
					if(map[rc[0]][rc[1]] == 2) next.add(rc);
					
					for(int j = 0; j < 4; j++) {
						int nr = rc[0] + dr[j];
						int nc = rc[1] + dc[j];
						
						if(nr >= 0 && nr < N && nc >= 0 && nc < N && map[nr][nc] != 1 && !v[nr][nc]) {
							queue.offer(new int[] { nr, nc });
							v[nr][nc] = true;
						}
					}
				}
				
				if(!next.isEmpty()) {
					queue.clear();
				}
			}
			
			if(next.isEmpty()) break;
			
			F -= L;
			L = -1;
			if(F <= 0) {
				F = -1;
				break;
			}

			next.sort((o1, o2) -> { 
				int diff = o1[0] - o2[0];
				return diff != 0 ? diff : o1[1] - o2[1];
			});
			
			int[] start = next.get(0);
			map[start[0]][start[1]] = 0;
			int[] des = destination.get(start[0] + "|" + start[1]);
			
			v = new boolean[N][N];
			queue.offer(start);
			v[start[0]][start[1]] = true;
			boolean end = false;
			
			// bfs
			E:while(!queue.isEmpty()) {
				L++;
				int size = queue.size();
				
				for(int i = 0; i < size; i++) {
					int[] rc = queue.poll();
					if(rc[0] == des[0] && rc[1] == des[1]) {
						end = true;
						break E;
					}
					
					for(int j = 0; j < 4; j++) {
						int nr = rc[0] + dr[j];
						int nc = rc[1] + dc[j];
						
						if(nr >= 0 && nr < N && nc >= 0 && nc < N && map[nr][nc] != 1 && !v[nr][nc]) {
							queue.offer(new int[] { nr, nc });
							v[nr][nc] = true;
						}
					}
				}
			}
			
			if(!end) {
				F = -1;
				break;
			}
			if(F >= L) {
				F += L;
			} else {
				F = -1;
				break;
			}
			
			r = des[0];
			c = des[1];
			
		}
		
		E:for(int i = 0; i < N; i++) {
			for(int j = 0; j < N; j++) {
				if(map[i][j] == 2) {
					F = -1;
					break E;
				}
			}
		}
		
		bw.write(Integer.toString(F));
		bw.flush();
	}
}
