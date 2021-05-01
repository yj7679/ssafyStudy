import java.util.*;
import java.io.*;

public class BJ_1339단어수학 {

	static int N, ans;
	static int[] alpha, numbers;
	
	public static void main(String[] args) throws Exception {
		System.setIn(new FileInputStream("단어수학.txt"));
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		String str = new String();
		
		N = Integer.parseInt(st.nextToken());
		alpha = new int[26];	
		numbers = new int[26];
		
		for (int i = 0; i < N; i++) {
			str = br.readLine();
			for (int j = 0; j < str.length(); j++) {
				int idx = str.charAt(j) - 'A';
				int length = str.length();
				alpha[idx] += Math.pow(10, (length - j - 1));
			}
		}
		
		Arrays.sort(alpha);
		
		int idx = 9;
		for (int i = 25; i >= 0; i--) {
			if (alpha[i] == 0) continue;
			numbers[i] = alpha[i] * idx--;
		}
		
		calculate();
		System.out.println(ans);
	}

	private static void print(int[] alpha) {
		for (int i = 0; i < 26; i++) {
			System.out.print(alpha[i] + " ");
		}
		System.out.println();
		
	}

	private static void calculate() {
		for (int i = 0; i < 26; i++) {
			ans += numbers[i];
		}
	}
}
