package madjava;

import java.util.Arrays;
import java.util.Scanner;

/**
 * @Title：
 * @Description：
 * @author Afei
 * @date： 日期：2012-6-10 时间：下午05:41:04
 * @Copyright：西北师范大学纬度工作室 Copyright (c) 2012
 * @version:1.0
 */
public class Qu3 {

	/**
	 * 功能说明:1、 有n个人围成一圈，顺序排号。从第一个人开始报数（从1到3报数），凡报到3的人退出圈子，<br>
	 * 问最后留下的是原来第几号的那位。
	 * 
	 * @Afei 2012-6-10
	 * @param args
	 */

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner input = new Scanner(System.in);
		System.out.print("请输入总人数：");
		int p = input.nextInt();
		/**** 初始化人员 ***/
		boolean[] per = new boolean[p];// boolean数组表示站成一圈的人，false表示退出
		for (int i = 0; i < per.length; i++) {
			per[i] = true;
		}

		/**** 报号 ***/
		int t = 0, len = per.length;
		while (len > 1) {
			for (int i = 0; i < per.length; i++) {

				if (per[i]) {
					t++;
					if (t == 3) {
						t = 0;
						per[i] = false;
						len--;
					}
				}
			}
		}
		/***** 结果 *****/
		System.out.println("最后的情况：" + Arrays.toString(per));
		for (int i = 0; i < per.length; i++) {
			if (per[i]) {
				System.out.println("原来喊的数：" + (i + 1) % 3);
				System.out.println(i+1);
			}
		}
	}
}
