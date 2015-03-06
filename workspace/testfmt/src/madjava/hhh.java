package madjava;

import java.util.Scanner;

public class hhh {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		System.out.println("请输入两个字符串：");
		String sh = sc.nextLine();
		String sk = sc.nextLine();
		String ss = sh + sk;// 两个字符串存到ss内
		System.out.println(ss);
	}
}