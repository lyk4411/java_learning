package madjava;

public class Test1 {
	public static void main(String[] args) {
		Godown godown = new Godown(30);
		Consumer c1 = new Consumer(50, godown);
		Consumer c2 = new Consumer(20, godown);
		Consumer c3 = new Consumer(20, godown);
		Consumer c4 = new Consumer(20, godown);
		Consumer c5 = new Consumer(30, godown);
		Consumer c6 = new Consumer(30, godown);
		Consumer c7 = new Consumer(30, godown);
		Producer p1 = new Producer(10, godown);
		Producer p2 = new Producer(10, godown);
		Producer p3 = new Producer(10, godown);
		Producer p4 = new Producer(10, godown);
		Producer p5 = new Producer(10, godown);
		Producer p6 = new Producer(10, godown);
		Producer p7 = new Producer(80, godown);
		Producer p8 = new Producer(20, godown);
		Producer p9 = new Producer(20, godown);
		
		c1.start();
		c2.start();
		c3.start();
		c4.start();
		c5.start();
		c6.start();
		c7.start();
		p1.start();
		p2.start();
		p3.start();
		p4.start();
		p5.start();
		p6.start();
		p7.start();
		p8.start();
		p9.start();

	}
}

/**
 * �ֿ�
 */
class Godown {
	public static final int max_size = 100;// �������
	public int curnum; // ��ǰ�����

	Godown() {
	}

	Godown(int curnum) {
		this.curnum = curnum;
	}

	/**
	 * ����ָ�������Ĳ�Ʒ
	 * 
	 * @param neednum
	 */
	public synchronized void produce(int neednum) {
		// �����Ƿ���Ҫ����
		while (neednum + curnum > max_size) {
			System.out.println("Ҫ�����Ĳ�Ʒ����" + neednum + "����ʣ������"
					+ (max_size - curnum) + "����ʱ����ִ����������!");
			try {
				// ��ǰ�������̵߳ȴ�
				wait();
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
		}
		// �����������������������������򵥵ĸ��ĵ�ǰ�����
		curnum += neednum;
		System.out.println("�Ѿ�������" + neednum + "����Ʒ���ֲִ���Ϊ" + curnum);
		// �����ڴ˶���������ϵȴ��������߳�
		notifyAll();
	}

	/**
	 * ����ָ�������Ĳ�Ʒ
	 * 
	 * @param neednum
	 */
	public synchronized void consume(int neednum) {
		// �����Ƿ������
		while (curnum < neednum) {
			try {
				// ��ǰ�������̵߳ȴ�
				System.out.println("�޿�棬��ʱ����ִ����������!");
				wait();
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
		}
		// ����������������������ѣ�����򵥵ĸ��ĵ�ǰ�����
		curnum -= neednum;
		System.out.println("�Ѿ�������" + neednum + "����Ʒ���ֲִ���Ϊ" + curnum);
		// �����ڴ˶���������ϵȴ��������߳�
		notifyAll();
	}
}

/**
 * ������
 */
class Producer extends Thread {
	private int neednum; // ������Ʒ������
	private Godown godown; // �ֿ�

	Producer(int neednum, Godown godown) {
		this.neednum = neednum;
		this.godown = godown;
	}

	public void run() {
		// ����ָ�������Ĳ�Ʒ
		godown.produce(neednum);
	}
}

/**
 * ������
 */
class Consumer extends Thread {
	private int neednum; // ������Ʒ������
	private Godown godown; // �ֿ�

	Consumer(int neednum, Godown godown) {
		this.neednum = neednum;
		this.godown = godown;
	}

	public void run() {
		// ����ָ�������Ĳ�Ʒ
		godown.consume(neednum);
	}
}