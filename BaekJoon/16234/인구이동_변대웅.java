import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class 인구이동_변대웅 {
	static int N, L, R;
	static int[][] map;
	static int count;
	static int[] dr = { -1, 0, 1, 0 };
	static int[] dc = { 0, 1, 0, -1 };
	static boolean[][] v;
	static Queue<Integer> popList = new LinkedList<>();
	static Queue<Queue<int[]>> changeList = new LinkedList<>();
	static int changeCount = 0;

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		N = Integer.parseInt(st.nextToken());
		L = Integer.parseInt(st.nextToken());
		R = Integer.parseInt(st.nextToken());
		count = 0;

		map = new int[N][N];
		v = new boolean[N][N];
		for (int i = 0; i < N; i++) {
			st = new StringTokenizer(br.readLine());
			for (int j = 0; j < N; j++)
				map[i][j] = Integer.parseInt(st.nextToken());
		}
		do {
			changeCount = 0;
			for (int r = 0; r < N; r++) {
				for (int c = 0; c < N; c++) {
					if(!v[r][c])
						bfs(r, c);
				}
			}
			if(changeCount > 0) 
				change();
		} while (changeCount > 0);
		
		System.out.println(count);
	}

	// 인구수 설정
	private static void change() {
		for(int i = 0; i < changeCount; i++) {
			int pop = popList.poll();
			Queue<int[]> changes = changeList.poll();
			while(!changes.isEmpty()) {
				int[] current = changes.poll();
				map[current[0]][current[1]] = pop;
				v[current[0]][current[1]] = false;
			}
		}
		count++;
	}
	
	//국경 열기
	private static void bfs(int r, int c) {
		Queue<int[]> q = new LinkedList<>();
		Queue<int[]> changes = new LinkedList<>();
		q.offer(new int[] { r, c });
		changes.offer(new int[] { r, c });
		v[r][c] = true;
		int countContry = 1;
		int sumPopul = map[r][c];
		while (!q.isEmpty()) {
			int[] current = q.poll();
			int currentPopul = map[current[0]][current[1]];
			for (int d = 0; d < 4; d++) {
				int nr = current[0] + dr[d];
				int nc = current[1] + dc[d];
				if (nr < 0 || nr >= N || nc < 0 || nc >= N || v[nr][nc])
					continue;
				int gap = Math.abs(currentPopul - map[nr][nc]);
				if (gap >= L && gap <= R) {
					countContry++;
					sumPopul += map[nr][nc];
					changes.offer(new int[] { nr, nc });
					q.offer(new int[] { nr, nc });
					v[nr][nc] = true;
				}
			}
		}
		if (countContry > 1) {
			int popul = sumPopul / countContry;
			popList.offer(popul);
			changeList.offer(changes);
			changeCount++;
		} else
			v[r][c] = false;
	}

}
