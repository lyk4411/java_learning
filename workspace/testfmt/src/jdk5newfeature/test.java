package jdk5newfeature;

public class test {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Integer i1 = 137;// �Զ�װ������ζ���

		Integer i2 = 137;// �Զ�װ������ζ���

		System.out.println(i1 == i2);// ��ӡ��false
		/* 137����127������i1��i2ָ����������ͬ�Ķ��ڴ���󡣵�ַ����ȣ���ӡfalse */

		i1 = 13;

		i2 = 13;

		System.out.println(i1 == i2); // ��ӡ��true

		int arr[] = { 1, 2, 3 };
		for (int i : arr) {
			i = 10;// ֻ���޸���ָ�򡣲�û�иı�����򼯺��е����ݡ�

		}

		System.out.println(arr[0]);
		System.out.println(arr[1]);
		System.out.println(arr[2]);
	}

}
