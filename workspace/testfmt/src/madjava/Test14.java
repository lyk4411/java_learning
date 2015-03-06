package madjava;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

/**
 * Java�̣߳���Ϊͬ�������
 * 
 * @author leizhimin 2009-11-5 10:57:29
 */
public class Test14 {
	public static void main(String[] args) {
		// �����������ʵ��˻�
		MyCount14 MyCount14 = new MyCount14("95599200901215522", 10000);
		// ����һ���̳߳�
		ExecutorService pool = Executors.newFixedThreadPool(2);
		Thread t1 = new SaveThread14("����", MyCount14, 2000);
		Thread t2 = new SaveThread14("����", MyCount14, 3600);
		Thread t3 = new DrawThread14("����", MyCount14, 2700);
		Thread t4 = new SaveThread14("����", MyCount14, 600);
		Thread t5 = new DrawThread14("��ţ", MyCount14, 1300);
		Thread t6 = new DrawThread14("����", MyCount14, 800);
		// ִ�и����߳�
		pool.execute(t1);
		pool.execute(t2);
		pool.execute(t3);
		pool.execute(t4);
		pool.execute(t5);
		pool.execute(t6);
		// �ر��̳߳�
		pool.shutdown();
	}
}

/**
 * ����߳���
 */
class SaveThread14 extends Thread {
	private String name; // ������
	private MyCount14 MyCount14; // �˻�
	private int x; // �����

	SaveThread14(String name, MyCount14 MyCount14, int x) {
		this.name = name;
		this.MyCount14 = MyCount14;
		this.x = x;
	}

	public void run() {
		MyCount14.saving(x, name);
	}
}

/**
 * ȡ���߳���
 */
class DrawThread14 extends Thread {
	private String name; // ������
	private MyCount14 MyCount14; // �˻�
	private int x; // �����

	DrawThread14(String name, MyCount14 MyCount14, int x) {
		this.name = name;
		this.MyCount14 = MyCount14;
		this.x = x;
	}

	public void run() {
		MyCount14.drawing(x, name);
	}
}

/**
 * ��ͨ�����˻�������͸֧
 */
class MyCount14 {
	private String oid; // �˺�
	private int cash; // �˻����

	MyCount14(String oid, int cash) {
		this.oid = oid;
		this.cash = cash;
	}

	/**
	 * ���
	 * 
	 * @param x
	 *            �������
	 * @param name
	 *            ������
	 */
	public void saving(int x, String name) {
		if (x > 0) {
			synchronized (this) {
				cash += x; // ���
				System.out.println(name + "���" + x + "����ǰ���Ϊ" + cash);
				notifyAll(); // �������еȴ��̡߳�
			}
		}
	}

	/**
	 * ȡ��
	 * 
	 * @param x
	 *            �������
	 * @param name
	 *            ������
	 */
	public synchronized void drawing(int x, String name) {
		synchronized (this) {
			if (cash - x < 0) {
				try {
					wait();
				} catch (InterruptedException e1) {
					e1.printStackTrace();
				}
			} else {
				cash -= x; // ȡ��
				System.out.println(name + "ȡ��" + x + "����ǰ���Ϊ" + cash);
			}
		}
		notifyAll(); // �������д�����
	}
}