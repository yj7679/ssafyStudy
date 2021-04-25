package com.gold;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.PriorityQueue;

public class P1715 {
	// 카드 정렬하기
	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		int N = Integer.parseInt(br.readLine());
		PriorityQueue<Integer> pq = new PriorityQueue<Integer>();
		
		for(int i = 0; i < N; i++) pq.add(Integer.parseInt(br.readLine()));

		long result = 0L;
		while(true) {
			int x = pq.poll();
			if(pq.isEmpty()) break;
			int y = pq.poll();
			int sum = x + y;
			
			result += sum;
			pq.offer(sum);
		}
		bw.write(Long.toString(result));
		bw.flush();
	}
}
