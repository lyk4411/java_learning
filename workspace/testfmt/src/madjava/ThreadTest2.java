package madjava;

public class ThreadTest2 {

	private int ii;

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		ThreadTest2 aa = new ThreadTest2();
		inc bb = aa.new inc();
		desc cc = aa.new desc();

		for (int i = 0; i < 2; i++) {
			Thread dd = new Thread(bb);
			dd.start();
			dd = new Thread(cc);
			dd.start();
		}
	}

	private synchronized void add() {
		ii++;
		System.out.println(Thread.currentThread().getName() + "-inc:" + ii);
	}

	private synchronized void desc() {
		ii--;
		System.out.println(Thread.currentThread().getName() + "-desc" + ii);
	}

	class inc implements Runnable {

		@Override
		public void run() {
			// TODO Auto-generated method stub
			for (int i = 0; i < 100; i++) {
				add();
			}
		}

	}

	class desc implements Runnable {

		@Override
		public void run() {
			// TODO Auto-generated method stub
			for (int i = 0; i < 100; i++) {
				desc();
			}
		}

	}

}
