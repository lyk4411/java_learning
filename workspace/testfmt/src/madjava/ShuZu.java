package madjava;

import java.util.Scanner;

public class ShuZu {
	public static void main(String[] args) {
		int age[] = new int[10];
		age[0] = 20;
		age[1] = 25;
		age[2] = 35;
		age[3] = 46;
		age[4] = 55;
		age[5] = 68;
		age[6] = 77;
		age[7] = 88;
		age[8] = 100;
		Scanner sc = new Scanner(System.in);
		int count, tmp;
		System.out.println("请输入一个数：");
		count = sc.nextInt();
		System.out.println("您输入的数是：" + count);
		age[9] = count;
		for (int i = 0; i < age.length; i++) {
			if (age[i] > age[9]) {
				tmp = age[i];
				age[i] = age[9];
				age[9] = tmp;
			}
		}
		for (int i = 0; i < age.length; i++) {
			System.out.print(age[i] + " ");
		}
	}
}
