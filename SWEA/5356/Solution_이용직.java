import java.util.Scanner;
import java.io.FileInputStream;
 
 
class Solution
{
    public static void main(String args[]) throws Exception
    {
         
        Scanner sc = new Scanner(System.in);
        int T;
        T=sc.nextInt();
 
 
        for(int test_case = 1; test_case <= T; test_case++)
        {
         
            String[] str = new String[5];
            int max= 0;
            int len=0;
            for(int i=0; i<5; i++) {
                str[i] = sc.next();
                len = str[i].length();
                if(len>max) {
                    max = len;
                }
            }
            char[][] table = new char[max][max];
             
            for(int i=0; i<5; i++) {
                for(int j=0; j<str[i].length(); j++) {
                    table[i][j] = str[i].charAt(j);
                }
            }
             
            System.out.print("#"+test_case + " ");
 
              for(int i=0; i<max; i++) {
                  for(int j=0; j<5; j++) {
                      //char의 기본 초기화는 \u0000이다. 
                      if(table[j][i]!='\u0000') {
                          System.out.print(table[j][i]);
                      }
                  }
              }
              
            System.out.println();
 
        }
    }
}