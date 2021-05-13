import java.util.Scanner;
import java.util.Stack;

public class PPAP {

	public static void main(String[] args) {
		
		Stack<Character> stack = new Stack<>();
		
		Scanner sc = new Scanner(System.in);
		
		String temp = sc.next();
				
		//1. �տ������� P�϶��� ���ÿ� �־��ش�.
		//2. A�� ������ ���� �տ� P�� �ΰ� �ִ��� Ȯ���Ѵ�.
		//3. 2���� ���� �ÿ� A �ڿ� �ִ°� P�� ���� Ȯ���Ѵ�.
		//4. �տ� �ִ� 2���� pop���ش�.
		
		for (int i = 0; i < temp.length(); i++) {
			char arr = temp.charAt(i);
			
			if(arr == 'P') stack.push('P');
			
			//A�϶� ���ÿ� �ּ� 2���̻� �־�� ��(pop�� �ȵǼ� �տ� �ִ°� ���� P)
			else {
				if(stack.size()>=2 && i<temp.length()-1 && temp.charAt(i+1)=='P') {
					stack.pop();
					stack.pop();
				}
				
				//A�� �������� pop�� ���ϸ� NP ��� 
				else {
					System.out.println("NP");
					return;
				}
				
			}
		}
		if(stack.size()==1) {
			System.out.println("PPAP");
		}
		//P�� ������ ��쿡 AP���
		else
			System.out.println("NP");
	}

}
