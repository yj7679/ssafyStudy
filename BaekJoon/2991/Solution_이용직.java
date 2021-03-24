import java.util.Scanner;
import java.io.IOException;

public class Main
{

	public static void main(String args[]) throws IOException
	{
	
		Scanner sc = new Scanner(System.in);
		int A,B,C,D;
		int[] man = new int[3];
		int[] mCnt = new int[3];

		
		
		A=sc.nextInt();
		B=sc.nextInt();
		C=sc.nextInt();
		D=sc.nextInt();

		int term1 = A+B;
		int term2 = C+D;
		for(int i=0; i<3; i++) {
			man[i] = sc.nextInt();
		}
		for (int i = 0; i < 3; i++) {
			if((man[i]%term1)<=A && (man[i]%term1)>0) {
				mCnt[i]++;
			}
			if((man[i]%term2)<=C&& (man[i]%term2)>0) {
				mCnt[i]++;
			}
		}
		for (int i = 0; i < mCnt.length; i++) {
			System.out.println(mCnt[i]);
		}



		
	}
}

	
