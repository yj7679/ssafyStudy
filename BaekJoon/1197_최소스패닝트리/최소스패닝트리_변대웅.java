import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.StringTokenizer;

public class 최소스패닝트리_변대웅 {
	static class Edge implements Comparable<Edge> {
		int from, to, weight;

		public Edge(int from, int to, int weight) {
			super();
			this.from = from;
			this.to = to;
			this.weight = weight;
		}

		@Override
		public int compareTo(Edge o) {
			return this.weight - o.weight;
		}

	}

	static int V, E;

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		V = Integer.parseInt(st.nextToken());
		E = Integer.parseInt(st.nextToken());
		ArrayList<Edge>[] nodes = new ArrayList[V + 1];
		int[] minEdge = new int[V + 1];
		boolean[] v = new boolean[V + 1];
		for (int i = 1; i <= V; i++) {
			nodes[i] = new ArrayList<Edge>();
			minEdge[i] = Integer.MAX_VALUE;
		}
		for (int i = 0; i < E; i++) {
			st = new StringTokenizer(br.readLine());
			int from = Integer.parseInt(st.nextToken());
			int to = Integer.parseInt(st.nextToken());
			int weight = Integer.parseInt(st.nextToken());

			nodes[from].add(new Edge(from, to, weight));
			nodes[to].add(new Edge(to, from, weight));
		}
		int result = 0;
		minEdge[1] = 0;
		// 최소간선 찾기
		for (int k = 0; k < V; k++) {
			int min = Integer.MAX_VALUE;
			int minIdx = 0;
			for (int i = 1; i <= V; i++) {
				if (!v[i] && min > minEdge[i]) {
					min = minEdge[i];
					minIdx = i;
				}
			}
			v[minIdx] = true;
			result += min;

			// 구성된 트리에서 노드들까지 가는 최단거리 minEdge update
			for (Edge edge : nodes[minIdx]) {
				minEdge[edge.to] = Math.min(minEdge[edge.to], edge.weight);
			}
		}
		System.out.println(result);
	}
}
