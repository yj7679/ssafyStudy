import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.util.Scanner;
 
public class Solution {
 
    public static void main(String[] args) throws FileNotFoundException {
        Scanner sc = new Scanner(System.in);
         
        int t = sc.nextInt();
        for(int test_case = 1; test_case <= t; test_case++) {
            int n = sc.nextInt();
            int center = n / 2;
            int result = 0;
             
            for(int i = 0; i < n; i++) {
                String gains = sc.next();
                for(int j = 0; j < n; j++) {
                    int gain = (int)gains.charAt(j) - (int)'0';
                    if(i <= center) {
                        if(j >= center - i && j <= center + i)
                            result += gain;
                    }
                    else {
                        if(j >= center - (n - 1 - i) && j <= center + (n - 1 - i))
                            result += gain;
                    }
                }
            }
            System.out.println("#"+test_case+" "+result+"");
        }
         
    }
}