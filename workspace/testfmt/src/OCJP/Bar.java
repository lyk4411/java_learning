package OCJP;

class Foo2 {
	public int a = 3;

	public void addFive() {
		assert (a > 0);
		a += 5;
		System.out.print("f ");
	}
}

public class Bar extends Foo2 {
	public int a = 8;

	public void addFive() {
		assert (a < 0);
		this.a += 5;
		System.out.print("b ");
	}

	static public void main(String[] args) {
		Foo2 f = new Bar();
		f.addFive();
		System.out.println(f.a);
	}
}