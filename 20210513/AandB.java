package BaekJun;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class AandB {

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		String S = br.readLine();
		String T = br.readLine();
		StringBuffer sb = new StringBuffer(T);
		int del = T.length();
		while(del > S.length())
		{
			char a = sb.charAt(del-1); 
			sb.deleteCharAt(del-1);
			if(a == 'B')
			{
				sb.reverse();
			}
			del--;
		}
//		System.out.println(sb.toString());
		String result = sb.toString();
		if(S.equals(result))
			System.out.println("1");
		else
			System.out.println("0");
	}

}
