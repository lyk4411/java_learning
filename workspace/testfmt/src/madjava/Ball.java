package madjava;

public class Ball {
	public static void main(String[] args) {
		double sum;
		double high = 100.0;
		sum = high;
		for (int i = 1; i <= 10; i++) {// ��i����أ�
			high = high / 2.0;
			sum += high;// ��i�η���ʱ�ĸ߶�
			if (i == 10)
				sum -= high;// ��ʮ����ز�����
		}
		System.out.println("��10�����ʱ��������" + sum + "��");
		high = high / 2;
		System.out.println("��10�η���" + high + "��");
	}
}