package examples100;

class MyThread1 extends Thread {
	boolean stopped;

	MyThread1(ThreadGroup tg, String name) {
		super(tg, name);
		stopped = false;
	}

	public void run() {
		System.out.println(Thread.currentThread().getName() + " starting.");
		try {
			for (int i = 1; i < 1000; i++) {
				System.out.print(".");
				Thread.sleep(250);
				synchronized (this) {
					if (stopped)
						break;
				}
			}
		} catch (Exception exc) {
			System.out.println(Thread.currentThread().getName()
					+ " interrupted.");
		}
		System.out.println(Thread.currentThread().getName() + " exiting.");
	}

	synchronized void myStop() {
		stopped = true;
	}
}

public class Main {
	public static void main(String args[]) throws Exception {
		ThreadGroup tg = new ThreadGroup("My Group");

		MyThread1 thrd = new MyThread1(tg, "MyThread1 #1");
		MyThread1 thrd2 = new MyThread1(tg, "MyThread1 #2");
		MyThread1 thrd3 = new MyThread1(tg, "MyThread1 #3");

		thrd.start();
		thrd2.start();
		thrd3.start();

		Thread.sleep(1000);

		System.out.println(tg.activeCount() + " threads in thread group.");

		Thread thrds[] = new Thread[tg.activeCount()];
		tg.enumerate(thrds);
		for (Thread t : thrds)
			System.out.println(t.getName());

		thrd.myStop();

		Thread.sleep(1000);

		System.out.println(tg.activeCount() + " threads in tg.");
		tg.interrupt();
	}
}
