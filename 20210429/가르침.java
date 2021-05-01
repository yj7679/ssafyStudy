import java.util.*;
import java.io.*;

public class 가르침 {
	static int N, K;
	static int[] words;
	static List<Integer> indexes;
	static boolean[] selected;
	static int result = Integer.MIN_VALUE;

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		N = Integer.parseInt(st.nextToken());
		K = Integer.parseInt(st.nextToken());
		words = new int[N];
		indexes = new ArrayList<>();
		selected = new boolean[26];
		for (int i = 0; i < N; i++) {
			String s = br.readLine();
			words[i] = convertToBit(s);
		}
		if (K < 5)
			System.out.println(0);
		else {
			K -= 5;
			if(indexes.size() < K)
				System.out.println(N);
			else {
				select(0, 0, 0, 0);
				System.out.println(result);
			}
		}
	}

	private static void select(int idx, int cnt, int start, int key) {
		if(cnt == K) {
			int count = 0;
			for(int k = 0; k < N; k++) {
				if(check(words[k], key))
					count++;
			}
			result = Math.max(result, count);
		}
		for(int i = start; i < indexes.size(); i++) {
			int num = indexes.get(i);
			select(idx + 1, cnt + 1, i + 1, key | (1 << num));
		}
	}

	private static boolean check(int word, int key) {
		if((word & key) == word)
			return true;
		return false;
	}

	private static int convertToBit(String s) {
		int bit = 0;
		for (char c : s.toCharArray()) {
			if (c != 'a' && c != 'n' && c != 't' && c != 'i' && c != 'c') {
				bit |= 1 << (c - 'a');
				if (!selected[c - 'a']) {
					indexes.add(c - 'a');
					selected[c - 'a'] = true;
				}
			}
		}
		return bit;
	}

}
