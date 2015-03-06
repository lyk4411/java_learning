package OCJP;

class Alpha1 {
	public void foo() {
		System.out.print("Afoo ");
	}
}

public class Beta1 extends Alpha1 {
	public void foo() {
		System.out.print("Bfoo ");
	}

	public static void main(String[] args) {
		Alpha1 a = new Beta1();
		Beta1 b = (Beta1) a;
		a.foo();
		b.foo();
	}
}