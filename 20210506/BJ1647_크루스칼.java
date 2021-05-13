package day0505;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class BJ1647_크루스칼 {
	static int E,V;
	static int sum=0;
	static int max= 0;
	static int[] parent;
	static Edge[] edges;
	static class Edge implements Comparable<Edge>{
		int s,d,w;

		public Edge(int s,int d, int w) {
			super();
			this.s = s;
			this.d = d;
			this.w = w;
		}

		@Override
		public int compareTo(Edge o) {
			
			return this.w - o.w;
		}

		public Edge() {
			super();
		}
		
	}
	static boolean union(int a, int b) {
		int aSet = findSet(a);
		int bSet = findSet(b);
		if(aSet==bSet) {
			return false;
		}
		else {
			parent[bSet] = aSet;
			return true;
		}
		
	}
	static int findSet(int a) {
		if(a==parent[a]) {
			return a;
		}
		return parent[a] = findSet(parent[a]);
		
	}
	
	static void make() {
		for (int i = 1; i <= V; i++) {
			parent[i] = i;
		}
	}
	
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine()," ");
		
		V =Integer.parseInt(st.nextToken());
		E =Integer.parseInt(st.nextToken());
		
		parent= new int[V+1];
		make();
		edges = new Edge[E];

		for (int i = 0; i < E; i++) {
			st = new StringTokenizer(br.readLine()," ");
			int from =Integer.parseInt(st.nextToken());
			int to =Integer.parseInt(st.nextToken());
			int w =Integer.parseInt(st.nextToken());
			
			edges[i] = new Edge(from, to,w);
		}
		Arrays.sort(edges);
		
		
		int cnt=0;
		int sum=0;
		for(Edge e :edges) {
			if(cnt==V-1) {
				break;
			}
			
			//붙여지면
			if(union(e.s,e.d)) {
				cnt++;
				sum+=e.w;
				if(max<e.w) {
					max = e.w;
				}
			}
			
		}
		System.out.println(sum-max);
		

	}

}
