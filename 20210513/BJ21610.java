package day0512;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.StringTokenizer;

// 마법사 상어와 비바라기
public class BJ21610 {
	static int N,M;
	static int[][] map,v;
	static int[] dx= {0,0,-1,-1,-1,0,1,1,1};
	static int[] dy = {0,-1,-1,0,1,1,1,0,-1};
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
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine()," ");
		
		N =Integer.parseInt(st.nextToken());
		M =Integer.parseInt(st.nextToken());
		map = new int[N][N];
		for (int i = 0; i < N; i++) {
			st = new StringTokenizer(br.readLine()," ");
			for (int j = 0; j < N; j++) {
				map[i][j] = Integer.parseInt(st.nextToken());
			}
		}
		
		//구름 저장
		ArrayList<Point> cloud = new ArrayList<>();
		//처음의 위치는 왼쪽아래 4칸
		for(int r=N-2;r<=N-1;r++) {
			for(int c=0;c<=1;c++) {
				cloud.add(new Point(r,c));
			}
		}
		for(int z=0;z<M;z++) {
			st = new StringTokenizer(br.readLine()," ");
			int d = Integer.parseInt(st.nextToken());
			int l = Integer.parseInt(st.nextToken());
			
			//1 이동 후 4개좌표의 위치
			int cnt=0;

			//음수면 절대값한다음 -1한다음%5한다음 오른쪽에서 그결과-1칸 ex)-1이면 1->0->(마지막-0-1)
			//ex)-10이면 10->9->4-> (마지막-4-1)
			for(Point p: cloud) {
				int nx = p.x+dx[d]*l;
				int ny = p.y+dy[d]*l;
				
				//양수로 넘치면 그냥 %R
				if(nx>=N) {
					nx %=N;
				}
				//음수로 넘치면
				else if(nx<0) {
					nx = N-(((int)Math.abs(nx)-1)%N+1);
				}
				if(ny>=N) {
					ny%=N;
				}
				else if(ny<0) {
					ny = N-(((int)Math.abs(ny)-1)%N+1);
					
				}
				p.x=nx;
				p.y=ny;
				
			}
			//구름의 위치 체크
			v=new int[N][N];
			
			
			// 각 구름에서 비가 내림
			for(Point p: cloud) {
				map[p.x][p.y]+=1;
				v[p.x][p.y]=1;
			}
			
			//print(map);
			
			//대각선에 있는 물이 있는 칸 개수만큼 증가
			for(Point p:cloud) {
				map[p.x][p.y] +=check(p);
			}
			//구름이 사라짐.
			cloud.clear();
			
			//print(map);
			for(int i=0;i<N;i++) {
				for(int j=0;j<N;j++) {
					//2이상이고 v체크 안된 곳을 줄인다.
					if(map[i][j]>=2 && v[i][j]==0) {
						map[i][j]-=2;
						cloud.add(new Point(i,j));
					}
				}
			}
			//print(map);
			
		}
		//print(map);
		int ans = sum(map);
		System.out.println(ans);
	}
	
	private static int sum(int[][] map2) {
		int ans=0;
		for (int i = 0; i < map2.length; i++) {
			for (int j = 0; j < map2[i].length; j++) {
				ans+=map2[i][j];
			}
		}
		return ans;
	}

	//바구니의 물이 채워진 대각선의 칸 개수
	private static int check(Point p) {
		int x = p.x;
		int y = p.y;
		int cnt=0;
		for(int d=2;d<=8; d+=2) {
			int nx = x+dx[d];
			int ny = y+dy[d];
			if(nx>=0 && ny>=0 && nx<N && ny<N && map[nx][ny]!=0) {
				cnt++;
			}
		}
		return cnt;
		
	}
	private static void print(int[][] map2) {
		for (int i = 0; i < map2.length; i++) {
			for (int j = 0; j < map2.length; j++) {
				System.out.print(map2[i][j]+" ");
			}
			System.out.println();
		}
		System.out.println("-------------");
	}

}
