package threads;

//BEGIN main
public class StopBoolean extends Thread {
	// MUST be volatile to ensure changes visible to other threads.
	protected volatile boolean done = false;

	public void run() {
		while (!done) {
			System.out.println("StopBoolean running");
			try {
				sleep(720);
			} catch (InterruptedException ex) {
				// nothing to do
			}
		}
		System.out.println("StopBoolean finished.");
	}

	public void shutDown() {
		done = true;
	}

	public static void main(String[] args) throws InterruptedException {
		StopBoolean t1 = new StopBoolean();
		StopBoolean t2 = new StopBoolean();
		
		t1.start();
		t2.start();
		Thread.sleep(1000 * 5);
		t1.shutDown();
		t2.shutDown();
	}
}
// END main