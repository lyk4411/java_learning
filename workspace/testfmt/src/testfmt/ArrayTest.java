package testfmt;

public class ArrayTest {
	public static void main(String[] args) {
		int[] arr1 = { 1, 2, 3, 4, 5 }; // ��ʼ��һ�����飬������5�������ˣ�
		int[] arr2 = new int[10];// ���³�ʼ�����飬������10;
		// �������鸴�Ƶ�������
		for (int i = 0; i < arr1.length; i++) {
			arr2[i] = arr1[i];
		}
		// �����������arr1ָ��������
		arr1 = arr2;

		// �����Ҫ���ƣ���򵥵ľ���ֱ��ʵ����
		int[] arr1_1 = new int[5];// ��ʼ��һ�����飬������5�������ˣ�
		arr1_1 = new int[10]; // ��ʵ����һ�Σ�����һ�������飬��ǰ������Ķ����Ͳ�������
	}
}