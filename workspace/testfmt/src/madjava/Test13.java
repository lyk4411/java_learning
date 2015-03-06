package madjava;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

/**
 * Java�̣߳�������������
 * 
 * @author leizhimin 2009-11-5 10:57:29
 */
public class Test13 {
	public static void main(String[] args) {
		// �����������ʵ��˻�
		MyCount13 MyCount13 = new MyCount13("95599200901215522", 10000);
		// ����һ���̳߳�
		ExecutorService pool = Executors.newFixedThreadPool(2);
		Thread t1 = new SaveThread13("����", MyCount13, 2000);
		Thread t2 = new SaveThread13("����", MyCount13, 3600);
		Thread t3 = new DrawThread13("����", MyCount13, 2700);
		Thread t4 = new SaveThread13("����", MyCount13, 600);
		Thread t5 = new DrawThread13("��ţ", MyCount13, 1300);
		Thread t6 = new DrawThread13("����", MyCount13, 800);
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
class SaveThread13 extends Thread {
	private String name; // ������
	private MyCount13 MyCount13; // �˻�
	private int x; // �����

	SaveThread13(String name, MyCount13 MyCount13, int x) {
		this.name = name;
		this.MyCount13 = MyCount13;
		this.x = x;
	}

	public void run() {
		MyCount13.saving(x, name);
	}
}

/**
 * ȡ���߳���
 */
class DrawThread13 extends Thread {
	private String name; // ������
	private MyCount13 MyCount13; // �˻�
	private int x; // �����

	DrawThread13(String name, MyCount13 MyCount13, int x) {
		this.name = name;
		this.MyCount13 = MyCount13;
		this.x = x;
	}

	public void run() {
		MyCount13.drawing(x, name);
	}
}

/**
 * ��ͨ�����˻�������͸֧
 */
class MyCount13 {
	private String oid; // �˺�
	private int cash; // �˻����

	MyCount13(String oid, int cash) {
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
	public synchronized void saving(int x, String name) {
		if (x > 0) {
			cash += x; // ���
			System.out.println(name + "���" + x + "����ǰ���Ϊ" + cash);
		}
		notifyAll(); // �������еȴ��̡߳�
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
		notifyAll(); // �������д�����
	}
}