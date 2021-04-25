package day0421;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.PriorityQueue;

//카드 정렬하기 - 우선순위큐
public class BJ1715 {
	static int N;
	static long num;
	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		PriorityQueue<Long> q = new PriorityQueue<>();
		
		N = Integer.parseInt(br.readLine());
		for (int i = 0; i < N; i++) {
			num = Long.parseLong(br.readLine());
			q.add(num);
		}
		
		
		long num1=0,num2=0;
		long cumul=0;
		while(!q.isEmpty()) {
			if(q.size()==1) {

				break;
			}
			
			
			num1 = q.poll();
			num2 = q.poll();
			q.add(num1+num2);
			cumul+=num1+num2;
		}

		System.out.println(cumul);
	}

}
