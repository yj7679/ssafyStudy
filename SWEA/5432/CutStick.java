package D4;

import java.util.*;

public class CutStick {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int T = sc.nextInt();
		sc.nextLine();
		for (int i = 0; i < T; i++) 
		{
			int test = i+1;
			ArrayList<Character> list = new ArrayList();
			int tmp =0;
			int result=0;
			
			String s = sc.next();
			for(int j=0;j<s.length();j++)
			{
				list.add(s.charAt(j));
			}
			for(int j=0;j<s.length();j++)
			{
				if(list.get(j) == '(' && list.get(j+1) == ')')
				{
					result = result+tmp;
					j++;
				}
				else
				{
					if(list.get(j) == '(')
					{
						tmp++;
					}
					else if(list.get(j) == ')')
					{
						tmp--;
						result++;
					}
				}
			}
			
			System.out.println("#"+test+" "+result);
		}

	}

}
