package madjava;

public class timu3 {
	public static void main(String[] args) {
		int i, j = 0, k;
		int bai, shi, ge;
		for (i = 100; i < 1000; i++) {
			bai = i / 100;// ���λ��
			shi = (i / 10) % 10;// ��ʮλ��
			ge = (i % 100) % 10;// ���λ��
			k = bai * bai * bai + shi * shi * shi + ge * ge * ge;
			if (i == k) {
				System.out.println(i);
				j++;
			}
		}
		System.out.println("����������ˮ�ɻ���Ϊ��" + j);
	}
}
