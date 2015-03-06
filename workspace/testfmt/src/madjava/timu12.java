package madjava;

import java.util.Scanner;

public class timu12 {
	public static void main(String[] args) {
		double bonus, aa;
		Scanner sc = new Scanner(System.in);
		System.out.println("请输入利润：");
		aa = sc.nextInt();
		if (aa <= 100000)
			bonus = aa * 0.1;
		else if (aa <= 20000)
			bonus = 100000 * 0.1 + (aa - 100000) * 0.075;
		else if (aa <= 400000)
			bonus = 100000 * 0.1 + 100000 * 0.075 + (aa - 200000) * 0.05;
		else if (aa <= 600000)
			bonus = 100000 * 0.1 + 100000 * 0.075 + 20000 * 0.05
					+ (aa - 400000) * 0.03;
		else if (aa <= 1000000)
			bonus = 100000 * 0.1 + 100000 * 0.075 + 20000 * 0.05 + 200000
					* 0.03 + (aa - 600000) * 0.015;
		else
			bonus = 100000 * 0.1 + 100000 * 0.075 + 20000 * 0.05 + 200000
					* 0.03 + 400000 * 0.015 + (aa - 1000000) * 0.01;
		System.out.println("当利润为：" + aa + "元时，奖金是：" + bonus);
	}
}
