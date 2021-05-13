package com.gold;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.Arrays;

public class P1647 {
	// 도시 분할 계획
	public static int getP(int[] p, int a) {
		if(a == p[a]) return a;
		
		return p[a] = getP(p, p[a]);
	}
	
	public static boolean union(int[] p, int[][] len, int a, int b) {
		int pA = getP(p, a);
		int pB = getP(p, b);
		
		if(pA == pB) return false;
		
		p[pB] = pA;
		return true;
	}
	
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		String[] input = br.readLine().split(" ");
		int N = Integer.parseInt(input[0]);
		int M = Integer.parseInt(input[1]);
		
		int[] p = new int[N + 1];
		for(int i = 0; i <= N; i++) {
			p[i] = i;
		}
		
		int[][] len = new int[M][3];
		for(int i = 0; i < M; i++) {
			input = br.readLine().split(" ");
			len[i][0] = Integer.parseInt(input[0]);
			len[i][1] = Integer.parseInt(input[1]);
			len[i][2] = Integer.parseInt(input[2]);
		}

		Arrays.sort(len, (o1, o2) -> { return o1[2] - o2[2]; });
		
		int sum = 0;
		int max = 0;
		for(int i = 0; i < M; i++) {
			if(union(p, len, len[i][0], len[i][1])) {
				sum += len[i][2];
				max = Math.max(max, len[i][2]);
			}
		}
		bw.write(Integer.toString(sum - max));
		bw.flush();
	}
}
