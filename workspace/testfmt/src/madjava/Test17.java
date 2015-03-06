package madjava;

import java.util.concurrent.BrokenBarrierException;
import java.util.concurrent.CyclicBarrier;

/**
 * Java�̣߳�������-�ϰ���
 * 
 * @author leizhimin 2009-11-6 10:50:10
 */
public class Test17 {
	public static void main(String[] args) {
		// �����ϰ�����������MainTaskΪ���ж��������̶߳��ﵽ�ϰ���ʱ����Ҫִ�е�����(Runnable)
		CyclicBarrier cb = new CyclicBarrier(7, new MainTask());
		new SubTask("A", cb).start();
		new SubTask("B", cb).start();
		new SubTask("C", cb).start();
		new SubTask("D", cb).start();
		new SubTask("E", cb).start();
		new SubTask("F", cb).start();
		new SubTask("G", cb).start();
	}
}

/**
 * ������
 */
class MainTask implements Runnable {
	public void run() {
		System.out.println(">>>>������ִ���ˣ�<<<<");
	}
}

/**
 * ������
 */
class SubTask extends Thread {
	private String name;
	private CyclicBarrier cb;

	SubTask(String name, CyclicBarrier cb) {
		this.name = name;
		this.cb = cb;
	}

	public void run() {
		System.out.println("[������" + name + "]��ʼִ���ˣ�");
		for (int i = 0; i < 999999; i++)
			; // ģ���ʱ������
		System.out.println("[������" + name + "]��ʼִ������ˣ���֪ͨ�ϰ����Ѿ���ɣ�");
		try {
			// ֪ͨ�ϰ����Ѿ����
			cb.await();
		} catch (InterruptedException e) {
			e.printStackTrace();
		} catch (BrokenBarrierException e) {
			e.printStackTrace();
		}
	}
}