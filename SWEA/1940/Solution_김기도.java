package D2;

import java.util.*;
public class RcCar {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
        int T = sc.nextInt();
        for (int i = 0; i < T; i++) 
        {
            int test = i + 1;
            int a=0;
            int dis = 0;
            int spd = 0;
            int NN = sc.nextInt();
            for (int j = 0; j < NN; j++) 
            {
                int N = sc.nextInt();
                if (N != 0) 
                {
                    a = sc.nextInt();
                }
                if (N == 1) 
                {
                    spd = spd + a;
                } else if (N == 2) 
                {
                    spd = spd - a;
                    if (spd < 0) 
                    {
                        spd = 0;
                    }
                }
                dis = dis + spd;
            }
            System.out.println("#" + test + " " + dis);
        }

	}

}
