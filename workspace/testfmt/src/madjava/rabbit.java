package madjava;

import java.util.Scanner;

public class rabbit {
	public static void main(String[] args) {
		double number = 1, month;
		double tmp1 = 1, tmp2 = 1;
		Scanner sc = new Scanner(System.in);
		System.out.println("������ڼ����£�");
		month = sc.nextInt();
		for (int i = 1; i <= month; i++) {
			if (i <= 2)
				number = 1;
			else {
				number = tmp1 + tmp2;// ǰ������������֮��
				tmp2 = tmp1;// ǰ�ڶ�����
				tmp1 = number;// ǰһ����
			}
			System.out.println("��" + i + "���µ��������ǣ�" + number);
		}
	}
}