package 스터디문제;

import java.util.*;
import java.io.*;

public class BJ_1941소문난칠공주 {
	
	static int ans;
	static char[][] map;
	static int[] arr, check;
	
	public static void main(String[] args) throws Exception {
		System.setIn(new FileInputStream("소문난칠공주.txt"));
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		String str = new String();
		
		map = new char[5][5];
		check = new int[25];
		arr = new int[25];
		
		for (int r = 0; r < 5; r++) {
			str = br.readLine();
			for (int c = 0; c < 5; c++) {
				map[r][c] = str.charAt(c);
				int idx = r * 5 + c;
				arr[idx] = idx;
				if (map[r][c] == 'S') check[idx] = 1;
			}
		}

		combination(new int[7], 0, 0);
		
		System.out.println(ans);
	}

	private static void combination(int[] sel, int k, int idx) {
		if (k == sel.length) {
			int s = 0;
			for (int i = 0; i < sel.length; i++) {
				s += check[sel[i]];
			}
			if (s >= 4) ans++;
			return;
		}
		
		for (int i = idx; i < arr.length; i++) {
			if (k == 0) sel[k] = arr[i];
			else {
				for (int j = 0; j < k; j++) {
					if ((i - sel[j]) == 1 || (i - sel[j] == 5)) {
						sel[k] = arr[i];
						combination(sel, k + 1, i + 1);
					}
				}
			}
		}
		
	}


}
