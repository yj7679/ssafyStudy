package BaekJun;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

public class MemorizeWord {

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		String[] s = br.readLine().split(" "); 
		int N = Integer.parseInt(s[0]);
		int M = Integer.parseInt(s[1]);
		int alpha = (1<<26)-1;
		boolean[] visit = new boolean[26];
		int[] word = new int[N];
		
		for(int i=0;i<N;i++)
		{
			String ss = br.readLine();
			for(int j=0;j<ss.length();j++)
			{
				word[i] |= 1<<(ss.charAt(j)-'a');
			}
		}
		for(int i=0;i<M;i++)
		{
			int cnt=0;
			s = br.readLine().split(" ");
			int o = Integer.parseInt(s[0]);
			char x = s[1].charAt(0);
			if(o==1)
			{
				alpha = alpha ^ (1<<x-'a');
			}
			else
			{
				alpha = alpha | (1<<x-'a');
			}
			for(int j=0;j<N;j++)
			{
				if((word[j] & alpha) >=word[j])
				{
					cnt++;
				}
			}
			System.out.println(cnt);
		}
//		System.out.println(Integer.toBinaryString(word[0]));

	}

}
