package ssafy;

import java.util.Scanner;
import java.io.FileInputStream;

class Solution
{
	static int lim=0;
	static int[] boxs = new int[100];
	static int cnt=0;
	static int temp;
	static int[] dx = {-1,-1,0,1,1,1,0,-1};
	static int[] dy = {0,1,1,1,0,-1,-1,-1};
	public static void main(String args[]) throws Exception
	{
		//System.setIn(new FileInputStream("inputs/input.txt"));

		/*
		   표준입력 System.in 으로부터 스캐너를 만들어 데이터를 읽어옵니다.
		 */
		Scanner sc = new Scanner(System.in);
		int T;
		T=sc.nextInt();
		/*
		   여러 개의 테스트 케이스가 주어지므로, 각각을 처리합니다.
		*/


		//T=10;
		for(int test_case = 1; test_case <= T; test_case++)
		{
			int N = sc.nextInt();
			int M = sc.nextInt();
			char[][] table = new char[N][N];
			
			  for(int i=0; i<N; i++) { for(int j=0; j<N; j++) { table[i][j] =' '; } }
			 

			for(int i= 0; i<2; i++) {
				for(int j=0; j<2; j++) {
					if(i==j) table[(N-1)/2+i][(N-1)/2+j] = 'W';
					else table[(N-1)/2+i][(N-1)/2+j] = 'B';
				}
			}

			
			for(int i=0; i<M; i++) {
				int y = sc.nextInt();
				int x= sc.nextInt();
				int doll = sc.nextInt();
				int nx = 0;
				int ny = 0;
				x=x-1;
				y=y-1;
		
				//흑돌 차례
				if(doll==1) {
					table[x][y]='B';
					//8방탐색
					for(int d=0; d<8;d++) {
						nx = x+dx[d];
						ny = y+dy[d];
						boolean flag = false;
						//백돌만나면 그방향으로 탐색 일자로 감
						if(nx>=0 && ny>=0 && nx<N && ny<N && table[nx][ny]=='W') {
							//일자탐색
							for(int st=1; nx>=0 &&nx<N && ny>=0 && ny<N&&table[nx][ny]!=' '; st++) {
								nx = x + dx[d]*st;
								ny = y + dy[d]*st;
								//일자탐색하다가 B만남
								if(nx>=0&& ny>=0&&nx<N &&ny<N && table[nx][ny]=='B') {
									flag=true;
									break;
								}
							}
							nx = x;
							ny = y;
							//일자탐색하다가 B만나면 그쪽 방향으로 왔던거 다 W->B바꾸고 B를 만나는 경우 그만둔다.
							if(flag == true) {
								for(int st=1; nx>=0 &&nx<N &&ny>=0 &&ny<N &&table[nx][ny]!=' '; st++) {
									nx = x + dx[d]*st;
									ny = y + dy[d]*st;
	
									if(table[nx][ny]=='W') {
										table[nx][ny]='B';
									}
									else if(table[nx][ny]=='B') {
										break;
									}
								}
							}
							
						}
						
					}
					
				}
				//백돌차례
				else {
					table[x][y]='W';
					//8방탐색
					for(int d=0; d<8;d++) {
						nx = x+dx[d];
						ny = y+dy[d];
						boolean flag = false;
						//흑돌 만나면 그방향으로 탐색 일자로 감
						if(nx>=0 && ny>=0 && nx<N&& ny<N && table[nx][ny]=='B') {
							//일자탐색

							for(int st=1; nx>=0 &&nx<N&& ny>=0 && ny<N &&table[nx][ny]!=' '; st++) {
								nx = x + dx[d]*st;
								ny = y + dy[d]*st;

								if(nx>=0&& ny>=0&&nx<N &&ny<N&&table[nx][ny]=='W' &&table[nx][ny]!=' ') {
									flag=true;
									break;
								}
							}
							nx = x;
							ny = y;
							//일자탐색하다가 W만나면 그쪽 방향으로 왔던거 다 B->W바꾸고 W를 만나는 경우 그만둔다.
							if(flag == true) {

								for(int st=1; nx>=0 &&nx<N &&ny>=0 &&ny<N && table[nx][ny]!=' '; st++) {
									nx = x + dx[d]*st;
									ny = y + dy[d]*st;
								if(table[nx][ny]=='B') {
										table[nx][ny]='W';
									}
									else if(table[nx][ny]=='W') {
										break;
									}
								}
							}
							
						}
						
					}
					
				}
				

				
			}
			int Bcnt=0;
			int Wcnt=0;
			for(int i=0; i<N; i++) {
				for(int j=0 ; j<N; j++) {
					if(table[i][j] == 'W') Wcnt++;
					if(table[i][j] =='B') Bcnt++;
				}
			}
			System.out.print("#"+test_case + " ");
		
			System.out.println(Bcnt+" " + Wcnt);
			
			
		}
	}

		
}

	
