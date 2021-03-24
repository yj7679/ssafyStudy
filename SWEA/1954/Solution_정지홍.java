package com.ssafy;

import java.util.Scanner;

public class D2_1954_달팽이숫자 {
	static int[][] s;
	static int N;
	static int num = 1;
	static int r = 0, c = -1;

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int T = sc.nextInt();
		int d = 1;
		for (int tc = 1; tc <= T; tc++) {
			N = sc.nextInt();
			s = new int[N][N];
			num = 1;
			d = 1;
			r = 0;
			c = -1;
			System.out.println("#" + tc);
			snail(N, d);
			for (int i = 0; i < N; i++) {
				for (int j = 0; j < N; j++) {
					System.out.print(s[i][j] + " ");
				}
				System.out.println();
			}
		}
	}

	public static void snail(int n, int d) {
		if (n <= 0)
			return;
		
		for (int i = 0; i < n; i++) {
			c += d;
			s[r][c] = num++;
		}
		--n;
		for (int i = 0; i < n; i++) {
			r += d;
			s[r][c] = num++;
		}
		d = d == 1 ? -1 : 1;
		snail(n, d);
	}
}