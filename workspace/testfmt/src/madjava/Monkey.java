package madjava;

public class Monkey {
	public static void main(String[] args) {
		int sum = 0;
		for (int i = 0; i < 5; i++) {
			if (i == 0)
				sum = 5 * 1 + 1;// ���������������������һ����
			else
				sum = sum * 5 + 1;
		}
		System.out.println("�������ӣ�" + sum);
	}
}