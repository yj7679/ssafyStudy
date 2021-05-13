import java.util.Scanner;
import java.util.Stack;

public class PPAP {

	public static void main(String[] args) {
		
		Stack<Character> stack = new Stack<>();
		
		Scanner sc = new Scanner(System.in);
		
		String temp = sc.next();
				
		//1. 앞에서부터 P일때는 스택에 넣어준다.
		//2. A를 만났을 때는 앞에 P가 두개 있는지 확인한다.
		//3. 2개가 있을 시에 A 뒤에 있는게 P인 것을 확인한다.
		//4. 앞에 있는 2개를 pop해준다.
		
		for (int i = 0; i < temp.length(); i++) {
			char arr = temp.charAt(i);
			
			if(arr == 'P') stack.push('P');
			
			//A일때 스택에 최소 2개이상 있어야 함(pop이 안되서 앞에 있는건 거의 P)
			else {
				if(stack.size()>=2 && i<temp.length()-1 && temp.charAt(i+1)=='P') {
					stack.pop();
					stack.pop();
				}
				
				//A를 만났을때 pop을 못하면 NP 출력 
				else {
					System.out.println("NP");
					return;
				}
				
			}
		}
		if(stack.size()==1) {
			System.out.println("PPAP");
		}
		//P만 가득할 경우에 AP출력
		else
			System.out.println("NP");
	}

}
