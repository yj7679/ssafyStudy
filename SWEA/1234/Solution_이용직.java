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
        //T=sc.nextInt();
        /*
           ���� ���� �׽�Ʈ ���̽��� �־����Ƿ�, ������ ó���մϴ�.
        */
 
        T=10;
        for(int test_case = 1; test_case <= T; test_case++)
        {
            int N =sc.nextInt();
            String str = sc.next();
            char[] strC = new char[N];
            int size = N;
            //System.out.println(N +" "+ str.length());
             
            for(int i=0; i<str.length(); i++) {
                strC[i] = str.charAt(i);
            }
 
            boolean flag=true;
            while(flag) {
                flag= false;
                for(int i=0; i<size-1;i++) {
                    //���ϴٰ� ���ӵ� ������ ã���� �ѹ� ���ؾ���
 
                    if(strC[i]==strC[i+1]) {
                        //System.out.println("i, i+1: "+ i+" "+ (i+1) + " " + size);
                          
                        if(i==size-2) {
                            size= size-2;
                             
                            continue;
                        }
                         
                         
                         
                        for(int j=i+2; j<size;j++) {
                            //System.out.println("j: "+j+ size);
                            strC[j-2]=strC[j];//��ĭ����ܿ���
                             
                        }
                        size = size-2;
                        flag= true;
                        break;
 
                    }   
                }
 
 
                 
                //�� �������ߴµ� ���ӵ� ������ �ȳ��� ���
                if(flag==false) {
                    break;
                }
 
            }
            System.out.print("#"+ test_case + " ");
         
 
 
            for(int i=0; i<size; i++) {
                System.out.print(strC[i]);
            }
            System.out.println();
             
             
        }
    }
 
 
     
     
         
         
}