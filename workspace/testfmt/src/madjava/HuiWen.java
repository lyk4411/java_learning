package madjava;

import java.io.BufferedReader;
import java.io.InputStreamReader;

public class HuiWen {

	/**
	 * �ݹ鷽���ж�һ��string�Ƿ��ǻ��� ����true��ʾ��ǰ�ַ�����һ�������ַ��� ����false��ʾ���ַ������ǻ����ַ���
	 * 
	 * @param args
	 */

	public static void main(String[] args) throws Exception {
		String str = "";
		BufferedReader br = new BufferedReader(
				new InputStreamReader(System.in), 256);
		System.out.println("�������������ַ���:");
		str = br.readLine();
		if (str.length() == 0) {
			System.out.println("������� " + "false");
		} else {
			System.out.println("������� " + huiwen(str, 0, str.length() - 1));
		}
	}

	public static boolean huiwen(String s, int start, int end) {
		if (start == end)
			return true;
		if (start > end) {
			// System.out.println("��û�������κ��ַ�����");
			return true;
		}
		if (s.charAt(start) == s.charAt(end)) {
			return huiwen(s, start + 1, end - 1);
		} else {
			return false;
		}
	}

}