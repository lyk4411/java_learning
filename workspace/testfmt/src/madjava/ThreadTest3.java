package madjava;

public class ThreadTest3 {

	private int jj = 0;

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		ThreadTest3 aa = new ThreadTest3();
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
		jj++;
		System.out.println(Thread.currentThread().getName() + "add" + jj);
	}

	private synchronized void reduce() {
		jj--;
		System.out.println(Thread.currentThread().getName() + "reduce" + jj);
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
				reduce();
			}
		}

	}
}
