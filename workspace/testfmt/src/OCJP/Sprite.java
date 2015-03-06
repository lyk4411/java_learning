package OCJP;

interface Foo {
	int bar();
}

public class Sprite {
	public int fubar(Foo foo) {
		return foo.bar();
	}

	public void testFoo() {
		fubar(
		// insert code here
		new Foo() {
			public int bar() {
				return 1;
			}
		});
	}
}