import java.util.Scanner;

public class D3_1873 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner sc = new Scanner(System.in);
		int T;
		T=sc.nextInt();
		int[] dir_x = { 0, 0,-1, 1};
		int[] dir_y = {-1, 1, 0, 0};
		int dir = 0;
		for(int test_case = 1; test_case <= T; test_case++)
		{
			int row_size = sc.nextInt();
			int col_size = sc.nextInt();
			String[][] ground = new String[row_size][col_size];
			int[] now = new int[2];
			for(int i = 0; i < row_size; i++) {
				String line = sc.next();
				for(int j = 0; j < col_size; j++) {
					 ground[i][j] = Character.toString(line.charAt(j));
					 if("^v<>".indexOf(Character.toString(line.charAt(j))) > -1) {
						 dir = "^v<>".indexOf(Character.toString(line.charAt(j)));
						 now[0] = i;
						 now[1] = j;
					 }
				}
			}
			
			String[] cmd = new String[sc.nextInt()];
			String line = sc.next();
			
			for(int i = 0; i < cmd.length; i++)
				switch (Character.toString(line.charAt(i))) {
				case "U":
					dir = 0;
					if(now[0]+dir_y[dir] < row_size && now[1]+dir_x[dir] < col_size
							&&now[0]+dir_y[dir] >= 0 && now[1]+dir_x[dir] >= 0) {
						if(ground[now[0]+dir_y[dir]][now[1]+dir_x[dir]].equals(".")) {
							ground[now[0]][now[1]] = ".";
							now[0]+=dir_y[dir];
							now[1]+=dir_x[dir];
						}
					}
					ground[now[0]][now[1]] = Character.toString("^v<>".charAt(dir));
					break;
				case "D":
					dir = 1;
					if(now[0]+dir_y[dir] < row_size && now[1]+dir_x[dir] < col_size
							&&now[0]+dir_y[dir] >= 0 && now[1]+dir_x[dir] >= 0) {
						if(ground[now[0]+dir_y[dir]][now[1]+dir_x[dir]].equals(".")) {
							ground[now[0]][now[1]] = ".";
							now[0]+=dir_y[dir];
							now[1]+=dir_x[dir];
						}
					}
					ground[now[0]][now[1]] = Character.toString("^v<>".charAt(dir));
					break;
				case "L":
					dir = 2;
					if(now[0]+dir_y[dir] < row_size && now[1]+dir_x[dir] < col_size
							&&now[0]+dir_y[dir] >= 0 && now[1]+dir_x[dir] >= 0) {
						if(ground[now[0]+dir_y[dir]][now[1]+dir_x[dir]].equals(".")) {
							ground[now[0]][now[1]] = ".";
							now[0]+=dir_y[dir];
							now[1]+=dir_x[dir];
						}
					}
					ground[now[0]][now[1]] = Character.toString("^v<>".charAt(dir));
					break;
				case "R":
					dir = 3;
					if(now[0]+dir_y[dir] < row_size && now[1]+dir_x[dir] < col_size
							&&now[0]+dir_y[dir] >= 0 && now[1]+dir_x[dir] >= 0) {
						if(ground[now[0]+dir_y[dir]][now[1]+dir_x[dir]].equals(".")) {
							ground[now[0]][now[1]] = ".";
							now[0]+=dir_y[dir];
							now[1]+=dir_x[dir];
						}
					}
					ground[now[0]][now[1]] = Character.toString("^v<>".charAt(dir));
					break;
				
				case "S":
					int[] soot = {now[0], now[1]};
					while(true) {
						if(soot[0]+dir_y[dir] >= row_size || soot[1]+dir_x[dir] >= col_size
								|| soot[0]+dir_y[dir] < 0 || soot[1]+dir_x[dir] < 0)
							break;
						if(ground[soot[0]+dir_y[dir]][soot[1]+dir_x[dir]].equals(".") || 
								ground[soot[0]+dir_y[dir]][soot[1]+dir_x[dir]].equals("-")) {
							soot[0]+=dir_y[dir];
							soot[1]+=dir_x[dir];
						}
						else if(ground[soot[0]+dir_y[dir]][soot[1]+dir_x[dir]].equals("*")) {
							ground[soot[0]+dir_y[dir]][soot[1]+dir_x[dir]] = ".";
							break;
						}
						else {
							break;
						}
					}
					break;
	
				default:
					break;
				}
			System.out.print("#"+test_case+" ");
			for(int i = 0; i < row_size; i++) {
				for(int j = 0; j < col_size; j++) {
					 System.out.print(ground[i][j]);
				}
				System.out.println();
			}
		}
	}

}
