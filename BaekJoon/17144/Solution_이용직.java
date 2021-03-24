import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

//미세먼지 안녕! - 시뮬레이션
public class Main {
	static int R,C,T;
	static int[][] map,temp;
	static int[][] machine;
	static int[] dr= {-1,1,0,0};
	static int[] dc= {0,0,1,-1};
	

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		String[] str = br.readLine().split(" ");

		R = Integer.parseInt(str[0]);
		C = Integer.parseInt(str[1]);
		T = Integer.parseInt(str[2]);
		map = new int[R][C];
		machine = new int[2][2]; //2개 x,y좌표값
		int temp=0;
		for(int i=0; i<R; i++) {
			str = br.readLine().split(" ");
			for(int j=0; j<C; j++) {
				map[i][j] = Integer.parseInt(str[j]);
				if(map[i][j] == -1) {
					machine[temp][0]=i;
					machine[temp][1]=j;
					temp++;
				}
			}
		}
		
		//print(map);
		//루프 빠져나오면 T초 후 모습이다.
		while(--T>=0) {
			//확산
			map = diffusion();

			cleaning();

		}

		int ans = sumMap();
		System.out.println(ans);
		
	}
	


	private static int sumMap() {
		int sum=0;
		for(int i=0; i<R; i++) {
			for(int j=0; j<C;j++) {
				sum+=map[i][j];
			}
		}
		return sum+2;
	}



	private static void cleaning() {
		//위쪽 영역
		int startr = machine[0][0];
		int startc = machine[0][1];
		
		for(int i=startr-2; i>=0;i--) {
			map[i+1][0] = map[i][0];
		}
		
		for(int j=0;j<C-1;j++) {
			map[0][j] = map[0][j+1];
		}
		
		for(int i=1;i<=startr;i++) {
			map[i-1][C-1] = map[i][C-1];
		}
		
		for(int j=C-1;j>=2;j--) {
			map[startr][j]=map[startr][j-1];
			
		}
		map[startr][startc+1]=0;
		
		//아래쪽 영역
		startr = machine[1][0];
		startc = machine[1][1];
		
		for(int i=startr+2; i<R;i++) {
			map[i-1][0]= map[i][0];
		}
		for(int j=1;j<C;j++) {
			map[R-1][j-1] = map[R-1][j];
		}
		for(int i=R-1;i>startr;i--) {
			map[i][C-1] =map[i-1][C-1];
		}
		for(int j=C-1; j>1;j--) {
			map[startr][j]=map[startr][j-1];
		}
		map[startr][startc+1]=0;
		
		
	}



	private static int[][] diffusion() {
		temp= new int[R][C];
		temp[machine[0][0]][machine[0][1]]=-1;
		temp[machine[1][0]][machine[1][1]]=-1;
		for(int i=0; i<R; i++) {
			for(int j=0;j<C;j++) {
				if(map[i][j]!=-1 && map[i][j]!=0) {
					int dircnt=0;
					int difdust = map[i][j]/5;
					
					for(int d=0; d<4; d++) {
						int nr = i+dr[d];
						int nc = j+dc[d];
						//미세먼지가뿌려질 수 있는 방향
						if(nr>=0 && nc>=0 && nr<R && nc<C && map[nr][nc]!=-1) {
							dircnt++;
							temp[nr][nc]+=difdust;
							
						}
						
					}
					temp[i][j] += map[i][j] - difdust*dircnt;
	
					
				}
				
			}
		}
		
		
		
		return temp;
	}


	private static void print(int[][] map2) {
		for (int i = 0; i < R; i++) {
			for (int j = 0; j < C; j++) {
				System.out.print(map2[i][j] +" ");
			}
			System.out.println();
		}
		
	}

}
