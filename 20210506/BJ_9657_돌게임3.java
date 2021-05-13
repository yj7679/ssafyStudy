import java.io.*;
import java.util.*;

// 돌 게임3

public class BJ_9657_돌게임3 {

	static int N;
	static boolean[] arr = new boolean[1001];

	public static void main(String[] args) throws Exception {
		System.setIn(new FileInputStream("input.txt"));
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		N = Integer.parseInt(st.nextToken());

		// 상근이가 이길 수 있을 때 true
		arr[1] = true;
		arr[3] = true;
		arr[4] = true;
		
		for (int i = 5; i <= N; i++) {
			if(!arr[i-1] || !arr[i-3] || !arr[i-4]) {	// 창영이가 질 수 있는 경우가 하나라도 있다면
				arr[i] = true;
			}
		}
		
		String res = arr[N] ? "SK" : "CY";
		System.out.println(res);
	}
}