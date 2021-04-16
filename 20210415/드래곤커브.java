import java.util.*;
import java.io.*;

public class 드래곤커브 {
	static int N;
	static int[][] info;
	static int[][] map = new int[101][101];
	static int[] dr = { 0, -1, 0, 1 };
	static int[] dc = { 1, 0, -1, 0 };
	static int result = 0;
	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		N = Integer.parseInt(br.readLine());
		info = new int[N][4];
		for (int i = 0; i < N; i++) {
			StringTokenizer st = new StringTokenizer(br.readLine());
			for (int j = 0; j < 4; j++) {
				info[i][j] = Integer.parseInt(st.nextToken());
			}
			draw(info[i]);
		}
		count();
		System.out.println(result);
	}

	private static void count() {
		for(int i = 0; i < 100; i++) {
			for(int j = 0; j < 100; j++) {
				if(map[i][j] == 1 && map[i][j+1] == 1 && map[i+1][j] == 1 && map[i+1][j+1] == 1)
					result++;
			}
		}
	}

	private static void print() {
		for(int i = 0; i <= 100; i++) {
			for(int j = 0; j <= 100; j++) {
				System.out.print(map[i][j] + " ");
			}
			System.out.println();
		}
	}

	private static void draw(int[] info) {
		int startX = info[0];
		int startY = info[1];
		int d = info[2];
		int g = info[3];
		List<int[]> li = new ArrayList<>();
		li.add(new int[] { startX, startY });
		li.add(new int[] { startX + dc[d], startY + dr[d] });
		map[startY][startX] = 1;
		map[startY + dr[d]][startX + dc[d]] = 1;

		for (int i = 0; i < g; i++) {
			int size = li.size();
			int[] center = li.get(size - 1);
			for(int k = size - 2; k >= 0; k--) {
				int[] rotated = rotate(center, li.get(k));
				li.add(rotated);
				if(rotated[0] >= 0 && rotated[0] <= 100 && rotated[1] >= 0 && rotated[1] <= 100)
					map[rotated[1]][rotated[0]] = 1;
			}
		}
	}

	private static int[] rotate(int[] center, int[] point) {
		int[] newPoint = new int[2];
		newPoint[0] = center[1] - point[1] + center[0];
		newPoint[1] = point[0] - center[0] + center[1];
		return newPoint;
	}
}
