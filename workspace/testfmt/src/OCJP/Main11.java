package OCJP;

import java.util.Scanner;

public class Main11 {
	public static void main(String... args) {
		T = cin.nextInt();
		while (T-- != 0) {
			N = cin.nextLong();
			count = 0;
			double sqrt = Math.sqrt((N + 1));
			for (int i = 2; i <= sqrt; i++) {
				if ((N + 1) % i == 0)
					count++;
			}
			System.out.println(count);

		}
	}

	static Scanner cin = new Scanner(System.in);
	static int T, count;
	static long N;
}