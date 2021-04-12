package day0413;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

//알고스팟 - 0/1 BFS
public class BJ1261 {
	static int N,M;
	static int[][] map;
	static int[] dx= {-1,1,0,0};
	static int[] dy= {0,0,-1,1};
	static class Point{
		int x,y;

		public Point(int x, int y) {
			super();
			this.x = x;
			this.y = y;
		}
		
		
	}
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine(), " ");
		M = Integer.parseInt(st.nextToken());
		N = Integer.parseInt(st.nextToken());
		map = new int[N][M];
		for(int i=0; i<N;i++) {
			String str = br.readLine();
			for (int j = 0; j < M; j++) {
				map[i][j]= Character.getNumericValue(str.charAt(j));
			}
		}
		//print(map);
		
		
		bfs();
		
		
		
		
		
		
	}
	private static void bfs() {
		Queue<Point> q = new LinkedList<>();
		q.add(new Point(0,0));
		int[][] broken = new int[N][M];
		int[][] v = new int[N][M];
		v[0][0]=1;
		broken[0][0]=1;

		
		while(!q.isEmpty()) {
			int size= q.size();

			for(int s=0; s<size; s++) {
				Point p = q.poll();
				int x = p.x;
				int y = p.y;
				for(int d=0; d<4;d++) {
					int nx = x+dx[d];
					int ny = y+dy[d];
//					System.out.println("-----------");
//					System.out.println("before");
//					print(broken);
//					System.out.println(x+" "+y);
					if(nx>=0 && ny>=0 && nx<N && ny<M && (v[nx][ny]==0||broken[nx][ny]> broken[x][y])) {//안갔던 곳이거나 갔던곳인데 벽 부신 횟수가 더 크면바꿔 넣음
						//빈공간을 만난 경우
						if(map[nx][ny]==0) {

							if(broken[nx][ny]==0 || broken[nx][ny]>broken[x][y]) {
//							System.out.println("빈공간");
							q.add(new Point(nx,ny));
							v[nx][ny]=1;
							broken[nx][ny]= broken[x][y];
							}
						}
						//안부셨던 벽을 만난 경우
						else if(broken[nx][ny]==0){
//							System.out.println("안부셧던벽");
							q.add(new Point(nx,ny));
							v[nx][ny]=1;
							broken[nx][ny]= broken[x][y]+1;
						}
						//부셨던 벽인데 현재까지 부셔온 벽의 수가 더 작은 경우
						else if(broken[nx][ny]> broken[x][y]+1) {
//							System.out.println("부셧던벽인데 부셔온게 더작음");
							q.add(new Point(nx,ny));
							//방문체크는 이미되어있다.
							broken[nx][ny] = broken[x][y]+1;
							
						}
						
			
					}
//					System.out.println("after");
//					print(broken);
//					System.out.println("--------");

				}
				
			}
					
		}
		
		System.out.println(broken[N-1][M-1]-1);
		
	}
	private static void print(int[][] map2) {
		for (int i = 0; i < N; i++) {
			for (int j = 0; j <M; j++) {
				System.out.print(map2[i][j]+" ");

			}
			System.out.println();
		}
	}

}
