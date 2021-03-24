import java.util.Scanner;
import java.io.FileInputStream;
 
/*
   사용하는 클래스명이 Solution 이어야 하므로, 가급적 Solution.java 를 사용할 것을 권장합니다.
   이러한 상황에서도 동일하게 java Solution 명령으로 프로그램을 수행해볼 수 있습니다.
 */
class Solution
{
    public static void main(String args[]) throws Exception
    {
         
        Scanner sc = new Scanner(System.in);
        int T;
        T=sc.nextInt();
         
 
        for(int test_case = 1; test_case <= T; test_case++)
        {
            int n = sc.nextInt();
             
            int v = 0;
             
            int d = 0;
            for(int i = 0; i < n; i++) {
                int command = sc.nextInt();
                if(command == 1) {
                    int a = sc.nextInt();
                    v += a;
                } else if(command == 2) {
                    int a = sc.nextInt();
                    v -= a;
                    if(v < 0)
                        v = 0;
                }
                d += v;
            }
            System.out.println("#" + test_case + " " + d);
             
        }
    }
}