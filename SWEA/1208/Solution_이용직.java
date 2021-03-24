import java.util.Scanner;
import java.io.FileInputStream;
 
class Solution
{
    static int lim=0;
    static int[] boxs = new int[100];
    static int cnt=0;
    static int temp;
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
            lim = sc.nextInt();
            cnt=0;
            for(int i=0; i<100; i++) {
                boxs[i] = sc.nextInt();             
            }
            //sorting
            for(int i=0; i<100; i++) {
                for(int j=0; j<99;j++) {
                    if(boxs[j]>boxs[j+1]) {
                    temp = boxs[j];
                    boxs[j] = boxs[j+1];
                    boxs[j+1] = temp;
                    }   
                }
            }
 
            while(true) {
                cnt++;
                for(int i= 99; i>0;i--) {
                    if(boxs[i-1]<boxs[i]){//끝에서 훑다가 작아지는 변경이 일어나면 뜯음
                    boxs[i]--;
                    break;
                    }
                }
                for(int i=0; i<100; i++) {
                    if(boxs[i]<boxs[i+1]) { //커지는 변화가 있으면 거기에 넣음
                        boxs[i]++;
                        break;
                    }
                }
                if(cnt == lim) {
                    break;
                }
            }
            System.out.print("#"+test_case + " ");
            System.out.println(boxs[99]-boxs[0]);
             
 
 
             
             
        }
    }
 
         
}
 