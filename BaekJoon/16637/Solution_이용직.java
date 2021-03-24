import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

//괄호추가하기- AD대비 G3
public class Main {
	static int N;
	static int max = Integer.MAX_VALUE *(-1);
	//static char[] op;
	//static int[] nums;
	public static void main(String[] args) throws NumberFormatException, IOException {
		//System.setIn(new FileInputStream("src/day0309/input.txt"));
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		N = Integer.parseInt(br.readLine());
		String str =br.readLine();
		int opcnt=0,numcnt=0;
		char[] op = new char[N/2];
		int[] nums = new int[N/2+1];
		for(int i=0;i<N; i++) {
			if((i&1)==1) {
				op[opcnt++]=str.charAt(i);
			}
			else {
				nums[numcnt++]=Integer.parseInt(String.valueOf(str.charAt(i)));
			}
		}
//		print(op);
//		print(nums);
		powerSet(nums, op,0,new boolean[op.length]);
		System.out.println(max);

	}
	private static void powerSet(int[] nums, char[] op, int k, boolean[] sel) {
		if(k>=sel.length) {
			int[] nums_temp = nums.clone();
			int len = sel.length;
			for(int i=len-1; i>=0; i--) {
				if(sel[i]==true) {
					if(op[i]=='+') {
						nums_temp[i]=nums_temp[i]+nums_temp[i+1];
					}
					else if(op[i]=='-') {
						nums_temp[i]=nums_temp[i]-nums_temp[i+1];
					}
					else if(op[i]=='*') {
						nums_temp[i]=nums_temp[i]*nums_temp[i+1];
					}
					
					
					for(int j=i+1;j<nums_temp.length-1;j++) {
						nums_temp[j]=nums_temp[j+1];
					}
				}
			}
			int cumul=nums_temp[0];
			int cnt=1;
			for(int i=0;i<sel.length;i++) {
				if(sel[i]==false) {
					if(op[i]=='+') {
						cumul+=nums_temp[cnt++];
					}
					else if(op[i]=='-') {
						cumul-=nums_temp[cnt++];
					}
					else if(op[i]=='*') {
						cumul*=nums_temp[cnt++];
					}

					//System.out.print(cumul+" ");
				}
			}

			max = Math.max(max, cumul);
			
			return;
		}

		sel[k]=true;
		powerSet(nums,op,k+2,sel);

		sel[k]=false;
		powerSet(nums,op,k+1,sel);

		
		
	}
	private static void print(int[] arr) {
		
		for(int i=0;i<arr.length;i++) {
			System.out.print(arr[i]+" ");
		}
		System.out.println();
	}
	private static void print(char[] arr) {
		
		for(int i=0;i<arr.length;i++) {
			System.out.print(arr[i]+" ");
		}
		System.out.println();
	}
}
