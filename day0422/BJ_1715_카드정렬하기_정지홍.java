import java.io.*;
import java.util.*;

// 카드 정렬하기

public class BJ_1715_카드정렬하기_정지홍 {

	public static void main(String args[]) throws IOException {
		System.setIn(new FileInputStream("input.txt"));
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());

		int res = 0, tmp = 0;
		int N = Integer.parseInt(st.nextToken());
		PriorityQueue<Integer> pq = new PriorityQueue<>();
		for (int i = 0; i < N; i++) {
			st = new StringTokenizer(br.readLine());
			pq.add(Integer.parseInt(st.nextToken()));
		}
		while(pq.size() > 1) {
			tmp = pq.poll() + pq.poll();		// 가장 적은 숫자 카드 묶음 두 개를 묶는다
			res += tmp;
			pq.add(tmp);						// 묶여진 카드 더미를 다시 list에 넣는다
		}
		System.out.println(res);
	}
}