package madjava;

import java.util.Scanner;

public class Day {
	public static void main(String[] args) {
		int year, month, day, number;
		Scanner sc = new Scanner(System.in);
		System.out.println("��������ݣ�");
		year = sc.nextInt();
		System.out.println("�������·ݣ�");
		month = sc.nextInt();
		System.out.println("�������գ�");
		day = sc.nextInt();
		System.out.println("����������:" + year + "��" + month + "��" + day + "��");
		number = day;
		switch (month - 1) {
		case 11: {
			number += 30;
		}
		case 10: {
			number += 31;
		}
		case 9: {
			number += 30;
		}
		case 8: {
			number += 31;
		}
		case 7: {
			number += 31;
		}
		case 6: {
			number += 30;
		}
		case 5: {
			number += 31;
		}
		case 4: {
			number += 30;
		}
		case 3: {
			number += 31;
		}
		case 2: {
			number += 28;
		}
		case 1: {
			number += 31;
		}
		}
		if (month > 2 && year % 4 == 0)
			number += 1;
		System.out.println("�������������һ�굱�еĵڣ�" + number + "��");
	}
}