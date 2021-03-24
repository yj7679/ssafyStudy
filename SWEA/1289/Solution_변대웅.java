import java.util.Arrays;
import java.util.Scanner;
 
public class Solution {
 
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int t = sc.nextInt();
 
        for (int test_case = 1; test_case <= t; test_case++) {
            int result = 0;
            String bits = sc.next();
            char currentChr = '0';
             
            for(int i = 0; i < bits.length(); i++) {
                if(bits.charAt(i) != currentChr) {
                    currentChr = currentChr == '0' ? '1' : '0';
                    result++;
                }
            }
            System.out.println("#" + test_case + " " + result);
        }
    }
}