package OCJP;

public class GC {
	private Object o;

	private void doSomethingElse(Object obj) {
		o = obj;
	}

	public void doSomething() {
		Object o = new Object();
		doSomethingElse(o);
		o = new Object();
		doSomethingElse(null);
		o = null;
	}

	public static void test(String str) {
		int check = 4;
		if (check == str.length()) {
			System.out.print(str.charAt(check -= 1) + ", ");
		} else {
			System.out.print(str.charAt(0) + ", ");
		}
	}

	public static void main(String[] args) {
		test("four");
		test("tee");
		test("to");
	}
}