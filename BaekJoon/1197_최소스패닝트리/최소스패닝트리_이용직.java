import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;

//최소 스패닝 트리
public class Main {
	static int V,E;
	static int parents[];
	static Edge[] edges;
	static class Edge implements Comparable<Edge>{
		int from,to,weight;

		public Edge(int from, int to, int weight) {
			super();
			this.from = from;
			this.to = to;
			this.weight = weight;
		}

		@Override
		public int compareTo(Edge o) {
			return Integer.compare(this.weight, o.weight);
		}
	}
	
	static public void make() {
		for(int i=1; i<=V;i++) {
			parents[i]=i;
		}
	}
	static public int findSet(int a) {
		if(parents[a] ==a) return a;
		
		return parents[a]= findSet(parents[a]);
	}
	
	static public boolean union(int a, int b) {
		int aRoot = findSet(a);
		int bRoot = findSet(b);
		if(aRoot!=bRoot) {
			parents[bRoot] =aRoot;
			return true;
		}
		else return false;
		
	}
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		String[] str = br.readLine().split(" ");
		V = Integer.parseInt(str[0]);
		E = Integer.parseInt(str[1]);
		
		parents = new int[V+1];
		edges =new Edge[E];
		
		make();
		
		for(int i=0; i<E; i++) {
			str = br.readLine().split(" ");
			edges[i] = new Edge(Integer.parseInt(str[0]),Integer.parseInt(str[1]),Integer.parseInt(str[2]));
		}
		Arrays.sort(edges);
		int result=0;
		int cnt=0;
		//크루스칼 알고리즘 - 정렬된 간선의 웨이트로 차례로 연결
		for(int i=0; i<E;i++) {
			if(union(edges[i].from,edges[i].to)) {
				result+=edges[i].weight;
				if(++cnt==V-1)break;
			}
		}
		System.out.println(result);
		
		
		
	}
}
