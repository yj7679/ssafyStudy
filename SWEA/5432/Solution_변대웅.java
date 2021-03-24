import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.util.Arrays;
import java.util.Scanner;
import java.util.Stack;

public class Solution {

	public static void main(String[] args) throws FileNotFoundException {
//		System.setIn(new FileInputStream("input.txt"));
		Scanner sc = new Scanner(System.in);
		int t = sc.nextInt();

		for (int test_case = 1; test_case <= t; test_case++) {
			int result = 0;
			int count = 0;
			String bong = sc.next();
			char prev = '(';
			for (char c : bong.toCharArray()) {
				if (c == '(') {
					count++;
					result++;
				} else if (c == ')') {
					if (prev == '(') {
						count--;
						result--;
						result += count;
					} else {
						count--;
					}
				}
				prev = c;
			}
			System.out.println("#" + test_case + " " + result);
		}
	}
}
