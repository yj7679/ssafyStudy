import java.util.*;
import java.io.*;

public class 가장큰정사각형 {
	static int N, M;
	static char[][] map;
	static int[][] maxLength;

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());
		map = new char[N][M];
		maxLength = new int[N][M];
		for (int i = 0; i < N; i++)
			map[i] = br.readLine().toCharArray();
		System.out.println(getMax());
	}

	private static int getMax() {
		int max = 0;
		for (int i = N - 1; i >= 0; i--) {
			for (int j = M - 1; j >= 0; j--) {
				if (j == M - 1 || i == N - 1) {
					maxLength[i][j] = map[i][j] == '1' ? 1 : 0;
				} else {
					if (map[i][j] == '1') {
						int right = maxLength[i][j + 1];
						int bottom = maxLength[i + 1][j];
						if (right != bottom) {
							maxLength[i][j] = Math.min(right, bottom) + 1;
						} else {
							if (map[i + right][j + right] == '1') {
								maxLength[i][j] = right + 1;
							} else {
								maxLength[i][j] = right;
							}
						}

					}
				}
				max = Math.max(max, maxLength[i][j] * maxLength[i][j]);
			}
		}
		return max;
	}
}