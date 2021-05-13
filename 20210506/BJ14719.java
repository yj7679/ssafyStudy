package day0504;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

//빗물 - 시뮬레이션
public class BJ14719 {
	static int H,W;
	static int[][] map;
	static int[] nums;
	static int ans=0;
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st= new StringTokenizer(br.readLine()," ");
		
		H = Integer.parseInt(st.nextToken());
		W = Integer.parseInt(st.nextToken());
		map = new int[H][W];
		nums = new int[W];
		st= new StringTokenizer(br.readLine()," ");
		for(int i=0;i<W;i++) {
			nums[i] =Integer.parseInt(st.nextToken());
		}
		
		for(int w=0;w<W;w++) {	
			for(int h=0;h<nums[w];h++) {
				map[h][w] = 1;
				
			}
		}
		//print(map);
		
		for(int i=0;i<H;i++) {
			ans+=water(i);
		}
		System.out.println(ans);
		
	}
	private static int water(int i) {
		int cumul_cnt=0;
		int temp_cnt=0;
		boolean flag=false;
		for (int j = 0; j < W; j++) {
			// 막혀서 빗물을 담을 곳이 생긴경우
			if(temp_cnt!=0 && flag==true && map[i][j]==1) {
				cumul_cnt +=temp_cnt;
				temp_cnt=0;
			}
			
			// 쌓일 수 있는 곳인데 안막혀서 계속 쌓을 수 있는 경우
			else if(flag== true && map[i][j]==0) {
				temp_cnt++;
			}
			
			//처음으로 벽에 닿아서 쌓아나가기 시작할 수 있는 위치인 경우
			else if(temp_cnt==0 && flag==false && map[i][j]==1) {
				flag=true;
			}
		}
		return cumul_cnt;
	}
	private static void print(int[][] map2) {
		for (int i = 0; i < map2.length; i++) {
			for (int j = 0; j < map2[i].length; j++) {
				System.out.print(map2[i][j]);
			}
			System.out.println();
		}
	}

}
