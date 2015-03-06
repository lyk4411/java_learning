package madjava;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

/**
 * Java线程：不用条件变量
 * 
 * @author leizhimin 2009-11-5 10:57:29
 */
public class Test13 {
	public static void main(String[] args) {
		// 创建并发访问的账户
		MyCount13 MyCount13 = new MyCount13("95599200901215522", 10000);
		// 创建一个线程池
		ExecutorService pool = Executors.newFixedThreadPool(2);
		Thread t1 = new SaveThread13("张三", MyCount13, 2000);
		Thread t2 = new SaveThread13("李四", MyCount13, 3600);
		Thread t3 = new DrawThread13("王五", MyCount13, 2700);
		Thread t4 = new SaveThread13("老张", MyCount13, 600);
		Thread t5 = new DrawThread13("老牛", MyCount13, 1300);
		Thread t6 = new DrawThread13("胖子", MyCount13, 800);
		// 执行各个线程
		pool.execute(t1);
		pool.execute(t2);
		pool.execute(t3);
		pool.execute(t4);
		pool.execute(t5);
		pool.execute(t6);
		// 关闭线程池
		pool.shutdown();
	}
}

/**
 * 存款线程类
 */
class SaveThread13 extends Thread {
	private String name; // 操作人
	private MyCount13 MyCount13; // 账户
	private int x; // 存款金额

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
 * 取款线程类
 */
class DrawThread13 extends Thread {
	private String name; // 操作人
	private MyCount13 MyCount13; // 账户
	private int x; // 存款金额

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
 * 普通银行账户，不可透支
 */
class MyCount13 {
	private String oid; // 账号
	private int cash; // 账户余额

	MyCount13(String oid, int cash) {
		this.oid = oid;
		this.cash = cash;
	}

	/**
	 * 存款
	 * 
	 * @param x
	 *            操作金额
	 * @param name
	 *            操作人
	 */
	public synchronized void saving(int x, String name) {
		if (x > 0) {
			cash += x; // 存款
			System.out.println(name + "存款" + x + "，当前余额为" + cash);
		}
		notifyAll(); // 唤醒所有等待线程。
	}

	/**
	 * 取款
	 * 
	 * @param x
	 *            操作金额
	 * @param name
	 *            操作人
	 */
	public synchronized void drawing(int x, String name) {
		if (cash - x < 0) {
			try {
				wait();
			} catch (InterruptedException e1) {
				e1.printStackTrace();
			}
		} else {
			cash -= x; // 取款
			System.out.println(name + "取款" + x + "，当前余额为" + cash);
		}
		notifyAll(); // 唤醒所有存款操作
	}
}