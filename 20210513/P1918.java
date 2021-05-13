package com.gold;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.Stack;

public class P1918 {
	// 후위 표기식
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		Stack<Character> stack = new Stack<Character>();
		char[] input = br.readLine().toCharArray();
		
		for(char c : input) {
			if(c >= 'A' && c <= 'Z') bw.write(c);
			else if(c == '(') stack.push(c);
			else if(c == ')') {
				while(stack.peek() != '(') bw.write(stack.pop());
				stack.pop();
				
			} else if(c == '/' || c == '*') {
				while(!stack.isEmpty() && (stack.peek() == '/' || stack.peek() == '*')) bw.write(stack.pop());
				stack.push(c);
				
			} else if(c == '-' || c== '+') {
				while(!stack.isEmpty() && stack.peek() != '(') bw.write(stack.pop());
				stack.push(c);
				
			}
		}
		while(!stack.isEmpty()) bw.write(stack.pop());
		bw.flush();
	}
}
