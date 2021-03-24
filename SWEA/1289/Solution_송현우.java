import java.util.Scanner;
import java.io.FileInputStream;

class Solution
{
	public static void main(String args[]) throws Exception
	{
		Scanner sc = new Scanner(System.in);
		int T;
		T=sc.nextInt();

		for(int test_case = 1; test_case <= T; test_case++)
		{
			String memory = sc.next();
			String now = "0";
			int result = 0;
			for(int i = 0; i < memory.length(); i++) {
				if(!Character.toString(memory.charAt(i)).equals(now)) {
					result += 1;
					if(now.equals("0"))
						now = "1";
					else 
						now = "0";
				}
			}
			System.out.println("#"+test_case+" "+result);
		}
	}
}