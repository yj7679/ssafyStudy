import java.util.Deque;
import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;
import java.util.Stack;

public class Solution_변대웅 {
	static class Location {
		int num;
		int count;
		Location prev;
		public Location(int num, int count, Location prev) {
			super();
			this.num = num;
			this.count = count;
			this.prev = prev;
		}
		
	}

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int n = sc.nextInt();
		int k = sc.nextInt();
		if(n >= k) {
			System.out.println(n-k);
			for(int i = n; i >= k; i--) {
				System.out.print(i + " ");
			}
			return;
		}
		bfs(n, k);
	}

	private static void bfs(int n, int k) {
		Queue<Location> q = new LinkedList<>();
		q.offer(new Location(n, 0, null));
		boolean[] v = new boolean[200001];
		v[n] = true;
		while (!q.isEmpty()) {
			Location current = q.poll();
			if(current.num == k) {
				System.out.println(current.count);
				Stack<Integer> history = new Stack<>();
				while(current != null) {
					history.push(current.num);
					current = current.prev;
				}
				while(!history.isEmpty()) {
					System.out.print(history.pop() + " ");
				}
				break;
			}
			if(current.num + 1 < v.length && !v[current.num+1]) {
				q.offer(new Location(current.num + 1, current.count + 1, current));
				v[current.num + 1] = true;
			}
			if(current.num -1 >= 0 && !v[current.num-1]) {
				q.offer(new Location(current.num - 1, current.count + 1, current));
				v[current.num - 1] = true;
			}
			if(current.num * 2 < v.length && !v[current.num * 2]) {
				q.offer(new Location(current.num * 2, current.count + 1, current));
				v[current.num * 2] = true;
			}
		
		}
	}

}
