package day0314;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;


//스타트택시 bfs
public class BJ19238 {
	//상, 좌, 우, 하 순서로 탐색
	static int[] dx = {-1,0,0,1};
	static int[] dy = {0,-1,1,0};
	static int N,M,F;
	static int[][] map,mans,check;
	static int[][][] dest;//총 M명이 목적지가 겹칠 수 있다.
	static int taxix,taxiy;
	
	static class Point{
		int x,y;

		public Point(int x, int y) {
			super();
			this.x = x;
			this.y = y;
		}
		
	}
	//승객을 태운 이후, 연료 카운트해서 승객~ 목적지까지 가는 동안 쓰이는 연료의 x2가 충전 
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		String[] str = br.readLine().split(" ");
		
		N = Integer.parseInt(str[0]);
		M = Integer.parseInt(str[1]);
		F = Integer.parseInt(str[2]);
		
		map = new int[N+2][N+2];
		mans = new int[N+2][N+2];
		dest = new int[N+2][N+2][M];//M명의 목적지
		
		for (int i = 0; i < N; i++) {
			str = br.readLine().split(" ");
			for (int j =0 ; j < N; j++) {
				map[i+1][j+1] = Integer.parseInt(str[j]);				
			}
		}
		
		for (int i = 0; i < N+2; i++) {
			for (int j =0 ; j < N+2; j++) {
				if(i==0||j==0||i==N+1 ||j==N+1)
				map[i][j] =1;
				
			}
		}
		
		//print(map);
		
		
		str = br.readLine().split(" ");
		
		taxix = Integer.parseInt(str[0]);
		taxiy = Integer.parseInt(str[1]);
		
		int samedest=0;
		for(int i=1;i<=M;i++) {
			str = br.readLine().split(" ");
			mans[Integer.parseInt(str[0])][Integer.parseInt(str[1])] = i;
			dest[Integer.parseInt(str[2])][Integer.parseInt(str[3])][samedest++] = i;
		}
		

		//택시- 승객1을 모셔주기
		//승객1을 모셔준 위치- 승객2를 모셔주기
		bfs(taxix,taxiy);
		boolean flag=true;
		
		l:for(int i=1; i<=N; i++) {
			for(int j=1;j<=N;j++) {
				int cnt=0;
				while(cnt<M) {
					if(dest[i][j][cnt++]!=0) {
						//다했는데도 목적지가 있는경우 목적지까지 못태워준 손님 존재
						System.out.println(-1);
						flag = false;
						break l;
					}
				}
				
			}
		}
		if(flag==true) {
			System.out.println(F);
		}
		
	
		
	}
	private static void bfs(int startx, int starty) {
		check = new int[N+2][N+2];
		Queue<Point> q = new LinkedList<>();
		q.add(new Point(startx,starty));
		check[startx][starty]=1;
		int manInCar=0;
		w:while(!q.isEmpty()) {

			
			Point p = q.poll();
			
			//현재 온칸이 승객이고 차에 아무도 안타있으면
			if(mans[p.x][p.y] !=0 && manInCar==0) {
				int minr=p.x,minc=p.y;
				for(int i=1; i<=N;i++) {
					for(int j=1;j<=N;j++) {
						if(check[i][j]==check[p.x][p.y] && mans[i][j]!=0) {
							
							if(minr>i) {
								minr=i;
								minc=j;
							}
							else if(minr==i && minc>j) {
								minc=j;
							}
							
							

						}
					}
				}

				F -= (check[p.x][p.y]-1);//승객태우면 그때까지 연료쓴거뺀다.
				if(F<0) {
					System.out.println(-1);
					System.exit(0);
				}
				
				//check 초기화하고 n번 승객태웠다는 표시 하기.
				manInCar=mans[minr][minc];
				mans[minr][minc]=0;


				clearmap(check);
				q.clear();
				
				q.add(new Point(minr,minc));
				check[minr][minc]=1;
				continue;
				

			}

			//if승객태운상태로 해당 목적지인 곳을 만났으면 연료채우기, 목적지 map위치 0으로 만들기
			int cnt=0;
			while(cnt<M) {
				if(manInCar!=0 && dest[p.x][p.y][cnt]==manInCar) {

					//사람이 비어있는것은 양수로 표현
					manInCar=0;
					dest[p.x][p.y][cnt]=0;
	
					F-=(check[p.x][p.y]-1);
					if(F<0) {
						System.out.println(-1);
						System.exit(0);
					}
					F+=(2*(check[p.x][p.y]-1));
	
					clearmap(check);
					//System.out.println("목적지 데려다주고 남은연료:" +F);
					q.clear();
					
					q.add(new Point(p.x,p.y));
					check[p.x][p.y]=1;
					continue w;

				}
				cnt++;
			}
			for(int d=0; d<4;d++) {
				int nx = p.x+dx[d];
				int ny = p.y+dy[d];
				

				
				//안갔던 곳이고 벽이 아니면 간다.
				if(map[nx][ny]!=1 && check[nx][ny]==0) {
					q.add(new Point(nx,ny));
					check[nx][ny] = check[p.x][p.y]+1;


				}
				
			}
		}
		
		
	}
	private static void clearmap(int[][] check) {
		for (int i = 0; i < check.length; i++) {
			for (int j = 0; j < check.length; j++) {
				check[i][j]=0;
			}
		}
		
	}
	private static void print(int[][] map2) {
		for (int i = 0; i < map2.length; i++) {
			for (int j = 0; j < map2.length; j++) {
				System.out.print(map2[i][j] + " ");
			}
			System.out.println();
		}
		
		
	}

}
