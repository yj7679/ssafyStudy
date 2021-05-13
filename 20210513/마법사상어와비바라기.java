import java.util.*;
import java.io.*;

public class 마법사상어와비바라기 {
	static int N, M;
	static int[][] A;
	static int[] dr = { 0, 0, -1, -1, -1, 0, 1, 1, 1 };
	static int[] dc = { 0, -1, -1, 0, 1, 1, 1, 0, -1 };
	static Queue<int[]> clouds;

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());
		A = new int[N][N];
		clouds = new LinkedList<>();
		for (int i = 0; i < N; i++) {
			st = new StringTokenizer(br.readLine());
			for (int j = 0; j < N; j++) {
				A[i][j] = Integer.parseInt(st.nextToken());
			}
		}
		clouds.offer(new int[] { N - 1, 0 });
		clouds.offer(new int[] { N - 1, 1 });
		clouds.offer(new int[] { N - 2, 0 });
		clouds.offer(new int[] { N - 2, 1 });
		for (int i = 0; i < M; i++) {
			st = new StringTokenizer(br.readLine());
			int d = Integer.parseInt(st.nextToken());
			int s = Integer.parseInt(st.nextToken());
			moveClouds(d, s);
			rain();
			waterCopy();
			makeClouds();
		}
		System.out.println(getResult());
	}

	private static int getResult() {
		int result = 0;
		for(int i = 0; i < N; i++) {
			for(int j = 0; j < N; j++) {
				result += A[i][j];
			}
		}
		return result;
	}

	private static void makeClouds() {
		boolean[][] check = new boolean[N][N];
		while(!clouds.isEmpty()) {
			int[] loc = clouds.poll();
			check[loc[0]][loc[1]] = true;
		}
		for(int i = 0; i < N; i++) {
			for(int j = 0; j < N; j++) {
				if(A[i][j] >= 2 && !check[i][j]) {
					A[i][j] -= 2;
					clouds.offer(new int[] {i, j});
				}
			}
		}
	}

	private static void waterCopy() {
		int size = clouds.size();
		for (int i = 0; i < size; i++) {
			int[] loc = clouds.poll();
			int count = 0;
			for (int d = 2; d <= 8; d += 2) {
				int nr = loc[0] + dr[d];
				int nc = loc[1] + dc[d];
				if(nr >= 0 && nr < N && nc >= 0 && nc < N && A[nr][nc] > 0)
					count++;
			}
			A[loc[0]][loc[1]] += count;
			clouds.offer(loc);
		}

	}

	private static void rain() {
		int size = clouds.size();
		for (int i = 0; i < size; i++) {
			int[] loc = clouds.poll();
			A[loc[0]][loc[1]]++;
			clouds.offer(loc);
		}

	}

	private static void moveClouds(int d, int s) {
		int size = clouds.size();
		for (int i = 0; i < size; i++) {
			int[] loc = clouds.poll();
			int nr = loc[0] + dr[d] * s;
			int nc = loc[1] + dc[d] * s;
			nr = (nr + (N * 100)) % N;
			nc = (nc + (N * 100)) % N;
			clouds.offer(new int[] { nr, nc });
		}
	}

}
