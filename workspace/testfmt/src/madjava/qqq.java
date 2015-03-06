package madjava;

import java.util.Scanner;

public class qqq {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		System.out.println("请输入总人数（大于三人）:");
		int m;
		m = sc.nextInt();
		int[] student = new int[m + 1];
		int[] aa = new int[m + 1];
		int n = 0, k = 0;
		int i, a = 1;
		for (i = 1; i <= m; i++)// 初始化数组
		{ // 初始化数组
			student[i] = a; // 初始化数组a++;
		}
		for (int q = 1; m > 2; q++) { // 程序利用数组序号数，只改变位置，数完一遍，没数的到前面，
			if (q != 1)
				m = (m - m / 3);// 重新开始数,直到剩下两人，跳出程序。。
			n = m / 3;// 每数一次坐下的人数
			k = m % 3;// 每次剩下没有数的人数
			if (k != 0) {// 每次剩下没有数数的人传到数组aa开头数1
				for (int j = 0; j < k; j++) {
					aa[(1 + j)] = student[(m - k + 1) + j];
				}
			}
			int s = 0;
			for (int p = 1; p < (m - k - n);) // 数了，但没坐下的人传给aa
			{
				s++;
				if (s % 3 != 0)// 判断是否坐下？没坐下的给aa
				{
					aa[k + p] = student[s];
					p++;
				}
			}
			for (int w = 1; w <= m - n - 1; w++) {
				student[w] = aa[w];
			}
		}
		System.out.println("最后留下的是：" + aa[2] + "号");
	}
}