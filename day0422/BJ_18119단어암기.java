package 스터디문제;

import java.util.*;
import java.io.*;
 
public class BJ_18119단어암기 {
    
	static int N, M, ans;
	static boolean[][] words;
	static boolean[] valid;
	
	public static void main(String[] args) throws Exception {
		System.setIn(new FileInputStream("단어암기.txt"));
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
 
        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());
 
        words = new boolean[N][26];
        for (int i = 0; i < N; i++) {
            String str = br.readLine();
 
            for (int j = 0; j < str.length(); j++) {
                char c = str.charAt(j);
 
                words[i][c - 'a'] = true;
            }
        }
 
        // 각 단어마다 모든 알파벳을 기억하고 있는지 확인
        valid = new boolean[N]; 
        Arrays.fill(valid, true);
        
        // 각 단어마다 잊어버린 알파벳의 개수
        int[] alpha = new int[N];
 
        int cnt = N;
        for (int i = 0; i < M; i++) {
            st = new StringTokenizer(br.readLine());
            int o = Integer.parseInt(st.nextToken());
            char x = st.nextToken().charAt(0);
 
            if (o == 1) {
                for (int j = 0; j < N; j++) {
                	// 잊어버린 알파벳이 있는 경우
                    if (words[j][x - 'a']) {
                        alpha[j]++;
                        if (valid[j]) {
                            cnt--;
                            valid[j] = false;
                        }
                    }
                }
            } else if (o == 2) {
                for (int j = 0; j < N; j++) {
                	// 기억하려는 알파벳이 목록에 있고 모든 알파벳을 기억한 단어가 아닌 경우
                    if (!valid[j] && words[j][x - 'a']) {
                        alpha[j]--;
 
                        if (alpha[j] == 0) {
                            valid[j] = true;
                            cnt++;
                        }
                    }
                }
            }
            ans = cnt;
            System.out.println(ans);
        }
    }
}
