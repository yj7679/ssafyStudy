import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.Queue;

//뱀과 사다리게임 - BFS
public class Main {
	static int N,M;
	static int[] sn = new int[101];
	static int[] la = new int[101];
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		String[] str = br.readLine().split(" ");
		N = Integer.parseInt(str[0]);
		M = Integer.parseInt(str[1]);
		
		for(int i=0; i<N; i++) {
			str = br.readLine().split(" ");
			int from = Integer.parseInt(str[0]);
			int to = Integer.parseInt(str[1]);
			la[from] = to;
		}
		for(int i=0; i<M; i++) {
			str = br.readLine().split(" ");
			int from = Integer.parseInt(str[0]);
			int to = Integer.parseInt(str[1]);
			sn[from]=to;
		}
		
		bfs(1);
		
		
		
	}
	private static void bfs(int start) {
		Queue<Integer> q = new LinkedList<>();
		int[] v = new int[101];
		q.add(start);
		v[start]=1;
		
		while(!q.isEmpty()) {
			
			for(int s=0;s<q.size();s++) {
				int x = q.poll();
				//100번째칸에 도착한 경우
				if(x==100) {
					System.out.println(v[x]-1);
					//System.out.println(Arrays.toString(v));
					System.exit(0);
				}
				for(int i=1;i<=6;i++) {
					int nx = x+i;
					
					
					if(nx<101) {
						//그냥 빈칸으로 옮겼을때
						if(v[nx]==0 && sn[nx]==0 && la[nx]==0) {
							q.add(nx);
							v[nx]=v[x]+1;
						}
						//뱀만난 경우
						else if(v[nx]==0 && sn[nx]!=0 && v[sn[nx]]==0) {
							q.add(sn[nx]);
							v[nx]=v[x]+1;
							v[sn[nx]]= v[x]+1;
						}
						//사다리 만난 경우
						else if(v[nx]==0 && la[nx]!=0 & v[la[nx]]==0) {
							q.add(la[nx]);
							v[nx]=v[x]+1;
							v[la[nx]]= v[x]+1;
						}
						
						
						
						
					}
	
					
					
					
					
				}
			}
			
			
		}
		
	}

}
