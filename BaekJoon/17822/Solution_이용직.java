import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;

//원판 돌리기 - 시뮬레이션

public class Main {
	static int[][] map,v;
	static int N,M,T;
	static int[] dx = {0,1,-1,0};
	static int[] dy = {1,0,0,-1};
	static class Point{
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
		M = Integer.parseInt(str[1]);
		T = Integer.parseInt(str[2]);
		int[][] opers = new int[T][3];
		map = new int[N][M];
		for (int i = 0; i < N; i++) {
			str = br.readLine().split(" ");
			for (int j = 0; j < M; j++) {
				map[i][j] = Integer.parseInt(str[j]);
			}
		}
		//print(map);
		for (int i = 0; i < T; i++) {
			str = br.readLine().split(" ");
			for (int j = 0; j < 3; j++) {
				opers[i][j] = Integer.parseInt(str[j]);
			}
		}
		//print(opers);
		
//		print(map);
//		System.out.println("--------------");
//		lotate(1-1,1,1); // 번호, 방향, 횟수
//		print(map);
//		System.out.println("---------------");
//		erase();
//		print(map);
//		erase();
//		System.out.println("----------");
//		print(map);
		for(int i=0; i<T; i++) {
//			System.out.println("시작");
//			print(map);
//			
			lotate(opers[i][0]-1, opers[i][1],opers[i][2]);
//			System.out.println("돌렸음");
//			print(map);
//			System.out.println("지우기 시작");
			erase(); // 필요한게 없음
//			System.out.println("끝");
//			print(map);
//			System.out.println("------------");
		}
		int Ans = sumMap();
		System.out.println(Ans);
}
	private static int sumMap() {
		int sum=0;
		for(int i=0; i<N; i++) {
			for(int j=0; j<M; j++) {
				sum+=map[i][j];
			}
		}
		return sum;
	}
	private static void erase() {
		boolean flag = false;
		//여기!
		v = new int[N][M];
		
		Queue<Point> q = new LinkedList<>();
		
		for(int i=0; i<N;i++) {
			for(int j=0;j<M; j++) {
				q.add(new Point(i,j));
				

				while(!q.isEmpty()) {
					Point p = q.poll();
				
					for(int d=0; d<4; d++) {
						int nx = p.x+dx[d];
						int ny = (p.y+dy[d])%M;
						if(ny==-1) {
							ny = M-1;
						}
						if(nx>=0 &&ny<M && nx<N && map[p.x][p.y]!=0 &&v[nx][ny]==0 &&  map[nx][ny]==map[p.x][p.y]) {
							v[p.x][p.y] =1;
							flag =true;
							v[nx][ny]=1;
							q.add(new Point(nx,ny));
						}
						
					}
				}
			}
		}
//		System.out.println("지울부분 체크");
//		print(v);
		for(int i=0; i<N; i++) {
			for(int j=0; j<M;j++) {
				if(v[i][j]==1) {
					map[i][j]=0;
				}
			}
		}
		//지울게 없었으면 flag ==false이므로 평균으로 연산하는 것하기
		if(flag==false) {
			//평균계산
			int numcnt=0;
			int sum=0;
			for(int i=0; i<N; i++) {
				for(int j=0; j<M;j++) {
					if(map[i][j] !=0) {
						numcnt++;
						sum+=map[i][j];
					}
				}
			}
			double ave = (double)sum / (double)numcnt;
			for(int i=0; i<N; i++) {
				for(int j=0; j<M;j++) {
					if(map[i][j] !=0 && (double)map[i][j]>ave) {
						map[i][j]--;
					}
					else if(map[i][j] !=0 && (double)map[i][j]<ave) {
						map[i][j]++;
					}
				}
			}
			
		}
		
	}
	private static void lotate(int idx, int d, int count) {
		int cnttemp=count;
		//시계방향 - 마지막꺼 뽑아서 뒤에서부터 땡겨넣음
		if(idx==0) {
			if(d==0) {
				while(--count>=0) {
					int temp = map[idx][M-1];
					for(int i=M-1; i>=1;i--) {
						map[idx][i] = map[idx][i-1];
					}
					map[idx][0]=temp;
				}
			}
			else if(d==1) {
				while(--count>=0) {
					int temp = map[idx][0];
					for(int i=0; i<M-1;i++) {
						map[idx][i] = map[idx][i+1];
					}
					map[idx][M-1] = temp;
				}
			}
		}
		//인덱스가 0이 아닌 경우
		else {
			//idx=1인경우
			int idxtemp= idx+1; //3
			int idxtemp2=idx+1; //3
			while(idxtemp<=N) {// 3<=4
				count = cnttemp;

				idx = idxtemp-1;
				if(d==0) {
					while(--count>=0) {
						int temp = map[idx][M-1];
						for(int i=M-1; i>=1;i--) {
							map[idx][i] = map[idx][i-1];
						}
						map[idx][0]=temp;
					}
				}
				else if(d==1) {
					while(--count>=0) {
						int temp = map[idx][0];
						for(int i=0; i<M-1;i++) {
							map[idx][i] = map[idx][i+1];
						}
						map[idx][M-1] = temp;
					}
				}
				idxtemp += idxtemp2; // 4= 2+2
			
			}
		}
	}
	private static void print(int[][] map2) {
		for (int i = 0; i < map2.length; i++) {
			for (int j = 0; j < map2[0].length; j++) {
				System.out.print(map2[i][j] + " ");
			}
			System.out.println();
		}
		
	}
}
