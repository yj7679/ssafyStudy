package BaekJun;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;

public class Baseball {
	static int N;
	static int result = 0;

	static int[][] play;
	static int[] per;
	static boolean[] visit;

	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		N = Integer.parseInt(br.readLine()); // 이닝 수
		play = new int[N][9]; // 선수의 이닝별 결과
		per = new int[9]; // 선수배치 순열
		visit = new boolean[9]; // 중복제거 순열 방문배열

		for (int i = 0; i < N; i++) // 입력받기
		{
			String[] s = br.readLine().split(" ");
			for (int j = 0; j < 9; j++) {
				play[i][j] = Integer.parseInt(s[j]);
			}
		}
//		for(int i = 0;i<N;i++) {
//			System.out.println(Arrays.toString(play[i]));
//		}
		visit[3] = true; // 1번선수는 4번타자 고정
		per[3] = 1; //0>
		permutation(2); // 2번~9번선수 순열 구하기

		System.out.println(result);
	}

	private static void permutation(int k) {

		if (k == 10) {
//			System.out.println(Arrays.toString(per));
			int game = move(); // 게임시작

			result = Math.max(result, game); // 점수 최대값
			return;
		}

		for (int i = 0; i < per.length; i++) {
			if (!visit[i]) {
				visit[i] = true;
				per[i] = k;
				permutation(k + 1);
				visit[i] = false;
			}
		}
	}

	private static int move() {
		int start = 1; // 1번 타자 시작
		int point = 0; // 게임 점수
		for (int i = 0; i < N; i++) // 이닝번 반복
		{
			int[] ru = new int[3]; // 각 루별 주자유무
			int out = 0; // 아웃 카운트

			while (out < 3) // 아웃 3번이면 1이닝 끝 ,
			{

				if (start == 10) {	// 9번타자까지 끝나면 1번타자부터 다시 시작
					start = 1;
				}
				int ta = play[i][per[start - 1] - 1];	//지금 치는 선수의 결과

				if (ta == 0) {	// 아웃일때
					out++;
					start++;
				} else if (ta == 1) {	//1루타
					if (ru[2] != 0) {	//3루에 주자가 있으면 점수1점
						point++;
					}
					for (int j = 2; j >= 1; j--) {	//1루,2루 선수를 2,3루로 이동
						ru[j] = ru[j - 1];
					}
					ru[0] = 1;	//친사람은 1루로
					start++;
				} else if (ta == 2) {	//2루타
					if (ru[2] != 0) {	//2,3루에 주자가 있으면 1점
						point++;
					}
					if (ru[1] != 0) {
						point++;
					}
					ru[2] = ru[0];	//1루 > 3루 이동
					ru[1] = 1;	//친사람은 2루로
					ru[0] = 0;	//1루는 비어있음
					start++;
				} else if (ta == 3) {	//3루타
					for (int j = 0; j < 3; j++) {	//1,2,3루에 주자가 있으면 +1점씩
						if (ru[j] != 0) {
							point++;
							ru[j] = 0;
						}
					}
					ru[2] = 1;	//친사람은 3루로
					start++;
				} else if (ta == 4) {//홈런
					for (int j = 0; j < 3; j++) {	//1,2,3루에 주자가 있으면 +1점씩
						if (ru[j] != 0) {
							point++;
							ru[j] = 0;
						}
					}
					point++;	//친사람도 +1점
					start++;
				}
			}
		}

		return point;
	}

}
