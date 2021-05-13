package com.gold;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;

public class P11967 {
	// 불켜기
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		String[] input = br.readLine().split(" ");
		int N = Integer.parseInt(input[0]);
		int M = Integer.parseInt(input[1]);
		
		ArrayList<int[]>[][] list = new ArrayList[N][N];
		boolean[][] v = new boolean[N][N];
		boolean[][] check = new boolean[N][N];
		
		for(int i = 0; i < M; i++) {
			input = br.readLine().split(" ");
			int x = Integer.parseInt(input[0]) - 1;
			int y = Integer.parseInt(input[1]) - 1;
			int a = Integer.parseInt(input[2]) - 1;
			int b = Integer.parseInt(input[3]) - 1;
			
			if(list[x][y] == null) list[x][y] = new ArrayList<int[]>();
			list[x][y].add(new int[] { a, b });
		}
		
		int[] dr = { -1, 1, 0, 0 };
		int[] dc = { 0, 0, -1, 1 };
		Queue<int[]> queue = new LinkedList<int[]>();
		queue.offer(new int[] { 0, 0 });
		check[0][0] = true;
		v[0][0] = true;
		int result = 1;
		
		while(!queue.isEmpty()) {
			int[] rc = queue.poll();
			
			for(int i = 0; i < 4; i++) {
				int nr = rc[0] + dr[i];
				int nc = rc[1] + dc[i];
				
				if(nr < 0 || nr >= N || nc < 0 || nc >= N || !check[nr][nc] || v[nr][nc]) continue;
				queue.add(new int[] { nr, nc });
				v[nr][nc] = true;
			}
			
			if(list[rc[0]][rc[1]] != null) {
				for(int[] data : list[rc[0]][rc[1]]) {
					if(v[data[0]][data[1]]) continue;
					if(!check[data[0]][data[1]]) result++;
					check[data[0]][data[1]] = true;
					
					for(int i = 0; i < 4; i++) {
						int nr = data[0] + dr[i];
						int nc = data[1] + dc[i];
						
						if(nr < 0 || nr >= N || nc < 0 || nc >= N || !v[nr][nc]) continue;
						queue.offer(data);
						v[data[0]][data[1]] = true;
						break;
					}
				}
			}
		}
		
		bw.write(Integer.toString(result));
		bw.flush();
	}
}
