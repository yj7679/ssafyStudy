package day0415;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.StringTokenizer;

//비숍 - 백트래킹
public class BJ1799 {
	static int N;
	static int[][] map;
	static int ans = 0;
	static Point[] arr;
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
	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st=null; 
		N= Integer.parseInt(br.readLine());
		map = new int[N][N];
		ArrayList<Point> list = new ArrayList<>();
		for (int i = 0; i <N; i++) {
			st = new StringTokenizer(br.readLine()," ");
			for (int j = 0; j < N; j++) {
				map[i][j] = Integer.parseInt(st.nextToken());
				if(map[i][j]==1) {
					list.add(new Point(i,j));
				}
			}	
		}
		arr = new Point[list.size()];
		int cnt=0;
		for(Point p:list) {

			arr[cnt++] = new Point(p.x,p.y);

			//System.out.println(arr[cnt-1]);
		}
	
		
		solve(arr,0,0);
		System.out.println(ans);
	}
	private static void solve(Point[] arr, int idx,int cnt) {
		if(idx == arr.length) {
			ans=Math.max(ans, cnt);

			return;
		}
		if(cnt+arr.length-idx<ans) {
			return;
		}
		
		int x = arr[idx].x;
		int y = arr[idx].y;
		

		//현재 못넣는 경우
		if(!isAvailable(x,y)) {
			solve(arr,idx+1,cnt);
		}
		//현재 넣을 수 있는 경우
		else {
			//현재위치에 넣고 가는 경우
			map[x][y]=2;
			
			solve(arr,idx+1,cnt+1);
			//현재위치에 안넣고 가는 경우
			map[x][y]=1;
			solve(arr,idx+1,cnt);
		}
	}
	private static void print(int[][] map2) {
		for (int i = 0; i < N; i++) {
			for (int j = 0; j < N; j++) {
				System.out.print(map2[i][j]+" ");
			}
			System.out.println();
		}
	}
	private static boolean isAvailable(int x, int y) {

		for(Point p: arr) {
			if(p.x==x) {
				break;
			}
			if(map[p.x][p.y]==2 && Math.abs(p.x-x)==Math.abs(p.y-y))
				return false;
			
		}
		
		return true;
	}
}
