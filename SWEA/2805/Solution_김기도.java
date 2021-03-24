package D3;

import java.util.*;

public class Farm {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int T = sc.nextInt();
		for(int i=0;i<T;i++)
		{
			int test= i+1;
			int N = sc.nextInt();
			sc.nextLine();
			int[][] arr = new int[N][N];
			ArrayList<Integer> res = new ArrayList();
			
			for(int j =0;j<N;j++)
			{
				String num = sc.nextLine();
				for(int k=0;k<N;k++)
				{
					arr[j][k] = num.charAt(k) -'0';
				}
			}
			
			for(int j=0;j<N;j++)
			{
				int kk=0;
				if(j<N/2)
				{
					for(int k=0;k<N/2-j;k++)
					{
						kk++;
					}
					for(int k=0;k<=j*2;k++)
					{
						res.add(arr[j][kk]);
						kk++;
					}
				}
				else
				{
					for(int k=0; k<=j-N/2-1;k++)
					{
						kk++;
					}
					for(int k=(j-N/2)*2; k<N;k++)
					{
						res.add(arr[j][kk]);
						kk++;
					}
				}
			}
			int result=0;
			for(int j=0;j<res.size();j++)
			{
				result = result+res.get(j);
			}
			System.out.println("#"+test+" "+result);
			
		}

	}

}
