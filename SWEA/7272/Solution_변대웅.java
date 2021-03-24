import java.util.Scanner;
 
public class Solution {
 
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String result = "SAME";
        int t = sc.nextInt();
 
        for (int test_case = 1; test_case <= t; test_case++) {
            String s1 = sc.next();
            String s2 = sc.next();
            if (getCode(s1).equals(getCode(s2)))
                result = "SAME";
            else
                result = "DIFF";
            System.out.println("#" + test_case + " " + result + "");
        }
    }
 
    public static String getCode(String s1) {
        StringBuilder result = new StringBuilder("");
        for (char a : s1.toCharArray())
            if (a == 'B') {
                result.append("1");
            } else if (a == 'A' || a == 'D' || a == 'O' || a == 'P' || a == 'Q' || a == 'R') {
                result.append("2");
            } else {
                result.append("3");
            }
        return result.toString();
    }
}