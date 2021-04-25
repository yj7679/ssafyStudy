package BaekJun;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.Queue;


public class Mootube {
	static ArrayList<int[]>[] adj;	//인접 리스트
	static int N,Q;
	static int min;
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		String[] s = br.readLine().split(" "); 
		N = Integer.parseInt(s[0]);
		Q = Integer.parseInt(s[1]);
		adj = new ArrayList[N];
		
		for(int i=0;i<N;i++)
		{
			adj[i] = new ArrayList();
		}
		
		for(int i=0;i<N-1;i++)
		{
			s = br.readLine().split(" ");
			int p = Integer.parseInt(s[0]);
			int q = Integer.parseInt(s[1]);
			int r = Integer.parseInt(s[2]);
			adj[p-1].add(new int[] {q-1,r});
			adj[q-1].add(new int[] {p-1,r});
		}
//		for(int i=0;i<N;i++)
//		{
//			for (int j = 0; j < adj[i].size(); j++) {				
//				System.out.print(Arrays.toString(adj[i].get(j))+" ");
//			}
//			System.out.println();
//		}
		
		for(int i=0;i<Q;i++)
		{
			boolean[] visit = new boolean[N];
			int cnt=0;
			
			s = br.readLine().split(" ");
			int k = Integer.parseInt(s[0]);
			int v = Integer.parseInt(s[1]);
			visit[v-1] = true;
			Queue<Integer> q = new LinkedList<>();
			q.add(v-1);
			
			while(!q.isEmpty())
			{
				int view = q.poll();
				for(int j=0;j<adj[view].size();j++)
				{
					if(adj[view].get(j)[1] >=k && !visit[adj[view].get(j)[0]])	//처음 연결된곳과 K를 비교, K보다 작으면 큐에 안넣음
					{
						visit[adj[view].get(j)[0]] = true;
						q.add(adj[view].get(j)[0]);
						cnt++;
					}
				}
			}
			System.out.println(cnt);
		}
	}

}
