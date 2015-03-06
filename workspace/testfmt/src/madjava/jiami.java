package madjava;

import java.util.Scanner;

public class jiami {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		System.out.println("请输入要加密的四位数：");
		int n = sc.nextInt();
		int[] age = new int[4];
		age[0] = n / 1000;
		age[1] = n % 1000 / 100;
		age[2] = n % 100 / 10;
		age[3] = n % 10;
		// for(int i=0;i<4;i++){
		// System.out.println(age[i]);
		// }
		for (int i = 0; i < age.length; i++)
			age[i] = (age[i] + 5) % 10;
		int tmp;
		tmp = age[0];// 一四位互换
		age[0] = age[3];
		age[3] = tmp;
		tmp = age[2];// 二三位互换
		age[2] = age[3];
		age[3] = tmp;
		System.out.print("加密之后的数为：");
		for (int i = 0; i < 4; i++) {
			System.out.print(age[i]);
		}

	}
}