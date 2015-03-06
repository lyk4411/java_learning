package madjava;

class A {

}

public class T {

	public static void main(String[] args) throws ClassNotFoundException {
		// TODO Auto-generated method stub
		Class<?> c1 = Class.forName("madjava.A");
		Class<?> c2 = A.class;
		Class<?> c3 = new A().getClass();
		System.out.println(c1.getName());
		System.out.println(c2.getName());
		System.out.println(c3.getName());
	}

}