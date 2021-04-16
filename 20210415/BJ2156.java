package day0415;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

//포도주시식- DP
public class BJ2156 {
	static int N;
	static long[][] d;
	static long[] a;
	public static void main(String[] args) throws NumberFormatException, IOException {
		
		BufferedReader br =new BufferedReader(new InputStreamReader(System.in));
		N = Integer.parseInt(br.readLine());
		d = new long[N+1][3];
		a = new long[N];
		for (int i = 0; i < N; i++) {
			a[i] = Long.parseLong(br.readLine());
		}
		if(N==1) {
			System.out.println(a[0]);
			System.exit(0);
		}
		d[1][0] = 0;
		d[1][1] = a[0];

		d[2][0] = a[0];
		d[2][1] = a[1];
		d[2][2] = a[0] + a[1];

		for (int i = 3; i <= N; i++) {
			d[i][0] = Math.max(d[i-1][2],Math.max(d[i - 1][0], d[i - 1][1]));
			d[i][1] = d[i - 1][0] + a[i-1];
			d[i][2] = d[i - 1][1] + a[i-1];
		}
		System.out.println(Math.max(d[N][0], Math.max(d[N][1],d[N][2])));
	}

}
