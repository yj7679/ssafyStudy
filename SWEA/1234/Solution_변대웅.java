import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.util.Scanner;
 
public class Solution {
 
    public static void main(String[] args) throws FileNotFoundException {
//      System.setIn(new FileInputStream("input.txt"));
        Scanner sc = new Scanner(System.in);
 
        int t = 10;
        for (int test_case = 1; test_case <= t; test_case++) {
            int size = sc.nextInt();
            String s = sc.next();
            int idx = 0;
            while(idx < s.length() - 1) {
                if(s.charAt(idx) == s.charAt(idx+1)) {
                    s = s.substring(0, idx) + s.substring(idx+2, s.length());
                    idx = 0;
                } else {
                    idx++;
                }
            }
            System.out.println("#" + test_case + " " + s);
        }
 
    }
}