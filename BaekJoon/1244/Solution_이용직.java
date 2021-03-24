import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.StringTokenizer;

public class Main {

	public static void main(String[] args) throws IOException {
		
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		String N = br.readLine();
		int n = Integer.parseInt(N);

		StringTokenizer st = new StringTokenizer(br.readLine(), " ");
		int[] swits = new int[n+1];
		for(int i=1; i<=n; i++) {
			swits[i] = Integer.parseInt(st.nextToken());
		}
		int pcount=Integer.parseInt(br.readLine());
		
		int[][] peo = new int[pcount][2];
		for(int i=0; i<pcount; i++) {
			st = new StringTokenizer(br.readLine(), " ");
			peo[i][0] =Integer.parseInt(st.nextToken());
			peo[i][1] =Integer.parseInt(st.nextToken());
			
			//남
			if(peo[i][0] == 1) {
				for(int p = peo[i][1]; p<=n; p+=peo[i][1]) {
					swits[p] = swits[p]+1 - (((swits[p]+1)>>1)<<1);
				}
			}
			else if(peo[i][0] == 2) {
				int startP = peo[i][1];
				swits[startP] = swits[startP]+1 - (((swits[startP]+1)>>1)<<1);
				for(int strid =1; startP-strid>=1 && startP+strid<=n; strid++){
					if(swits[startP-strid]!= swits[startP+strid]) {
						
						break;
					}
					swits[startP-strid] = (swits[startP-strid]+1)%2;
					swits[startP+strid] = (swits[startP+strid]+1)%2;
				}
			}
	
		}

		for (int q = 1; q <= n; q++) {
			if(q!=1 &&q%20==1) {
				System.out.println();
			}
			System.out.print(swits[q]+" ");
		}

		

	}

}
