import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;

//뱀 - 시뮬+큐
public class Main {
	static int N, K,L;
	static int[][] map,v;
	//우,하,좌,상 순서
	static int[] dx= {0,1,0,-1};
	static int[] dy= {1,0,-1,0};
	static class Point{
		int x,y;

		public Point(int x, int y) {
			super();
			this.x = x;
			this.y = y;
		}
		
		
	}
	static class Oper{
		int t;
		char d;
		
		public Oper(int t, char d) {
			super();
			this.t = t;
			this.d = d;
		}
		
		
		
	}
	public static void main(String[] args) throws NumberFormatException, IOException {
		
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		N = Integer.parseInt(br.readLine());
		K = Integer.parseInt(br.readLine());
		String str[];
		map = new int[N+2][N+2];
		v = new int[N+2][N+2];
		//사과
		for(int i=0;i<K;i++) {
			str = br.readLine().split(" ");
			map[Integer.parseInt(str[0])][Integer.parseInt(str[1])]=1;
		}
		L =Integer.parseInt(br.readLine());
		Queue<Oper> q = new LinkedList<>();
		for(int i=0; i<L;i++) {
			str = br.readLine().split(" ");
			q.add(new Oper(Integer.parseInt(str[0]), str[1].charAt(0)));
		}
		int time=1;
		Queue<Point> sn = new LinkedList<>();
		sn.add(new Point(1,1));
		Point head = new Point(1,1);//머리는 1,1부터
		v[1][1]=1;
		int d =0; //오른쪽 시작
		//1초부터 시작
		while(true) {
			//System.out.println(time+ "초 시작");
			
			int nx = head.x+dx[d];
			int ny = head.y+dy[d];
			//d방향에 벽 또는 몸이 있는지 판단.
			if(nx==0 || ny==0 || nx==N+1 || ny==N+1 || v[nx][ny]==1) {
				//System.out.println("충돌");
				break;
			}
			//d방향에 사과있는지 판단. 있다 머리만 놓음 ,없다 머리 놓고 꼬리자름
			if(map[nx][ny]==1) {
				head.x = nx;
				head.y = ny;
				v[nx][ny]=1;
				sn.add(new Point(nx,ny));
				map[nx][ny]=0;
			}
			else if(map[nx][ny]==0) {
				head.x = nx;
				head.y = ny;
				v[nx][ny]=1;
				sn.add(new Point(nx,ny));
				Point tail = sn.poll();
				v[tail.x][tail.y]=0;
			}

			//print(v);
			//System.out.println("--------------");
			

			//System.out.println(time+ "초 끝");
			//n초 끝나면 바꿈
			if(!q.isEmpty()) {

				Oper temp = q.peek();
				if(temp.t==time) {
					//System.out.println(time+"초에 방향바꿨습니다.");
					if(temp.d=='D') {
						//System.out.println("오른쪽으로");
						d = (d+1)%4;
					}
					else if(temp.d=='L') {
						//System.out.println("왼쪽으로");
						d = (d+3)%4;
					}
					q.poll();
				}
			}

			time++;
		}
		System.out.println(time);
	
		
		
		
	}
	private static void print(int[][] v2) {
		for (int i = 0; i < v2.length; i++) {
			for (int j = 0; j < v2.length; j++) {
				System.out.print(v2[i][j]+" ");
			}
			System.out.println();
		}
		
	}

}
