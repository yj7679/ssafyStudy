import java.util.*;
import java.io.*;

public class 도시분할계획 {
	static int N, M;
	static class Edge implements Comparable<Edge>{
		int to, cost;

		public Edge(int to, int cost) {
			super();
			this.to = to;
			this.cost = cost;
		}

		@Override
		public int compareTo(Edge o) {
			return cost - o.cost;
		}
	}
	
	static ArrayList<Edge>[] adjList;
	
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());
		adjList = new ArrayList[N+1];
		for(int i = 1; i <= N; i++)
			adjList[i] = new ArrayList<>();
		
		for(int i = 0; i < M; i++) {
			st = new StringTokenizer(br.readLine());
			int from = Integer.parseInt(st.nextToken());
			int to = Integer.parseInt(st.nextToken());
			int cost = Integer.parseInt(st.nextToken());
			adjList[from].add(new Edge(to, cost));
			adjList[to].add(new Edge(from, cost));
		}
		
		System.out.println(prim());
		
	}

	private static int prim() {
		PriorityQueue<Edge> pq = new PriorityQueue<>();
		pq.offer(new Edge(1, 0));
		boolean[] v = new boolean[N+1];
		int maxCost = 0;
		int count = 0;
		int result = 0;
		
		while(!pq.isEmpty()) {
			Edge edge = pq.poll();
			if(!v[edge.to]) {
				v[edge.to]= true;
				count++;
				maxCost = Math.max(maxCost, edge.cost);
				result += edge.cost;
				if(count == N)
					break;
				for(Edge e : adjList[edge.to]) {
					if(!v[e.to]) {
						pq.offer(e);
					}
				}
			}
		}
		return result - maxCost;
	}
}
