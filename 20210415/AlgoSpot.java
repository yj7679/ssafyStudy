package BaekJun;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.PriorityQueue;

class xyv implements Comparable<xyv> {
	int x;
	int y;
	int v;
	@Override
	public String toString() {
		return "xyv [x=" + x + ", y=" + y + ", v=" + v + "]";
	}
	public xyv(int x, int y, int v) {
		this.x = x;
		this.y = y;
		this.v = v;
	}
	@Override
	public int compareTo(xyv o) {
		return this.v - o.v;
	}
}
public class AlgoSpot {
	static int N;
	static int M;
	static int[][] map;
	static boolean[][] visit;
	static int[] dx = { 0, 0, 1, -1};
	static int[] dy = { 1, -1, 0, 0};
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		String[] s = br.readLine().split(" ");
		N = Integer.parseInt(s[0]);
		M = Integer.parseInt(s[1]);
		map = new int[M][N];
		visit = new boolean[M][N];
		visit[0][0]=true;
		
		for (int i = 0; i < M; i++) {
			s = br.readLine().split("");
			for (int j = 0; j < N; j++) {
				map[i][j] = Integer.parseInt(s[j]);
			}
		}
		
//		for (int i = 0; i < N; i++) {
//			System.out.println(Arrays.toString(map[i]));
//		}
		
		bfs(0,0);
	}
	private static void bfs(int a,int b) {
		PriorityQueue<xyv> q = new PriorityQueue<>();
		q.offer(new xyv(a,b,0));
		
		while (true) {
//			System.out.println(q.peek().toString());
			xyv p = q.poll();
			int x = p.x;
			int y = p.y;
			int v = p.v;
			
			if (y == N - 1 && x == M - 1) {
				System.out.println(v);
				q.clear();
				break;
			}
			for (int i = 0; i < 4; i++) {
				int ax = x + dx[i];
				int ay = y + dy[i];
				if (ax >= 0 && ax < M && ay >= 0 && ay < N) {
					if (!visit[ax][ay]) {
						visit[ax][ay] = true;
						q.add(new xyv(ax, ay, v + map[ax][ay]));
					}
				}
			}
		}
	}
}
