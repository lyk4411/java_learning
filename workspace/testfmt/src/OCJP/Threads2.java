package OCJP;

public class Threads2 implements Runnable {

	public void run() {
		System.out.println("run.");
		throw new RuntimeException("Problem");
	}

	 void waitForSignal() throws InterruptedException {
		 Object obj = new Object();
		 synchronized (Thread.currentThread()) {
		 obj.wait();
		 obj.notify();
		 }
		 }
	
	public static void main(String[] args) {
		Thread t = new Thread(new Threads2());
		t.start();
		System.out.println("End of method.");
		System.out.println(Math.E);
	}
}