import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.util.Scanner;
 
public class Solution {
 
    public static void main(String[] args) throws FileNotFoundException {
        //System.setIn(new FileInputStream("input.txt"));
        Scanner sc = new Scanner(System.in);
 
        int t = 10;
        for (int test_case = 1; test_case <= t; test_case++) {
            int[] boxes = new int[100];
            int minIndex = 0;
            int min = Integer.MAX_VALUE;
            int maxIndex = 0;
            int max = Integer.MIN_VALUE;
 
            int dump = sc.nextInt();
 
            for (int i = 0; i < 100; i++) {
                boxes[i] = sc.nextInt();
                if (boxes[i] < min) {
                    min = boxes[i];
                    minIndex = i;
                }
                if (boxes[i] > max) {
                    max = boxes[i];
                    maxIndex = i;
                }
            }
 
            for (int i = 0; i < dump; i++) {
                boxes[minIndex]++;
                boxes[maxIndex]--;
                min = Integer.MAX_VALUE;
                max = Integer.MIN_VALUE;
                for (int k = 0; k < 100; k++) {
                    if (boxes[k] < min) {
                        min = boxes[k];
                        minIndex = k;
                    }
                    if (boxes[k] > max) {
                        max = boxes[k];
                        maxIndex = k;
                    }
                }
                if((max - min) < 2)
                    break;
 
            }
            System.out.println("#" + test_case + " " + (max - min));
        }
    }
}