import java.util.*;
import java.io.*;
public class 빗물 {
	public static void main(String[] args) throws Exception{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		int H = Integer.parseInt(st.nextToken());
		int W = Integer.parseInt(st.nextToken());
		int[] arr = new int[W];
		st = new StringTokenizer(br.readLine());
		for(int i = 0; i < W; i++) {
			arr[i] = Integer.parseInt(st.nextToken());
		}
		
		int result = 0;
		
		for(int i = 1; i < W - 1; i++) {
			int height = arr[i];
			int lHeight = height;
			int rHeight = height;
			for(int l = i - 1; l >= 0; l--) {
				lHeight = Math.max(lHeight, arr[l]);
			}
			for(int r = i + 1; r < W; r++) {
				rHeight = Math.max(rHeight, arr[r]);
			}
			result += Math.min(lHeight, rHeight) - height;
		}
		System.out.println(result);
	}

}
