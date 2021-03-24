package day0314;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

//감시- 시뮬레이션
public class BJ15683 {
	static int N,M,ans=100;
	static int[][] map;
	//상, 우, 하, 좌
	static int[] dx= {-1,0,1,0};
	static int[] dy= {0,1,0,-1};
	static StringBuilder sb= new StringBuilder("");
	
	public static void main(String[] args) throws IOException {
		
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		String[] str= br.readLine().split(" ");
		N = Integer.parseInt(str[0]);
		M = Integer.parseInt(str[1]);
		map= new int[N][M];
		boolean flag= false;
		int startx=0,starty=0;
		for(int i=0; i<N; i++) {
			str = br.readLine().split(" ");
			for(int j=0; j<M; j++) {
				map[i][j] = Integer.parseInt(str[j]);
				if(map[i][j]!=0 && map[i][j]<6 &&flag==false) {
					flag=true;
					startx=i;
					starty=j;
				}
			}
		}
		//print(map);
		
		dfs(startx,starty);

		System.out.println(ans);
	
		

	}

	
	
	
	
	
	private static void dfs(int x, int y) {
		int[][] temp=new int[N][M];
		if(x==N && y==0) {

			int cnt=0;
			for(int i=0;i<N; i++) {
				for(int j=0;j<M;j++) {
					if(map[i][j]==0) {
						cnt++;
					}
				}
			}					

			ans = Math.min(ans, cnt);
			return;
		}

		switch(map[x][y]) {
			case 1:
				for(int d=0; d<4;d++) {

					int nx = x+dx[d];
					int ny = y+dy[d];
					while(nx>=0 && nx<N && ny>=0 && ny<M && map[nx][ny]!=6) {
						if(map[nx][ny]==0) {
							map[nx][ny]=-1;
							temp[nx][ny]=1;
						}
						nx+=dx[d];
						ny+=dy[d];
					}

					if(y+1==M) {
						dfs(x+1,0);
					}
					else{
						dfs(x,y+1);
					}
					nx=x+dx[d];
					ny=y+dy[d];
					while(nx>=0 && nx<N && ny>=0 && ny<M && map[nx][ny]!=6) {
						if(map[nx][ny]==-1 &&temp[nx][ny]==1) {
							map[nx][ny]=0;
						}
						nx+=dx[d];
						ny+=dy[d];
					}
				}
				break;
			case 2:
				for(int d=0; d<2;d++) {
					
					for(int k=0; k<=2; k=k+2) {
						int nx = x+dx[(d+k)%4];
						int ny = y+dy[(d+k)%4];
						while(nx>=0 && nx<N && ny>=0 && ny<M && map[nx][ny]!=6) {
							if(map[nx][ny]==0) {
								map[nx][ny]=-1;
								temp[nx][ny]=1;
							}
							nx+=dx[(d+k)%4];
							ny+=dy[(d+k)%4];
						}
					}

					if(y+1==M) {
						dfs(x+1,0);
					}
					else{
						dfs(x,y+1);
					}
					
					for(int k=0; k<=2; k=k+2) {
						int nx = x+dx[(d+k)%4];
						int ny = y+dy[(d+k)%4];
						while(nx>=0 && nx<N && ny>=0 && ny<M && map[nx][ny]!=6) {
							if(map[nx][ny]==-1 && temp[nx][ny]==1) {
								map[nx][ny]=0;
							}
							nx+=dx[(d+k)%4];
							ny+=dy[(d+k)%4];
						}
					}
				}
				break;
			case 3:
				for(int d=0; d<4;d++) {
					
					for(int k=0; k<2; k++) {
						int nx = x+dx[(d+k)%4];
						int ny = y+dy[(d+k)%4];
						while(nx>=0 && nx<N && ny>=0 && ny<M && map[nx][ny]!=6) {
							if(map[nx][ny]==0) {
								map[nx][ny]=-1;
								temp[nx][ny]=1;
							}
							nx+=dx[(d+k)%4];
							ny+=dy[(d+k)%4];
						}

					}

					if(y+1==M) {
						dfs(x+1,0);
					}
					else{
						dfs(x,y+1);
					}
					
					for(int k=0; k<2; k++) {
						int nx = x+dx[(d+k)%4];
						int ny = y+dy[(d+k)%4];
						while(nx>=0 && nx<N && ny>=0 && ny<M && map[nx][ny]!=6) {
							if(map[nx][ny]==-1 && temp[nx][ny]==1) {
								map[nx][ny]=0;
							}
							nx+=dx[(d+k)%4];
							ny+=dy[(d+k)%4];
						}

					}
				}				
				
				break;
			case 4:
				for(int d=0; d<4;d++) {
					
					for(int k=0; k<3; k++) {
						int nx = x+dx[(d+k)%4];
						int ny = y+dy[(d+k)%4];
						while(nx>=0 && nx<N && ny>=0 && ny<M && map[nx][ny]!=6) {
							if(map[nx][ny]==0) {
								map[nx][ny]=-1;
								temp[nx][ny]=1;
							}
							nx+=dx[(d+k)%4];
							ny+=dy[(d+k)%4];
						}
						
					}

					if(y+1==M) {
						dfs(x+1,0);
					}
					else{
						dfs(x,y+1);
					}
					
					for(int k=0; k<3; k++) {
						int nx = x+dx[(d+k)%4];
						int ny = y+dy[(d+k)%4];
						while(nx>=0 && nx<N && ny>=0 && ny<M && map[nx][ny]!=6) {
							if(map[nx][ny]==-1 &&temp[nx][ny]==1) {
								map[nx][ny]=0;
							}
							nx+=dx[(d+k)%4];
							ny+=dy[(d+k)%4];
						}
					}
				}			
				break;
			case 5:
				for(int d=0; d<4; d++) {
					int nx = x+dx[d];
					int ny = y+dy[d];
					while(nx>=0 && nx<N && ny>=0 && ny<M && map[nx][ny]!=6) {
						if(map[nx][ny]==0) {
							map[nx][ny]=-1;
						}
						nx+=dx[d];
						ny+=dy[d];
					}
				}
				
				if(y+1==M) {
					dfs(x+1,0);
				}
				else{
					dfs(x,y+1);
				}

				
				break;
			case 6:
				if(y+1==M) {
					dfs(x+1,0);
				}
				else{
					dfs(x,y+1);
				}
				break;
				
			case 0:	
				if(y+1==M) {
					dfs(x+1,0);
				}
				else{
					dfs(x,y+1);
				}
				break;
				
			case -1:
				if(y+1==M) {
					dfs(x+1,0);
				}
				else{
					dfs(x,y+1);
				}
				break;
			
		}
		
	}






	private static void print(int[][] map2) {
		for (int i = 0; i < map2.length; i++) {
			for (int j = 0; j < map2[i].length; j++) {
				System.out.printf("%3d ",map2[i][j]);
			}
			
			System.out.println();
		}
	}

}
