import java.util.*;
import java.io.*;

public class 단어암기 {
	static int N, M, count;
	static int[][] infos;

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());
		infos = new int[N][2];
		for (int i = 0; i < N; i++) {
			char[] chrs = br.readLine().toCharArray();
			for (char c : chrs) {
				infos[i][0] = add(infos[i][0], c);
			}
			infos[i][1] = infos[i][0];
		}
		count = N;
		for (int i = 0; i < M; i++) {
			st = new StringTokenizer(br.readLine());
			int command = Integer.parseInt(st.nextToken());
			char c = st.nextToken().charAt(0);
			check(command, c);
			System.out.println(count);
		}
	}

	private static void check(int command, char c) {
		if (command == 1) {
			for (int i = 0; i < N; i++) {
				if (contain(infos[i][0], c)) {
					if (infos[i][0] == infos[i][1])
						count--;
					infos[i][1] = remove(infos[i][1], c);
				}
			}
		} else if (command == 2) {
			for (int i = 0; i < N; i++) {
				if (contain(infos[i][0], c)) {
					infos[i][1] = add(infos[i][1], c);
					if (infos[i][0] == infos[i][1])
						count++;
				}
			}
		}
	}

	private static int remove(int k, char c) {
		k -= (1 << (c - 'a'));
		return k;
	}

	private static boolean contain(int k, char c) {
		if ((k & (1 << (c - 'a'))) > 0)
			return true;
		return false;
	}

	private static int add(int k, char c) {
		k |= (1 << (c - 'a'));
		return k;
	}

}
