import java.util.Scanner;
import java.io.FileInputStream;
 
import java.math.BigInteger;
 
class Solution
{
 
    static int cnt=1;
    static int[] dx = {0,1,0,-1}; // 0~3 우하좌상 순서 nx = (x+1)%4한다.
    static int[] dy = {1,0,-1,0};//
    public static void main(String args[]) throws Exception
    {
 
 
        Scanner sc = new Scanner(System.in);
        int T;
        T=sc.nextInt();
  
        //T=1;
        for(int test_case = 1; test_case <= T; test_case++)
        {
            int N =sc.nextInt();
            Integer[][] arr = new Integer[N][N];
            for(int i=0; i<N ;i++) {
                for (int j = 0; j < N; j++) {
                    arr[i][j] =0;
                }
            }
            int d =0;
      
            recursive(0,0,d,arr);
            System.out.println("#"+test_case);
            for(int i=0; i<N ;i++) {
                for (int j = 0; j < N; j++) {
                    System.out.print(arr[i][j]+" ");
                }
                System.out.println();
            }
 
        }
         
    }
      
     public static void recursive(int x, int y, int d, Integer[][] arr) {
         if(cnt == arr.length*arr.length) {
             arr[x][y] = cnt;
             cnt=1;
             return;
         }
          
          
         int nx = x + dx[d];
         int ny = y+ dy[d]; //다음위치를 본다.
         //다음위치로 가면안된다. 바깥 나간것, 현재위치에 arr의 값이 0이아닌것.
         if(nx<0 || nx>=arr.length || ny<0 || ny>=arr.length || arr[nx][ny]!=0) {
             nx= nx-dx[d];
             ny =ny-dy[d]; //잘못왔으니까 물러남
             d = (d+1)%4; //방향을 튼다.
         }
         else {
             arr[x][y] = cnt++;//할일은 지금 위치에 숫자를 찍는 것
         }
          
 
         recursive(nx, ny, d, arr);//나머지는 넘긴다.
     }
  
          
}