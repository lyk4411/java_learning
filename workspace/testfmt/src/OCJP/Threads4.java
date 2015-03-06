package OCJP;

public class Threads4 {
	public static void main(String[] args) {
		new Threads4().go();
	}

	public void go() {
		Runnable r = new Runnable() {
			public void run() {
				System.out.print("foo");
			}
		};
		Thread t = new Thread(r);
		Thread t1 = new Thread(r);

		t.start();
		t1.start();
	}
 }