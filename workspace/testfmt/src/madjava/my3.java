package madjava;

import java.util.Arrays;
import java.util.Scanner;

public class my3 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner input = new Scanner(System.in);
		System.out.print("请输入总人数：");
		int person = input.nextInt();

		boolean per[] = new boolean[person];
		for (int i = 0; i < per.length; i++) {
			per[i] = true;
		}

		int t = 0;
		int leng = per.length;
		while (leng > 1) {
			for (int i = 0; i < per.length; i++) {
				if (per[i]) {
					t++;

					if (t == 3) {
						t = 0;
						leng--;
						per[i] = false;
					}
				}
			}
		}
		for (int i = 0; i < per.length; i++) {
			System.out.println(per[i]);
		}
		for (int i = 0; i < per.length; i++) {
			if (per[i]) {
				System.out.println(1 + i);
				System.out.println((i + 1) % 3);
			}
		}
	}
}
