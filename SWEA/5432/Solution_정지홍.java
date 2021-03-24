package com.ssafy;

import java.util.Scanner;
import java.util.Stack;

class Solution {
	public static void main(String args[]) throws Exception {
		Scanner sc = new Scanner(System.in);
		Stack<Character> st = new Stack<>();
		String str = "";
		int T = sc.nextInt();
		int stick;

		for (int tc = 1; tc <= T; tc++) {
			stick = 0;
			str = sc.next();
			for (int i = 0; i < str.length(); i++) {
				if(str.charAt(i) == '(') {
					st.push(str.charAt(i));
					if(str.charAt(i+1) == ')') {
						st.pop();
						stick += st.size();
						++i;
					}
				}
				else {
					st.pop();
					stick++;
				}
			}
			System.out.println("#" + tc + " " + stick);
		}
	}
}