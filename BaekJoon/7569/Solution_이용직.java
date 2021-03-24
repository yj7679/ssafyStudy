import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.io.BufferedReader;
import java.io.IOException;

//토마토 - 3차원BFS
public class Main {
	static int[] dx = {-1,1,0,0,0,0};
	static int[] dy = {0,0,1,-1,0,0};
	static int[] dz = {0,0,0,0,1,-1};
	static int N,M,H;
	static int[][][] map,days;
	static class Tomato{
		int z,x,y,day;

		public Tomato(int z, int x, int y, int day) {
			super();
			this.z = z;
			this.x = x;
			this.y = y;
			this.day = day;
		}
		
	}
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		String[] str =br.readLine().split(" ");
		M = Integer.parseInt(str[0]);
		N = Integer.parseInt(str[1]);
		H = Integer.parseInt(str[2]);
		map = new int[H][N][M];
		days = new int[H][N][M];
		for(int i=0; i<H ;i++) {
			for(int j=0; j<N; j++) {
				str = br.readLine().split(" ");
				for(int k=0; k<M; k++) {
					map[i][j][k] = Integer.parseInt(str[k]);
				}
			}
		}
		//print(map);
		bfs();
		int ans=0;
		for(int i=0; i<H ;i++) {
			for(int j=0; j<N; j++) {
				for(int k=0; k<M; k++) {
					ans = Math.max(ans, days[i][j][k]);
					if(days[i][j][k]==0 && map[i][j][k]!=-1) {
						System.out.println(-1);
//						print(map);
//						System.out.println("----------------");
//						print(days);
						return;
					}
				
				}
				
			}
		}
//		print(map);
//		System.out.println("----------------");
//		print(days);
		System.out.println(ans-1);

	}
	private static void bfs() {
		Queue<Tomato> q = new LinkedList<>();
		
		for(int i=0; i<H ;i++) {
			for(int j=0; j<N; j++) {
				for(int k=0; k<M; k++) {
					
					if(map[i][j][k]==1 && days[i][j][k]==0) {
						q.add(new Tomato(i,j,k,1));
						days[i][j][k] = 1;
						
						while(!q.isEmpty()) {
							Tomato t = q.poll();
							
							for(int d=0; d<6;d++) {
								int nx = t.x+dx[d];
								int ny = t.y+dy[d];
								int nz = t.z+dz[d];
								int nd = t.day+1;
								if(nx>=0 && ny>=0 && nz>=0 && nx<N && ny<M && nz <H && (days[nz][nx][ny]==0 ||nd < days[nz][nx][ny]) && map[nz][nx][ny]!=-1 &&map[nz][nx][ny]!=1) {
									q.add(new Tomato(nz,nx,ny,nd));
									days[nz][nx][ny] = nd;
									
								}
								
							}
							
						}
						
						
						
					}
					
				}
				
			}
		}
		
		
	}
	private static void print(int[][][] map2) {
		for(int i=0; i<H ;i++) {
			for(int j=0; j<N; j++) {
				for(int k=0; k<M; k++) {
					System.out.print(map2[i][j][k]+" ");
				}
				System.out.println();
			}
		}
		
	}

}
