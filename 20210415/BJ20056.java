package day0413;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.StringTokenizer;

//마법사 상어와 파이어볼- 시뮬레이션
public class BJ20056 {
	static int N,M,K;
	static int[][][] map;
	static class Point{
		int r,c,m,s,d;



		public Point(int r, int c, int m, int s, int d) {
			super();
			this.r = r;
			this.c = c;
			this.m = m;
			this.s = s;
			this.d = d;
		}
		
		
		
	}
	static int[] dx= {-1,-1,0,1,1,1,0,-1};
	static int[] dy= {0,1,1,1,0,-1,-1,-1};
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		StringTokenizer st = new StringTokenizer(br.readLine()," ");
		
		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());
		K = Integer.parseInt(st.nextToken());
		
		ArrayList<Point> fireBalls = new ArrayList<>();
		
		for(int i=0; i<M;i++) {
			st = new StringTokenizer(br.readLine()," ");
			int r = Integer.parseInt(st.nextToken())-1;
			int c = Integer.parseInt(st.nextToken())-1;
			int m = Integer.parseInt(st.nextToken());
			int s = Integer.parseInt(st.nextToken());
			int d = Integer.parseInt(st.nextToken());
			fireBalls.add(new Point(r,c,m,s,d));
		}
		
		//총 K번의 파이어볼 행동
		for(int f=0; f<K;f++) {
			ArrayList<Point> newFireBalls = new ArrayList<>();
			

			//파이어볼의 이동
			for(Point p : fireBalls) {
				int r = p.r;
				int c = p.c;


				int m = p.m;
				int d = p.d;
				int s = p.s;
				//파이어볼 속도와 방향으로 이동위치 찾기
				
				int nr = r + dx[d]*s;
				int nc = c + dy[d]*s;

				if(nr>=N) {

					nr = nr%N;

					
				}

				else if(nr<0) {
	
					nr = N - ((nr *(-1))%N);
					if(nr==N) {
						nr=0;
					}

					
				}

				if(nc>=N) {

					nc = nc%N;

				}

				else if(nc<0) {

					nc = N - ((nc *(-1))%N);
					if(nc==N) {
						nc=0;
					}

				}

				newFireBalls.add(new Point(nr,nc,m,s,d));
			}
			map =new int[N][N][4];//0질량합, 1속력의합,2방향의 체크,  3카운트


			for(Point p: newFireBalls) {
				int r = p.r;
				int c = p.c;
				int m = p.m;
				int d = p.d;
				int s = p.s;
				
				map[r][c][0]+=m;
				map[r][c][1]+=s;
				map[r][c][3]++;
				//방향 홀짝수 다른거 들어가면 check
				if(map[r][c][2]==-1) {
					continue;
				}
				
				//2개이상 겹치는 부분에서 홀짝이 번갈아 나오면 -1로 세팅한다.
				if(map[r][c][3]>=2 && (map[r][c][2]%2==0 && d%2==1) ||(map[r][c][2]%2==1 && d%2==0)) {
					map[r][c][2]=-1;
				}
				else {
					map[r][c][2]=d;
				}

				
			}
			//print(map);
			//System.out.println("-------");
			fireBalls.clear();
			for(int i=0;i<N;i++) {
				for(int j=0;j<N;j++) {

					//한개있는곳이면 그냥 둠
					if(map[i][j][3]==1) {
						fireBalls.add(new Point(i,j,map[i][j][0],map[i][j][1],map[i][j][2]));
					}
					//두개 이상이면 합쳐지고 퍼지는 방향으로 넣음
					else if(map[i][j][3]>=2){
						int m = map[i][j][0]/5;
						
						//0이면 안넣고 그냥 통과
						if(m==0) {
							continue;
						}
						
						int s = map[i][j][1]/map[i][j][3];
						
						//모두홀수거나 모두짝수인경우
						if(map[i][j][2]!=-1) {
							//System.out.println("모두홀or짝");
							for(int d=0;d<=6;d+=2) {
								fireBalls.add(new Point(i,j,m,s,d));
							}
						}
						//홀수와 짝수가 번갈아서 온곳
						else {
							//System.out.println("번갈아");
							for (int d = 1; d <=7; d+=2) {
								fireBalls.add(new Point(i,j,m,s,d));
							}
						}
						
					}
					
				}
			}
			
			
			
		}
		int ans=0;
		for(Point p: fireBalls) {
			ans += p.m;
			
		}
		System.out.print(ans);
	}
	
	
	
	
	private static void print(int[][][] map2) {
		for (int i = 0; i < N; i++) {
			for (int j = 0; j < N; j++) {
				System.out.print(map2[i][j][2]+" ");
			}
			System.out.println();
		}
	}

}
