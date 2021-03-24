import java.io.*;
import java.util.*;

// 숨바꼭질4
public class Solution_정지홍 {

	static int N, K, max;
	static int[] map;
	static int[] v;
	static HashMap<Integer, Integer> move = new HashMap<>();

	public static void main(String args[]) throws IOException {
		System.setIn(new FileInputStream("input.txt"));
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());

		N = Integer.parseInt(st.nextToken());
		K = Integer.parseInt(st.nextToken());
		max = Math.max(N, K);
		map = new int[max * 2 + 1];
		v = new int[max * 2 + 1];
		bfs();
	}

	private static void bfs() {
		Queue<Integer> q = new LinkedList<Integer>();
		v[N] = 0;
		q.offer(N);
		
		while(!q.isEmpty()) {
			int cur = q.poll();
			if(cur == K) {
				Stack<Integer> st = new Stack<>();
				System.out.println(v[K]);
				while(move.size() > 0 && cur != N) {
					st.push(cur);
					cur = move.get(cur);
				}
				st.push(cur);
				while(!st.isEmpty()) {
					System.out.print(st.pop() + " ");
				}
				break;
			}
			
			if(cur+1 <= max * 2 && v[cur+1] == 0) {
				v[cur+1] = v[cur] + 1;
				q.offer(cur+1);
				move.put(cur+1, cur);
			} if(cur-1 >= 0 && v[cur-1] == 0) {
				v[cur-1] = v[cur] + 1;
				q.offer(cur-1);
				move.put(cur-1, cur);
			} if(cur * 2 <= max * 2 && v[cur*2] == 0) {
				v[cur*2] = v[cur] + 1;
				q.offer(cur*2);
				move.put(cur*2, cur);
			}
		}
	}
}