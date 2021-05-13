import java.util.*;
import java.io.*;
public class 돌게임3 {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		String[] players = {"SK", "CY"};
		int numStones = sc.nextInt();
		
		//dp[n] : 돌이 n개로 시작할 때 먼저한애가 이기는지 지는지 (0 : 이김, 1 : 짐)
		int[] dp = new int[1001];
		dp[1] = 0;
		dp[2] = 1;
		dp[3] = 0;
		dp[4] = 0;
		
		for(int i = 5; i <= numStones; i++) {
			dp[i] = 1;
			if(dp[i-1] == 1)
				dp[i] = 0;
			if(dp[i-3] == 1)
				dp[i] = 0;
			if(dp[i-4] == 1)
				dp[i] = 0;
		}
		System.out.println(players[dp[numStones]]);
	}

}
