import java.util.*;
import java.io.*;

public class PPAP {
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		char[] chrs = br.readLine().toCharArray();
		System.out.println(getResult(chrs));
	}

	private static String getResult(char[] chrs) {
		Stack<Character> stack = new Stack<>();
		for (int i = 0; i < chrs.length; i++) {
			if (chrs[i] == 'P') {
				stack.push(chrs[i]);
			} else {
				if (stack.size() < 2) {
					return "NP";
				}
				char prev1 = stack.pop();
				char prev2 = stack.pop();
				if (prev1 == 'P' && prev2 == 'P' && i < chrs.length - 1 && chrs[i + 1] == 'P') {
					continue;
				} else {
					stack.push(chrs[i]);
				}
			}
		}
		if(stack.size() == 1 && stack.pop() == 'P')
			return "PPAP";
		else
			return "NP";
	}
}
