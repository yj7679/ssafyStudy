import java.util.Scanner;
import java.io.FileInputStream;

class Solution
{
	static char[] memo = new char[51];
	static char[] init = new char[51];
	
	public static void main(String args[]) throws Exception
	{
		//System.setIn(new FileInputStream("inputs/input.txt"));

		/*
		   표준입력 System.in 으로부터 스캐너를 만들어 데이터를 읽어옵니다.
		 */
		Scanner sc = new Scanner(System.in);
		int T;
		T=sc.nextInt();
		/*
		   여러 개의 테스트 케이스가 주어지므로, 각각을 처리합니다.
		*/


		//T=10;
		for(int test_case = 1; test_case <= T; test_case++)
		{
			String str= sc.next();
			int len = str.length();
			for(int i=0; i<len;i++) {
				memo[i] = str.charAt(i);
				init[i] = '0';
			}
			
			int cnt=0;
			for(int i=0; i<len; i++) {
				if(memo[i]!=init[i]) {
					cnt++;
					for(int j=i;j<len; j++) {
						init[j] = memo[i];
					}
				}
			}
			System.out.print("#" + test_case + " ");
			System.out.println(cnt);
			
			
			
		}
	}
	
	

		
}

	
