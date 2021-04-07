import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

//거짓말 - 유니온 파인드로 집합 나누기
public class Main {
	static int N,M, known,unkown;
	static int[] parents;
	static int[][] party;
	static void make() {
		for(int i=0;i<=N; i++) {
			parents[i] =i;
		}
		
	}
	static int findSet(int a) {
		if(parents[a] == a) return a;
		
		return parents[a] = findSet(parents[a]);
	}
	
	static boolean union(int a, int b) {
		int aRoot = findSet(a);
		int bRoot = findSet(b);
		if(aRoot ==bRoot) {
			return false;
		}
		parents[b] = aRoot;
		return true;
		
	}
	public static void main(String[] args) throws IOException {
		//진실을 모르는 사람들만 모여있는 집합의 개수를 구하기.
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		String[] str = br.readLine().split(" ");
		N = Integer.parseInt(str[0]);
		M = Integer.parseInt(str[1]);
		parents = new int[51]; //0은 진실을 아는 사람. 51은 진실을 모르는 사람
		party = new int[51][51];
		make();
		str = br.readLine().split(" ");
		known = Integer.parseInt(str[0]);
		//진실을 아는 사람들을 0에 붙임
		for(int i=1;i<=known;i++) {
			union(0,Integer.parseInt(str[i]));
		}
		
		int ans=0;
		for(int i=0;i<M; i++) {
			str = br.readLine().split(" ");
			int cnt= Integer.parseInt(str[0]);
			boolean flag=false; //진실을 말한 경우 true가 됨.
			for(int j=1;j<=cnt;j++) {
				// i번째에 오는 j번째사람들 번호 저장해놓음
				party[i][j-1] =Integer.parseInt(str[j]); 
				
				
				//진실을 아는 사람이 한명이라도 있으면 과장된 이야기를 할수 없다.그리고 그 파티에 있는사람들은 다 진실을 알게된 것
				if(findSet(Integer.parseInt(str[j]))==0) {
					flag=true;
					break;
				}

				
			}
			//진실을 들은 사람들을 다 0으로 붙임
			if(flag==true) {
				for(int j=1; j<=cnt;j++) {
					union(0,Integer.parseInt(str[j]));
				}
			}
			

		}
		
		//i번째 파티에 진실아는 사람 없는지 체크
		for(int i=0; i<M;i++) {
			int j=0;
			boolean flag=true;
			while(party[i][j]!=0) {
				if(findSet(party[i][j])==0) //진실을 아는 사람있으면 그냥 i번째 파티는 진실 못말함
				{
					//System.out.println((i+1)+"번째 파티" +(j+1)+"번째 사람이 진실을 안다");
					flag=false;
					break;
				}
				
				j++;
			}
			//아무도 진실을 모르면 말해도된다.
			if(flag==true) {
				ans++;
			}
			
		}
		System.out.println(ans);
		
	}

}
