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
        //T=sc.nextInt();
        /*
           여러 개의 테스트 케이스가 주어지므로, 각각을 처리합니다.
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
                    //비교하다가 연속된 같은거 찾으면 한번 더해야함
 
                    if(strC[i]==strC[i+1]) {
                        //System.out.println("i, i+1: "+ i+" "+ (i+1) + " " + size);
                          
                        if(i==size-2) {
                            size= size-2;
                             
                            continue;
                        }
                         
                         
                         
                        for(int j=i+2; j<size;j++) {
                            //System.out.println("j: "+j+ size);
                            strC[j-2]=strC[j];//두칸씩당겨오기
                             
                        }
                        size = size-2;
                        flag= true;
                        break;
 
                    }   
                }
 
 
                 
                //비교 끝까지했는데 연속된 같은거 안나온 경우
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