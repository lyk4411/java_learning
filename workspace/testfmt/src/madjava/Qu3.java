package madjava;

import java.util.Arrays;
import java.util.Scanner;

/**
 * @Title��
 * @Description��
 * @author Afei
 * @date�� ���ڣ�2012-6-10 ʱ�䣺����05:41:04
 * @Copyright������ʦ����ѧγ�ȹ����� Copyright (c) 2012
 * @version:1.0
 */
public class Qu3 {

	/**
	 * ����˵��:1�� ��n����Χ��һȦ��˳���źš��ӵ�һ���˿�ʼ��������1��3��������������3�����˳�Ȧ�ӣ�<br>
	 * ��������µ���ԭ���ڼ��ŵ���λ��
	 * 
	 * @Afei 2012-6-10
	 * @param args
	 */

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner input = new Scanner(System.in);
		System.out.print("��������������");
		int p = input.nextInt();
		/**** ��ʼ����Ա ***/
		boolean[] per = new boolean[p];// boolean�����ʾվ��һȦ���ˣ�false��ʾ�˳�
		for (int i = 0; i < per.length; i++) {
			per[i] = true;
		}

		/**** ���� ***/
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
		/***** ��� *****/
		System.out.println("���������" + Arrays.toString(per));
		for (int i = 0; i < per.length; i++) {
			if (per[i]) {
				System.out.println("ԭ����������" + (i + 1) % 3);
				System.out.println(i+1);
			}
		}
	}
}
