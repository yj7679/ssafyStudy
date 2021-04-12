package day0412;
//드래곤 커브- 시뮬레이션
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.StringTokenizer;


public class BJ15685 {
	static int N;
	static int[][] map= new int[101][101];
	static int[] dx= {0,-1,0,1};
	static int[] dy= {1,0,-1,0};
	static class Point{
		int x,y;

		public Point(int y, int x) {
			super();
			this.x = x;
			this.y = y;
		}
		
		
		
	}
	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		N = Integer.parseInt(br.readLine());
		Point[] startPoints = new Point[N];
		int[] generation = new int[N];
		ArrayList<Integer>[] curves = new ArrayList[N];
		for(int i=0;i<N;i++) {
			StringTokenizer st = new StringTokenizer(br.readLine()," ");
			startPoints[i] = new Point(Integer.parseInt(st.nextToken()),Integer.parseInt(st.nextToken()));
			curves[i] = new ArrayList<>();
			curves[i].add(Integer.parseInt(st.nextToken()));
			
			generation[i] = Integer.parseInt(st.nextToken());
		}
//		for(int i=0;i<N;i++) {
//			for(Integer t: curves[i])	
//			System.out.print(t+" ");
//			System.out.println();
//			System.out.print(generation[i]+" ");
//		}
		
		//총 N개의 커브에 대해서 진행
		for(int i=0; i<N;i++) {
			//각 커브에대해 generation만큼 커브 방향을 그린다.
			for (int j = 0; j < generation[i]; j++) {
				//매 generation은 현재 curves에 저장된 것들만큼 반복
				int size =curves[i].size();
				int[] temp = new int[size];
				int cnt=0;
				//현재꺼까지 나온 curves를 temp에 넣는다. 회전한거 넣어서
				for(Integer v : curves[i]) {
					temp[cnt++] = (v+1)%4;
				}
				
				for(int k = size-1; k>=0; k--) {
					curves[i].add(temp[k]);
				}
				
			}
//			for(Integer v : curves[i]) {
//				System.out.print(v+" ");
//			}
//			System.out.println();
		
		}
		//점찍기
		for(int i=0; i<N; i++) {
			//curves가 지나가는 경로의 점들을찍음
			int x = startPoints[i].x;
			int y = startPoints[i].y;

			map[x][y]=1;
			
			for(Integer v : curves[i]) {
				x=x+dx[v];
				y=y+dy[v];
				map[x][y]=1;
			}
			
		}
		int ans=0;
		for(int i=0;i<=99;i++) {
			l:for(int j=0;j<=99;j++) {
				for(int r=0;r<2;r++) {
					for (int c = 0; c < 2; c++) {
						if(map[i+r][j+c]==0)
							continue l;
					}
				}
				ans++;
				
			}
		}
		System.out.println(ans);
		
		
	}
	private static void print(int[][] map2) {
		for (int i = 0; i < map2.length; i++) {
			for (int j = 0; j < map2.length; j++) {
				System.out.print(map2[i][j]+" ");
			}
			System.out.println();
		}
		
	}

}
