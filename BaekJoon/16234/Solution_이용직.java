import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;

//인구이동 - 시뮬레이션 +BFS
public class Main {
	static int N,L,R;
	static int[][] land,check;
	static int[] dx = {-1,0,0,1};
	static int[] dy = {0,1,-1,0};
	private static class Point{
		int x,y;

		public Point(int x, int y) {
			super();
			this.x = x;
			this.y = y;
		}
		
		
	}
	
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		String[] str = br.readLine().split(" ");
		
		N = Integer.parseInt(str[0]);
		L = Integer.parseInt(str[1]);
		R = Integer.parseInt(str[2]);
		land = new int[N][N];

		for (int i = 0; i < N; i++) {
			str = br.readLine().split(" ");
			for (int j = 0; j < N; j++) {
				land[i][j] = Integer.parseInt(str[j]);
			}
		}
		//print(land);
		int ans=0;
		while(bfs()) {
			ans++;
		}

		System.out.println(ans);
		
		

		
	}
	private static boolean bfs() {
		//연합을 구분하기 위해서 만드는 맵
		check = new int[N][N];
		//연합 구분할 숫자
		int cnt=1;
		//BFS를 위한 큐
		Queue<Point> q = new LinkedList<>();
		//인구이동일어났는지 체크하기
		boolean ch=false;
		for(int i=0; i<N; i++) {
			for(int j=0; j<N; j++) {
				//이미 연합에 들어간 것이면 탐색할 필요없음
				if(check[i][j]!=0) continue;
				
				q.add(new Point(i,j));
				check[i][j]=cnt;
				while(!q.isEmpty()) {
					Point p = q.poll();
					
					for(int d=0; d<4;d++) {
						int nx = p.x+dx[d];
						int ny = p.y+dy[d];
						
					
						if(nx>=0 && ny>=0 && nx<N && ny<N && check[nx][ny]==0
								 && Math.abs(land[p.x][p.y] - land[nx][ny])>=L
								 && Math.abs(land[p.x][p.y] - land[nx][ny])<=R) {
							check[nx][ny]=cnt;
							q.add(new Point(nx,ny));
							ch=true; //연합이 하나라도 존재하면 인구이동있음
						}
					}
				}
				cnt++;
				
				
			}
		}
		cnt=cnt-1;
		//만들어진 check를 통해서 인구이동시키기.
		int[] sum = new int[cnt+1];
		int[] count = new int[cnt+1];
		int[] res= new int[cnt+1];
		for(int i=0; i<N; i++) {
			for(int j=0; j<N; j++) {
				sum[check[i][j]]+=land[i][j];
				count[check[i][j]]++;
			}
		}
		for(int i=1; i<=cnt;i++) {
			res[i] = sum[i]/count[i];
		}
		for(int i=0;i<N; i++) {
			for(int j=0; j<N; j++) {
				land[i][j] = res[check[i][j]];
			}
		}
		
		
		if(ch==true) return true;
		else return false;
	}
	private static void print(int[][] land2) {
		for (int i = 0; i < land2.length; i++) {
			for (int j = 0; j < land2.length; j++) {
				System.out.print(land2[i][j]+" ");
			}
			System.out.println();
		}
	}

}
