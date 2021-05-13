package BaekJun;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

public class QueenBee {
	static int[] dx = { 0, -1, -1 };
	static int[] dy = { -1, -1, 0 };
	static int N;
	static int[][] map;

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		String[] s = br.readLine().split(" ");
		N = Integer.parseInt(s[0]);
		int M = Integer.parseInt(s[1]);
		map = new int[N][N];
		for (int i = 0; i < N; i++) {
			for (int j = 0; j < N; j++) {
				map[i][j] = 1;
			}
		}

		for (int i = 0; i < M; i++) {
			s = br.readLine().split(" ");
			int zero = Integer.parseInt(s[0]);
			int one = Integer.parseInt(s[1]);
			int two = Integer.parseInt(s[2]);
			int x = N - 1;
			int y = 0;
			
			for(int j=N-1;j>=0;j--)
			{
				if(zero !=0)
				{
					zero--;
				}
				else if(one !=0)
				{
					one--;
					map[j][0]++;
				}
				else if(two !=0)
				{
					two--;
					map[j][0] +=2;
				}
			}
			for(int j=1;j<N;j++)
			{
				if(zero !=0)
				{
					zero--;
				}
				else if(one !=0)
				{
					one--;
					map[0][j]++;
				}
				else if(two !=0)
				{
					two--;
					map[0][j] +=2;
				}
			}
			
		}
			for (int j = 1; j < N; j++) {
				for (int k = 1; k < N; k++) {
					map[k][j] = map[0][j];
				}
			}

		StringBuilder sb = new StringBuilder();
		for (int i = 0; i < N; i++) {
			for (int j = 0; j < N; j++)
				sb.append(map[i][j] + " ");
			sb.append("\n");
		}

		System.out.println(sb.toString());
	}
}
