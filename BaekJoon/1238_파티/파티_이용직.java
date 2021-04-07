import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

//파티 - 플로이드 와샬
public class Main {
	static int N,M,X;
	static int[][] adj;
	static final int INF = Integer.MAX_VALUE;
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		String[] str = br.readLine().split(" ");
		
		N = Integer.parseInt(str[0]);
		M = Integer.parseInt(str[1]);
		X = Integer.parseInt(str[2]);
		adj = new int[N+1][N+1];
		for(int i=0; i<M;i++) {
			str = br.readLine().split(" ");
			for(int j=0; j<3;j++) {
				int from = Integer.parseInt(str[0]);
				int to =Integer.parseInt(str[1]);
				int w = Integer.parseInt(str[2]);
				adj[from][to] = w;

			}
		}
		for(int i=1;i<=N;i++) {
			for (int j = 1; j <= N; j++) {
				if(i!=j && adj[i][j]==0) {
					adj[i][j]=INF;
				}
			}
		}
		//print(adj);
		for(int k=1; k<=N;k++) {
			for(int i=1;i<=N; i++) {
				for(int j=1;j<=N;j++) {
					if(adj[i][k]!=INF && adj[k][j]!=INF) {
						adj[i][j] = Math.min(adj[i][j], adj[i][k]+adj[k][j]);
					}
				}
			}
		}
		//print(adj);
		int max = Integer.MIN_VALUE;
		for(int i=1;i<=N;i++) {
			if(adj[i][X]+adj[X][i]>max) {
				max=adj[i][X]+adj[X][i];
			}
		}
		System.out.println(max);
		
		
	}
	private static void print(int[][] adj2) {
		for (int i = 1; i <=N; i++) {
			for (int j = 1; j <=N; j++) {
				System.out.print(adj2[i][j]+" ");
			}
			System.out.println();
		}
		
	}

}
