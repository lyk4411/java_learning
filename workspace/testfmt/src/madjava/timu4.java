package madjava;

import java.util.Scanner;

public class timu4 {
	public static void main(String[] args) {
		for (;;) {
			Scanner sc = new Scanner(System.in);
			int a, b;
			int j = 0;
			System.out.println("������һ������");
			a = sc.nextInt();
			b = a;// ����ԭ��
			int age[] = new int[10];// ������������
			for (int i = 2; a != 1;)// ��������
			{
				if (a % i == 0) {
					age[j] = i;
					j++;
					a = a / i;
				} else
					i++;
			}
			System.out.print(b + "=");
			for (int i = 0; i < j; i++) {
				System.out.print(age[i]);
				if (i < j - 1)// �ж��Ƿ������һλ������,�������*
					System.out.print("*");
			}
			System.out.println();
		}
	}
}
