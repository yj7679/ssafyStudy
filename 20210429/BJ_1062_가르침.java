import java.io.*;
import java.util.*;

// 가르침

public class BJ_1062_가르침 {
	static int N, K, res;
	static int alpha;
	static int[] words;
	public static void main(String[] args) throws Exception {
		System.setIn(new FileInputStream("input.txt"));
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		N = Integer.parseInt(st.nextToken());
		K = Integer.parseInt(st.nextToken());
		
		words = new int[N];
		for (int i = 0; i < N; i++) {
			String str = br.readLine();
			for (int c = 0; c < str.length(); c++) {
				words[i] |= (1 << (str.charAt(c) - 'a'));
			}
		}
		
		if(K < 5) {	// 만약 a n t i c 를 모두 배울 수 없다면
			System.out.println(0);
			System.exit(0);
		}
		
		// 아는 글자 체크하기
		alpha |= (1 << 'a' - 'a');
		alpha |= (1 << 'n' - 'a');
		alpha |= (1 << 't' - 'a');
		alpha |= (1 << 'i' - 'a');
		alpha |= (1 << 'c' - 'a');
		
		comb(0, 0, new int[K-5]);
		
		System.out.println(res);
	}
	private static void comb(int cnt, int start, int[] sel) {
		if(cnt == K - 5) {
			int max = 0;
			int tmp = alpha;
			// 배운 글자 체크하기
			for (int i = 0; i < sel.length; i++) {
				tmp |= (1 << sel[i]);
			}
			
			for (int i = 0; i < N; i++) {
				//System.out.println(Integer.toBinaryString(tmp));
				if(words[i] == (words[i] & tmp))
					++max;
			}
			res = Math.max(max, res);
			return;
		}
		for (int i = start; i < 26; i++) {
			sel[cnt] = i;
			comb(cnt+1, i+1, sel);
		}
	}
}