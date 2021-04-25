import java.util.*;
import java.io.*;

public class MooTube {
	static int N, Q;
	static ArrayList<Edge>[] adjList;
	static int count;

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

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		N = Integer.parseInt(st.nextToken());
		Q = Integer.parseInt(st.nextToken());
		adjList = new ArrayList[N + 1];
		for (int i = 1; i <= N; i++)
			adjList[i] = new ArrayList<Edge>();

		for (int i = 0; i < N - 1; i++) {
			st = new StringTokenizer(br.readLine());
			int from = Integer.parseInt(st.nextToken());
			int to = Integer.parseInt(st.nextToken());
			int cost = Integer.parseInt(st.nextToken());
			adjList[from].add(new Edge(to, cost));
			adjList[to].add(new Edge(from, cost));
		}

		for (int i = 0; i < Q; i++) {
			st = new StringTokenizer(br.readLine());
			int k = Integer.parseInt(st.nextToken());
			int v = Integer.parseInt(st.nextToken());
			count = bfs(k, v);
			System.out.println(count);
		}
	}

	private static int bfs(int k, int v) {
		int count = -1;
		Queue<Edge> q = new LinkedList<>();
		q.offer(new Edge(v, Integer.MAX_VALUE));
		boolean[] visit = new boolean[N + 1];

		while (!q.isEmpty()) {
			Edge nextEdge = q.poll();
			visit[nextEdge.to]= true;
			if(nextEdge.cost >= k)
				count++;
			for(Edge e : adjList[nextEdge.to]) {
				if(!visit[e.to])
					q.offer(new Edge(e.to, Math.min(e.cost, nextEdge.cost)));
			}
			
		}
		return count;
	}

}
