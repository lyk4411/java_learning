package madjava;

import java.util.Scanner;

public class qqq {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		System.out.println("���������������������ˣ�:");
		int m;
		m = sc.nextInt();
		int[] student = new int[m + 1];
		int[] aa = new int[m + 1];
		int n = 0, k = 0;
		int i, a = 1;
		for (i = 1; i <= m; i++)// ��ʼ������
		{ // ��ʼ������
			student[i] = a; // ��ʼ������a++;
		}
		for (int q = 1; m > 2; q++) { // �������������������ֻ�ı�λ�ã�����һ�飬û���ĵ�ǰ�棬
			if (q != 1)
				m = (m - m / 3);// ���¿�ʼ��,ֱ��ʣ�����ˣ��������򡣡�
			n = m / 3;// ÿ��һ�����µ�����
			k = m % 3;// ÿ��ʣ��û����������
			if (k != 0) {// ÿ��ʣ��û���������˴�������aa��ͷ��1
				for (int j = 0; j < k; j++) {
					aa[(1 + j)] = student[(m - k + 1) + j];
				}
			}
			int s = 0;
			for (int p = 1; p < (m - k - n);) // ���ˣ���û���µ��˴���aa
			{
				s++;
				if (s % 3 != 0)// �ж��Ƿ����£�û���µĸ�aa
				{
					aa[k + p] = student[s];
					p++;
				}
			}
			for (int w = 1; w <= m - n - 1; w++) {
				student[w] = aa[w];
			}
		}
		System.out.println("������µ��ǣ�" + aa[2] + "��");
	}
}