package day0421;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

// 단어 암기
public class BJ18119 {
	static int N,M;
	static int[] strs;
	static char[][] op;
	static int remem=67108863; //0~25 'a'~'z'까지 다기억
	public static void main(String[] args) throws IOException {
		BufferedReader br =new BufferedReader(new InputStreamReader(System.in));

		System.out.println(Integer.toBinaryString(remem-(1<<('y'-'a'))));
		
		
		StringTokenizer st = new StringTokenizer(br.readLine()," ");
		StringBuilder sb = new StringBuilder();

		N= Integer.parseInt(st.nextToken());
		M= Integer.parseInt(st.nextToken());
		strs= new int[N];
		op= new char[M][2];
		String str="";
		int size=0;

		for (int i = 0; i < N; i++) {
			strs[i]=0;
			str = br.readLine();
			size = str.length();
			for (int j = 0; j < size; j++) {
				
				strs[i]=strs[i] |(1<<(str.charAt(j)-'a'));
			}
		}
		for (int i = 0; i < M; i++) {
			st = new StringTokenizer(br.readLine()," ");
			op[i][0] = st.nextToken().charAt(0);
			op[i][1] = st.nextToken().charAt(0);
			
			//지우기
			if(op[i][0] == '1') {
				remem = remem -(1<<(op[i][1]-'a'));
			}
			//기억하기
			else if(op[i][0]=='2'){
				remem = remem +(1<<(op[i][1]-'a'));
			}
			Integer.toBinaryString(remem);
			sb.append(calc());
			sb.append("\n");
			
		}
		//print(op);
		
		//문자열을 차례로 보면서 잊고있는 알파벳들어있는지 체크

		System.out.println(sb);
	}
	private static int calc() {
		int cnt=N;
		for (int i = 0; i < N; i++) {
			if((strs[i] & remem)!=strs[i]) {

				cnt--;
			}
		}
		return cnt;
		
	}
	private static void print(char[][] op2) {
		for (int i = 0; i < op2.length; i++) {
			for (int j = 0; j < op2[i].length; j++) {
				System.out.print(op2[i][j]+" ");
			}
			System.out.println();
		}
	}

}
