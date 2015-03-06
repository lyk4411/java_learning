package madjava;

import java.util.Scanner;

public class timu38 {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		System.out.println("请输入一串字符串：");
		String sh = sc.nextLine();
		char[] ch;
		ch = sh.toCharArray();// 转换为字符存到ch
		System.out.println("输入的字符串为：" + sh + "长度为：" + ch.length);
	}
}