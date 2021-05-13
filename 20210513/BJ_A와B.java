package 스터디문제;

import java.util.*;
import java.io.*;

/*첫째 줄에 S가 둘째 줄에 T가 주어진다. 
(1 ≤ S의 길이 ≤ 999, 2 ≤ T의 길이 ≤ 1000, S의 길이 < T의 길이)*/
public class BJ_A와B {

	static int ans;
	static String S, T;
	
	public static void main(String[] args) throws Exception {
		System.setIn(new FileInputStream("A와B.txt"));
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		S = new String();
		S = br.readLine();
		
		T = new String();
		T = br.readLine();
		
		int idx = T.length() - S.length();
		
		for (int i = 0; i < idx; i++) {
			if (T.charAt(T.length() - 1) == 'A') {
				T = T.substring(0, T.length() - 1);
			} else if (T.charAt(T.length() - 1) == 'B'){
				T = T.substring(0, T.length() - 1);
				T = reverse(T);
			}
		}
		
		if (T.equals(S)) ans = 1;
		else ans = 0;
		
		System.out.println(ans);
	}

	private static String reverse(String str) {
		return (new StringBuffer(str).reverse().toString());
	}

}
