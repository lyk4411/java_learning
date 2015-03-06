package madjava;

import java.util.Scanner;

public class rabbit {
	public static void main(String[] args) {
		double number = 1, month;
		double tmp1 = 1, tmp2 = 1;
		Scanner sc = new Scanner(System.in);
		System.out.println("请输入第几个月：");
		month = sc.nextInt();
		for (int i = 1; i <= month; i++) {
			if (i <= 2)
				number = 1;
			else {
				number = tmp1 + tmp2;// 前两个月兔子数之和
				tmp2 = tmp1;// 前第二个月
				tmp1 = number;// 前一个月
			}
			System.out.println("第" + i + "个月的兔子数是：" + number);
		}
	}
}