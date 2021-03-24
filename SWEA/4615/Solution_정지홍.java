package com.ssafy;

import java.util.Scanner;
// 오셀로
public class Main2 {

	public static void main(String[] args) {

		Scanner sc = new Scanner(System.in);
		int[] dr = {-1, -1, 0, 1, 1, 1, 0, -1};
		int[] dc = {0, 1, 1, 1, 0, -1, -1, -1};
		int T = sc.nextInt();
		int N = 0, M = 0;
		int[][] board;
		int[] r, c;
		int[] stoneColor;
		int b = 0, w = 0;
		
		for (int tc = 1; tc <= T; tc++) {
			// input
			N = sc.nextInt();
			M = sc.nextInt();
			board = new int[N][N];
			r = new int[M];
			c = new int[M];
			stoneColor = new int[M];
			b = 0;
			w = 0;
			for (int i = 0; i < M; i++) {
				r[i] = sc.nextInt() - 1;
				c[i] = sc.nextInt() - 1;
				stoneColor[i] = sc.nextInt();
			}
			board[N/2-1][N/2-1] = 2;
			board[N/2-1][N/2] = 1;
			board[N/2][N/2-1] = 1;
			board[N/2][N/2] = 2;
			
			for (int i = 0; i < M; i++) {
				// 돌을 놓는다
				board[r[i]][c[i]] = stoneColor[i];
				
				// 같은색깔 돌 찾기
				for (int j = 0; j < 8; j++) {	// 8방 탐색
					int go = 1;
					while(r[i]+dr[j]*go >= 0 && r[i]+dr[j]*go < N && c[i]+dc[j]*go >= 0 && c[i]+dc[j]*go < N 	// 범위를 벗어나지 않고
							&& board[ r[i]+dr[j]*go ][ c[i]+dc[j]*go ] != 0 && stoneColor[i] != board[ r[i]+dr[j]*go ][ c[i]+dc[j]*go ]) {	// 내가 놓은 돌 색깔과 다른 돌 색깔일 경우
						++go;
					}
					if(!(r[i]+dr[j]*go >= 0 && r[i]+dr[j]*go < N && c[i]+dc[j]*go >= 0 && c[i]+dc[j]*go < N) || board[ r[i]+dr[j]*go ][ c[i]+dc[j]*go ] == 0) {	// 범위를 벗어나서 while문을 빠져나왔다면
						continue;
					}
					// 같은색 돌을 찾아서 while문을 빠져나왔다면
					--go;
					while(stoneColor[i] != board[ r[i]+dr[j]*go ][ c[i]+dc[j]*go ]) {
						board[ r[i]+dr[j]*go ][ c[i]+dc[j]*go ] = stoneColor[i];
						--go;
					}
				}
			}
			// 돌 개수 세기
			for (int i = 0; i < N; i++) {
				for (int j = 0; j < N; j++) {
					if(board[i][j] == 1) 		b++;
					else if(board[i][j] == 2)	w++;
				}
			}
			// output
			System.out.println("#" + tc + " " + b + " " + w);
		}
	}
}