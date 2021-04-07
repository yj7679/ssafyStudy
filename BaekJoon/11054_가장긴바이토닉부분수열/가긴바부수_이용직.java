import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

//가장 긴 바이토닉 부분 수열
public class Main {
	static int N;
	static int[] d1,d2,nums;
	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br =new BufferedReader(new InputStreamReader(System.in));
		N =Integer.parseInt(br.readLine());
		nums = new int[N+2];
		d1 = new int[N+2];
		d2 = new int[N+2];
		String[] str = br.readLine().split(" ");
		for(int i=0; i<N;i++) {
			nums[i+1] =Integer.parseInt(str[i]);
		}
		
		d1[0] = 0;
		//nums에 들어있는 거보고 작은 값이면서 그 작은 것들 중에서 d값이 제일 큰거 찾기
		for(int i=1; i<=N;i++) {
			int max =Integer.MIN_VALUE;
			int idx=0;
			for(int j=1;j<i;j++) {
				if(nums[j]<nums[i] && max<d1[j]) {
					idx = j;
					max = d1[j];
				}
			}
			d1[i] = d1[idx]+1;
			
		}
		//print(d1);
		
		
		d2[N+1]=0;
		for(int i=N; i>=1;i--) {
			int max =Integer.MIN_VALUE;
			int idx=N+1;
			for(int j=N+1; j>i;j--) {
				if(nums[j]<nums[i] && max<d2[j]) {
					idx = j;
					max = d2[j];
				}
			}
			d2[i] = d2[idx]+1;
			
		}
		//print(d2);
		int ans=0;
		for(int i=1; i<=N;i++) {
			if(ans <d1[i]+d2[i]) {
				ans = d1[i]+d2[i];
			}
		}
		System.out.println(ans-1);
		
		
		
		
	
	}
	private static void print(int[] d12) {
		for (int i = 1; i <= N; i++) {
			System.out.print(d12[i]+" ");
		}
		System.out.println();
		
	}

}
