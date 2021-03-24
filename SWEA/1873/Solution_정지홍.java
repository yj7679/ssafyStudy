package com.ssafy;

import java.util.Scanner;

class Solution {
	static char[][] map;
	static int[][] d = {{-1,0},{1,0},{0,1},{0,-1}};	// UP, DOWN, RIGHT, LEFT
	static int x, y, H, W;
	
	public static void main(String args[]) throws Exception {
		Scanner sc = new Scanner(System.in);
		int T = sc.nextInt();
		int mIdx, prevIdx = -1;
		
		for (int tc = 1; tc <= T; tc++) {
			// input 받기
			String str;
			H = sc.nextInt();
			W = sc.nextInt();
			map= new char[H][W];

			for (int i = 0; i < H; i++) {
				str = sc.next();
				for (int j = 0; j < W; j++) {
					map[i][j] = str.charAt(j);
					if(map[i][j] == '<' || map[i][j] == '>' || map[i][j] == 'v' || map[i][j] == '^') {
						if(map[i][j] == '^')	prevIdx = 0;
						if(map[i][j] == 'v')	prevIdx = 1;
						if(map[i][j] == '>')	prevIdx = 2;
						if(map[i][j] == '<')	prevIdx = 3;
						x = i;	y = j;
					}
				}
			}
			
			int N = sc.nextInt();
			char[] move = new char[N];
			str = sc.next();
			for (int i = 0; i < move.length; i++) {
				move[i] = str.charAt(i);
			}
			
			// move
			int nx, ny;
			for (int i = 0; i < move.length; i++) {
				if(move[i] == 'U')			mIdx = 0;
				else if(move[i] == 'D')		mIdx = 1;
				else if(move[i] == 'R')		mIdx = 2;
				else if(move[i] == 'L')		mIdx = 3;
				else						mIdx = 4;
				// 이동하는 동작이라면
				if(mIdx != 4) {
					nx = x + d[mIdx][0];
					ny = y + d[mIdx][1];
					if(nx >= 0 && nx < H && ny >= 0 && ny <W && map[nx][ny] == '.') {
						map[x][y] = '.';
						x = nx;		y = ny;		
					}
					// 방향 바꿔주기
					if(mIdx == 0)			map[x][y] = '^';
					else if(mIdx == 1)		map[x][y] = 'v';
					else if(mIdx == 2)		map[x][y] = '>';
					else if(mIdx == 3) 		map[x][y] = '<';
					prevIdx = mIdx;
				}
				// 포탄발사 동작이라면
				else {
					nx = x + d[prevIdx][0];
					ny = y + d[prevIdx][1];
					while (nx >= 0 && nx < H && ny >= 0 && ny < W && (map[nx][ny] == '.' || map[nx][ny] == '-')) {
						nx += d[prevIdx][0];
						ny += d[prevIdx][1];
					}
					if(nx >= 0 && nx < H && ny >= 0 && ny < W && map[nx][ny] == '*')	map[nx][ny] ='.';
				}
			}
			
			// print
			System.out.print("#" + tc + " ");
			for (int i = 0; i < H; i++) {
				for (int j = 0; j < W; j++) {
					System.out.print(map[i][j]);
				}
				System.out.println();
			}
		}
		sc.close();
	}
}