import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.StringTokenizer;

public class Main {
	public static int space = 0;

	public static void main(String[] args) throws IOException {

		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		int R = Integer.parseInt(st.nextToken());
		int C = Integer.parseInt(st.nextToken());
		int map[][] = new int[R][C];
		int dir[][] = { { 1, 0 }, { -1, 0 }, { 0, 1 }, { 0, -1 } };
		int answer = 9999;
		ArrayDeque<int[]> dq = new ArrayDeque<>();

		// 1. ��ǥ �� ���� BFS�� ��������.
		// 2. BFS�� �ϸ鼭 1�� ���������� count++
		
		for (int i = 0; i < R; i++) {
			String str = br.readLine();
			for (int j = 0; j < C; j++) {
				// map �ʱ�ȭ
				map[i][j] = str.charAt(j) == '1' ? 1 : 0;
				// bfs�����鼭 ã�� 1�� ������ space�� ������ stop
				if (map[i][j] == 1)
					space++;
			}
		}
		
		for (int i = 0; i < R; i++) {
			for (int j = 0; j < C; j++) {
				if (map[i][j] == 0) {

					for (int a = i; a < R; a++) {
						for (int b = j; b < C; b++) {
							if (i == a && j == b)
								continue;
							if (map[a][b] == 0) {
								// ���� �ٸ��� 0 �� �����, ���������� bfs�ؼ� �ּҽð� ���ϱ�

								int cmap[][] = new int[R][C];
								for (int z = 0; z < R; z++)
									cmap[z] = map[z].clone();

								int time = 0;
								int spacecount = 0;
								System.out.println(i + " " + j);
								dq.add(new int[] { i, j });
								System.out.println(a + " " + b);
								System.out.println("");
								cmap[i][j] = 2;
								dq.add(new int[] { a, b });
								cmap[a][b] = 2;
							
								while (!dq.isEmpty()) {
									time++;
									int size = dq.size();
									while (size-- > 0) {
										int now[] = dq.poll();
										
										for (int k = 0; k < 4; k++) {
											int nr = now[0] + dir[k][0];
											int nc = now[1] + dir[k][1];
											if (nr >= 0 && nc >= 0 && nr < R && nc < C && cmap[nr][nc] != 2) {
												if (cmap[nr][nc] == 1)
													spacecount++;
												cmap[nr][nc] = 2;
												dq.add(new int[] { nr, nc });
											}
										}
									}
									if (spacecount == space)
										break;
								}
								dq.clear();
								answer = answer > time ? time : answer;
							}
						}
					}

				}
			}
		}
		System.out.println(answer);
	}
}