package madjava;

import java.util.Scanner;

public class Timu44 {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		System.out.println("请输入一个大于2的偶数：");
		int a;
		a = sc.nextInt();
		int[] age = new int[a];
		int m = 0;
		for (int i = 2; i < a; i++)
			for (int j = 2; j <= i; j++) {
				if (i % j == 0 && i == j) {
					age[m] = i;
					System.out.println(age[m]);
					m++;
				} else if (i % j == 0 && i != j)
					break;
			}
		int j = 0;
		int i = 0;
		for (; i < m - 2; i++) {
			for (; j < m - 2; j++) {
				if (a == age[i] + age[j])
					break;
			}
			if (a == age[i] + age[j])
				break;
		}
		System.out.println(a + "=" + age[i] + "+" + age[j]);
	}
}
