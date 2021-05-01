package com.gold;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;

public class P1007 {
	// 벡터 매칭
	public static int N;
	public static double result;
	public static void cal(long[][] data, int idx, int k, boolean[] v) {
		if(k == (N / 2)) {
			long sumX = 0L;
			long sumY = 0L;
			
			for(int i = 0; i < N; i++) {
				if(v[i]) {
					sumX -= data[i][0];
					sumY -= data[i][1];
				} else {
					sumX += data[i][0];
					sumY += data[i][1];
				}
			}
			
			result = Math.min(result, Math.sqrt((double)(sumX * sumX + sumY * sumY)));
			return;
		}
		
		if(idx == N) return;
		
		cal(data, idx + 1, k, v);
		v[idx] = true;
		cal(data, idx + 1, k + 1, v);
		v[idx] = false;
	}
	
	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		int T = Integer.parseInt(br.readLine());
		
		for(int tc = 0; tc < T; tc++) {
			N = Integer.parseInt(br.readLine());
			result = Double.MAX_VALUE;
			long[][] data = new long[N][2];
			
			for(int i = 0; i < N; i++) {
				String[] input = br.readLine().split(" ");
				data[i][0] = Long.parseLong(input[0]);
				data[i][1] = Long.parseLong(input[1]);
			}
			
			cal(data, 0, 0, new boolean[N]);
			
			bw.write(result + "\n");
		}
		bw.flush();
	}
}
