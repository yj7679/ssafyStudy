import java.util.Arrays;
import java.util.Scanner;
import java.util.Stack;
import java.io.IOException;

public class Main
{

	public static void main(String args[]) throws IOException
	{
		Scanner sc = new Scanner(System.in);
		String str = new String();
		char c =0;
		Stack <Character> stack = new Stack();
		str = sc.nextLine();
		int len =str.length();
		char[] strC = new char[len];
		boolean flag= false;
		for(int i=0; i<len; i++) {
			c =str.charAt(i);
			
			if(c=='<') {//스택에서 뽑아서 넣기
				flag = true;
			}
			else if(c=='>') {
				flag = false;
				strC[i] = c; //닫는것도 같이 스택에 안들어가게 하는것
				continue;
				
			}
			if(flag == false) {//괄호에 안쌓여있으면 스택에 넣음
				if(c==' ') {
					strC[i] = c;//괄호에 안들어가있고 공백이면 그냥 넣고 넘어감.
					continue;
				}


				stack.push(c);
				//다음이 마지막이거나 다음이 공백이거나 다음이 < 이면 뒤집어서 넣음
				if(i+1 == len || str.charAt(i+1)==' ' || str.charAt(i+1)=='<') {
					for(int j=i-stack.size()+1; j<=i; j++ ) {
						strC[j] = stack.pop();
					}
						
				}

			}
			else {//괄호에 쌓여있으면 그냥 넣음
				strC[i] = c;
			}
			
		}
		for(int i=0; i<len; i++) {
			System.out.print(strC[i]);
		}

		
	
	
		
	}
}

	
