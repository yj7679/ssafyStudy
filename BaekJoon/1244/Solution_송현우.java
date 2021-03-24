import java.util.Scanner;

public class Main {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner sc = new Scanner(System.in);
		int size = sc.nextInt();
		int[] sw = new int[size + 1];

		for (int i = 1; i <= size; i++)
			sw[i] = sc.nextInt();

		int N = sc.nextInt();

		for (int i = 0; i < N; i++) {
			int mode = sc.nextInt();
			int num = sc.nextInt();
			switch (mode) {
			case 1:
				int x = 1;
				int next = num*x++;
				while (next <= size) {
					if (sw[next] == 0)
						sw[next] = 1;
					else
						sw[next] = 0;
					next = num * x++;
				}
				break;

			default:
				int j = 1;
				while (true) {
					if (num - j == 0 || num + j == size + 1) {
						break;
					}

					if (sw[num + j] != sw[num - j]) {
						break;
					} else
						j++;
				}
				if (sw[num] == 0)
					sw[num] = 1;
				else
					sw[num] = 0;
				
				for(int y = 1; y < j; y++) {
					if(sw[num + y] == 0) {
						sw[num + y] = 1;
						sw[num - y] = 1;
					}
					else {
						sw[num + y] = 0;
						sw[num - y] = 0;
					}
				}
			}
		}
		for (int i = 1; i <= size; i++) {
			System.out.print(sw[i] + " ");
			if(i%20 == 0) {
				System.out.println();
			}
		}
	}

}
