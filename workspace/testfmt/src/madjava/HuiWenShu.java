package madjava;

import java.util.Scanner;

public class HuiWenShu {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int a;
		int wan, qian, shi, ge;
		for (;;)// ʹ�����ܹ�ѭ������
		{
			System.out.println("������һ����λ�����������ж��Ƿ��ǻ�����");
			a = sc.nextInt();
			System.out.println("����������ǣ�" + a);
			if (a > 99999 || a < 10000) {
				System.out.println("!!!!!!!!�������������ȷ!!!!!!!!!!!!!!");
				System.out.println();
			} else {
				wan = a / 10000;// ����λ��
				qian = (a / 1000) % 10;// ��ǧλ��
				shi = (a / 10) % 10;// ��ʮλ��
				ge = a % 10;// ���λ��
				if (wan == ge && shi == qian) {// �ж�
					System.out.println("����������ǻ�����");
					System.out.println();
				} else {
					System.out.println("������������ǻ�����");
					System.out.println();
				}
			}
		}
	}
}