package com.gold;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;

public class P18119 {
	// 단어 암기
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		String[] input = br.readLine().split(" ");
		int N = Integer.parseInt(input[0]);
		int M = Integer.parseInt(input[1]);
		int[] text = new int[N];
		
		for(int i = 0; i < N; i++) {
			char[] tmp = br.readLine().toCharArray();
			int v = 0;
			
			for(int j = 0; j < tmp.length; j++) {
				v = v | (1 << (tmp[j] - 'a'));
			}
			text[i] = v;
		}
		
		int v = 0;
		for(int tc = 0; tc < M; tc++) {
			input = br.readLine().split(" ");
			int o = Integer.parseInt(input[0]);
			int x = input[1].charAt(0) - 'a';
			
			if(o == 1) {
				v = v | (1 << x);
			} else {
				v = v & ~(1 << x);
			}
			
			int cnt = 0;
			for(int i = 0; i < N; i++) {
				if((v & text[i]) == 0) cnt++;
			}
			bw.write(Integer.toString(cnt) + "\n");
		}
		bw.flush();
	}
}
