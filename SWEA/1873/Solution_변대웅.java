import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.util.Scanner;
 
public class Solution {
 
    public static void main(String[] args) throws FileNotFoundException {
 
        Scanner sc = new Scanner(System.in);
 
        int t = sc.nextInt();
        int[] dr = { -1, 0, 1, 0 };
        int[] dc = { 0, 1, 0, -1 };
 
        for (int test_case = 1; test_case <= t; test_case++) {
            int h = sc.nextInt();
            int w = sc.nextInt();
            int cw = 0;
            int cc = 0;
            char[] dirs = { '^', '>', 'v', '<' };
            char dir = 0;
 
            char[][] map = new char[h][w];
 
            for (int i = 0; i < h; i++) {
                map[i] = sc.next().toCharArray();
                for (int k = 0; k < w; k++) {
                    if (map[i][k] == '^') {
                        cw = i;
                        cc = k;
                        dir = 0;
                    } else if (map[i][k] == '>') {
                        cw = i;
                        cc = k;
                        dir = 1;
                    } else if (map[i][k] == 'v') {
                        cw = i;
                        cc = k;
                        dir = 2;
 
                    } else if (map[i][k] == '<') {
                        cw = i;
                        cc = k;
                        dir = 3;
                    }
                }
            }
            int n = sc.nextInt();
            char[] commands = sc.next().toCharArray();
 
            for (char c : commands) {
                if (c != 'S') {
                    if (c == 'U') {
                        dir = 0;
                    } else if (c == 'R') {
                        dir = 1;
                    } else if (c == 'D') {
                        dir = 2;
                    } else if (c == 'L') {
                        dir = 3;
                    }
                    map[cw][cc] = dirs[dir];
                    int tw = cw + dr[dir];
                    int tc = cc + dc[dir];
                    if (tw >= 0 && tw < h && tc >= 0 && tc < w && map[tw][tc] == '.') {
                        map[tw][tc] = dirs[dir];
                        map[cw][cc] = '.';
                        cw = tw;
                        cc = tc;
                    }
                } else {
                    int tw = cw + dr[dir];
                    int tc = cc + dc[dir];
                    while (tw >= 0 && tw < h && tc >= 0 && tc < w) {
                        if (map[tw][tc] == '#')
                            break;
                        else if (map[tw][tc] == '*') {
                            map[tw][tc] = '.';
                            break;
                        }
                        tw = tw + dr[dir];
                        tc = tc + dc[dir];
                    }
                }
            }
 
            System.out.print("#" + test_case + " ");
            print(map);
        }
    }
 
    public static void print(char[][] board) {
        for (int i = 0; i < board.length; i++) {
            for (int j = 0; j < board[i].length; j++) {
                System.out.print(board[i][j]);
            }
            System.out.println();
        }
    }
}