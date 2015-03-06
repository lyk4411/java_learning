package examples100;

import java.util.Arrays;


/**
 * 
 * {@link java.lang.ThreadGroup}ʾ��
 * 
 * <pre>
 * 1.�߳����ʾһ���̵߳Ľ��.�����߳���Ҳ���԰��������߳���.�߳��鹹��һ����,������,���˳�ʼ�߳�����,ÿ���߳��鶼��һ�����߳���
 * 2.ÿ���̲߳���ʱ,���ᱻ����ĳ���߳���(Java��ÿ���̶߳�������ĳ���߳���),���߳������Ǹ��߳����в�������.���û��ָ��,�������������̵߳��̵߳��߳�����.(����main�г�ʼ��һ���߳�,δָ���߳���,���߳������߳���Ϊmain)
 * 3.�߳�һ������ĳ������޷�������
 * 4.main�߳����parent��system�߳���,��system�߳����parentΪnull.(�ο�ThreadGroup��˽�й��췽��).Ҳ����˵��ʼ�߳���Ϊsystem.��system/main������һ����
 * 5.��activeCount/activeCount/enumerate������Ϊ����ȷ��ͳ��,�����������ϢĿ��
 * 6.��ͨ��enumerate��û�̵߳����ò�������в���
 * 7.�����̷߳����й��Լ����߳������Ϣ{@link Thread#getThreadGroup()},���ǲ������������й����߳���ĸ��߳���������κ��߳������Ϣ
 * 8.�߳����ĳЩ����,�����߳��������������������߳�ִ��,��{@link ThreadGroup#interrupt()}
 * 7.public class ThreadGroup implements Thread.UncaughtExceptionHandler,����ʵ����UncaughtExceptionHandler����.��
 *     ->��Thread��δ������쳣��ͻȻ��ֹʱ,���ô������Ľӿ�.��ĳһ�߳��򲶻���쳣��������ֹʱ,JVM��ʹ��UncaughtExceptionHandler��ѯ���߳��Ի����
 *     UncaughtExceptionHandler���̲߳����ô�������uncaughtException����,���̺߳��쳣��Ϊ��������.���ĳһ�߳�Ϊ��ȷ������UncaughtExceptionHandler,
 *     ������ThreadGroup������ΪUncaughtExceptionHandler.���ThreadGroup����Դ����쳣û������Ҫ��,���Խ�����ת����
 *  {@link Thread#getDefaultUncaughtExceptionHandler()}
 * </pre>
 * 
 * <pre>
 * 1."�߳��Ƕ���ִ�еĴ���Ƭ�ϣ��̵߳�����Ӧ�����߳��Լ������������Ҫί�е��ⲿ".������������������Java�У��̷߳������쳣
 * ��������checked����unchecked exception������Ӧ�����̴߳���߽�֮�ڣ�run�����ڣ�����try catch�������
 * .���仰˵�����ǲ��ܲ�����߳������ݵ��쳣
 * 
 * 2.�ο�{@link Thread#dispatchUncaughtException}���÷�����һ��˽�з��������쳣����ʱ����.�ж��߳������Ƿ�������uncaughtExceptionHandler.
 * ���û����ֱ�ӷ���group�����Լ������ڵ��߳���,���߳���ʵ����UncaughtExceptionHandler�ӿ�.{@link Thread#getUncaughtExceptionHandler()}
 * </pre>
 * 
 * @author landon
 * 
 */
public class ThreadGroupExample {
	
	public static void main(String[] args) {
		// main.thread.name:main,main.threadGroup.name:main
		// ����ǰ�߳�Ϊmain���������߳���
		// Thread#public final ThreadGroup getThreadGroup()
		// ���ظ��߳��������߳���.������߳��Ѿ�ֹͣ�����򷵻�null
		System.out.println("main.thread.name:{},main.threadGroup.name:{}"
				+ Thread.currentThread().getName()
				+ Thread.currentThread().getThreadGroup().getName());

		Thread thread1 = new Thread("Thread-1");
		// ��������Կ���
		// 1.thread1Ϊָ���߳���,����������߳���Ϊmain��������thread1��main�߳��������߳���main
		// 2.thread1��δ����.�������߳�����Ѿ�ָ����,�����̳߳�ʼ����ʱ����Ѿ�ӵ����
		// ��Դ�뿴:
		// Thread#private void init(ThreadGroup g, Runnable target,String
		// name,long stackSize)
		// 1.Thread parent = currentThread(),��ȡ�����߳�,������thread���߳�
		// 2.�ж�SecurityManager�Ƿ�Ϊ��,�����Ϊ��,����SecurityManager#getThreadGroup().
		// 3.���SecurityManager#getThreadGroup()Ϊ�ջ��߲�����SecurityManager�����߳��鸳ֵΪparent.getThreadGroup()���������߳��������߳���
		// �����Thread�ĳ�ʼ�������п��Կ���,�߳��Ƿ����ػ��߳��Լ��̵߳����ȼ�������parentָ��
		System.out.println("thread1.name:{},thread1.threadGroup.name:{}"
				+ thread1.getName() + thread1.getThreadGroup().getName());
		// ���Ƿ����ػ��̺߳��̵߳����ȼ����������,threa1����parent�߳�main����һ����
		System.out
				.println("threa1.name:{},threa1.isDaemon:{},threa1.priority:{}"
						+ thread1.getName() + thread1.isDaemon()
						+ thread1.getPriority());
		Thread curThread = Thread.currentThread();
		System.out
				.println("curThread.name:{},curThread.isDaemon:{},curThread.priority:{}"
						+ curThread.isDaemon() + curThread.getPriority());

		// ���߳�δִ������,�������:��������Thread-0
		// ��Thread�ĳ�ʼ���������Կ���,������Ϊnull��ʱ�򣨼������̣߳�,��ָ��һ������"Thread-" +
		// nextThreadNum()
		// ��nextThreadNum��һ����̬ͬ������,��threadInitNumber�����̬������ִ��++
		Thread thread2 = new Thread();
		System.out.println("threa2.name:{}" + thread2.getName());

		// public ThreadGroup(String name) ����һ���µ��߳���,�����߳���ĸ��߳�����Ŀǰ�����̵߳��߳���
		// ��Դ���Ͽ�:
		// 1.this(Thread.currentThread().getThreadGroup(),
		// name),������ǰ�����߳��������߳�����Ϊ�丸parent�߳��鴫��
		// 2.��parent.maxPriority/daemon��ֵ����
		// 3.parent.add(this),�������߳�����뵽���߳���
		// 4.����ThreadGroup��һ��˽�еĿղ����Ĺ��췽��,��ָ���߳�������Ϊsystem,priorityΪ������ȼ�,parentΪnull����û�и��߳���.�Ӹô����ע������,
		// ->��˽�й��췽��ͨ����������һ��ϵͳ�߳���,C�������
		ThreadGroup group1 = new ThreadGroup("ThreadGroup-1");
		// ���:group1.parent.name:main,��group1�ĸ��߳���Ϊmain
		// ThreadGroup#public final ThreadGroup getParent() �����߳���ĸ��߳���
		System.out.println("group1.parent.name:{}"
				+ group1.getParent().getName());
		ThreadGroup mainGroup = Thread.currentThread().getThreadGroup();
		// ���:mainGroup.parentOf(group1):true,group1.parentOf(group1),true
		// ThreadGroup#public final boolean parentOf(ThreadGroup g)
		// �жϸ��߳����Ƿ�Ϊ�߳�������������������߳���
		// �������,mainGroup��group1��parent,������ԭ��,����Ҳ����true
		System.out
				.println("mainGroup.parentOf(group1):{},group1.parentOf(group1),{}"
						+ mainGroup.parentOf(group1) + group1.parentOf(group1));
		// �������mainGroup�ĸ��߳���Ϊsystem.�ο�ThreadGroup��˽�й��췽��,��֪system��һ��ϵͳ�߳��飬��parentΪnull.��Ϊ��ʼ�߳���
		System.out.println("mainGroup.parent.name:{}"
				+ mainGroup.getParent().getName());

		GroupExampleThread get1 = new GroupExampleThread("GroupExampleThread-1");
		// ��Thread#startԴ�뿴���������̺߳�->�����group.add(this),��ֻ�����߳�������,���ŻὫ�̼߳����������߳���
		// ����ע��ThreadGroup#void add(Thread
		// t),���÷���ֻ��Ĭ�Ϸ���Ȩ��,��������Ȩ��.����Ӧ�ó����޷����ø÷�������jdk lang���ڵĿ�
		get1.start();
		// ThreadGroup#public int activeCount()
		// ���ش��߳����л�̵߳Ĺ�����,��������ܷ�ӳ�����(��Ϊ���̲߳�������,���Բ��Ǻܾ�ȷ.���̵߳Ĳ�ȷ����,��add(ĳһ�����߳�����)/remove(ĳһ�����߳�����)).
		// ->���еĲ���ȷ��->����ֻ������Ϣ
		// ��Դ���ʵ�ֿ�,�������Ŀֻ��ȡ��һ��groupsSnapshot(syncrhonized)������ǰ�Ŀ���
		System.out.println("mainGroup.activeCount:{}"
				+ get1.getThreadGroup().activeCount());
		Thread[] mainGroupActiveThreads = new Thread[mainGroup.activeCount()];
		// ThreadGroup#public int enumerate(Thread list[])
		// �����߳��鼴�������е����л�̸߳��Ƶ�ָ��������.עӦ�ó������ʹ��activeCount������ȡ�����С�Ĺ�����.
		// �������̫С���޷����������߳�,����Զ�����߳�
		// �ɶ���У��÷����ķ���ֵ�Ƿ��ϸ�С�ڲ���list�ĳ���
		// ��Ϊ�˷������еľ�������(Դ��ʵ��Ҳ��ȡ��һ��Snapshot(syncrhonized)),�����������ϢĿ��
		mainGroup.enumerate(mainGroupActiveThreads);
		// �������:1.���߳������������߳�,main��GroupExampleThread-1
		// 2.Thread#toString�������ص���Ϣ��Thread[threadName,priority,groupName(�����group��Ϊnull)]
		System.out.println("mainGroupActiveThreads:{}"
				+ Arrays.toString(mainGroupActiveThreads));

		// Thread#public Thread(ThreadGroup group, String name) ָ���߳���
		GroupExampleThread get2 = new GroupExampleThread(group1,
				"GroupExampleThread-2");
		// ͨ������start��get2����group1
		get2.start();

		// ���:group1.activeCount:1
		System.out.println("group1.activeCount:{}" + group1.activeCount());
		// ���:mainGroup.activeCount:3,����ͳ�ư������̵߳Ļ�߳���Ŀ,��Ϊgroup1Ϊ������
		System.out
				.println("mainGroup.activeCount:{}" + mainGroup.activeCount());

		Thread[] mainGroupActiveThreads2 = new Thread[mainGroup.activeCount()];
		// ThreadGroup#public int enumerate(Thread list[], boolean recurse)
		// recurseΪ�ݹ����˼
		// ���recurseΪtrue��ʾҪ���Ʊ������߳���Ļ�߳�,����ֻ�Ǹ��Ƶ�ǰ�߳���Ļ�߳�
		// enumerate(Thread list[])����Ĭ�ϴ�true
		mainGroup.enumerate(mainGroupActiveThreads2, false);
		// ���:[Thread[main,5,main], Thread[GroupExampleThread-1,5,main], null]
		// ��������Կ�,ֻ�������߳�������Ļ�߳�
		System.out.println("mainGroupActiveThreads2:{}"
				+ Arrays.toString(mainGroupActiveThreads2));

		Thread[] mainGroupActiveThreads3 = new Thread[mainGroup.activeCount()];
		mainGroup.enumerate(mainGroupActiveThreads3, true);
		// ���:Thread[GroupExampleThread-1,5,main],
		// Thread[GroupExampleThread-2,5,ThreadGroup-1]]
		// ��������Կ�,���������߳�������߳���group1�Ļ�߳�
		System.out.println("mainGroupActiveThreads3:{}"
				+ Arrays.toString(mainGroupActiveThreads3));

		// ͨ��enumerate�����õ���̵߳�����,���ǿ��Զ�����в���
		Thread get1Ref = mainGroupActiveThreads3[1];
		System.out.println("get1 == get1Ref:{}" + (get1 == get1Ref));
		// �ж�get1,�������,get1�߳�����ȷʵ�������
		get1Ref.interrupt();

		// ���Ա�����߳��б����в������ȡ�߳�״̬���ж��Ƿ��ڻ״̬��
		for (Thread tRef : mainGroupActiveThreads3) {
			System.out.println("threadName:{},state:{},isAlive:{}"
					+ tRef.getName() + tRef.getState() + tRef.isAlive());
		}

		// ThreadGroup#public final void interrupt() ���߳��鼰�������е������̵߳���interrupt����
		// ��������Կ���get2Ҳ���ж���
		mainGroup.interrupt();

		// �Զ����һ��group,��д��uncaughtException����i
		ExampleThreadGroup etg = new ExampleThreadGroup("ExampleThreadGroup");
		AExceptionThread aet = new AExceptionThread(etg, "A-Exception-Thread");
		aet.start();

		// ThreadGroup#public void list() ���йش��߳������Ϣ��ӡ�ı�׼���.�˷���ֻ�Ե�������
		// �������߳������Ϣ:className[name=groupName,maxPri=],��������ǰ�����̵߳���Ϣ,{@link
		// Thread#toString()}.{@link ThreadGroup#toString()}
		// Ȼ��������߳���������
		etg.list();

		mainGroup.list();
	}

	/**
	 * 
	 * GroupExampleThread
	 * 
	 * @author landon
	 * 
	 */
	private static class GroupExampleThread extends Thread {
		public GroupExampleThread(String name) {
			super(name);
		}

		// �˹��췽��ָ�����߳���
		public GroupExampleThread(ThreadGroup tg, String name) {
			super(tg, name);
		}

		@Override
		public void run() {
			System.out.println("GroupExampleThread" + "[" + getName() + "]"
					+ " task begin.");

			// ��sleepģ�������ʱ
			try {
				sleep(5 * 1000);
			} catch (InterruptedException e) {
				System.out.println("GroupExampleThread" + "[" + getName() + "]"
						+ " was interrutped");
			}

			System.out.println("GroupExampleThread" + "[" + getName() + "]"
					+ " task end.");
		}
	}

	// ��ʵ�ֵ�һ���߳���,��д��uncaughtException
	private static class ExampleThreadGroup extends ThreadGroup {

		public ExampleThreadGroup(String name) {
			super(name);
		}

		@Override
		public void uncaughtException(Thread t, Throwable e) {
			// ע.�÷�����������t�߳�,�ο�Thread#dispatchUncaughtException,��һ��˽�з���
			System.out.println("uncaughtException.thread.name.{}" + t.getName()
					+ e);
			System.out.println("uncaughtException.thread.state.{}"
					+ t.getState());

			// ��������������һ�����߳�
			GroupExampleThread thread = new GroupExampleThread(this,
					t.getName());
			thread.start();
		}
	}

	private static class AExceptionThread extends Thread {
		public AExceptionThread(ThreadGroup group, String name) {
			super(group, name);
		}

		@Override
		public void run() {
			// ֱ���׳�һ����ָ���쳣
			throw new NullPointerException();
		}
	}
}
