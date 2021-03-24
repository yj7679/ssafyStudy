import java.util.Scanner;
import java.io.FileInputStream;
 
class Solution
{
    static char[] memo = new char[51];
    static char[] init = new char[51];
    static char[] com = new char[101];
    static char[][] tb = new char[21][21];
    static int H;
    static int W;
    static int[] dx = {-1,0,1,0};
    static int[] dy = {0,1,0,-1};
    public static void main(String args[]) throws Exception
    {
        //System.setIn(new FileInputStream("inputs/input.txt"));
 
        /*
           표준입력 System.in 으로부터 스캐너를 만들어 데이터를 읽어옵니다.
         */
        Scanner sc = new Scanner(System.in);
        int T;
        T=sc.nextInt();
        /*
           여러 개의 테스트 케이스가 주어지므로, 각각을 처리합니다.
        */
 
 
        //T=10;
        for(int test_case = 1; test_case <= T; test_case++)
        {
            H= sc.nextInt();
            W = sc.nextInt();
            String str;
            for(int i=0; i<H ;i++) {
                str = sc.next();
                for(int j=0; j<W; j++) {
                    tb[i][j]=str.charAt(j);
                }
            }
            int N=sc.nextInt();
 
            str =sc.next();
            for(int i=0; i<N; i++) {
                tr(str.charAt(i));
                 
 
 
            }
            System.out.print("#"+ test_case+" ");
            for(int i=0; i<H ;i++) {
                for(int j=0; j<W; j++) {
                    System.out.print(tb[i][j]);
                }
                System.out.println();
            }
 
        }
    }
     
    public static void tr(char a) {
        int x=0;
        int y=0;
        int dir=0;
         
        //전차위치 찾기
        l:
        for(int i=0; i<H;i++) {
            for(int j=0; j<W; j++) {
                 
                if((tb[i][j]=='^') ||(tb[i][j]=='<')||(tb[i][j]=='>')||(tb[i][j]=='v')) {
                    x =i;
                    y =j;
                    break l;
                     
                }
            }
        }
         
        switch(a) {
        case 'S':
 
            //해당 위치별로 방향 설정
            if(tb[x][y]=='^') dir=0;
            else if(tb[x][y]=='>') dir=1;
            else if(tb[x][y]=='v') dir=2;
            else if(tb[x][y]=='<') dir=3;
            int nx=x + dx[dir];
            int ny=y +dy[dir];
             //물또는 평지는 다날라감
            while(nx>=0 && ny>=0 &&  nx<H  && ny<W &&  (tb[nx][ny]=='.'||tb[nx][ny]=='-') && (tb[nx][ny]!='#')) {
                nx = nx + dx[dir];
                ny = ny + dy[dir];
            }
            //다날라갔는데 끝에 벽돌 만나면 부심
            if(nx>=0 && ny>=0 &&  nx<H  && ny<W && tb[nx][ny]=='*') {
                tb[nx][ny] = '.';
            }
 
             
             
             
            break;
        case 'U':
            //올라갈 수 있는상황: 위가 평지
            if(x-1>=0 && x-1<H && tb[x-1][y]=='.') {
                tb[x][y]='.';//있던자리 평지화
                tb[x-1][y] = '^';//위칸으로 전차 변경
            }
             
            //못 가는 상황: 물,벽, 바깥
            else {;
                tb[x][y]='^';//위 쪽으로 방향만 바꿈
            }
 
            break;
             
             
        case 'R':
 
            //이동할 수 있는상황: 평지
            if(y+1>=0 && y+1 <W && tb[x][y+1]=='.') {
                tb[x][y]='.';//있던자리 평지화
                tb[x][y+1] = '>';//전차 방향 변경
            }
             
            //못 가는 상황: 물,벽, 바깥
            else {
                tb[x][y]='>';// 방향만 바꿈
            }
             
            break;
        case 'L':
 
             
            //이동할 수 있는상황: 평지
            if(y-1>=0 && y-1<W && tb[x][y-1]=='.') {
                tb[x][y]='.';//있던자리 평지화
                tb[x][y-1] = '<';//전차 방향 변경
            }
             
            //못 가는 상황: 물,벽, 바깥
            else {
                tb[x][y]='<';// 방향만 바꿈
            }
             
            break;
        case 'D':
 
            //이동할 수 있는상황: 평지
            if(x+1>=0 && x+1<H && tb[x+1][y]=='.') {
                tb[x][y]='.';//있던자리 평지화
                tb[x+1][y] = 'v';//전차 방향 변경
            }
             
            //못 가는 상황: 물,벽, 바깥
            else {
                tb[x][y]='v';// 방향만 바꿈
            }
             
             
            break;
        }
         
    }
     
     
 
         
}