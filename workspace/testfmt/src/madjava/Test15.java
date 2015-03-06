package madjava;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.atomic.AtomicLong;

/**
 * Java线程：新特征-原子量
 * 
 * @author leizhimin 2009-11-6 9:53:11
 */
public class Test15 {
	public static void main(String[] args) {
		ExecutorService pool = Executors.newFixedThreadPool(2);
		Runnable t1 = new MyRunnable15("张三", 2000);
		Runnable t2 = new MyRunnable15("李四", 3600);
		Runnable t3 = new MyRunnable15("王五", 2700);
		Runnable t4 = new MyRunnable15("老张", 600);
		Runnable t5 = new MyRunnable15("老牛", 1300);
		Runnable t6 = new MyRunnable15("胖子", 800);
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

class MyRunnable15 implements Runnable {
	private static AtomicLong aLong = new AtomicLong(10000); // 原子量，每个线程都可以自由操作
	private String name; // 操作人
	private int x; // 操作数额

	MyRunnable15(String name, int x) {
		this.name = name;
		this.x = x;
	}

	public void run() {
		System.out.println(name + "执行了" + x + "，当前余额：" + aLong.addAndGet(x) );
	}
}