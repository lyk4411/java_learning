package jdk5newfeature;

public class test2 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		// name(),返回名称
		System.out.println(Grade.A.name());

		// ordinal(),返回枚举值在枚举中所处位置
		System.out.println(Grade.A.ordinal());
		System.out.println(Grade.B.ordinal());
		System.out.println(Grade.C.ordinal());


		// valueOf().将字符串转为枚举值
		String str = "C";
		// Grade g = Grade.valueOf(Grade.class,str);
		Grade g = Grade.valueOf(str);
		System.out.println(g);
		System.out.println(g.localValue());

	}

}
