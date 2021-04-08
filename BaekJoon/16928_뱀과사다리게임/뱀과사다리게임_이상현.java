package com.silver;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.Queue;

public class P16928 {
	// 뱀과 사다리 게임
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		String[] input = br.readLine().split(" ");
		int N = Integer.parseInt(input[0]);
		int M = Integer.parseInt(input[1]);
		
		int[] map = new int[101];
		Arrays.fill(map, Integer.MAX_VALUE);
		int[] obj = new int[101];
		
		for(int i = 0; i < N; i++) {
			input = br.readLine().split(" ");
			obj[Integer.parseInt(input[0])] = Integer.parseInt(input[1]);
		}
		
		for(int i = 0; i < M; i++) {
			input = br.readLine().split(" ");
			obj[Integer.parseInt(input[0])] = Integer.parseInt(input[1]);
		}
		
		Queue<Integer> queue = new LinkedList<Integer>();
		queue.add(1);
		map[1] = 0;
		
		int cnt = 0;
		E:while(!queue.isEmpty()) {
			cnt++;
			
			int size = queue.size();
			
			for(int s = 0; s < size; s++) {
				int x = queue.poll();
				boolean check = false;
				
				for(int i = 6; i > 0; i--) {
					int nx = x + i;
					if(nx > 100) continue;
					
					if(obj[nx] > 0) {
						if(map[nx] > cnt && map[obj[nx]] > cnt) {
							map[nx] = cnt;
							map[obj[nx]] = cnt;
							queue.add(obj[nx]);
						}
						
					} else if(!check) {
						if(map[nx] > cnt) {
							check = true;
							
							map[nx] = cnt;
							queue.add(nx);
							if(nx == 100) break E;
						}
					}
				}
			}
		}
		
		bw.write(Integer.toString(map[100]));
		bw.flush();
	}
}
