package D3;

import java.util.Arrays;
import java.util.Scanner;

public class Memory {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int T = sc.nextInt();
		sc.nextLine();
		for(int i=0;i<T;i++)
		{
			int test = i+1;
			int cnt =0;
			String N = sc.nextLine();
			int[] arr = new int[N.length()];
			int[] re = new int[N.length()];
			
			for(int j=0;j<N.length();j++)
			{
				arr[j] = Character.getNumericValue(N.charAt(j));
			}
			for(int j=0;j<N.length();j++)
			{
				if(Arrays.equals(arr, re))
				{
					break;
				}
				if(arr[j] != re[j])
				{
					for(int k=j;k<N.length();k++)
					{
						re[k] = arr[j];
					}
					cnt++;
				}
			}
			
			System.out.println(cnt+"번");
			
		}

	}

}
