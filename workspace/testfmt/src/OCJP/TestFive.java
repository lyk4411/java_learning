package OCJP;

public class TestFive {
	private int x = 3;

	public void foo() {
		synchronized (this) {
			int current = x;
			x = current + 1;
			System.out.print(x + ", ");
		}
	}

	public void go() {
		for (int i = 0; i < 5; i++) {
			new Thread() {
				public void run() {
					foo();
				}
			}.start();
		}
	}

	public static void main(String[] args) {
		TestFive a = new TestFive();
		a.go();
	}
}