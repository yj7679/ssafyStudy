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