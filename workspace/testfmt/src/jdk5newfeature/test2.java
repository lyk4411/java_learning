package jdk5newfeature;

public class test2 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		// name(),��������
		System.out.println(Grade.A.name());

		// ordinal(),����ö��ֵ��ö��������λ��
		System.out.println(Grade.A.ordinal());
		System.out.println(Grade.B.ordinal());
		System.out.println(Grade.C.ordinal());


		// valueOf().���ַ���תΪö��ֵ
		String str = "C";
		// Grade g = Grade.valueOf(Grade.class,str);
		Grade g = Grade.valueOf(str);
		System.out.println(g);
		System.out.println(g.localValue());

	}

}
