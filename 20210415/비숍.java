import java.util.*;
import java.io.*;

public class 비숍 {
	static int N;
	static List<int[]>[] empty;
	static boolean[][] put;
	static int[] result;
	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		N = Integer.parseInt(br.readLine());
		empty = new ArrayList[2];
		empty[0] = new ArrayList<>();
		empty[1] = new ArrayList<>();
		for (int i = 0; i < N; i++) {
			StringTokenizer st = new StringTokenizer(br.readLine());
			for (int j = 0; j < N; j++) {
				if (Integer.parseInt(st.nextToken()) == 1) {
					if(i % 2 == 0) {
						if(j % 2 == 0)
							empty[0].add(new int[] {i, j});
						else
							empty[1].add(new int[] {i, j});
					}
					else {
						if(j % 2 == 0)
							empty[1].add(new int[] {i, j});
						else
							empty[0].add(new int[] {i, j});
					}
				}
			}
		}
		result = new int[2];
		put = new boolean[2][];
		put[0] = new boolean[empty[0].size()];
		put[1] = new boolean[empty[1].size()];
		
		solve(0, empty[0], 0, 0);
		solve(1, empty[1], 0, 0);
		System.out.println(result[0] + result[1]);
	}
	private static void solve(int t, List<int[]> empty, int idx, int count) {
		if(idx == empty.size()) {
			result[t] = Math.max(result[t], count);
			return;
		}
		if(count + empty.size() - idx < result[t])
			return;
		// idx번째 칸에 놓기
		if(check(idx, t)) {
			solve(t, empty, idx + 1, count + 1);
			unCheck(idx, t);
		}
		// idx번째 칸에 안놓기
		solve(t, empty, idx + 1, count);
	}
	private static void unCheck(int idx, int t) {
		put[t][idx] = false;
	}
	
	private static boolean check(int idx, int t) {
		int[] cur = empty[t].get(idx);
		for(int i = 0; i < idx; i++) {
			if(!put[t][i])
				continue;
			else {
				int[] loc = empty[t].get(i);
				if(Math.abs(cur[0] - loc[0]) == Math.abs(cur[1] - loc[1]))
					return false;
			}
		}
		put[t][idx] = true;
		return true;
	}

}
