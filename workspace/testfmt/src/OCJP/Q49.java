package OCJP;

public class Q49 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		try {
			A49 a = new A49();
			a.method1();
			System.out.println("ok");
		} catch (Exception e) {
			System.out.print("an error occurred");
		}
	}

}

class A49 {
	public void method1() {
		B b = new B();
		b.method2();
	}
}

class B {
	public void method2() {
		C c = new C();
		c.method3();
	}
}

class C {
	public void method3() {

	}
}