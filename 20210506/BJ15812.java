package day0506;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

//침략자 진아- BFS
public class BJ15812 {
	static int N,M;
	static int[][] map,temp;
	static ArrayList<Point> list = new ArrayList<>();
	static int size=0,vil=0;
	static int min = Integer.MAX_VALUE/2;
	static class Point{
		int x,y;

		public Point(int x, int y) {
			super();
			this.x = x;
			this.y = y;
		}

		@Override
		public String toString() {
			return "Point [x=" + x + ", y=" + y + "]";
		}
		
		
	}
	static int[] dx= {1,0,-1,0};
	static int[] dy= {0,1,0,-1};
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine()," ");
		
		N =Integer.parseInt(st.nextToken());
		M =Integer.parseInt(st.nextToken());
		temp = new int[N][M];
		map = new int[N][M];
		for (int i = 0; i < N; i++) {
			String str = br.readLine();
			for (int j = 0; j < M; j++) {
				map[i][j] = str.charAt(j)-'0';
				if(map[i][j]==0) {
					list.add(new Point(i,j));
				}
			}
		}
		size = list.size();
		vil = N*M-size;
		//print(map);
		
		combination(0,0,new Point[2]);
		System.out.println(min);
	}
	private static void combination(int k, int idx, Point[] sel) {
		if(k==sel.length) {
			//System.out.println(Arrays.toString(sel));
			
			for(int i=0;i<N;i++) {
				for(int j=0;j<M;j++) {
					temp[i][j] = map[i][j];
				}
			}
			//마을의 개수 N*M-size: vil
			bfs(sel,vil);
			
			
			
			
			return;
		}
		for(int i=idx;i<size;i++) {
			sel[k] = list.get(i);
			combination(k+1,i+1,sel);
		
			
		}
	
	}
	private static void bfs(Point[] sel, int vil2) {
		Queue<Point>  q = new LinkedList<>();
		int[][]v =new int[N][M];
		//System.out.print(sel[0].x+" "+sel[0].y+"   ");
		//System.out.println(sel[1].x+" "+sel[1].y);
		q.add(sel[0]);
		q.add(sel[1]);
		int cnt=0;
		v[sel[0].x][sel[0].y]=1;
		v[sel[1].x][sel[1].y]=1;
		
		while(!q.isEmpty()) {
			int qs = q.size();
			for(int s=0;s<qs;s++) {
				Point p = q.poll();
				
				for(int d=0;d<4;d++) {
					int nx = p.x+dx[d];
					int ny = p.y+dy[d];
					//|| (v[nx][ny]!=0 && v[p.x][p.y]<v[nx][ny]) 
					if(nx>=0 && ny>=0 &&nx<N&& ny<M && (v[nx][ny]==0)) {
						v[nx][ny]= v[p.x][p.y]+1;
						q.add(new Point(nx,ny));
						if(map[nx][ny]==1) {
							vil2--;
						}
					}
				
				}
				
			}
			cnt++;
			if(vil2==0) {
				if(min>cnt) {
					min = cnt;
				}
				//System.out.println(cnt);
				//print(v);
				//System.out.println("-----------");
				break;
				
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
