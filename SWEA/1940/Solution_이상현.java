import java.util.Scanner;
import java.lang.Math;
import java.io.FileInputStream;

class Solution
{
	public static void main(String args[]) throws Exception
	{
		Scanner sc = new Scanner(System.in);
		int T = sc.nextInt();

		for(int test_case = 1; test_case <= T; test_case++)
		{
            int N = sc.nextInt();
            int result = 0;
            int speed = 0;
            
            for(int i = 0; i < N; i ++){
            	int command = sc.nextInt();
                
                switch(command){
                    case 1:
                        speed += sc.nextInt();
                        break;
                        
                    case 2:
                        speed = Math.max(0, speed - sc.nextInt());
                        break;
                        
                    default:
                        break;
                }
                result += speed;
            }
            System.out.printf("#%d %d\n", test_case, result);
		}
	}
}