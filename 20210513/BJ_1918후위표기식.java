package 스터디문제;

import java.util.*;
import java.io.*;

public class BJ_1918후위표기식 {

	public static void main(String[] args) throws Exception {
		System.setIn(new FileInputStream("후위표기식.txt"));
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		Stack<Character> stack = new Stack<>();
		String str = new String();
		str = br.readLine();

		HashMap<Character, Integer> map = new HashMap<>();
		map.put('(', 0);
		map.put('+', 1);
		map.put('-', 1);
		map.put('*', 2);
		map.put('/', 2);

		for (int i = 0; i < str.length(); i++) {
			char ch = str.charAt(i);

			if ('A' <= ch && ch <= 'Z')
				sb.append(ch);
			else {
				if (ch == '(')
					stack.push(ch);
				else if (ch == ')') {
					while (!stack.isEmpty() && stack.peek() != '(')
						sb.append(stack.pop());
					if (!stack.isEmpty() && stack.peek() == '(') {
						stack.pop();
					}
				} else {
					while (!stack.isEmpty() && map.get(stack.peek()) >= map.get(ch))
						sb.append(stack.pop());
					stack.push(ch);
				}

			}
		}

		while (!stack.isEmpty())
			sb.append(stack.pop());

		System.out.println(sb.toString());
	}

}
