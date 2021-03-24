package D3;

import java.util.Scanner;

public class Noglasses {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int T = sc.nextInt();
		sc.nextLine();
		for (int i = 0; i < T; i++) 
		{
			int test = i+1;
			String s1 = sc.next();
			String s2 = sc.next();
			boolean flag = true;
			if(s1.length() == s2.length())
			{
				for(int j=0;j<s1.length();j++)
				{
					if(s1.charAt(j) == 'B')
					{
						if(s2.charAt(j) != 'B')
						{
							flag = false;
						}
					}
					else if(s2.charAt(j) == 'B')
					{
						if(s1.charAt(j) != 'B')
						{
							flag = false;
						}
					}
					else if(s1.charAt(j) == 'A' ||s1.charAt(j) == 'D' || s1.charAt(j) == 'O' || s1.charAt(j) == 'P' || s1.charAt(j) == 'Q' || s1.charAt(j) == 'R')
					{
						if(s2.charAt(j) == 'A' ||s2.charAt(j) == 'D' || s2.charAt(j) == 'O' || s2.charAt(j) == 'P' || s2.charAt(j) == 'Q' || s2.charAt(j) == 'R')
						{
							continue;
						}
						else
						{
							flag = false;
						}
					}
					else
					{
						if(s2.charAt(j) == 'A' ||s2.charAt(j) == 'D' || s2.charAt(j) == 'O' || s2.charAt(j) == 'P' || s2.charAt(j) == 'Q' || s2.charAt(j) == 'R'|| s2.charAt(j) == 'B')
						{
							flag = false;
						}
					}
				}
			}
			else
			{
				System.out.println("#"+test+" DIFF");
				continue;
			}
			if(flag == true)
			{
				System.out.println("#"+test+" SAME");
			}
			else
			{
				System.out.println("#"+test+" DIFF");
			}
		}

	}

}
