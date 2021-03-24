import java.util.Scanner;
import java.io.FileInputStream;
import java.util.Arrays;
 
class Solution
{
    public static void main(String args[]) throws Exception
    {
                Scanner sc = new Scanner(System.in);
        int T;
        T=sc.nextInt();
         
        String[] one = {"A","D","O","P","Q","R"};
        String[] two = {"B"};
        String[] other = {"C","E","F","G","H","I","J","K","L","M","N","S","T","U","V","W","X","Y","Z"};
        for(int test_case = 1; test_case <= T; test_case++)
        {
            String left = sc.next();
            String right = sc.next();
             
            if(left.length() != right.length()) {
                System.out.println("#"+test_case+" DIFF");
                continue;
            }
             
            boolean same = true;
            for(int i = 0; i < left.length(); i++) {
                if(Arrays.asList(one).contains(Character.toString(left.charAt(i)))) {
                    if(!Arrays.asList(one).contains(Character.toString(right.charAt(i)))) {
                        same = false;
                        break;
                    }
                }
                else if(Arrays.asList(two).contains(Character.toString(left.charAt(i)))) {
                    if(!Arrays.asList(two).contains(Character.toString(right.charAt(i)))) {
                        same = false;
                        break;
                    }
                }
                else {
                    if(!Arrays.asList(other).contains(Character.toString(right.charAt(i)))) {
                        same = false;
                        break;
                    }
                }
            }
            if(same)
                System.out.println("#"+test_case+" SAME");
            else
                System.out.println("#"+test_case+" DIFF");
        }
    }
}