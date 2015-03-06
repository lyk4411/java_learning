package madjava;

import java.util.Scanner;

public class HuiWenShu {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int a;
		int wan, qian, shi, ge;
		for (;;)// 使程序能够循环输入
		{
			System.out.println("请输入一个五位数的整数，判断是否是回文数");
			a = sc.nextInt();
			System.out.println("您输入的数是：" + a);
			if (a > 99999 || a < 10000) {
				System.out.println("!!!!!!!!您输入的数不正确!!!!!!!!!!!!!!");
				System.out.println();
			} else {
				wan = a / 10000;// 求万位数
				qian = (a / 1000) % 10;// 求千位数
				shi = (a / 10) % 10;// 求十位数
				ge = a % 10;// 求个位数
				if (wan == ge && shi == qian) {// 判断
					System.out.println("您输入的数是回文数");
					System.out.println();
				} else {
					System.out.println("您输入的数不是回文数");
					System.out.println();
				}
			}
		}
	}
}