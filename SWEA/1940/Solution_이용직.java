import java.util.Scanner;
import java.io.FileInputStream;
 
class Solution
{
    public static void main(String args[]) throws Exception
    {
        //System.setIn(new FileInputStream("inputs/input.txt"));
 
        /*
           표준입력 System.in 으로부터 스캐너를 만들어 데이터를 읽어옵니다.
         */
        Scanner sc = new Scanner(System.in);
        int T;
        T=sc.nextInt();
        /*
           여러 개의 테스트 케이스가 주어지므로, 각각을 처리합니다.
        */
 
 
        for(int test_case = 1; test_case <= T; test_case++)
        {
            int N = sc.nextInt();
            int d=0;
            int a = 0;
            int v=0;
             
            for(int i=0; i <N; i++) {
                int mode = sc.nextInt();
                if(mode ==0) {
                    d= d+v;
                    continue;
                }
                else {
                    a = sc.nextInt();
                    if(mode == 1) {
                        v= v+ a;
                    }
                    else if(mode ==2 ) {
                        if(v<a) {
                            v=0;
                        }
                        else
                            v= v-a;
                    }
                }
                d= d+ v;
            }
            System.out.print("#"+ test_case +" ");
            System.out.println(d);
             
             
        }
    }
     
     
         
         
}