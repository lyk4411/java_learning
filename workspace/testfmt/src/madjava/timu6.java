package madjava;

import java.util.Scanner;

public class timu6 {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int a, b;
		System.out.println("请输入两个整数：");
		a = sc.nextInt();
		b = sc.nextInt();
		System.out.println("您输入的数是：" + a + " 和" + b);
		int age[] = new int[(a + b) / 2];
		int j = 0;
		for (int i = 1; i < (a + b) / 2; i++) {
			if (a % i == 0 && b % i == 0) {
				age[j] = i;
				j++;
			}
		}
		System.out.println("最大公约数是：" + age[--j]);
		for (int k = 1; k < 100000; k++) {

			if (k % a == 0 && k % b == 0) {
				System.out.println("最小公倍数是：" + k);
				break;
			}
		}
	}
}