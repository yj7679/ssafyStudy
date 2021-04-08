import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

//평범한 배낭 - DP
public class Main {
	static int N,K;
	static int[][] D;
	static int[] v,w;
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		String[] str = br.readLine().split(" ");
		N = Integer.parseInt(str[0]);
		K = Integer.parseInt(str[1]);
		D = new int[N+1][K+1];
		v = new int[N+1];
		w = new int[N+1];
		
		//i번째 물건을 무게와 가치로 저장
		for(int i=1; i<=N; i++) {
			str = br.readLine().split(" ");
			int weight = Integer.parseInt(str[0]);
			int value = Integer.parseInt(str[1]);
			w[i] = weight;
			v[i] = value;
		}
		
		//System.out.println(Arrays.toString(v));
		//System.out.println(Arrays.toString(w));
		
		//아이템을 고려하는 개수를 한개씩 늘린다.
		for(int i=1; i<=N; i++) {
			//무게를 늘려가면서 최대로 넣을 수 있는 D[i][j]에 i번째 아이템까지 고려했을 때 j만큼의 무게를 담을 수 있는 최대 가치를 저장
			for(int j=1;j<=K;j++) {
				//넣을 수 있다. 고려할 것이 추가됐을때 그 고려하는 물건의 무게가 지금 j만큼 담을 수 있는데에 추가할 수 있는지 확인하고 '최적값'만 갱신한다.
				if(w[i]<=j) {
					D[i][j] = Math.max(D[i-1][j-w[i]]+v[i], D[i-1][j]);
					
				}
				else {//못넣는다.
					D[i][j] = D[i-1][j];
					
				}
				
				
				
			}
		}
		
		System.out.println(D[N][K]);
	}

}
