package day0505;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

//불켜기 - 2차원 UNION FIND
public class BJ11967 {
	static int N,M;
	static ArrayList<Room>[][] move;
	static int[][]  v,p;
	static class Room implements Comparable<Room>{
		int r,c;
		

		public Room(int r, int c) {
			super();
			this.r = r;
			this.c = c;
		}

		@Override
		public String toString() {
			return "Room [r=" + r + ", c=" + c + "]";
		}

		@Override
		public int compareTo(Room o) {
			int diff = this.r - o.r;
			return diff!=0 ? diff : this.c-o.c;
		}
		
		
	}
	static int[] dr= {-1,1,0,0};
	static int[] dc= {0,0,1,-1};
	static Queue<Room> q = new LinkedList<>();
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine()," ");
		
		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());
		move = new ArrayList[N+1][N+1];
		
		v = new int[N+1][N+1];
		p = new int[N+1][N+1];
		int ans=0;
		for(int i=1;i<=N; i++) {
			for (int j = 1; j <= N; j++) {
				move[i][j] = new ArrayList<>();
			}
		}
		for(int i=0;i<M;i++) {
			st = new StringTokenizer(br.readLine()," ");
			Room room1 = new Room(Integer.parseInt(st.nextToken()), Integer.parseInt(st.nextToken()));
			Room room2 = new Room(Integer.parseInt(st.nextToken()), Integer.parseInt(st.nextToken()));
			
			move[room1.r][room1.c].add(new Room(room2.r,room2.c));
		}
		
		q.add(new Room(1,1));
		//1,1은 불켜져있고 해당위치에서 시작함.
		v[1][1]=1;
		p[1][1]=1;
		int cnt=1;
		while(!q.isEmpty()) {
			int size= q.size();
			for(int s=0;s<size;s++) {
				Room room =q.poll();
				int r = room.r;
				int c = room.c;
				
				//r,c에서 켤수있는 방을 탐색해서 불킨다.
				for(Room nr : move[r][c]) {
					//불켜기. 불켰다고해서 그해당위치 갈 수 있는 것은 아니다.
					if(v[nr.r][nr.c]==0) {
						//System.out.println(nr.r+" "+nr.c+"켜기");
						v[nr.r][nr.c]=1;
						cnt++;
					}
					//킨곳을 기준으로 사방으로 닿을 수 있는 불켜진 길이 있어서 갈수 있었떤 곳이면 dfs로 다 방문한다.
					for(int d=0; d<4;d++) {
						int nnr = nr.r+dr[d];
						int nnc = nr.c+dc[d];
						//새롭게 불 킨 위치에서 사방 중에 한쪽의 불이켜져있고 갔떤곳이면
						if(nnr>=1 && nnc>=1 && nnc<=N && nnr<=N && v[nnr][nnc]==1 && p[nnr][nnc]==1) {
							p[nnr][nnc]=1;
							dfs(nnr,nnc);
							//System.out.println(nnr+" "+nnc+"로 가기");
							
						}
						
						
					}

				}
				//해당위치에서 불다켰다.
				
			/*	//4방탐색으로 한쪽방향에 불켜져있고 4방인접하면넣기
				for(int d=0; d<4;d++) {
					int nnr = r+dr[d];
					int nnc = c+dc[d];
					//불이 켜져있고 안갔던 곳이면 이동함
					if(nnr>=1 && nnc>=1 && nnc<=N && nnr<=N && v[nnr][nnc]==1 && p[nnr][nnc]==0) {
						p[nnr][nnc]=1;
						q.add(new Room(nnr,nnc));
						//System.out.println(nnr+" "+nnc+"로 가기");
						
					}
					
					
				}*/
			
			}
			
		}
		System.out.println(cnt);
		
	}

	private static void dfs(int r, int c) {
		p[r][c]=1;
		for(int d=0;d<4;d++) {
			int nr =r+dr[d];
			int nc =c+dc[d];
			if(nr>=1 && nc>=1 && nr<=N && nc<=N && v[nr][nc]==1 && p[nr][nc]==0) {
				p[nr][nc]=1;
				dfs(nr,nc);
				q.add(new Room(nr,nc));
			}
		}
		
	}

	private static boolean check(int r, int c, int r2, int c2) {
		if(Math.abs(r-r2)+Math.abs(c-c2)==1) {
			return true;
		}
		return false;
	}

}
