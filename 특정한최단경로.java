import java.util.*;
import java.io.*;

public class 특정한최단경로 {
	static int N, E;
	static int[][] adjMat;

	static class Edge implements Comparable<Edge>{
		int to, cost;

		public Edge(int to, int cost) {
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
		E = Integer.parseInt(st.nextToken());
		adjMat = new int[N + 1][N + 1];

		for (int i = 0; i < E; i++) {
			st = new StringTokenizer(br.readLine());
			int from = Integer.parseInt(st.nextToken());
			int to = Integer.parseInt(st.nextToken());
			int cost = Integer.parseInt(st.nextToken());
			adjMat[from][to] = cost;
			adjMat[to][from] = cost;
		}
		st = new StringTokenizer(br.readLine());
		int v1 = Integer.parseInt(st.nextToken());
		int v2 = Integer.parseInt(st.nextToken());
		int center = dijkstra(v1, v2);
		if(center == -1)
			System.out.println(-1);
		else {
			int t1 = dijkstra(1, v1);
			int t2 = dijkstra(v2, N);
			if(t1 == -1 || t2 == -1) {
				System.out.println(-1);
				return;
			}
			int w1 = dijkstra(1, v2);
			int w2 = dijkstra(v1, N);
			if(w1 == -1 || w2 == -1) {
				System.out.println(-1);
				return;
			}
			System.out.println(Math.min((t1 + t2), (w1 + w2)) + center);
		}
	}

	private static int dijkstra(int from, int to) {
		PriorityQueue<Edge> pq = new PriorityQueue<>();
		pq.offer(new Edge(from, 0));
		boolean[] v = new boolean[N + 1];

		while (!pq.isEmpty()) {
			Edge edge = pq.poll();
			if(edge.to == to)
				return edge.cost;
			v[edge.to] = true;
			for (int i = 1; i <= N; i++) {
				if (adjMat[edge.to][i] > 0 && !v[i]) {
					pq.offer(new Edge(i, edge.cost + adjMat[edge.to][i]));
				}
			}
		}
		return -1;
	}

}
