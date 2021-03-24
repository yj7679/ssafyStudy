package D3;

import java.util.Scanner;

public class Othello {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int T = sc.nextInt();
		sc.nextLine();
		for (int i = 0; i < T; i++) {
			int[] dx = { 0, 0, 1, -1, -1, -1, 1, 1 };
			int[] dy = { 1, -1, 0, 0, -1, 1, -1, 1 };
			int test = i + 1;
			int N = sc.nextInt();
			int M = sc.nextInt();
			int[][] arr = new int[N][N];
			if (N == 4) {
				arr[1][1] = 2;
				arr[2][2] = 2;
				arr[1][2] = 1;
				arr[2][1] = 1;
			} else if (N == 6) {
				arr[2][2] = 2;
				arr[3][3] = 2;
				arr[2][3] = 1;
				arr[3][2] = 1;
			} else {
				arr[3][3] = 2;
				arr[4][4] = 2;
				arr[3][4] = 1;
				arr[4][3] = 1;
			}
			for (int j = 0; j < M; j++) {
				int x = sc.nextInt();
				int y = sc.nextInt();
				int c = sc.nextInt(); // 흑 1 , 백 2
				arr[y - 1][x - 1] = c;

				if (c == 1) {
					for (int k = 0; k < 8; k++) {
						int ax = x - 1;
						int ay = y - 1;
						int cx = x - 1;
						int cy = y - 1;
						
						ax = ax + dx[k];
						ay = ay + dy[k];
						cx = cx + dx[k];
						cy = cy + dy[k];
						if (ax >= 0 && ax < N && ay >= 0 && ay < N) {
							if (arr[ay][ax] == 2) {
								int cnt = 0;
								while (true) {
									cx = cx + dx[k];
									cy = cy + dy[k];
									if (cx >= 0 && cx < N && cy >= 0 && cy < N) {
										if (arr[cy][cx] == 0) {
											break;
										} else if (arr[cy][cx] == 1) {
											cnt++;
										}
									} else {
										break;
									}
								}
								if (cnt > 0) {
									while (true) {
										arr[ay][ax] = 1;
										ax = ax + dx[k];
										ay = ay + dy[k];
										if (ax >= 0 && ax < N && ay >= 0 && ay < N) {
											if (arr[ay][ax] == 1) {
												break;
											}
										}
									}
								}
							}
						}
					}
				} else if (c == 2) {
					for (int k = 0; k < 8; k++) {
						int ax = x - 1;
						int ay = y - 1;
						int cx = x - 1;
						int cy = y - 1;
						ax = ax + dx[k];
						ay = ay + dy[k];
						cx = cx + dx[k];
						cy = cy + dy[k];
						if (ax >= 0 && ax < N && ay >= 0 && ay < N) {
							if (arr[ay][ax] == 1) {
								int cnt = 0;
								while (true) {
									cx = cx + dx[k];
									cy = cy + dy[k];
									if (cx >= 0 && cx < N && cy >= 0 && cy < N) {
										if (arr[cy][cx] == 0) {
											break;
										} else if (arr[cy][cx] == 2) {
											cnt++;
										}
									} else {
										break;
									}
								}
								if (cnt > 0) {
									while (true) {
										arr[ay][ax] = 2;
										ax = ax + dx[k];
										ay = ay + dy[k];
										if (ax >= 0 && ax < N && ay >= 0 && ay < N) {
											if (arr[ay][ax] == 2) {
												break;
											}
										}
									}
								}
							}

						}
					}

				}
			}
			int b = 0;
			int w = 0;
			for (int k = 0; k < N; k++) {
				for (int l = 0; l < N; l++) {
					if(arr[k][l] == 1)
					{
						b++;
					}
					else if(arr[k][l] == 2)
					{
						w++;
					}
				}
			}
			System.out.println("#"+test+" "+b+" "+w);
		}

	}

}
