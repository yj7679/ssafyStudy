package BaekJun;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

public class RobotCleaner {
	static int N, M, x, y, d, result = 0;
	static int[][] map;
	static int[] dx = { -1, 0, 1, 0 }; // 0북 1동 2남 3서
	static int[] dy = { 0, 1, 0, -1 };

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		String[] s = br.readLine().split(" ");
		N = Integer.parseInt(s[0]);
		M = Integer.parseInt(s[1]);

		s = br.readLine().split(" ");
		x = Integer.parseInt(s[0]);
		y = Integer.parseInt(s[1]);
		d = Integer.parseInt(s[2]);

		map = new int[N][M];
		for (int i = 0; i < N; i++) {
			s = br.readLine().split(" ");
			for (int j = 0; j < M; j++) {
				map[i][j] = Integer.parseInt(s[j]);
				if (i == x && j == y)
					map[i][j] = 2;	//로봇의 처음 위치
			}
		}
		while (true) {
			int ax = x;
			int ay = y;
			int ad = d;
			if (map[ax - 1][ay] != 0 && map[ax + 1][ay] != 0 && map[ax][ay + 1] != 0 && map[ax][ay - 1] != 0) {	// 로봇주변이 청소가 불가능 할 때
				if (d == 0) {	// 방향 기준 한칸 뒤로 이동
					if (map[ax + 1][ay] != 1) {
						x = ax + 1;
						y = ay;
					} else	// 한칸 뒤로 움직일 수 없을 때 종료
						break;
				} else if (d == 1) {
					if (map[ax][ay - 1] != 1) {
						x = ax;
						y = ay - 1;
					} else
						break;
				} else if (d == 2) {
					if (map[ax - 1][ay] != 1) {
						x = ax - 1;
						y = ay;
					} else
						break;
				} else if (d == 3) {
					if (map[ax][ay + 1] != 1) {
						x = ax;
						y = ay + 1;
					} else
						break;
				}
			} else {
				if (d == 0) {	//청소가 가능할 때
					ax = ax + dx[3];
					ay = ay + dy[3];
					if (ax >= 0 && ax < N && ay >= 0 && ay < M) {
						if (map[ax][ay] == 0) {		//현재 방향(북) 기준 왼쪽(서)으로 방향전환, 한칸 정지
							x = ax;
							y = ay;
							d = 3;
							map[ax][ay] = 2;	//청소한 자리 2로 변경
						} else
							d = 3;
					} else
						d = 3;
				} else if (d == 1) {
					ax = ax + dx[0];
					ay = ay + dy[0];
					if (ax >= 0 && ax < N && ay >= 0 && ay < M) {
						if (map[ax][ay] == 0) {
							x = ax;
							y = ay;
							d = 0;
							map[ax][ay] = 2;
						} else
							d = 0;
					} else
						d = 0;
				} else if (d == 2) {
					ax = ax + dx[1];
					ay = ay + dy[1];
					if (ax >= 0 && ax < N && ay >= 0 && ay < M) {
						if (map[ax][ay] == 0) {
							x = ax;
							y = ay;
							d = 1;
							map[ax][ay] = 2;
						} else
							d = 1;
					} else
						d = 1;
				} else if (d == 3) {
					ax = ax + dx[2];
					ay = ay + dy[2];
					if (ax >= 0 && ax < N && ay >= 0 && ay < M) {
						if (map[ax][ay] == 0) {
							x = ax;
							y = ay;
							d = 2;
							map[ax][ay] = 2;
						} else
							d = 2;
					} else
						d = 2;
				}

			}
		}
		for (int i = 0; i < N; i++) {
			for (int j = 0; j < M; j++) {
				if (map[i][j] == 2)
					result++;
			}
		}
		System.out.println(result);

	}

}
