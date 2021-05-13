package day0512;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Stack;

public class BJ16120 {
	//PPAP -스택 + 문자열ㄹ
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		String str = br.readLine();
		int len = str.length();
		Stack<Character> stack =new Stack<>();
		for(int i=0;i<len;i++) {
			stack.add(str.charAt(i));
			int size = stack.size();
			if(size>=4) {
				if(stack.get(size-4)=='P'
						&&stack.get(size-3)=='P'
						&&stack.get(size-2)=='A'
						&&stack.get(size-1)=='P') {
					for(int c=0;c<3;c++) {
						stack.pop();
					}
					
				}
			}
		}
		if(stack.size()==1 && stack.get(0)=='P') {
			System.out.println("PPAP");
		}
		else {
			System.out.println("NP");
		}
		
	}

}
