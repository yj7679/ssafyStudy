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
            String str1 = sc.next();
            String str2 = sc.next();
            int len1 = str1.length();
            int len2 = str2.length();
             
            //길이 다르면 다른 문자열이다.
             
            System.out.print("#"+ test_case +" ");
            if (len1!= len2) {
                System.out.println("DIFF");
                continue;
            }
            //문자열 두개를 하나씩 비교하는데 중간에 다르면 빠지게 flag넣는다.
            boolean flag = true;
            for(int i=0; i<len1;i++) {
                //다르면
                if(!(check(str1.charAt(i),str2.charAt(i)))) {
                    flag = false;
                    break; // 더비교할필요없음
                }
                 
            }
            //비교끝: 다똑같으면 flag ==true 아니면 false
            if(flag ==true) {
                System.out.println("SAME");
            }
            else {
                System.out.println("DIFF");
            }
             
             
        }
    }
     
    public static boolean check(char a, char b) {
        char[] noO = {'C','E','F','G','H','I','J','K','L','M','N','S','T','U','V','W','X','Y','Z'};
        char[] oneO = {'A','D','O','P','Q','R'};
        char[] twoO = {'B'};
        //테이블로 합쳐서 이중 FOR문에 넣을 수 있게끔
        char[][] table = new char[3][];
        table[0] = noO;
        table[1] = oneO;
        table[2] = twoO;
         
        // 문자 a와 문자 b가 구멍이 몇개인지 저장
        int numa=0;
        int numb=0;
         
        for(int i=0; i<table.length;i++) {
            for(int j=0; j<table[i].length; j++) {
                if(a==table[i][j]) {
                    //table의 0번째 행에는 구멍0개인애들이니까 그냥 i넣음. 나머지도 마찬가지
                    numa = i;
                }
                if(b == table[i][j]) {
                    numb= i;
                }
            }
        }
         
        //종류가 같으면 true 리턴
        if(numa == numb) return true;
        else return false;
         
         
         
    }
 
     
}