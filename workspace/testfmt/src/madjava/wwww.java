package madjava;

import java.util.Scanner;

public class wwww {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int[] age = new int[10];
		System.out.println("������ʫ��������");
		for (int i = 0; i < 10; i++)
			age[i] = sc.nextInt();
		System.out.println("����������ǣ�");
		for (int i = 0; i < 10; i++) {
			System.out.print(age[i] + " ");
		}
		int tmp = age[0];
		int a = 0;
		for (int i = 0; i < 10; i++) {
			if (tmp > age[i]) {
				tmp = age[i];
				a = i;
			}
		}
		age[a] = age[9];
		age[9] = tmp;
		for (int i = 0; i < 10; i++) {
			if (tmp < age[i]) {
				tmp = age[i];
				a = i;
			}
		}
		age[a] = age[0];
		age[0] = tmp;
		System.out.println();
		System.out.println("����������ǣ�");
		for (int i = 0; i < 10; i++) {
			System.out.print(age[i] + " ");
		}
	}
}