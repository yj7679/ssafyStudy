import java.io.*;
import java.util.*;

// 낚시왕

class BJ_17143_낚시왕 {
	
	static int[] dr = {0, -1, 1, 0, 0};
	static int[] dc = {0, 0, 0, 1, -1};
	static int R, C, M, fishing = 0;
	static ArrayList<Shark> sharkList = new ArrayList<>();
	
	static class Shark implements Comparable<Shark>{
		int r, c, s, d, z;

		public Shark(int r, int c, int s, int d, int z) {
			super();
			this.r = r;
			this.c = c;
			this.s = s;
			this.d = d;
			this.z = z;
		}
		
		@Override
		public int compareTo(Shark o) {
			if(this.r == o.r && this.c == o.c) 	return o.z - this.z;
			if(this.r == o.r)					return this.c - o.c;
			else								return this.r - o.r;
		}
	}

	public static void main(String[] args) throws Exception {
		System.setIn(new FileInputStream("input.txt"));
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());

		R = Integer.parseInt(st.nextToken());
		C = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());
		
		for (int i = 0; i < M; i++) {
			st = new StringTokenizer(br.readLine());
			int r = Integer.parseInt(st.nextToken());
			int c = Integer.parseInt(st.nextToken());
			int s = Integer.parseInt(st.nextToken());
			int d = Integer.parseInt(st.nextToken());
			int z = Integer.parseInt(st.nextToken());
			sharkList.add(new Shark(r, c, s, d, z));
		}
		Collections.sort(sharkList);

		for (int c = 1; c <= C; c++) { // 낚시왕이 한 칸씩 이동
			L: for (int r = 1; r <= R; r++) { // 땅에서 제일 가까운 상어 잡기
				for (int m = 0; m < sharkList.size(); m++) {
					if(r == sharkList.get(m).r && c == sharkList.get(m).c) {
						fishing += sharkList.get(m).z;
						sharkList.remove(m);
						break L;
					}
				}
			}
			moveAll();
			eat();
			
		}
		System.out.println(fishing);
	}

	private static void moveAll() {
		for (int i = 0; i < sharkList.size(); i++) {
			move(sharkList.get(i));
		}
	}

	private static void move(Shark shark) {
		
		if(shark.d == 1 || shark.d == 2) { // 위, 아래로 움직이는 상어일 경우
			shark.s = shark.s % (2 * (R - 1));
		} else { // 왼쪽, 오른쪽으로 움직이는 상어일 경우
			shark.s = shark.s % (2 * (C - 1));
		}
		
		for (int i = 0; i < shark.s; i++) {
			int nr = shark.r + dr[shark.d];
			int nc = shark.c + dc[shark.d];
			if(nr >= 1 && nr <= R && nc >= 1 && nc <= C)	{ // 경계를 넘지 않고 그대로 움직일 경우
				shark.r = nr;
				shark.c = nc;
			} 
			else { // 경계를 넘을 경우
				if(shark.d % 2 == 1)	shark.d++;
				else					shark.d--;
				
				shark.r += dr[shark.d];
				shark.c += dc[shark.d];
			}
		}
	}
	
	private static void eat() {
		Collections.sort(sharkList);
		for (int i = 0; i < sharkList.size() - 1; i++) {
			for (int j = i + 1; j < sharkList.size(); j++) {
				if(sharkList.get(i).r == sharkList.get(j).r && sharkList.get(i).c == sharkList.get(j).c) { // 만약 위치가 같으면
					sharkList.remove(j--);	// 작은 놈이 잡아먹힌다
				}
				if(sharkList.get(i).r < sharkList.get(j).r)	break;
			}
		}
	}
}