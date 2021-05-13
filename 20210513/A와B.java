import java.util.*;
import java.io.*;

public class A와B {
	static String S, T;
	static StringBuilder sb;
	static int result = 0;

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		S = br.readLine();
		T = br.readLine();
		sb = new StringBuilder(T);
		for (int i = 0; i < T.length() - S.length(); i++) {
			if (sb.charAt(sb.length() - 1) == 'A') {
				sb.setLength(sb.length() - 1);
			} else {
				sb.setLength(sb.length() - 1);
				sb.reverse();
			}
		}
		System.out.println(S.equals(sb.toString()) ? 1 : 0);
	}

}
