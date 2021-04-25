import java.util.*;
import java.io.*;

public class DDR2342 {
	static int[] arr;
	static int[][][] dp;
	static int size;
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		arr = new int[100001];
		dp = new int[5][5][100001];
		for (size = 1; size < 200000; size++) {
			int num = Integer.parseInt(st.nextToken());
			if (num == 0)
				break;
			arr[size] = num;
		}
		size--;
		System.out.println(dfs(1, 0, 0));
	}

	private static int dfs(int idx, int l, int r) {
		if(idx == size + 1) {
			return 0;
		}
		if(dp[l][r][idx] != 0)
			return dp[l][r][idx];
		int num = arr[idx];
		int result = Math.min(getCost(l, num) + dfs(idx + 1, num, r), getCost(r, num) + dfs(idx + 1, l, num));
		dp[l][r][idx] = result;
		return result;
	}

	private static int getCost(int i, int num) {
		int cost = 0;
		if(i == 0)
			cost =  2;
		else if(i == num)
			cost = 1;
		else if(Math.abs(i - num) == 2)
			cost = 4;
		else
			cost = 3;
		return cost;
	}

}
