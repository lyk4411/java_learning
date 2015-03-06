package OCJP;

class

PingPong2 {
	synchronized void hit(long n) {
		for (int i = 1; i < 3; i++)
			System.out.print(n + "-" + i + " ");
	}
}

public class Tester implements Runnable {
	static PingPong2 pp2 = new PingPong2();

	public static void main(String[] args) {
		new Thread(new Tester()).start();
		new Thread(new Tester()).start();

		String str = "null";

		if (str == null) {
			System.out.println("aaaa");
		} else if(str.length() == 0){
			System.out.println("bbbbb");
		} else{
			System.out.println("cccc");
		}
	}

	public void run() {
		pp2.hit(Thread.currentThread().getId());
	}
}