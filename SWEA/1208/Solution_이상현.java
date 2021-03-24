import java.util.Scanner;
import java.util.ArrayList;
import java.util.Collections;
import java.io.FileInputStream;

class Solution
{
	public static void main(String args[]) throws Exception
	{
		Scanner sc = new Scanner(System.in);
		int T = 10;

		for(int test_case = 1; test_case <= T; test_case++)
		{
            ArrayList<Integer> list = new ArrayList<Integer>();
         	int N = sc.nextInt();
            for(int i = 0; i < 100; i++){
                list.add(sc.nextInt());
            }
            
            int count = 0;
            while(count < N){
                count++;
                int max = Collections.max(list);
                int min = Collections.min(list);
                
                list.set(list.indexOf(max), max - 1);
                list.set(list.indexOf(min), min + 1);
            }
            
            System.out.printf("#%d %d\n", test_case, Collections.max(list) - Collections.min(list));
		}
	}
}