import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class 토마토_변대웅 {
	static int N, M, H, count0, qSize;
	static int[][][] map;
	static int[] dh = { 1, -1, 0, 0, 0, 0 };
	static int[] dr = { 0, 0, -1, 0, 1, 0 };
	static int[] dc = { 0, 0, 0, 1, 0, -1 };

	public static void main(String[] args) throws IOException {
		System.setIn(new FileInputStream("input.txt"));
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		M = Integer.parseInt(st.nextToken());
		N = Integer.parseInt(st.nextToken());
		H = Integer.parseInt(st.nextToken());
		map = new int[H][N][M];
		count0 = 0;
		qSize = 0;
		Queue<int[]> q = new LinkedList<>();
		for (int h = 0; h < H; h++) {
			for (int n = 0; n < N; n++) {
				st = new StringTokenizer(br.readLine());
				for (int m = 0; m < M; m++) {
					map[h][n][m] = Integer.parseInt(st.nextToken());
					if (map[h][n][m] == 0)
						count0++;
					else if (map[h][n][m] == 1) {
						qSize++;
						q.offer(new int[] { h, n, m });
					}
				}
			}
		}
		for (int t = 0; t < Integer.MAX_VALUE; t++) {
			int temp = qSize;
			qSize = 0;
			for (int i = 0; i < temp; i++) {
				int[] current = q.poll();
				for (int d = 0; d < 6; d++) {
					int nh = current[0] + dh[d];
					int nr = current[1] + dr[d];
					int nc = current[2] + dc[d];
					if (nh >= 0 && nh < H && nr >= 0 && nr < N && nc >= 0 && nc < M && map[nh][nr][nc] == 0) {
						map[nh][nr][nc] = 1;
						q.offer(new int[] { nh, nr, nc });
						qSize++;
						count0--;
					}
				}
			}
			if(qSize == 0) {
				if(count0 > 0) {
					System.out.println(-1);
				} else {
					System.out.println(t);
				}
				break;
			}
		}

	}

}
