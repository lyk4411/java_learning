package madjava;

import java.util.Scanner;

public class timu24 {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		System.out.println("������һ��������5λ��������");
		int aa;
		aa = sc.nextInt();
		System.out.println("����������ǣ�" + aa);
		if (aa > 99999)
			System.out.println("��������󣡣�����");
		else if (aa / 10000 != 0) {
			System.out.println(aa + "����λ����");
			System.out.println("��λ���ǣ�" + aa % 10000 % 1000 % 100 % 10);
			System.out.println("ʮλ���ǣ�" + aa % 10000 % 1000 % 100 / 10);
			System.out.println("��λ���ǣ�" + aa % 10000 % 1000 / 100);
			System.out.println("ǧλ���ǣ�" + aa % 10000 / 1000);
			System.out.println("��λ���ǣ�" + aa / 10000);
		} else if (aa / 1000 != 0) {
			System.out.println(aa + "����λ����");
			System.out.println("��λ���ǣ�" + aa % 1000 % 100 % 10);
			System.out.println("ʮλ���ǣ�" + aa % 1000 % 100 / 10);
			System.out.println("��λ���ǣ�" + aa % 1000 / 100);
			System.out.println("ǧλ���ǣ�" + aa / 1000);
		} else if (aa / 100 != 0) {
			System.out.println(aa + "����λ����");
			System.out.println("��λ���ǣ�" + aa % 100 % 10);
			System.out.println("ʮλ���ǣ�" + aa % 100 / 10);
			System.out.println("��λ���ǣ�" + aa / 100);
		} else if (aa / 10 != 0) {
			System.out.println(aa + "����λ����");
			System.out.println("��λ���ǣ�" + aa % 10);
			System.out.println("ʮλ���ǣ�" + aa / 10);
		} else {
			System.out.println(aa + "��һλ����");
			System.out.println("��λ���ǣ�" + aa);
		}
	}
}
