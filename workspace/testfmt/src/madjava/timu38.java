package madjava;

import java.util.Scanner;

public class timu38 {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		System.out.println("������һ���ַ�����");
		String sh = sc.nextLine();
		char[] ch;
		ch = sh.toCharArray();// ת��Ϊ�ַ��浽ch
		System.out.println("������ַ���Ϊ��" + sh + "����Ϊ��" + ch.length);
	}
}