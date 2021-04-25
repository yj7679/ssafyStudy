import java.io.*;
import java.util.*;

// 단어 암기

public class Main {
	static int N, M, res;
	static int[] words;
	static char[][] query;
	static int check;

	public static void main(String args[]) throws IOException {
		//System.setIn(new FileInputStream("input.txt"));
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());
		words = new int[N];
		query = new char[M][2];
		
		for (int i = 0; i < N; i++) {
			String str = br.readLine();
			char[] c = str.toCharArray();
			for (int j = 0; j < c.length; j++) {
				words[i] |= (1 << c[j] - 'a');
			}
		}
		for (int i = 0; i < M; i++) {
			String str = br.readLine();
			query[i][0] = str.charAt(0);
			query[i][1] = str.charAt(2);
		}
		
		check = (1 << 27) - 1;
		
		for (int i = 0; i < M; i++) {
			if(query[i][0] == '1') { // 잊는다
				int key = 0;
				for (int j = 0; j < 26; j++) {
					if(j != query[i][1] - 'a') {
						key |= (1 << j);
					}
				}
				check &= key;
			} else {	// 기억해낸다
				check |= (1 << (query[i][1] - 'a'));
			}
			
			res = 0;
			for (int j = 0; j < N; j++) {	// 알고 있는 단어 개수를 뽑아낸다
				if((check & words[j]) == words[j]) ++res;
			}
			System.out.println(res);
		}
	}
}