package madjava;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.Semaphore;

/**
 * Java�̣߳�������-�ź���
 * 
 * @author leizhimin 2009-11-5 13:44:45
 */
public class Test9 {
	public static void main(String[] args) {
		MyPool myPool = new MyPool(20);
		// �����̳߳�
		ExecutorService threadPool = Executors.newFixedThreadPool(2);
		MyThread99 t1 = new MyThread99("����A", myPool, 3);
		MyThread99 t2 = new MyThread99("����B", myPool, 12);
		MyThread99 t3 = new MyThread99("����C", myPool, 7);
		// ���̳߳���ִ������
		threadPool.execute(t1);
		threadPool.execute(t2);
		threadPool.execute(t3);
		// �رճ�
		threadPool.shutdown();
	}
}

/**
 * һ����
 */
class MyPool {
	private Semaphore sp; // ����ص��ź���

	/**
	 * �صĴ�С�������С�ᴫ�ݸ��ź���
	 * 
	 * @param size
	 *            �صĴ�С
	 */
	MyPool(int size) {
		this.sp = new Semaphore(size);
	}

	public Semaphore getSp() {
		return sp;
	}

	public void setSp(Semaphore sp) {
		this.sp = sp;
	}
}

class MyThread99 extends Thread {
	private String threadname; // �̵߳�����
	private MyPool pool; // �Զ����
	private int x; // �����ź����Ĵ�С

	MyThread99(String threadname, MyPool pool, int x) {
		this.threadname = threadname;
		this.pool = pool;
		this.x = x;
	}

	public void run() {
		try {
			// �Ӵ��ź�����ȡ������Ŀ�����
			pool.getSp().acquire(x);
			// todo��Ҳ����������������ӵ�ҵ��
			System.out.println(threadname + "�ɹ���ȡ��" + x + "����ɣ�");
		} catch (InterruptedException e) {
			e.printStackTrace();
		} finally {
			// �ͷŸ�����Ŀ����ɣ����䷵�ص��ź�����
			pool.getSp().release(x);
			System.out.println(threadname + "�ͷ���" + x + "����ɣ�");
		}
	}
}