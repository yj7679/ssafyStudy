import java.util.Scanner;
 
public class Solution {
 
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int t = sc.nextInt();
         
        for(int test_case = 1; test_case <= t; test_case++) {
            int sum = 0;
            int maxLength = Integer.MIN_VALUE;
            char[][] chrs = new char[5][];
            for(int i = 0; i < 5; i++) { 
                chrs[i] = sc.next().toCharArray();
                sum += chrs[i].length;
                maxLength = Math.max(chrs[i].length, maxLength);
            }
            char[] result = new char[sum];
            int idx = 0;
            for(int i = 0; i < maxLength; i++) {
                for(int j = 0; j < 5; j++) {
                    if(chrs[j].length <= i)
                        continue;
                    result[idx++] = chrs[j][i];
                }
            }
             
            System.out.println("#" + test_case + " " + new String(result));
        }
    }
}