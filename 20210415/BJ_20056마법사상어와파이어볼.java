package 스터디문제;

import java.util.*;
import java.io.*;

/*4 ≤ N ≤ 50
0 ≤ M ≤ N2
1 ≤ K ≤ 1,000
1 ≤ ri, ci ≤ N
1 ≤ mi ≤ 1,000
1 ≤ si ≤ 1,000
0 ≤ di ≤ 7*/
public class BJ_20056마법사상어와파이어볼 {

	/**
	 * 파이어볼 정보 담는 클래스
	 */
	static class Fireball {
		int r, c, m, s, d;

		public Fireball(int r, int c, int m, int s, int d) {
			super();
			this.r = r;
			this.c = c;
			this.m = m;
			this.s = s;
			this.d = d;
		}
		
	}
	
	/**
	 * 맵에 담을 정보를 가진 클래스
	 */
	static class Info {
		int m, s, d;
		
		public Info(int m, int s, int d) {
			super();
			this.m = m;
			this.s = s;
			this.d = d;
		}		
	}
	
	
	static int N, M, K, ans;
	static List<Fireball> fireballs;
	static List<Info>[][] map;
	
	static int[] dr = { -1, -1, 0, 1, 1, 1, 0, -1 };
	static int[] dc = { 0, 1, 1, 1, 0, -1, -1, -1 };
	
	public static void main(String[] args) throws Exception {
		System.setIn(new FileInputStream("마법사상어와파이어볼.txt"));
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());

		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());
		K = Integer.parseInt(st.nextToken());
		fireballs = new ArrayList<>();
		map = new ArrayList[N + 1][N + 1];
		
		for (int r = 0; r <= N; r++) {
			for (int c = 0; c <= N; c++) {
				map[r][c] = new ArrayList<>();
			}
		}
		
		for (int i = 0; i < M; i++) {
			st = new StringTokenizer(br.readLine());
			int r = Integer.parseInt(st.nextToken());
			int c = Integer.parseInt(st.nextToken());
			int m = Integer.parseInt(st.nextToken());
			int s = Integer.parseInt(st.nextToken());
			int d = Integer.parseInt(st.nextToken());
			fireballs.add(new Fireball(r, c, m, s, d));
			map[r][c].add(new Info(m, s, d));
		}
		print(map);
		for (int i = 0; i < K; i++) {
			// 파이어볼 이동
			move();
			System.out.println("=============");
			print(map);
			// 이동 후 정보는 맵에 저장하고 파이어볼 모두 제거
			fireballs.clear();
			// 맵의 정보에 따라 파이어볼을 다시 생성하고 맵의 정보는 모두 제거
			separate();
		}
		
		for (int i = 0; i < fireballs.size(); i++) {
			ans += fireballs.get(i).m;
		}
		
		System.out.println(ans);
	}

	private static void print(List<Info>[][] map) {
		for (int r = 1; r <= N; r++) {
			for (int c = 1; c <= N; c++) {
				if (map[r][c].size()>0) {
					int m = 0;
					for (int i = 0; i < map[r][c].size(); i++) {
						m += map[r][c].get(i).m;
						
					}
					System.out.print(m + " ");
				}
				else
					System.out.print(0 + " ");
			}
			System.out.println();
		}
		
	}

	/**
	 * 한 지점에 파이어볼이 2개 이상일때와 아닐때의 처리를 하는 함수
	 */
	private static void separate() {
		for (int r = 1; r <= N; r++) {
			for (int c = 1; c <= N; c++) {
				// 파이어볼이 2개 이상일 경우
				if (map[r][c].size() >= 2) {
					int m = 0;
					int s = 0;
					int size = map[r][c].size();
					int[] dir = new int[4];
					
					/**
					 * 모두 홀수, 짝수, 그렇지 않은 경우
					 */
					boolean odd = false;
					boolean even = false;
					boolean flag = true;
					
					// 첫번째 파이어볼이 홀수, 짝수인지에 따라 true값 넣어주기
					if (map[r][c].get(0).d % 2 == 0) {
						even = true;
					} else odd = true;

					// 그 이후 파이어볼부터 홀수인지 짝수인지 판별 후 even과 odd 의 값이 true인지 체크해줘서 아니라면 flag를 false로
					// i = 0부터 시작한건 m과 s에 값을 처음부터 넣어주기 위함 ( 홀, 짝 체크는 중복이긴 함 )
					for (int i = 0; i < size; i++) {
						m += map[r][c].get(i).m;
						s += map[r][c].get(i).s;
						if (map[r][c].get(i).d % 2 == 0) {
							if (!even) flag = false;
						} else {
							if (!odd) flag = false;
						}
					}
					m /= 5;
					// 질량이 0이 되면 파이어볼 사라짐
					if (m == 0) continue;
					
					s /= size;
					// flag에 따라 방향을 정해주고 파이어볼 생성
					for (int d = 0; d < 4; d++) {
						if (flag) {
							dir[d] = d * 2;
							fireballs.add(new Fireball(r, c, m, s, dir[d]));
						} else {
							dir[d] = d * 2 + 1;
							fireballs.add(new Fireball(r, c, m, s, dir[d]));
						}
					}
					
					// 파이어볼 생성 후에 맵은 다시 지워준다
					for (int i = 0; i < size; i++) {
						map[r][c].remove(0);
					}
				} else if (map[r][c].size() == 1) {	// 파이어볼이 한개인 경우엔 분리하지 않고 그대로 파이어볼을 생성한다
					int m = map[r][c].get(0).m;
					int s = map[r][c].get(0).s;
					int d = map[r][c].get(0).d;
					fireballs.add(new Fireball(r, c, m, s, d));
					map[r][c].remove(0);
				}
			}
		}
		
	}

	/**
	 * 파이어볼의 정보에 따라 이동하는 함수
	 */
	private static void move() {
		for (int i = 0; i < fireballs.size(); i++) {
			int r = fireballs.get(i).r;
			int c = fireballs.get(i).c;
			int m = fireballs.get(i).m;
			int s = fireballs.get(i).s;
			int d = fireballs.get(i).d;
			
			// 새로운 좌표로 이동하는걸 나머지 연산을 이용하여 범위 밖으로 나가는걸 처리해준다.
			int nr = fireballs.get(i).r + (dr[fireballs.get(i).d] * s % N);
			int nc = fireballs.get(i).c + (dc[fireballs.get(i).d] * s % N);
			
			if (nr < 1) nr += N;
			if (nc < 1) nc += N;
			if (nr > N) nr -= N;
			if (nc > N) nc -= N;
			// 기존좌표의 맵에 정보가 있다면 지워준다.
			if (map[r][c].size() > 0) {
				for (int j = 0; j < map[r][c].size(); j++) {
					map[r][c].remove(0);
				}
			}
			map[nr][nc].add(new Info(m, s, d));
			
		}
		
		
	}

	
	
	
}
