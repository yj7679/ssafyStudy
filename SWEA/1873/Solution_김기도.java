package D3;

import java.util.Scanner;

public class BattleField {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int T = sc.nextInt();
		for(int i=0;i<T;i++)
		{
			int test = i+1;
			int H = sc.nextInt();
			int W = sc.nextInt();
			char[][] arr = new char[H][W];
			int x = 0;
			int y = 0;
			for(int j=0;j<H;j++)
			{
				String c = sc.next();
				for(int k=0;k<W;k++)
				{
					arr[j][k] = c.charAt(k);
					if(arr[j][k]=='<' || arr[j][k]=='^' || arr[j][k]=='v' || arr[j][k]=='>')
					{
						x = j;
						y = k;
					}
				}
			}
			int input = sc.nextInt();
			sc.nextLine();
			String od = sc.nextLine();
			char[] tank = new char[input];
			for(int j=0;j<input;j++)
			{
				tank[j] = od.charAt(j);
			}
			for(int j=0;j<input;j++)
			{
				if(tank[j] == 'S')	// 포탄쏠때
				{
					int sx =x;
					int sy =y;
					if(arr[x][y] == '<') // 전차가 왼쪽 볼때
					{
						while(true)
						{
							sy = sy-1;
							if(sx>=0 && sx<H && sy>=0 && sy<W)
							{
								if(arr[sx][sy] == '#')
								{
									break;
								}
								else if(arr[sx][sy] == '*')
								{
									arr[sx][sy] = '.';
									break;
								}
							}
							else
							{
								break;
							}
						}
					}
					else if(arr[x][y] == '>')// 전차가 오른쪽 볼때
					{
						while(true)
						{
							sy = sy+1;
							if(sx>=0 && sx<H && sy>=0 && sy<W)
							{
								if(arr[sx][sy] == '#')
								{
									break;
								}
								else if(arr[sx][sy] == '*')
								{
									arr[sx][sy] = '.';
									break;
								}
							}
							else
							{
								break;
							}
						}
					}
					else if(arr[x][y] == '^')// 전차가 위쪽 볼때
					{
						while(true)
						{
							sx = sx-1;
							if(sx>=0 && sx<H && sy>=0 && sy<W)
							{
								if(arr[sx][sy] == '#')
								{
									break;
								}
								else if(arr[sx][sy] == '*')
								{
									arr[sx][sy] = '.';
									break;
								}
							}
							else
							{
								break;
							}
						}
					}
					else if(arr[x][y] == 'v')// 전차가 아래쪽 볼때
					{
						while(true)
						{
							sx = sx+1;
							if(sx>=0 && sx<H && sy>=0 && sy<W)
							{
								if(arr[sx][sy] == '#')
								{
									break;
								}
								else if(arr[sx][sy] == '*')
								{
									arr[sx][sy] = '.';
									break;
								}
							}
							else
							{
								break;
							}
						}
					}
				}
				else if(tank[j] == 'U')
				{
					arr[x][y] = '^';
					if(x-1>=0 && x-1<H && y>=0 && y<W && arr[x-1][y] == '.')
					{
						arr[x][y] = '.';
						x = x-1;
						arr[x][y] = '^';
					}
				}
				else if(tank[j] == 'D')
				{
					arr[x][y] = 'v';
					if(x+1>=0 && x+1<H && y>=0 && y<W && arr[x+1][y] == '.')
					{
						arr[x][y] = '.';
						x = x+1;
						arr[x][y] = 'v';
					}
				}
				else if(tank[j] == 'R')
				{
					
					arr[x][y] = '>';
					if(x>=0 && x<H && y+1>=0 && y+1<W && arr[x][y+1] == '.')
					{
						arr[x][y] = '.';
						y=y+1;
						arr[x][y] = '>';
					}
				}
				else if(tank[j] == 'L')
				{
					
					arr[x][y] = '<';
					if(x>=0 && x<H && y-1>=0 && y-1<W && arr[x][y-1] == '.')
					{
						arr[x][y] = '.';
						y = y-1;
						arr[x][y] = '<';
					}
				}
			}
			System.out.print("#"+test+" ");
			for(int j=0;j<H;j++)
			{
				for(int k=0;k<W;k++)
				{
					System.out.print(arr[j][k]);
				}
				System.out.println("");
			}
		}

	}

}
