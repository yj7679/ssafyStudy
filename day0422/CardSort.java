package BaekJun;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.PriorityQueue;

public class CardSort {

	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int N = Integer.parseInt(br.readLine());
		PriorityQueue<Integer> q = new PriorityQueue<>();
		
		for(int i=0;i<N;i++)
		{
			int K = Integer.parseInt(br.readLine());
			q.add(K);
		}
		int sum=0;
		while(q.size()>1)
		{
			int card1 = q.poll();
			int card2 = q.poll();
			sum = sum+card1+card2;
//			System.out.println(card1+"+"+card2);
//			System.out.println(sum);
			q.add(card1+card2);
			
		}
		System.out.println(sum);

	}

}
