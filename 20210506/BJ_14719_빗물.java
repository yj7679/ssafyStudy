import java.io.*;
import java.util.*;

// 
public class BJ_14719_빗물 {

	static int H, W;
	static int[][] block;

	public static void main(String[] args) throws Exception {
		System.setIn(new FileInputStream("input.txt"));
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		H = Integer.parseInt(st.nextToken());
		W = Integer.parseInt(st.nextToken());
		block = new int[H][W];
		
		st = new StringTokenizer(br.readLine());
		for (int i = 0; i < W; i++) {
			int blockHeight = Integer.parseInt(st.nextToken());
			for (int j = H-1; j > H-1-blockHeight; j--) {
				block[j][i] = -1;	//블록은 -1
			}
		}
		
		for (int w = 0; w < W; w++) {
			for (int h = 0; h < H; h++) {
				if(block[h][w] == -1) {	// 만약 벽이라면
					int tmph = h;
					int tmpw = w+1;
					while(tmpw < W && block[tmph][tmpw] == 0) {
						++tmpw;
					}
					if(tmpw < W) {
						while(block[tmph][--tmpw] == 0) {
							block[tmph][tmpw] = 1;
						}
					}
				}
			}
		}
		
		System.out.println(getWater(block));
		
//		for (int i = 0; i < H; i++) {
//			System.out.println(Arrays.toString(block[i]));
//		}
		
	}

	private static int getWater(int[][] block) {
		int res = 0;
		for (int i = 0; i < block.length; i++) {
			for (int j = 0; j < block[i].length; j++) {
				if(block[i][j] == 1)	++res;
			}
		}
		return res;
	}
}