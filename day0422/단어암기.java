package Baekjoon;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.Arrays;
import java.util.StringTokenizer;

public class 단어암기 {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		StringTokenizer st = null;

		st = new StringTokenizer(br.readLine());

		int N = Integer.parseInt(st.nextToken());
		int M = Integer.parseInt(st.nextToken());

		boolean[][] temp = new boolean[N][26];
		for (int i = 0; i < N; i++) {
			String input = br.readLine();

			for (int j = 0; j < input.length(); j++) {
				char c = input.charAt(j);

				temp[i][c - 'a'] = true;
			}
		}

		boolean[] alpha = new boolean[N];
		Arrays.fill(alpha, true);

		//알파벳을 넣고 뺄때 숫자가 일치하지 않으면 카운팅 불가 
		int[] result = new int[N];
		
		StringBuilder sb = new StringBuilder();
		int ans = N;
		
		for (int i = 0; i < M; i++) {
			st = new StringTokenizer(br.readLine());
			int o = Integer.parseInt(st.nextToken());
			char x = st.nextToken().charAt(0);

			if (o == 1) {
				for (int j = 0; j < N; j++) {
					//하나라도 단어에서 걸리면
					if (temp[j][x - 'a']) {
						result[j]++;
						//alpha 배열을 false로 
						if (alpha[j]) {
							ans--;
							alpha[j] = false;
						}
					}
				}
				
			} else if (o == 2) {
				for (int j = 0; j < N; j++) {
					//단어가 비어있고 하나라도 단어에서 걸리면
					if (!alpha[j] && temp[j][x - 'a']) {
						result[j]--;

						if (result[j] == 0) {
							alpha[j] = true;
							ans++;
						}
					}
				}
			}

			sb.append(ans + "\n");
		}

		bw.write(sb.toString() + "\n");
		bw.flush();
		bw.close();
		br.close();
	}
}
