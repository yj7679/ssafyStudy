package day0414;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;

//소문난 칠공주
public class BJ1941_fullcombi {
	static char[][] map = new char[5][5];
	static int[] dx = {1,0,-1,0};
	static int[] dy = {0,1,0,-1};
	static int ans=0;
	static int[][] v = new int[5][5],check=new int[5][5];
	static class Point{
		int r,c;

		public Point(int r, int c) {
			super();
			this.r = r;
			this.c = c;
		}

		@Override
		public String toString() {
			return "Point [r=" + r + ", c=" + c + "]";
		}
		
	}
	public static void main(String[] args) throws IOException {
		BufferedReader br= new BufferedReader(new InputStreamReader(System.in));
		ArrayList<Point> S = new ArrayList<>();
		
		for(int i=0; i<5;i++) {
			String str = br.readLine();
			for (int j = 0; j < 5; j++) {
				map[i][j] = str.charAt(j);
				S.add(new Point(i,j));
			}
		}
		combination(S,0,0,0, new Point[7]);
		System.out.println(ans);
	}
	
	private static void combination(ArrayList<Point> S, int k, int idx,int y, Point[] sel) {
		if(y==4) {
			return;
		}
		if(k==sel.length) {
			v= new int[5][5];
			
			for(Point p: sel) {
				v[p.r][p.c]= 1;
			}
			
			l:for(int i=0;i<5;i++) {
				for (int j = 0; j < 5; j++) {
					if(v[i][j]==1) {
						dfs(i,j);
						break l;
					}
				}
			}
			boolean flag= true;
			b:for(int i=0;i<5;i++) {
				for (int j = 0; j < 5; j++) {
					if(v[i][j]==1) {
						flag=false;
						break b;
					}
				}
			}
			
			if(flag==true) {
				ans++;
			}
			return;
		}
		
		int size = S.size();
		for(int i=idx;i<size;i++) {
			Point p = S.get(i);
			sel[k] = new Point(p.r,p.c);			
			if(map[p.r][p.c]=='Y') {
				combination(S,k+1,i+1,y+1,sel);
			}
			else {
				combination(S,k+1,i+1,y,sel);
			}
		}
		
		
	}

	private static void dfs(int i, int j) {
		
		v[i][j]=0;
		for(int d=0; d<4; d++) {
			int nx = i+dx[d];
			int ny = j+dy[d];
			
			if(nx>=0 && ny>=0 && nx<5 && ny<5 && v[nx][ny]==1) {
				
				dfs(nx,ny);
			}
		}
	}

	private static void print(int[][] v2) {
		for (int i = 0; i < 5; i++) {
			for (int j = 0; j < 5; j++) {
				System.out.print(v2[i][j]+" ");
			}
			System.out.println();
		}
		System.out.println("--------------");
	}

}
