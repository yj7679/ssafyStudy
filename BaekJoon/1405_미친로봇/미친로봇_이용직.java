package day0314;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

//미친로봇- DFS 백트래킹
public class BJ1405 {
	static int N;
	static double[] prob = new double[4];
	static int[] dx= {-1,1,0,0};
	static int[] dy= {0,0,1,-1};
	static double ans=0;
	
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		String[] str= br.readLine().split(" ");
		N = Integer.parseInt(str[0]);
		for(int i=1; i<=4;i++) {
			prob[i-1]=Double.valueOf(str[i])/(double)100;
			//System.out.println(prob[i-1]);
		}
		
		int[][] v = new int[31][31];
		//중복허용하고 4개중에 N개뽑는것
		v[15][15]=1;
		dfs(15,15,1,N,v);
		
		System.out.println(ans);
	}

	private static void dfs(int x, int y, double p, int dep,int[][] v) {
		if(dep==0) {
			ans+=p;
			//print(v);
			//System.out.println("-----");
			return;
		}
		for(int d=0;d<4;d++) {
			if(v[x+dx[d]][y+dy[d]]==0) {
				v[x+dx[d]][y+dy[d]]=1;
				dfs(x+dx[d],y+dy[d],p*prob[d],dep-1,v);
				v[x+dx[d]][y+dy[d]]=0;
			}
		}
			
		
		
	}

	private static void print(int[][] v) {
		for (int i = 13; i < 18; i++) {
			for (int j = 13; j < 18; j++) {
				System.out.print(v[i][j]+" ");
			}
			System.out.println();
		}
	}


}
