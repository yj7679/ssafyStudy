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
                    if(boxs[i-1]<boxs[i]){//������ �ȴٰ� �۾����� ������ �Ͼ�� ����
                    boxs[i]--;
                    break;
                    }
                }
                for(int i=0; i<100; i++) {
                    if(boxs[i]<boxs[i+1]) { //Ŀ���� ��ȭ�� ������ �ű⿡ ����
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
 