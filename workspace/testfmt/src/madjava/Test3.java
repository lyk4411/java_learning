package madjava;

import java.util.concurrent.Executors;
import java.util.concurrent.ExecutorService;

/**
 * Java�̣߳��̳߳�-
 * 
 * @author Administrator 2009-11-4 23:30:44
 */
public class Test3 {
	public static void main(String[] args) {
		// ����һ�������ù̶��߳������̳߳�
		//ExecutorService pool = Executors.newFixedThreadPool(2);
		ExecutorService pool = Executors.newCachedThreadPool();		
		// ����ʵ����Runnable�ӿڶ���Thread����ȻҲʵ����Runnable�ӿ�
		Thread t1 = new MyThread3();
		Thread t2 = new MyThread3();
		Thread t3 = new MyThread3();
		Thread t4 = new MyThread3();
		Thread t5 = new MyThread3();
		// ���̷߳�����н���ִ��
		pool.execute(t1);
		pool.execute(t2);
		pool.execute(t3);
		pool.execute(t4);
		pool.execute(t5);

		// �ر��̳߳�
		pool.shutdown();
	}
}

class MyThread3 extends Thread {
	@Override
	public void run() {
		System.out.println(Thread.currentThread().getName() + "����ִ�С�����");
	}
}