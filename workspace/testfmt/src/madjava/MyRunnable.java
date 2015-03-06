package madjava;

public class MyRunnable implements Runnable {
	private Foo foo = new Foo();

	public static void main(String[] args) {
		MyRunnable r = new MyRunnable();
		Thread ta = new Thread(r, "Thread-A");
		Thread tb = new Thread(r, "Thread-B");
		ta.start();
		tb.start();
	}

	public void run() {
		for (int i = 0; i < 3; i++) {
			this.fix(30);
			System.out.println(Thread.currentThread().getName()
					+ " :当前foo对象的x值= " + foo.getX());
		}
	}

	public int fix(int y) {
		return foo.fix(y);
	}
}