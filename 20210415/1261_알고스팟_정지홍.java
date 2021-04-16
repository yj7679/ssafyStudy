import java.io.*;
import java.util.*;

// 알고스팟

class Main {
	
	static int N, M;
	static int[][] maze;
	static int[][] crush;
	static boolean[][] v;
	static int[] dr = {-1, 0, 1, 0};
	static int[] dc = {0, 1, 0, -1};
	
	public static void main(String[] args) throws Exception {
		//System.setIn(new FileInputStream("input.txt"));
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());
		maze = new int[M][N];
		crush= new int[M][N];
		v = new boolean[M][N];

		for (int i = 0; i < M; i++) {
			String str = br.readLine();
			char[] c = str.toCharArray();
			for (int j = 0; j < N; j++) {
				maze[i][j] = c[j] - '0';
			}
		}
		
		for (int i = 0; i < M; i++) {
			Arrays.fill(crush[i], Integer.MAX_VALUE);
		}
		
		crush[0][0] = 0;
		int r = 0, c = 0, cost = 0;
		
		while(true) {
			cost = Integer.MAX_VALUE;
			
			// 방문하지 않은 정점 중 출발지에서 자신으로 오는 비용이 최소인 정점 선택
			for (int i = 0; i < M; i++) {
				for (int j = 0; j < N; j++) {
					if(!v[i][j] && cost > crush[i][j]) {
						cost = crush[i][j];
						r = i;
						c = j;
					}
				}
			}
			v[r][c] = true;
			if(r == M-1 && c == N-1) {
				System.out.println(crush[r][c]);
				break;
			}
			for (int d = 0; d < 4; d++) {
				int nr = r + dr[d];
				int nc = c + dc[d];
				if(nr >= 0 && nr < M && nc >= 0 && nc < N && !v[nr][nc]
						&& crush[nr][nc] > cost + maze[nr][nc]) {
					crush[nr][nc] = cost + maze[nr][nc];
				}
				
			}
		}
		
	}
}