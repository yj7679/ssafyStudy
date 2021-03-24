import java.util.Arrays;
import java.util.Scanner;
import java.io.IOException;

public class Main
{

	public static void main(String args[]) throws IOException
	{
		Scanner sc = new Scanner(System.in);
		int N = sc.nextInt();
		int[] P = new int[N];
		int[] nt = new int[N+1];
		int sum=0;
		
		for(int i=0; i<N;i++) {
			P[i] = sc.nextInt();

		}
		Arrays.sort(P);//SJF가 제일 짧은 대기시간의 합이다.
		for(int i=0; i<N;i++) {
			nt[i+1] = nt[i] +P[i]; //필요한시간은 앞사람의 필요한시간 + 현재 자기가 필요한시간
			sum+= nt[i+1];
		}
		System.out.println(sum);
		
		
		
	
	
		
	}
}

	
