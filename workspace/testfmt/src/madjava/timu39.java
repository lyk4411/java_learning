package madjava;

import java.util.Scanner;

public class timu39 {// 创建两个类也可以
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		double n;
		System.out.println("请输入一个数：");
		n = sc.nextInt();
		double s = 0;
		if (n % 2 == 0) {
			for (double i = 2; i <= n; i += 2) {
				s = s + 1 / i;
			}
			for (double i = 2; i <= n; i += 2) {
				System.out.print("1/" + i);
				if (i != n) {
					System.out.print("+");
				}
			}
		}
		if (n % 2 != 0) {
			for (double i = 1; i <= n; i += 2) {
				s = s + 1 / i;
			}
			for (double i = 1; i <= n; i += 2) {
				System.out.print("1/" + i);
				if (i != n) {
					System.out.print("+");
				}
			}
		}
		System.out.print("=" + s);
	}
}
