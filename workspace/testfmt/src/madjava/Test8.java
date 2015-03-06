package madjava;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.locks.ReadWriteLock;
import java.util.concurrent.locks.ReentrantReadWriteLock;

/**
 * Java线程：锁
 * 
 * @author leizhimin 2009-11-5 10:57:29
 */
public class Test8 {
	public static void main(String[] args) {
		// 创建并发访问的账户
		MyCount1 MyCount1 = new MyCount1("95599200901215522", 10000);
		// 创建一个锁对象
		ReadWriteLock lock = new ReentrantReadWriteLock(false);
		// 创建一个线程池
		ExecutorService pool = Executors.newFixedThreadPool(2);
		// 创建一些并发访问用户，一个信用卡，存的存，取的取，好热闹啊
		User1 u1 = new User1("张三", MyCount1, -4000, lock, false);
		User1 u2 = new User1("张三他爹", MyCount1, 6000, lock, false);
		User1 u3 = new User1("张三他弟", MyCount1, -8000, lock, false);
		User1 u4 = new User1("张三", MyCount1, 800, lock, false);
		User1 u5 = new User1("张三他爹", MyCount1, 0, lock, true);
		// 在线程池中执行各个用户的操作
		pool.execute(u1);
		pool.execute(u2);
		pool.execute(u3);
		pool.execute(u4);
		pool.execute(u5);
		// 关闭线程池
		pool.shutdown();
	}
}

/**
 * 信用卡的用户
 */
class User1 implements Runnable {
	private String name; // 用户名
	private MyCount1 MyCount1; // 所要操作的账户
	private int iocash; // 操作的金额，当然有正负之分了
	private ReadWriteLock myLock; // 执行操作所需的锁对象
	private boolean ischeck; // 是否查询

	User1(String name, MyCount1 MyCount1, int iocash, ReadWriteLock myLock,
			boolean ischeck) {
		this.name = name;
		this.MyCount1 = MyCount1;
		this.iocash = iocash;
		this.myLock = myLock;
		this.ischeck = ischeck;
	}

	public void run() {
		if (ischeck) {
			// 获取读锁
			myLock.readLock().lock();
			System.out.println("读：" + name + "正在查询" + MyCount1 + "账户，当前金额为"
					+ MyCount1.getCash());
			// 释放读锁
			myLock.readLock().unlock();
		} else {
			// 获取写锁
			myLock.writeLock().lock();
			// 执行现金业务
			System.out.println("写：" + name + "正在操作" + MyCount1 + "账户，金额为"
					+ iocash + "，当前金额为" + MyCount1.getCash());
			MyCount1.setCash(MyCount1.getCash() + iocash);
			System.out.println("写：" + name + "操作" + MyCount1 + "账户成功，金额为"
					+ iocash + "，当前金额为" + MyCount1.getCash());
			// 释放写锁
			myLock.writeLock().unlock();
		}
	}
}

/**
 * 信用卡账户，可随意透支
 */
class MyCount1 {
	private String oid; // 账号
	private int cash; // 账户余额

	MyCount1(String oid, int cash) {
		this.oid = oid;
		this.cash = cash;
	}

	public String getOid() {
		return oid;
	}

	public void setOid(String oid) {
		this.oid = oid;
	}

	public int getCash() {
		return cash;
	}

	public void setCash(int cash) {
		this.cash = cash;
	}

	@Override
	public String toString() {
		return "MyCount1{" + "oid='" + oid + '\'' + ", cash=" + cash + '}';
	}
}