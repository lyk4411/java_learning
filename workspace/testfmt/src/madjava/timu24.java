package madjava;

import java.util.Scanner;

public class timu24 {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		System.out.println("请输入一个不多于5位的正整数");
		int aa;
		aa = sc.nextInt();
		System.out.println("您输入的数是：" + aa);
		if (aa > 99999)
			System.out.println("您输入错误！！！！");
		else if (aa / 10000 != 0) {
			System.out.println(aa + "是五位数：");
			System.out.println("个位数是：" + aa % 10000 % 1000 % 100 % 10);
			System.out.println("十位数是：" + aa % 10000 % 1000 % 100 / 10);
			System.out.println("百位数是：" + aa % 10000 % 1000 / 100);
			System.out.println("千位数是：" + aa % 10000 / 1000);
			System.out.println("万位数是：" + aa / 10000);
		} else if (aa / 1000 != 0) {
			System.out.println(aa + "是四位数：");
			System.out.println("个位数是：" + aa % 1000 % 100 % 10);
			System.out.println("十位数是：" + aa % 1000 % 100 / 10);
			System.out.println("百位数是：" + aa % 1000 / 100);
			System.out.println("千位数是：" + aa / 1000);
		} else if (aa / 100 != 0) {
			System.out.println(aa + "是三位数：");
			System.out.println("个位数是：" + aa % 100 % 10);
			System.out.println("十位数是：" + aa % 100 / 10);
			System.out.println("百位数是：" + aa / 100);
		} else if (aa / 10 != 0) {
			System.out.println(aa + "是两位数：");
			System.out.println("个位数是：" + aa % 10);
			System.out.println("十位数是：" + aa / 10);
		} else {
			System.out.println(aa + "是一位数：");
			System.out.println("个位数是：" + aa);
		}
	}
}
