package madjava;

import java.util.Scanner;

public class timu15 {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int a, b, c;
		System.out.println("������������");
		a = sc.nextInt();
		b = sc.nextInt();
		c = sc.nextInt();
		int e;
		if (a > b) {
			e = a;
			a = b;
			b = e;
		}
		if (a > c) {
			e = a;
			a = c;
			c = e;
		}
		if (b > c) {
			e = b;
			b = c;
			c = e;
		}
		System.out.println("��������С����Ϊ��" + a + " " + b + " " + c);
	}
}
