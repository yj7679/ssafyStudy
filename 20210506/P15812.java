package com.gold;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.ArrayList;

public class P15812 {
	// 침략자 진아
	public static int result = Integer.MAX_VALUE;
	public static void cal(int[][] arr0, int[][] arr1, int[] sel, int idx, int k) {
		if(k == 2) {
			int max = 0;
			for(int[] rc : arr1) {
				max = Math.max(max, Math.min(len(rc[0], arr0[sel[0]][0], rc[1], arr0[sel[0]][1]),
											 len(rc[0], arr0[sel[1]][0], rc[1], arr0[sel[1]][1])));
			}
			
			result = Math.min(result, max);
			return;
		}
		if(idx == arr0.length) return;
		
		cal(arr0, arr1, sel, idx + 1, k);
		sel[k] = idx;
		cal(arr0, arr1, sel, idx + 1, k + 1);
	}
	
	public static int len(int x1, int x2, int y1, int y2) {
		return Math.abs(x1 - x2) + Math.abs(y1 - y2);
	}
	
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		String[] NM = br.readLine().split(" ");
		int N = Integer.parseInt(NM[0]);
		int M = Integer.parseInt(NM[1]);
		
		ArrayList<int[]> arr0 = new ArrayList<int[]>();
		ArrayList<int[]> arr1 = new ArrayList<int[]>();
		
		for(int i = 0; i < N; i++) {
			char[] input = br.readLine().toCharArray();
			
			for(int j = 0; j < M; j++) {
				if(input[j] == '0') {
					arr0.add(new int[] { i, j });
				} else {
					arr1.add(new int[] { i, j });
				}
			}
		}
		
		cal(arr0.toArray(new int[arr0.size()][2]), arr1.toArray(new int[arr1.size()][2]), new int[2], 0, 0);
		
		bw.write(Integer.toString(result));
		bw.flush();
	}
}
