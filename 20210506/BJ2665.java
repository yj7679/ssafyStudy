package day0506;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;

//미로만들기- BFS, 여러개의 방문배열
public class BJ2665 {
	static int N;
	static int[][] map;
	static int[][] v,brk;
	static int f,min = Integer.MAX_VALUE/2;
	
	static int[] dx= {1,0,-1,0};
	static int[] dy= {0,1,0,-1};
	static private class Point{
		int x,y,brcnt,step;

		public Point(int x, int y,int brcnt,int step) {
			super();
			this.x = x;
			this.y = y;
			this.brcnt=brcnt;
			this.step =step;
		}
		
	}
	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		N = Integer.parseInt(br.readLine());
		
		map =new int[N][N];
		v = new int[N][N];
		brk = new int[N][N];
		for (int i = 0; i < N; i++) {
			String str = br.readLine();
			for (int j = 0; j < N; j++) {
				map[i][j] = str.charAt(j)-'0';
			}
		}
		
		//print(map);
		
		bfs();
		System.out.println(min-1);
		
	}
	private static void bfs() {
		Queue<Point> q = new LinkedList<>();
		q.add(new Point(0,0,1,0));
		v[0][0]=1;
		brk[0][0]=1;
		
		
		while(!q.isEmpty()) {
			int size = q.size();
			for(int s=0;s<size;s++) {
				Point p = q.poll();
				int br = p.brcnt;
				int x = p.x;
				int y = p.y;
				int step = p.step;
				if(x==N-1 && y==N-1) {
					if(min>br) {
						//print(brk);
						//System.out.println("----------");
					
						min = br;
					}
				}
				
				for(int d=0;d<4;d++) {
					int nx = x+dx[d];
					int ny = y+dy[d];
					//경계선 체크
					if(nx>=0 && ny>=0&& nx<N && ny<N) {
						
						//흰방이고 안갔던 방이거나 덜 부시고 왔으면 간다
						if( map[nx][ny]==1 && (v[nx][ny]==0 || brk[nx][ny]>=br+1)) {
							v[nx][ny]=1;
							brk[nx][ny]=br; //부순 문개수 그대로
							q.add(new Point(nx,ny,br,step+1));
						}
						//처음 부시거나 덜부시고 왔으면 간다.
						else if(map[nx][ny]==0 && (brk[nx][ny] >br+1||brk[nx][ny]==0)) {
							v[nx][ny]=1;
							brk[nx][ny] =br+1;
							q.add(new Point(nx,ny,br+1,step+1));
						}
						
					}
					
					
				}
				//print(brk);
				//System.out.println("-----------");
			}
		}
		
	}
	private static void print(int[][] map2) {
		for (int i = 0; i < map2.length; i++) {
			for (int j = 0; j < map2[i].length; j++) {
				System.out.print(map2[i][j]+" ");
			}
			System.out.println();
		}
	}

}
