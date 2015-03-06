package madjava;

import java.util.Scanner;

public class Day {
	public static void main(String[] args) {
		int year, month, day, number;
		Scanner sc = new Scanner(System.in);
		System.out.println("请输入年份：");
		year = sc.nextInt();
		System.out.println("请输入月份：");
		month = sc.nextInt();
		System.out.println("请输入日：");
		day = sc.nextInt();
		System.out.println("输入日期是:" + year + "年" + month + "月" + day + "日");
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
		System.out.println("您输入的日期是一年当中的第：" + number + "天");
	}
}