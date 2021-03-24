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
            int Ans = 0;
            int N = sc.nextInt();
            int[][] farm = new int[N][N];
            String[] str = new String[N];
            for(int i=0; i<N; i++) {
                str[i] = sc.next();
            }
            for(int i=0; i<N;i++) {
                for(int j=0; j<N; j++) {
                    farm[i][j]=str[i].charAt(j)-'0';
                }
            }
            //print(farm);
            for(int i=0; i<N; i++) {
                if(i<(N/2+1)) {
                    for(int j=N/2-i; j<=N/2+i; j++) {
                        Ans +=farm[i][j];
                    }
                }
                else {
                    for(int j=N/2 +i -(N-1); j<=N/2 -i +(N-1); j++) {
                        Ans +=farm[i][j];   
                    }
                     
                }
            }
            System.out.print("#"+test_case + " ");
            System.out.println(Ans);
             
        }
    }
 
    private static void print(int[][] farm) {
        // TODO Auto-generated method stub
        for (int i = 0; i < farm.length; i++) {
            for (int j = 0; j < farm[i].length; j++) {
                System.out.print(farm[i][j]+" ");
            }
            System.out.println();
        }
         
    }
}