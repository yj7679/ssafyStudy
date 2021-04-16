import java.util.*;
import java.io.*;

public class 마법사상어와파이어볼 {
	static int N, K, M;
	static Deque<FireBall>[][] map;
	static int[] dr = { -1, -1, 0, 1, 1, 1, 0, -1 };
	static int[] dc = { 0, 1, 1, 1, 0, -1, -1, -1 };

	static class FireBall {
		int r, c, m, d, s;
		boolean moved;

		public FireBall(int r, int c, int m, int s, int d) {
			super();
			this.r = r;
			this.c = c;
			this.m = m;
			this.s = s;
			this.d = d;
			moved = false;
		}

		public int[] move() {
			int nr = r + dr[d] * s;
			int nc = c + dc[d] * s;
			nr = (nr + 2000) % N;
			nc = (nc + 2000) % N;
			if (nr == 0)
				nr = N;
			if (nc == 0)
				nc = N;
			return new int[] { nr, nc };
		}

	}

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());
		K = Integer.parseInt(st.nextToken());
		map = new LinkedList[N + 1][N + 1];
		for (int i = 1; i <= N; i++) {
			for (int j = 1; j <= N; j++)
				map[i][j] = new LinkedList<>();
		}
		for (int i = 0; i < M; i++) {
			st = new StringTokenizer(br.readLine());
			int r = Integer.parseInt(st.nextToken());
			int c = Integer.parseInt(st.nextToken());
			map[r][c].offerLast(new FireBall(r, c, Integer.parseInt(st.nextToken()), Integer.parseInt(st.nextToken()),
					Integer.parseInt(st.nextToken())));
		}
		for (int i = 0; i < K; i++) {
			move();
			divide();
		}
		System.out.println(getResult());
	}

	private static int getResult() {
		int sum = 0;
		for (int i = 1; i <= N; i++) {
			for (int j = 1; j <= N; j++) {
				if(map[i][j].isEmpty())
					continue;
				else {
					while(!map[i][j].isEmpty()) {
						sum += map[i][j].poll().m;
					}
				}
			}
		}
		return sum;
	}

	private static void divide() {
		for (int i = 1; i <= N; i++) {
			for (int j = 1; j <= N; j++) {
				if (map[i][j].isEmpty())
					continue;
				else if (map[i][j].size() == 1) {
					FireBall fb = map[i][j].pollFirst();
					fb.moved = false;
					map[i][j].offerLast(fb);
				} else {
					addNdevide(map[i][j]);
				}
			}
		}
	}

	private static void addNdevide(Deque<FireBall> deq) {
		int totalM = 0;
		int totalS = 0;
		int count = 0;
		int d = 0;
		int r = 0, c = 0;
		boolean sameD = true;
		while (!deq.isEmpty()) {
			FireBall fb = deq.pollFirst();
			count++;
			totalM += fb.m;
			totalS += fb.s;
			if (count == 1) {
				d = fb.d % 2;
				r = fb.r;
				c = fb.c;
			} else {
				if (d != fb.d % 2) {
					sameD = false;
				}
			}
		}
		int m = totalM / 5;
		if (m == 0)
			return;
		int s = totalS / count;
		d = sameD ? 0 : 1;
		for (int i = 0; i < 4; i++) {
			FireBall newFb = new FireBall(r, c, m, s, i * 2 + d);
			deq.offerLast(newFb);
		}
	}

	private static void move() {
		for (int i = 1; i <= N; i++) {
			for (int j = 1; j <= N; j++) {
				if (map[i][j].isEmpty())
					continue;
				else {
					move(map[i][j]);
				}
			}
		}
	}

	private static void move(Deque<FireBall> deq) {
		while (!deq.isEmpty()) {
			FireBall fb = deq.pollFirst();
			if (fb.moved) {
				deq.offerFirst(fb);
				break;
			} else {
				int[] loc = fb.move();
				FireBall newFb = new FireBall(loc[0], loc[1], fb.m, fb.s, fb.d);
				newFb.moved = true;
				map[loc[0]][loc[1]].offerLast(newFb);
			}
		}
	}
}
