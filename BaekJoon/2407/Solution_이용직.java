import java.util.Scanner;
import java.io.FileInputStream;
import java.math.BigInteger;
import java.math.BigInteger;

import java.math.BigInteger;

class Main
{
	static BigInteger[][] memo = new BigInteger[101][101];

    public static BigInteger recursive(int n, int m, BigInteger[][] memo ) {

    	if(n==m || m==0) {
        	memo[n][m] =  new BigInteger("1");
    		return BigInteger.ONE;
    	}
    	if(n==0 || n<m) {
    		return BigInteger.ZERO;
    	}
    	if(!(memo[n][m].equals(BigInteger.valueOf(0)))) {

    	
    		return memo[n][m];
    	}
    	else {

    		return memo[n][m]=(memo[n][m].add(recursive(n-1,m,memo))).add(recursive(n-1,m-1,memo));
    		
    	}
		
    }
    
    
    public static void main(String args[]) throws Exception
    {


        Scanner sc = new Scanner(System.in);
        int T;
 
 
        T=1;
        for(int test_case = 1; test_case <= T; test_case++)
        {
            int n = sc.nextInt();
            int m = sc.nextInt();
        	for(int i=0; i<=100; i++) {
        		for(int j=0; j<=100; j++) {
        			memo[i][j] = new BigInteger("0");
        		}
        	}
            BigInteger ans = recursive(n,m,memo); 

            System.out.println(ans);
             
            
        }
        
    }
     
}
 