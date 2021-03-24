package com.ssafy.algo;

import java.util.Scanner;

public class Solution {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int T = sc.nextInt();
		
		
		for(int i=0; i<T; i++) {
			int count = sc.nextInt();
			int speed = 0;
			int sum = 0;
			int mode1 = 0;
			int mode2 = 0;
		
			for(int j=0; j<count; j++) {
				int mode = sc.nextInt();
				
				switch(mode) {
				case 1: 	
					mode1 = sc.nextInt();
					speed += mode1;
					sum += speed;
					break;
				case 2:
					mode2 = sc.nextInt();
					if(speed > 0)speed -= mode2;
					if(speed == 0)speed = 0;
					sum += speed;
					break;
				case 0: 
					sum += speed;
					break;
				}
			}
			System.out.println("#" + (i+1)+ " " + sum);
		}
	}
}
