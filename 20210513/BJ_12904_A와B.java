import java.io.*;
import java.util.*;

public class BJ_12904_A와B {

	static String S, T;

	public static void main(String[] args) throws Exception {
		System.setIn(new FileInputStream("input.txt"));
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		S = br.readLine();
		T = br.readLine();
		String tmp = T;
		int times = T.length() - S.length();

		for (int i = 0; i < times; i++) {
			// T의 마지막 문자가 A라면
			if (tmp.charAt(tmp.length()-1) == 'A') {
				tmp = tmp.substring(0, tmp.length()-1);
			}
			// T의 마지막 문자가 B라면
			else {
				tmp = tmp.substring(0, tmp.length()-1);
				tmp = (new StringBuffer(tmp)).reverse().toString();
			}
		}
		
		if(tmp.equals(S)) System.out.println(1);
		else		 System.out.println(0);
	}
}
