package madjava;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.locks.Condition;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

/**
 * Java�̣߳���������
 * 
 * @author leizhimin 2009-11-5 10:57:29
 */
public class Test12 {
	public static void main(String[] args) {
		// �����������ʵ��˻�
		MyCount12 MyCount12 = new MyCount12("95599200901215522", 10000);
		// ����һ���̳߳�
		ExecutorService pool = Executors.newFixedThreadPool(2);
		Thread t1 = new SaveThread("����", MyCount12, 2000);
		Thread t2 = new SaveThread("����", MyCount12, 3600);
		Thread t3 = new DrawThread("����", MyCount12, 2700);
		Thread t4 = new SaveThread("����", MyCount12, 600);
		Thread t5 = new DrawThread("��ţ", MyCount12, 1300);
		Thread t6 = new DrawThread("����", MyCount12, 800);
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
class SaveThread extends Thread {
	private String name; // ������
	private MyCount12 MyCount12; // �˻�
	private int x; // �����

	SaveThread(String name, MyCount12 MyCount12, int x) {
		this.name = name;
		this.MyCount12 = MyCount12;
		this.x = x;
	}

	public void run() {
		MyCount12.saving(x, name);
	}
}

/**
 * ȡ���߳���
 */
class DrawThread extends Thread {
	private String name; // ������
	private MyCount12 MyCount12; // �˻�
	private int x; // �����

	DrawThread(String name, MyCount12 MyCount12, int x) {
		this.name = name;
		this.MyCount12 = MyCount12;
		this.x = x;
	}

	public void run() {
		MyCount12.drawing(x, name);
	}
}

/**
 * ��ͨ�����˻�������͸֧
 */
class MyCount12 {
	private String oid; // �˺�
	private int cash; // �˻����
	private Lock lock = new ReentrantLock(); // �˻���
	private Condition _save = lock.newCondition(); // �������
	private Condition _draw = lock.newCondition(); // ȡ������

	MyCount12(String oid, int cash) {
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
		lock.lock(); // ��ȡ��
		if (x > 0) {
			cash += x; // ���
			System.out.println(name + "���" + x + "����ǰ���Ϊ" + cash);
		}
		_draw.signalAll(); // �������еȴ��̡߳�
		lock.unlock(); // �ͷ���
	}

	/**
	 * ȡ��
	 * 
	 * @param x
	 *            �������
	 * @param name
	 *            ������
	 */
	public void drawing(int x, String name) {
		lock.lock(); // ��ȡ��
		try {
			if (cash - x < 0) {
				_draw.await(); // ����ȡ�����
			} else {
				cash -= x; // ȡ��
				System.out.println(name + "ȡ��" + x + "����ǰ���Ϊ" + cash);
			}
			_save.signalAll(); // �������д�����
		} catch (InterruptedException e) {
			e.printStackTrace();
		} finally {
			lock.unlock(); // �ͷ���
		}
	}
}