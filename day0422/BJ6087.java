package day0421;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;

//레이저통신
public class BJ6087 {
	static int W,H,ans=Integer.MAX_VALUE;
	static char[][] map;
	static int[][] v;
	static int endx,endy;
	static class Point{
		int x,y,d,cnt;

		public Point(int x, int y,int d,int cnt) {
			super();
			this.x = x;
			this.y = y;
			this.d = d;
			this.cnt=cnt;
		}

		@Override
		public String toString() {
			return "Point [x=" + x + ", y=" + y + "]";
		}
		
		
		
	}
	static int[] dx= {0,1,-1,0};//상우하좌 순서
	static int[] dy= {1,0,0,-1};
	public static void main(String[] args) throws IOException {
		BufferedReader br=new BufferedReader(new InputStreamReader(System.in));
		
		String[] st = br.readLine().split(" ");
		
		W =Integer.parseInt(st[0]);
		H =Integer.parseInt(st[1]);
		map = new char[H][W];
		boolean flag=false;
		v=new int[H][W];
		Point startp=null;
		for (int i = 0; i < H; i++) {
			String str = br.readLine();
			for (int j = 0; j < W; j++) {
				map[i][j] = str.charAt(j);
				if(flag==false && map[i][j]=='C') {
					startp = new Point(i,j,-1,0);
					flag=true;
				}
				if(flag==true && map[i][j]=='C') {
					endx = i;
					endy= j;
				}
				v[i][j]=Integer.MAX_VALUE;
			}
			
		}
		bfs(startp);
		
	}
	private static void bfs(Point startp) {
		Queue<Point> q = new LinkedList<>();

		v[startp.x][startp.y]=0;
		int size=0;
		q.add(new Point(startp.x,startp.y,startp.d,startp.cnt));
		
		while(!q.isEmpty()) {
			size = q.size();
			for(int s=0; s<size;s++) {
				Point p = q.poll();
				int x = p.x;
				int y = p.y;
				int pre_d = p.d;
				int mCnt= p.cnt;
				//새로운 C지점에 닿은 경우
				if(x==endx && y==endy) {
					ans = Math.min(ans, mCnt);
				    
				}
				
				for(int d=0;d<4;d++) {
					int nx = x+dx[d];
					int ny = y+dy[d];
					//더덜꺾여서 왓으면 다시넣음
					
					 if (nx < 0 || ny < 0 || nx >= H || ny >= W || map[nx][ny] == '*') {
		                    continue;
		                }
		                int temp = mCnt;
		                if (pre_d != d && pre_d != -1) {
		                    temp++;
		                }

		                if (v[nx][ny] < temp) {
		                    continue;
		                }

		                v[nx][ny] = temp;
		                q.add(new Point(nx, ny, d, temp));

				}


			}
		}
		//print(v);
		System.out.println(ans);
	

		
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
