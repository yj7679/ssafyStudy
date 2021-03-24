package com.ssafy;

import java.util.Scanner;

class Solution_정지홍 {
	public static void main(String args[]) throws Exception {
		Scanner sc = new Scanner(System.in);
		int[][] dog = new int[2][2];
		int[] person = new int[3];
		int attack = 0, time = 0, hp;

		for (int i = 0; i < 2; i++) {
			for (int j = 0; j < 2; j++) {
				dog[i][j] = sc.nextInt();
			}
		}
		for (int i = 0; i < 3; i++)
			person[i] = sc.nextInt();

		for (int i = 0; i < person.length; i++) {
			attack = 0;
			// 첫번째 개
			hp = person[i];
			while (hp > 0) {
				for (int j = 0; j < 2; j++) {
					hp -= dog[0][j];
					if (hp <= 0 && j == 0) {
						attack++;
					}
				}
			}
			// 두번째 개
			hp = person[i];
			while (hp > 0) {
				for (int j = 0; j < 2; j++) {
					hp -= dog[1][j];
					if (hp <= 0 && j == 0) {
						attack++;
					}
				}
			}
			System.out.println(attack);
		}
	}
}