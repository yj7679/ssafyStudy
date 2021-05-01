package BaekJun;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

public class Dice {

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		String[] s = br.readLine().split(" ");
		int N=Integer.parseInt(s[0]);
		int M=Integer.parseInt(s[1]);
		int x=Integer.parseInt(s[2]);
		int y=Integer.parseInt(s[3]);
		int o=Integer.parseInt(s[4]);
		int[][] map = new int[N][M];
		int[] dice = new int[6]; // 0앞 1위 2뒤 3밑 4왼 5오
		for(int i=0;i<N;i++)
		{
			s = br.readLine().split(" ");
			for(int j=0;j<M;j++)
			{
				map[i][j] = Integer.parseInt(s[j]);
			}
		}
		s = br.readLine().split(" ");
		for (int i = 0; i < o; i++) {
			int val = Integer.parseInt(s[i]);
			if(val ==4)
			{
//				System.out.println("값"+val);
				
				if(x+1<0 || x+1>=N || y<0 || y>=M)
					continue;
				x++;
				int temp = dice[0];
				for(int j=0;j<3;j++)
				{
					dice[j] = dice[j+1];
				}
				dice[3] = temp;
				if(map[x][y]==0)
				{
					map[x][y] = dice[3];
				}
				else
				{
					dice[3] = map[x][y];
					map[x][y]=0;
				}
			
//				System.out.println(Arrays.toString(dice));
				System.out.println(dice[1]);
			}
			else if(val ==3)
			{
//				System.out.println("값"+val);
				
				if(x-1<0 || x-1>=N || y<0 || y>=M)
					continue;
				x--;
				int temp = dice[3];
				for(int j=3;j>0;j--)
				{
					dice[j] = dice[j-1];
				}
				dice[0] = temp;
				if(map[x][y]==0)
				{
					map[x][y] = dice[3];
				}
				else
				{
					dice[3] = map[x][y];
					map[x][y]=0;
				}
//				System.out.println(Arrays.toString(dice));
				System.out.println(dice[1]);
			}
			else if(val ==2)// 0앞 1위 2뒤 3밑 4왼 5오
			{
//				System.out.println("값"+val);
			
				if(x<0 || x>=N || y-1<0 || y-1>=M)
					continue;
				y--;
				//왼>밑, 위>왼, 오>위, 밑>오
				int temp = dice[3];
				dice[3] = dice[4];
				dice[4] = dice[1];
				dice[1] = dice[5];
				dice[5] = temp;
				
				if(map[x][y]==0)
				{
					map[x][y] = dice[3];
				}
				else
				{
					dice[3] = map[x][y];
					map[x][y]=0;
				}
//				System.out.println(Arrays.toString(dice));
				System.out.println(dice[1]);
				
			}
			else if(val ==1)// 0앞 1위 2뒤 3밑 4왼 5오
			{
//				System.out.println("값"+val);
				if(x<0 || x>=N || y+1<0 || y+1>=M)
					continue;
				y++;
				//오>밑, 위>오, 왼>위, 밑>왼
				int temp = dice[3];
				dice[3] =dice[5];
				dice[5] =dice[1];
				dice[1] = dice[4];
				dice[4] = temp;
				
				if(map[x][y]==0)
				{
					map[x][y] = dice[3];
				}
				else
				{
					dice[3] = map[x][y];
					map[x][y]=0;
				}
				
//				System.out.println(Arrays.toString(dice));
				System.out.println(dice[1]);
				
			}
		}
	}

}
