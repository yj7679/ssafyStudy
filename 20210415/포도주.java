import java.util.Arrays;
import java.util.Scanner;

public class 포도주 {

	public static void main(String[] args) {

		Scanner sc = new Scanner(System.in);

		int T = sc.nextInt();
		int[] arr = new int[T];
		int[] DP = new int[T];
		
		for (int i = 0; i < T; i++) {
			arr[i] = sc.nextInt();
		}
		
		if(T == 1) System.out.println(arr[0]);
		
		else if(T == 2) System.out.println(arr[0] + arr[1]);
		
		else {
			DP[0] = arr[0];
			DP[1] = arr[0] + arr[1];
			//3번째 잔의 경우의 수 3가지 중에 최댓값 뽑기
			DP[2] = Math.max(DP[1], Math.max(arr[0]+arr[2], arr[1]+arr[2]));
			//4번째 잔부터
			for (int i = 3; i < T; i++) {
				DP[i] = Math.max(DP[i-2] + arr[i], DP[i-3] + arr[i] + arr[i-1]);
				//뒤에보다 앞이 더 클 경우에 앞을 넣어준다
				System.out.println(Arrays.toString(DP));
				DP[i] = Math.max(DP[i], DP[i-1]);
			}
		
			System.out.println(DP[T-1]);
		}
	}

}
