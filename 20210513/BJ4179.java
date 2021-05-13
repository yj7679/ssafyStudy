package day0512;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

//불! -BFS
public class BJ4179 {
	static int R,C;
	static char[][] map;
	static ArrayList<Point> fires=new ArrayList<>();
	static class Point{
		int x,y;

		public Point(int x, int y) {
			super();
			this.x = x;
			this.y = y;
		}
		
		
	}
	static int[] dx= {-1,1,0,0};
	static int[] dy= {0,0,1,-1};
	
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine()," ");
		
		R =Integer.parseInt(st.nextToken());
		C =Integer.parseInt(st.nextToken());
		map =  new char[R][C];

		Point J=null;
		Point F =null;
		for (int i = 0; i < R; i++) {
			String str = br.readLine();
			for (int j = 0; j < C; j++) {
				map[i][j] = str.charAt(j);
				if(map[i][j]=='J') {
					J =new Point(i,j);
				}
				else if(map[i][j]=='F') {
					fires.add(new Point(i,j));
				}
			}
		}
		//print(map);
		
		bfs(J);
	}
	private static void bfs(Point j) {
		Queue<Point> ji = new LinkedList<>();
		Queue<Point> fire = new LinkedList<>();

		int[][] vj=new int[R][C];
		int[][] vf=new int[R][C];
		vj[j.x][j.y]=1;
	
		
		ji.add(j);
		for(Point f:fires) {
			fire.add(f);
			vf[f.x][f.y]=1;
		}
		// 불 퍼지는거확인
		while(!fire.isEmpty()) {
			int size = fire.size();
			for(int s=0;s<size;s++) {
				Point p = fire.poll();
				int x = p.x;
				int y = p.y;
				for(int d=0;d<4;d++) {
					int nx = x+dx[d];
					int ny = y+dy[d];
					
					if(nx>=0 && nx<R && ny>=0 && ny<C && vf[nx][ny]==0 && map[nx][ny]!='#') {
						vf[nx][ny] = vf[x][y]+1;
						fire.add(new Point(nx,ny));
						
					}
				}
				
			}
			
		}
		
		//지훈이가 갈곳 전부 간 경우
		while(!ji.isEmpty()) {
			//불이 먼저 한스텝 다 퍼져나감
			int size = ji.size();
			for(int s=0;s<size;s++) {
				
				Point p = ji.poll();
				int x = p.x;
				int y = p.y;
				
				//테두리이면
				if(x==0 || y==0 || x==R-1 || y==C-1) {
					System.out.println(vj[x][y]);
					//print(vj);
					//System.out.println("----");
					//print(vf);
					System.exit(0);
				}
				
				for(int d=0;d<4;d++) {
					int nx = x+dx[d];
					int ny = y+dy[d];
					//불보다 빨리가야함
					if(nx>=0 && nx<R && ny>=0 && ny<C && vj[nx][ny]==0 && (vj[x][y]+1<vf[nx][ny]||vf[nx][ny]==0)&& map[nx][ny]!='#') {
						vj[nx][ny] = vj[x][y]+1;
						ji.add(new Point(nx,ny));
						
					}
				}
				
				
				
			}
			
			
			
			
		}
		
		System.out.println("IMPOSSIBLE");
		
		
		
		
	}
	private static void print(int[][] map2) {
		for (int i = 0; i < map2.length; i++) {
			for (int j = 0; j < map2[i].length; j++) {
				System.out.print(map2[i][j]+" ");
			}
			System.out.println();
		}
		
	}
	private static void print(char[][] map2) {
		for (int i = 0; i < map2.length; i++) {
			for (int j = 0; j < map2[i].length; j++) {
				System.out.print(map2[i][j]+" ");
			}
			System.out.println();
		}
	}

}
