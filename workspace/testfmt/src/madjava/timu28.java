package madjava;

import java.util.Scanner;

public class timu28 {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int age[] = new int[10];
		System.out.println("������ʮ��������");
		for (int i = 0; i < 10; i++) {
			age[i] = sc.nextInt();
		}
		System.out.println("�������Ϊ��");
		for (int i = 0; i < 10; i++) {
			System.out.print(age[i] + " ");
		}
		int aa;
		for (int i = 0; i < 9; i++)
			for (int j = 0; j < 9 - i; j++) {
				if (age[j] < age[j + 1]) {
					aa = age[j];
					age[j] = age[j + 1];
					age[j + 1] = aa;
				}
			}
		System.out.println();
		System.out.println("�����������Ϊ��");
		for (int i = 0; i < 10; i++) {
			System.out.print(age[i] + " ");
		}
	}
}
