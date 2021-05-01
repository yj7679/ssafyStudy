package day0428;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.StringTokenizer;

//특정한 최단 경로 - 다익스트라 : 최단경로
public class BJ1504 {
	static int N,E;
	static int[][] adjM= null;
	static int need1;
	static int need2;
	static int INF = Integer.MAX_VALUE/4;
	static int ans = INF;
	static class Edge{
		int to, w;

		public Edge(int to, int w) {
			super();
			this.to = to;
			this.w = w;
		}
		
		
		
	}
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		StringTokenizer st = new StringTokenizer(br.readLine()," ");
		
		N = Integer.parseInt(st.nextToken());
		E = Integer.parseInt(st.nextToken());
		
		adjM = new int[N+1][N+1];

		
		for(int i=0; i<E;i++) {
			st = new StringTokenizer(br.readLine()," ");
			int from =Integer.parseInt(st.nextToken()); 
			int to =Integer.parseInt(st.nextToken()); 
			int w =Integer.parseInt(st.nextToken()); 
			adjM[from][to]=w;
			adjM[to][from]=w;
		}
		
		for(int i=1;i<=N;i++) {
			for(int j=i+1;j<=N;j++) {
				if(adjM[i][j]==0) {
					adjM[i][j]=INF;
					adjM[j][i]=INF;
				}
				
			}
		}
		st = new StringTokenizer(br.readLine()," ");
		
		need1 = Integer.parseInt(st.nextToken());
		need2 = Integer.parseInt(st.nextToken());
	
	
		for(int k = 1; k <= N; k++) {
			for(int i = 1; i <= N; i++) {
				for(int j = 1; j <= N; j++) {
					if( adjM[i][k] != INF && adjM[k][j] != INF)
						adjM[i][j] = Math.min(adjM[i][j], adjM[i][k] + adjM[k][j]); 
				}
			}
		}
		
		// 1->need1 -> need2 -> destination
		// 1->need2 -> need1 -> destination
		
		int temp1 = adjM[1][need1]+adjM[need1][need2]+adjM[need2][N];
		int temp2 = adjM[1][need2]+adjM[need2][need1]+adjM[need1][N];
		
		ans = Math.min(temp1,temp2);
		
		if(ans>=INF)
			System.out.println(-1);
		else {
			System.out.println(ans);
		}
	}


}
