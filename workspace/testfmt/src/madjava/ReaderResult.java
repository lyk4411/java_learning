package madjava;

public class ReaderResult extends Thread {
	Calculator c;

	public ReaderResult(Calculator c) {
		this.c = c;
	}

	public void run() {
		synchronized (c) {
			try {
				System.out.println(Thread.currentThread() + "�ȴ�������������");
				c.wait();
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
			System.out.println(Thread.currentThread() + "������Ϊ��" + c.total);
		}
	}

	public static void main(String[] args) {
		Calculator calculator = new Calculator();
		// ���������̣߳��ֱ��ȡ������
		new ReaderResult(calculator).start();
		new ReaderResult(calculator).start();
		new ReaderResult(calculator).start();
		// ���������߳�
		calculator.start();
	}
}