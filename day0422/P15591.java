package com.gold;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

public class P15591 {
	// MooTube (Silver)
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		String[] input = br.readLine().split(" ");
		int N = Integer.parseInt(input[0]);
		int Q = Integer.parseInt(input[1]);
		
		List<int[]>[] list = new ArrayList[N];
		for(int i = 0; i < N; i++) list[i] = new ArrayList<int[]>();
		for(int i = 0; i < N - 1; i++) {
			input = br.readLine().split(" ");
			int p = Integer.parseInt(input[0]) - 1;
			int q = Integer.parseInt(input[1]) - 1;
			int r = Integer.parseInt(input[2]);
			
			list[p].add(new int[] { q, r });
			list[q].add(new int[] { p, r });
		}
		
		int[][] L = new int[N][N];
		for(int i = 0; i < N; i++) {
			Queue<int[]> queue = new LinkedList<int[]>();
			queue.add(new int[] { i, 0 });
			boolean[] v = new boolean[N];
			v[i] = true;
			
			while(!queue.isEmpty()) {
				int[] x = queue.poll();
				
				for(int[] data : list[x[0]]) {
					int nL = (x[1] == 0) ? data[1] : Math.min(x[1], data[1]);
					
					if(v[data[0]]) continue;
					
					queue.add(new int[] { data[0], nL });
					L[i][data[0]] = nL;
					v[data[0]] = true;
				}
			}
		}
		
		for(int i = 0; i < Q; i++) {
			input = br.readLine().split(" ");
			int k = Integer.parseInt(input[0]);
			int v = Integer.parseInt(input[1]) - 1;
			
			int result = 0;
			for(int j = 0; j < N; j++) {
				if(L[v][j] >= k) {
					result++;
				}
			}
			
			bw.write(result + "\n");
		}
		bw.flush();
	}
}
