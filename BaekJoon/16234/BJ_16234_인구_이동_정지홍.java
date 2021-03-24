import java.io.*;
import java.util.*;

// 인구 이동

class Point {
	int r, c;

	public Point(int r, int c) {
		super();
		this.r = r;
		this.c = c;
	}
}
public class BJ_16234_인구_이동_정지홍 {
	
	static int N, L, R, res = 0, valSum = 0;
	static int[] dr = {-1, 0, 1, 0};
	static int[] dc = {0, 1, 0, -1};
	static int[][] A;
	static int[][] v;
	static Queue<Point> list = new LinkedList<>();
	
	public static void main(String args[]) throws IOException {
		System.setIn(new FileInputStream("input.txt"));
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		
		N = Integer.parseInt(st.nextToken());
		L = Integer.parseInt(st.nextToken());
		R = Integer.parseInt(st.nextToken());
		A = new int[N][N];
		v = new int[N][N];
		
		for (int r = 0; r < N; r++) {
			st = new StringTokenizer(br.readLine());
			for (int c = 0; c < N; c++) {
				A[r][c] = Integer.parseInt(st.nextToken());
			}
		}
		
		bfs();
		System.out.println(res);
	}

	private static void bfs() {
		Queue<Point> q = new LinkedList<>();
		int cnt = -1;
		while(cnt != 0) {
			cnt = 0;
			// 나라를 전부 돌아봄
			for (int r = 0; r < N; r++) {
				for (int c = 0; c < N; c++) {
					if(v[r][c] == 0) {
						q.offer(new Point(r, c));
						list.offer(new Point(r, c));
						valSum += A[r][c];
						
						while(!q.isEmpty()) {
							Point p = q.poll();
							v[p.r][p.c]++;
							for (int d = 0; d < 4; d++) {
								int nr = p.r + dr[d];
								int nc = p.c+ dc[d];
								if(nr >= 0 && nr < N && nc >= 0 && nc < N && v[nr][nc] == 0 && 
										Math.abs(A[p.r][p.c] - A[nr][nc]) >= L && Math.abs(A[p.r][p.c] - A[nr][nc]) <= R) {
									q.offer(new Point(nr, nc));
									list.offer(new Point(nr, nc));
									valSum += A[nr][nc];
									v[nr][nc]++;
									cnt++;
								}
							}
						}
						
						int val = valSum / list.size();
						for (int i = 0, sz = list.size(); i < sz; i++) {
							Point p = list.poll();
							A[p.r][p.c] = val;
						}
						valSum = 0;
					}
				}
			}
			if(cnt > 0)	res++;
			for (int i = 0; i < N; i++) {
				for (int j = 0; j < N; j++) {
					v[i][j] = 0;
				}
			}
		}
	}
}