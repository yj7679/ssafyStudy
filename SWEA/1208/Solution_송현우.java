import java.util.Scanner;
import java.io.FileInputStream;
import java.util.Arrays;
 
class Solution
{
    public static void main(String[] args) {
        // TODO Auto-generated method stub
        Scanner sc = new Scanner(System.in);
        int T = 10;
        for(int test_case = 1; test_case <= 10; test_case++) {
            int dump = sc.nextInt();
            int[] boxs = new int[100];
            for(int i = 0; i<100; i++) {
                boxs[i] = sc.nextInt();
            }
            Arrays.sort(boxs);
            for(int i = 0; i < dump; i++) {
                if(boxs[99]-boxs[0] < 2) 
                    break;
                else {
                    boxs[99] = boxs[99]-1;
                    boxs[0] = boxs[0] + 1;
                    Arrays.sort(boxs);
                }
            }
            System.out.println("#"+test_case+" "+(boxs[99]-boxs[0]));
        }
    }
}