import java.util.Scanner;
import java.io.FileInputStream;
 
class Solution
{
    public static void main(String args[]) throws Exception
    {
        //System.setIn(new FileInputStream("inputs/input.txt"));
 
        /*
           ǥ���Է� System.in ���κ��� ��ĳ�ʸ� ����� �����͸� �о�ɴϴ�.
         */
        Scanner sc = new Scanner(System.in);
        int T;
        T=sc.nextInt();
        /*
           ���� ���� �׽�Ʈ ���̽��� �־����Ƿ�, ������ ó���մϴ�.
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