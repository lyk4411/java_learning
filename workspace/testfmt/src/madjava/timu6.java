package madjava;

import java.util.Scanner;

public class timu6 {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int a, b;
		System.out.println("����������������");
		a = sc.nextInt();
		b = sc.nextInt();
		System.out.println("����������ǣ�" + a + " ��" + b);
		int age[] = new int[(a + b) / 2];
		int j = 0;
		for (int i = 1; i < (a + b) / 2; i++) {
			if (a % i == 0 && b % i == 0) {
				age[j] = i;
				j++;
			}
		}
		System.out.println("���Լ���ǣ�" + age[--j]);
		for (int k = 1; k < 100000; k++) {

			if (k % a == 0 && k % b == 0) {
				System.out.println("��С�������ǣ�" + k);
				break;
			}
		}
	}
}