package com.ssafy;

import java.util.Scanner;
import java.util.Stack;

class SWEA {

	public static void main(String args[]) throws Exception {
		Scanner sc = new Scanner(System.in);
		int T = sc.nextInt();
		
		for (int tc = 1; tc <= T; tc++) {
			String s = sc.next();
			boolean flag = false, oldFlag = false;
			int cnt = 0;
			
			for (int i = 0; i < s.length(); i++) {
				if(s.charAt(i) == '0') {
					oldFlag = flag;
					flag = false;
				}
				else if(s.charAt(i) == '1') {
					oldFlag = flag;
					flag = true;
				}
				if(oldFlag != flag)
					++cnt;
			}
			
			System.out.println("#" + tc + " " + cnt);
		}
		sc.close();
	}
}