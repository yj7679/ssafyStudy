import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

//별찍기 - 재귀 
public class Main {
	static char[][] map;
	static int N;
	static StringBuilder sb =new StringBuilder();
	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		N = Integer.parseInt(br.readLine());
		map = new char[N+1][2*N];
		for(int i=0; i<N+1;i++) {
			for(int j=0;j<2*N;j++) {
				map[i][j]=' ';
			}
		}
		makeStar(1,1,N);
		print(map);
		sb.deleteCharAt(sb.length()-1);
		System.out.print(sb);
	}

	
	private static void print(char[][] map2) {
		for(int i=1;i<=N;i++) {
			for(int j=1;j<=N*2-1;j++) {
				sb.append(map[i][j]);
			}
			sb.append('\n');
		}
	}


	private static void makeStar(int startx, int starty,int len) {
		if(len==3) {
			map[startx][starty+len-1] = '*';
			map[startx+1][starty+1] = '*';
			map[startx+1][starty+3] ='*';
			for(int j=0;j<len*2-1;j++) {
				map[startx+len-1][starty+j]='*';
			}

			return;
		}

		makeStar(startx,len+starty-len/2,len/2);
		makeStar(startx+len/2, starty, len/2);
		makeStar(startx+len/2, starty+len, len/2);
		

		
	}

}