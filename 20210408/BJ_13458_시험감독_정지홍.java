import java.io.*;
import java.util.*;

// 시험 감독

class BJ_13458_시험감독 {

	static int N, B, C;
	static long cnt = 0;
	static int[] A;
	
	public static void main(String[] args) throws Exception {
		System.setIn(new FileInputStream("input.txt"));
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		N = Integer.parseInt(st.nextToken());
		A = new int[N];
		st = new StringTokenizer(br.readLine());
		for (int i = 0; i < N; i++) {
			A[i] = Integer.parseInt(st.nextToken());
		}
		st = new StringTokenizer(br.readLine());
		B = Integer.parseInt(st.nextToken());
		C = Integer.parseInt(st.nextToken());

		for (int i = 0; i < N; i++) {
			A[i] -= B;		++cnt;	// 총감독관 수
			
//			while(A[i] > 0) {		// 모든 사람을 감독할 수 있을때까지 부감독관을 추가한다
//				A[i] -= C;	++cnt;
//			}
			
			if(A[i] > 0)
				cnt += A[i] % C == 0 ? A[i] / C : A[i] / C + 1; 
		}
		System.out.println(cnt);
	}
}