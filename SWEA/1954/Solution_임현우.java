import java.util.Scanner;

public class Solution {
	
	static int[][] arr; //달팽이 경로를 적어주기 위해서
	static int start; //시작지점을 위해서
	static int end;  //종료시점을 위해서
	static int r, c;  //달팽이의 현재 위치를 알기 위해서
	static int count;  //몇번 이동할지
	public static void main(String[] args) {
	
		Scanner sc = new Scanner(System.in); 
		
		int T = sc.nextInt(); 
		int[] map = new int[T];
		for (int i = 0; i < map.length; i++) {
			int N = sc.nextInt();
			map[i] = N; 
		}
		
		for(int i=0; i<T; i++) {
			arr = new int[map[i]][map[i]];
			start = 1;
			end = map[i] * map[i];
			r = 0;
			c = 0;
			count = map[i];
			recursive(start);
			
			System.out.println("#" + (i+1));
			for(int j=0; j<map[i]; j++) {
				for(int k=0; k<map[i]; k++) {
					System.out.print(arr[j][k] + " ");
				}
				System.out.println("");
			}
		}
	}
	
	public static void recursive(int s) {
			if(s > end) {
				return;
			}
		
			for(int k=0; k< count; k++) {
			arr[r][c++] = s++; // 0,3  1,2,3
			} 
			r = r + 1; //1,2
			c = c - 1; 
			count = count - 1;
			for(int k=0; k<count; k++) {
				arr[r++][c] = s++; //3,2    4,5
			}
			r = r - 1;
			c = c - 1;   //2,1
			for(int k=0; k<count; k++) {
				arr[r][c--] = s++;  // 2,-1 6,7 
			}
			r = r - 1;
			c = c + 1;       //1,0
			count = count -1;
			for(int k=0; k<count; k++) {
				arr[r--][c] = s++;  // 0,0  8
			}
			r = r + 1;
			c = c + 1;   //1,1  //9
			
			recursive(s);
			
	}
	
}

