package OCJP;

class AAA {
	void foo() throws Exception {
		throw new Exception();
	}
}

class Sub2 extends AAA {
	void foo() {
		System.out.println("B  ");
	}
}

public class Tester1 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		AAA a = new Sub2();
		try {
			a.foo();
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

}
