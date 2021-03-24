import java.util.Scanner;
import java.io.FileInputStream;
 
class Solution {
    public static void main(String args[]) throws Exception {
        Scanner sc = new Scanner(System.in);
        int T;
        T = 10;
        for (int test_case = 1; test_case <= T; test_case++) {
            int N = sc.nextInt();
            int[] arr = new int[N];
            String line = sc.next();
 
            for (int i = 0; i < N; i++) {
                arr[i] = Integer.parseInt(Character.toString(line.charAt(i)));
            }
 
            int size = N;
 
            for (int i = 0; i < size - 1; i++) {
                if (arr[i] == arr[i + 1]) {
                    for (int j = i + 2; j < size && j-2 > -1; j++) {
                        arr[j - 2] = arr[j];
                    }
                    i -= 2;
                    if( i < 0)
                        i = -1;
                    size -= 2;
                }
            }
            System.out.print("#"+test_case+" ");
            for (int i = 0; i < size; i++) {
                System.out.print(arr[i]);
            }
            System.out.println();
        }
    }
}