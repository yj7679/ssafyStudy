package day0306;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.Queue;

//숨바꼭질4 - BFS 최단거리 + BFS찾아온 경로 찍기(다음 위치를 저장하는 배열 넣기)
public class BJ13913 {
	static int N,K;
	static int[] check=new int[100001];
	static int[] nextInfo=new int[100001];
	static int[] ans;
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		String[] str= br.readLine().split(" ");
		N = Integer.parseInt(str[0]);
		K = Integer.parseInt(str[1]);

		int cnt = bfs();
		System.out.println(cnt);
		//print(check);
		int nextIdx=K;
		int idx=1;
		int[] ans = new int[cnt+1];
		ans[0]=K;
		while(nextIdx!=N) {
			ans[idx++] = nextInfo[nextIdx];
			nextIdx = nextInfo[nextIdx];
		}
		StringBuilder sb = new StringBuilder("");
		for(int i=cnt;i>=0;i--) {
			sb.append(ans[i]+" ");
		}
		System.out.println(sb);



		//stack overflow생김
//		dfs(K,new int[cnt],0);
//
//		for(int i=0; i<cnt+1; i++) {
//			System.out.print(ans[i]+" ");
//		}
		
		
		
	}

	private static void dfs(int x, int[] sel, int k) {
		if(check[x]==0) {
			for(int i=0;i<k;i++) {
				ans[i] = sel[k-1-i];
			}
			return;
		}
		if(k==sel.length) {
			return;
		}

		if(x%2==0 && check[x/2]==check[x]-1) {
			sel[k] = x/2;
			dfs(x/2,sel,k+1);
			return;
		}
		if(x-1>=0 && check[x-1]==check[x]-1) {
			sel[k] = x-1;
			dfs(x-1,sel,k+1);
			return;
		}
		if(x+1 <=100000 && check[x+1]== check[x]-1) {
			sel[k] = x+1;
			dfs(x+1,sel,k+1);
			return;
		}

	}

	private static void print(int[] check2) {
		for (int i = 0; i < 30; i++) {
			System.out.print(check[i]+" ");
		}
		System.out.println();
	}
	private static int bfs() {
		Queue<Integer> q = new LinkedList<>();
		q.add(N);
		check[N]=0;
		
		while(!q.isEmpty()) {
			int x= q.poll();

			
			if(x==K) {
				check[K]=check[x];
				return check[K];
			}
			
			if(x+1!=N &&x+1 <=100000 && check[x+1]==0) {
				q.add(x+1);
				check[x+1] = check[x]+1;
				nextInfo[x+1]=x;
			}
			if(x-1!=N && x-1>=0&& check[x-1]==0) {
				q.add(x-1);
				check[x-1] = check[x]+1;
				nextInfo[x-1]=x;
			}
			if(2*x!=N && 2*x<=100000 && check[2*x]==0) {
				q.add(2*x);
				check[2*x] = check[x]+1;
				nextInfo[2*x] = x;
			}
			
			
			
		}
		q.clear();
		return check[K];
		
	}

}
