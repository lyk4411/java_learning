package madjava;
public class TestThread extends Thread {
	public TestThread(String name) {
		super(name);
	}
	public void run() {
		for (int i = 0; i < 5; i++) {
			try { 
				Thread.sleep(3); 
				} catch (InterruptedException e) { 
				e.printStackTrace();  
				}
			System.out.println(this.getName() + " :" + i);
		}
	}
	public static void main(String[] args) {
		Thread t1 = new TestThread("°¢Èı");
		Thread t2 = new TestThread("ÀîËÄ");
		t1.start();
		t2.start();
	}
}