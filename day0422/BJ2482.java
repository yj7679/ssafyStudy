package day0421;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
//색상환 - DP
public class BJ2482 {
	static int N,K;
	static long[][] d;
	static long MOD = 1000000003L;
	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		N = Integer.parseInt(br.readLine());
		K = Integer.parseInt(br.readLine());
		d = new long[N+1][K+1];
		
		//초기 세팅

		for(int i=0;i<N+1;i++) {
			d[i][1]=i;
			d[i][0]=1;
		}
		for(int i=2;i<N+1;i++) {
			for(int j=2;j<K+1;j++) {
				d[i][j] = (d[i-1][j]+d[i-2][j-1])%MOD ;
			
			}
		
		}
		
		print(d);
		System.out.println((d[N-3][K-1]+d[N-1][K])%MOD);
	}
	private static void print(long[][] d2) {
		for (int i = 0; i <= N; i++) {
			for (int j = 0; j <=K; j++) {
				System.out.print(d2[i][j]+" ");
			}
			System.out.println();
		}
	}

}
