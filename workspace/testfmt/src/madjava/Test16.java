package madjava;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;
import java.util.concurrent.atomic.AtomicLong;

/**
 * Java线程：新特征-原子量
 * 
 * @author leizhimin 2009-11-6 9:53:11
 */
public class Test16 {
	public static void main(String[] args) {
		ExecutorService pool = Executors.newFixedThreadPool(2);
		Lock lock = new ReentrantLock(false);
		Runnable t1 = new MyRunnable16("张三", 2000, lock);
		Runnable t2 = new MyRunnable16("李四", 3600, lock);
		Runnable t3 = new MyRunnable16("王五", 2700, lock);
		Runnable t4 = new MyRunnable16("老张", 600, lock);
		Runnable t5 = new MyRunnable16("老牛", 1300, lock);
		Runnable t6 = new MyRunnable16("胖子", 800, lock);
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

class MyRunnable16 implements Runnable {
	private static AtomicLong aLong = new AtomicLong(10000); // 原子量，每个线程都可以自由操作
	private String name; // 操作人
	private int x; // 操作数额
	private Lock lock;

	MyRunnable16(String name, int x, Lock lock) {
		this.name = name;
		this.x = x;
		this.lock = lock;
	}

	public void run() {
		lock.lock();
		System.out.println(name + "执行了" + x + "，当前余额：" + aLong.addAndGet(x));
		lock.unlock();
	}
}