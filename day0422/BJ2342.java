package day0421;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

//댄스댄스 레볼루션
public class BJ2342 {
	static String[] nums = { "01","02","03","04", "12","13","14","23","24","34"};
	static int[][] d;
	static int INF = Integer.MAX_VALUE/2;
	public static void main(String[] args) throws IOException {
		BufferedReader br =new BufferedReader(new InputStreamReader(System.in));
		
		String[] str = br.readLine().split(" ");
		String[] temp = new String[5];
		d = new int[str.length][10];
		int len = str.length;
		
		for(int i=0;i<10;i++) {
			d[0][i]=0;
		
		}
		//처음에 놓을수잇는 발 세팅
		for(int i=0;i<10;i++) {
			if(i<4 && nums[i].contains(str[0])) {
				d[1][i]=2;
			}
			else {
				d[1][i]=INF;
			}
		}		
		
		//아래줄 채우기
		for(int i=2;i<len;i++) {

			for(int j=0;j<10;j++) {
				int min=INF;
				//어차피 발을 못놓는곳
				if(!nums[j].contains(str[i-1])) {
					d[i][j]= INF;
				}
				
				//d[i][j]는 현재 채울 위치 
				//발을 놓을 수 있으면 이전 i-1에서 옮겨올수 있던 곳에서 와야한다. 7개의 값중에서 비교
				else {
					for(int k=0; k<10;k++) {
						if(d[i-1][k]!=INF) { //이전 위치에서 무한대가 아니게 올수있으면
							int w = weight(nums[j],nums[k]);
							if(w>0 && min > d[i-1][k]+w ) { //연관이 되게 올수있으면
								min =d[i-1][k]+w;

							}
						}
					}
					
					//최소값이랑 인덱스 뽑앗음
					d[i][j] = min;
				}
				
				
			}
		}
		
		int ans = INF;
		for(int j=0; j<10;j++) {
			ans = Math.min(d[len-1][j], ans);
		}
		System.out.println(ans);
		
		
		
	}
	
	//두개 넣으면 차이 비교해서 더할값 정해줌
	private static int weight(String current, String pre) {
		char[] a = current.toCharArray();
		char same='0';
		int val1=0,val2=0;
		//같으면 2리턴
		if(current.equals(pre)) {
			return 1;
		}
		boolean flag=false;
		for(int i=0;i<2;i++) {
			if(pre.contains(String.valueOf(a[i]))) {
				same = a[i];
				flag=true;
			}
		}
		if(flag==true) {
			for(int i=0;i<2;i++) {
				if(pre.charAt(i)!=same) {
					val2 = pre.charAt(i)-'0';
				}
				if(current.charAt(i)!=same) {
					val1 =current.charAt(i)-'0';
				}
			}
			//원점에서 다른데로 이동시킨 경우
			if(val2==0) {
				return 2;
			}
			//다른데서 원점으로 이동 불가능
			else if(val1==0) {
				return -1;
			}
			else if(Math.abs(val1-val2)==2) {
				return 4;
			}
			else {
				return 3;
			}
		}
		else {
			return -1;
		}
		
	}
	private static void print(int[][] d2) {
		for (int i = 0; i < d2.length; i++) {
			for (int j = 0; j < d2[i].length; j++) {
				System.out.print(d2[i][j]+" ");
			}
			System.out.println();
		}
	}

}
