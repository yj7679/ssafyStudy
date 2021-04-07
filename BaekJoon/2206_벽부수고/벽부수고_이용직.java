import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;

//벽부수고 이동하기 -BFS
public class Main {
	static int N,M;
	static int[][] map;
	static int[][][] v;
	static int[] dx= {0,-1,0,1};
	static int[] dy= {1,0,-1,0};
	static class Point{
		int x,y;
		boolean breakwall;
		int cnt;
		public Point(int x, int y, boolean breakwall, int cnt) {
			super();
			this.x = x;
			this.y = y;
			this.breakwall = breakwall;
			this.cnt = cnt;
		}
		
		
	}
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		String[] str = br.readLine().split(" ");
		
		N = Integer.parseInt(str[0]);
		M = Integer.parseInt(str[1]);
		map = new int[N][M];
		v = new int[N][M][2];
		
		for(int i=0;i<N; i++) {
			String st=br.readLine();
			for(int j=0;j<M;j++) {
				map[i][j] = (int)(st.charAt(j)-48);
			}
		}
		//print(map);
		
		bfs(0,0);
		//print(v,0);
		//System.out.println("-----------");
		//print(v,1);

			
				
	}
	private static void print(int[][][] v2, int k) {
		for(int i=0; i<N; i++) {
			for(int j=0; j<M; j++) {
				System.out.print(v2[i][j][k]+" ");
			}
			System.out.println();
		}
		
	}
	private static void bfs(int x, int y) {
		Queue<Point> q = new LinkedList<>();
		q.add(new Point(x,y,false,1));
		v[x][y][0] = 1;
		v[x][y][1] = 1;
		
		while(!q.isEmpty()) {
			Point p = q.poll();
			
			if(p.x==N-1 && p.y==M-1) {
				System.out.println(p.cnt);
				return;
			}
			for(int d=0;d<4;d++) {
				int nx = p.x+dx[d];
				int ny = p.y+dy[d];
				int bw=-1;
				if(p.breakwall==false) {
					bw=0;
				}
				else {
					bw=1;
				}
				//벽을 부신 여부랑 상관없이 벽없는 곳으로 진행하고싶다.
				if(nx>=0 && ny>=0 && nx<N && ny<M && map[nx][ny]==0 &&(v[nx][ny][bw]==0)) {
					
					//벽부쉈던거면 부순거로 표시 아니면 아닌걸로 표시

					q.add(new Point(nx,ny,p.breakwall,p.cnt+1));
					v[nx][ny][bw]=1;

					
				}
				
				//벽을 안부쉈었고 벽 하나 부시고 싶다.
				else if(nx>=0 && ny>=0 && nx<N && ny<M && p.breakwall==false && map[nx][ny]==1 && v[nx][ny][1]==0) {
					q.add(new Point(nx,ny,true,p.cnt+1));
					v[nx][ny][1]=1;
				}
			}
			
			
		}
		System.out.println(-1);
	}
	private static void print(int[][] map2) {
		for (int i = 0; i < N; i++) {
			for (int j = 0; j < M; j++) {
				System.out.print(map2[i][j]+" ");
			}
			System.out.println();
		}
	}

}
