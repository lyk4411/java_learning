package madjava;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.atomic.AtomicLong;

/**
 * Java�̣߳�������-ԭ����
 * 
 * @author leizhimin 2009-11-6 9:53:11
 */
public class Test15 {
	public static void main(String[] args) {
		ExecutorService pool = Executors.newFixedThreadPool(2);
		Runnable t1 = new MyRunnable15("����", 2000);
		Runnable t2 = new MyRunnable15("����", 3600);
		Runnable t3 = new MyRunnable15("����", 2700);
		Runnable t4 = new MyRunnable15("����", 600);
		Runnable t5 = new MyRunnable15("��ţ", 1300);
		Runnable t6 = new MyRunnable15("����", 800);
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

class MyRunnable15 implements Runnable {
	private static AtomicLong aLong = new AtomicLong(10000); // ԭ������ÿ���̶߳��������ɲ���
	private String name; // ������
	private int x; // ��������

	MyRunnable15(String name, int x) {
		this.name = name;
		this.x = x;
	}

	public void run() {
		System.out.println(name + "ִ����" + x + "����ǰ��" + aLong.addAndGet(x) );
	}
}