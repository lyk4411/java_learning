package madjava;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.locks.ReadWriteLock;
import java.util.concurrent.locks.ReentrantReadWriteLock;

/**
 * Java�̣߳���
 * 
 * @author leizhimin 2009-11-5 10:57:29
 */
public class Test8 {
	public static void main(String[] args) {
		// �����������ʵ��˻�
		MyCount1 MyCount1 = new MyCount1("95599200901215522", 10000);
		// ����һ��������
		ReadWriteLock lock = new ReentrantReadWriteLock(false);
		// ����һ���̳߳�
		ExecutorService pool = Executors.newFixedThreadPool(2);
		// ����һЩ���������û���һ�����ÿ�����Ĵ棬ȡ��ȡ�������ְ�
		User1 u1 = new User1("����", MyCount1, -4000, lock, false);
		User1 u2 = new User1("��������", MyCount1, 6000, lock, false);
		User1 u3 = new User1("��������", MyCount1, -8000, lock, false);
		User1 u4 = new User1("����", MyCount1, 800, lock, false);
		User1 u5 = new User1("��������", MyCount1, 0, lock, true);
		// ���̳߳���ִ�и����û��Ĳ���
		pool.execute(u1);
		pool.execute(u2);
		pool.execute(u3);
		pool.execute(u4);
		pool.execute(u5);
		// �ر��̳߳�
		pool.shutdown();
	}
}

/**
 * ���ÿ����û�
 */
class User1 implements Runnable {
	private String name; // �û���
	private MyCount1 MyCount1; // ��Ҫ�������˻�
	private int iocash; // �����Ľ���Ȼ������֮����
	private ReadWriteLock myLock; // ִ�в��������������
	private boolean ischeck; // �Ƿ��ѯ

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
			// ��ȡ����
			myLock.readLock().lock();
			System.out.println("����" + name + "���ڲ�ѯ" + MyCount1 + "�˻�����ǰ���Ϊ"
					+ MyCount1.getCash());
			// �ͷŶ���
			myLock.readLock().unlock();
		} else {
			// ��ȡд��
			myLock.writeLock().lock();
			// ִ���ֽ�ҵ��
			System.out.println("д��" + name + "���ڲ���" + MyCount1 + "�˻������Ϊ"
					+ iocash + "����ǰ���Ϊ" + MyCount1.getCash());
			MyCount1.setCash(MyCount1.getCash() + iocash);
			System.out.println("д��" + name + "����" + MyCount1 + "�˻��ɹ������Ϊ"
					+ iocash + "����ǰ���Ϊ" + MyCount1.getCash());
			// �ͷ�д��
			myLock.writeLock().unlock();
		}
	}
}

/**
 * ���ÿ��˻���������͸֧
 */
class MyCount1 {
	private String oid; // �˺�
	private int cash; // �˻����

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