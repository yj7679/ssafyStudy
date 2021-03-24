package D3;

import java.util.Scanner;

public class euiseok {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int T = sc.nextInt();
		sc.nextLine();
		for (int i = 0; i < T; i++) 
		{
			char [][] arr = new char[5][15];
			int test = i+1;
			
			for(int j=0; j<5;j++)
			{
				String s = sc.nextLine();
				for(int k =0; k<s.length();k++)
				{
					arr[j][k] = s.charAt(k);
				}
			}
			System.out.print("#"+test+" ");
			for(int j=0; j<15;j++)
			{
				for(int k =0; k<5;k++)
				{
					if(arr[k][j] == '\u0000')
					{
						continue;
					}
					else
					{
						System.out.print(arr[k][j]);
					}
				}
			}
			System.out.println("");
//			if(arr[1][4]=='\u0000')
//			{
//			System.out.println(arr[1][4]);
//			}
//			else
//			{
//				System.out.println("???");
//			}
		}

	}

}
