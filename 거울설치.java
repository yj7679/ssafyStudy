import java.util.*;
import java.io.*;

public class 거울설치 {
	static int N;
	static int[][] map;
	static int[] start;

	static int[] dr = { -1, 0, 1, 0 };
	static int[] dc = { 0, 1, 0, -1 };

	public static void main(String[] args) throws NumberFormatException, IOException {
		System.setIn(new FileInputStream("input.txt"));
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		N = Integer.parseInt(br.readLine());
		map = new int[N][N];
		start = new int[] { -1, -1 };
		for (int i = 0; i < N; i++) {
			char[] chrs = br.readLine().toCharArray();
			for (int j = 0; j < N; j++) {
				map[i][j] = chrs[j];
				if (map[i][j] == '#') {
					if (start[0] == -1) {
						start = new int[] { i, j };
					}
				}
			}
		}
		System.out.println(bfs(start));
	}

	private static int bfs(int[] start) {
		Queue<int[]> q = new LinkedList<>();
		q.offer(new int[] {start[0], start[1], -1});
		int[][] visited = new int[N][N];
		
		for(int i = 0; i < N; i++)
			Arrays.fill(visited[i], -100);
		
		map[start[0]][start[1]] = '*';
		
		while (!q.isEmpty()) {
			int[] cur = q.poll();
			int nMirror = cur[2] + 1;
			for (int d = 0; d < 4; d++) {
				int nr = cur[0] + dr[d];
				int nc = cur[1] + dc[d];
				while (nr >= 0 && nr < N && nc >= 0 && nc < N) {
					if (map[nr][nc] == '*')
						break;
					else if(map[nr][nc] == '.') {
						int tmp = visited[nr][nc] + d;
						if(tmp >= 0 && tmp %2 == 0)
							break;
					}
					else if (map[nr][nc] == '!') {
						int tmp = visited[nr][nc] + d;
						if(tmp >= 0 && tmp %2 == 0)
							break;
						q.offer(new int[] { nr, nc, nMirror });
					} else if (map[nr][nc] == '#') {
						return nMirror;
					}
					visited[nr][nc] = d;
					nr += dr[d];
					nc += dc[d];
				}
			}
		}
		return -1;
	}
}
