import java.util.Scanner;
import java.io.IOException;

public class Main
{

	public static void main(String args[]) throws IOException
	{
		Scanner sc = new Scanner(System.in);
		int N = sc.nextInt(); //명수
		int M = sc.nextInt(); //최대 받은 횟수
		int L = sc.nextInt();// 던지는 정도(칸수)
		int[] cnt = new int[N];
		int idx=0;
		int max=0;
		cnt[0] = 1;
		int count=0;
		while(max != M) {
			count++;
			//2로나눈 나머지가 1인경우 인덱스커지는 방향으로 던짐
			if(cnt[idx]-((cnt[idx]>>1)<<1)!=0) {
				//만약 인덱스 오버하면
				idx = idx+L; //L만큼 던짐
				if(idx >=N) {
					idx = idx - N;//만약 0~5까지 총 6명있는데 5가 2만큼 던지면 7된다. 근데 인덱스 상으로는 1이다. 따라서 N만큼 빼야함.
				}
				cnt[idx]++;
				max = Math.max(max, cnt[idx]);
			}
			//작아지는 쪽으로 던짐
			else {
				idx = idx-L; //L만큼 던짐
				if(idx <0) {
					idx = idx + N;//만약 0~5까지 총 6명있는데 0이 왼쪽으로 2만큼 던지면 -2된다. 근데 인덱스 상으로는 4이다. 따라서 N만큼 더해야함.
				}
				cnt[idx]++;
				max = Math.max(max, cnt[idx]);
			}
		}
		System.out.println(count);
		
	
	
		
	}
}

	
