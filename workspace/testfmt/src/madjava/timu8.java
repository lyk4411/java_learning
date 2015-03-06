package madjava;

import java.util.Scanner;

public class timu8 {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		System.out.println("请输入a值：");
		long a, b;
		a = sc.nextInt();
		System.out.println("请输入相加到几位数：");
		b = sc.nextInt();
		long sum = 0;
		long i = 1;
		for (; i <= b; i++) {
			int w = 1;
			for (long j = b - i; j > 0; j--) {
				w = w * 10;
			}
			sum = sum + a * w * i;
		}
		System.out.print("s=");
		for (int m = 1; m <= b; m++) {
			for (int n = 1; n <= m; n++) {
				System.out.print(a);
			}
			if (m != b)
				System.out.print("+");
		}
		System.out.print("=" + sum);
	}
}
