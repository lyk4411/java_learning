package threads;

import java.util.concurrent.ArrayBlockingQueue;
import java.util.concurrent.BlockingQueue;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

/**

 ��������һ������Ķ���:BlockingQueue,���BlockQueue�ǿյ�,��BlockingQueueȡ�����Ĳ������ᱻ��Ͻ���ȴ�״̬,ֱ��BlockingQueue���˶����Żᱻ����.ͬ��,���BlockingQueue������,�κ���ͼ����涫���Ĳ���Ҳ�ᱻ��Ͻ���ȴ�״̬,ֱ��BlockingQueue���пռ�Żᱻ���Ѽ�������.

 �����ٴ�ʵ��11.4�߳�----����Condition�н��ܵ����ӳ���,�����������������ܷŵ�ƻ��������1,��������ָ��.��������ʱ,�����߽���ȴ�״̬,�����ӿ�ʱ,�����ߵȴ�.

 */

/**
 * ʹ��BlockingQueue�Ĺؼ�����������:
 * 
 * 1.BlockingQueue����ĳ��÷�������:
 * 
 * 1)add(anObject):��anObject�ӵ�BlockingQueue��,�����BlockingQueue��������,�򷵻�true,������Ƹ�쳣
 * 
 * 2)offer(anObject):��ʾ������ܵĻ�,��anObject�ӵ�BlockingQueue��,�����BlockingQueue��������,
 * �򷵻�true,���򷵻�false.
 * 
 * 3)put(anObject):��anObject�ӵ�BlockingQueue��,���BlockQueueû�пռ�,
 * ����ô˷������̱߳����ֱ��BlockingQueue�����пռ��ټ���.
 * 
 * 4)poll(time):ȡ��BlockingQueue��������λ�Ķ���,����������ȡ��,����Ե�time�����涨��ʱ��,ȡ����ʱ����null
 * 
 * 5)take():ȡ��BlockingQueue��������λ�Ķ���,��BlockingQueueΪ��,
 * ��Ͻ���ȴ�״ֱ̬��Blocking���µĶ��󱻼���Ϊֹ
 * 
 * 2.BlockingQueue���ĸ������ʵ����,���ݲ�ͬ����,ѡ��ͬ��ʵ����
 * 
 * 1)ArrayBlockingQueue:�涨��С��BlockingQueue,�乹�캯�������һ��int������ָ�����С.�������Ķ�������FIFO(
 * �����ȳ�)˳�������.
 * 
 * 2)LinkedBlockingQueue:��С������BlockingQueue,���乹�캯����һ���涨��С�Ĳ���,
 * ���ɵ�BlockingQueue�д�С����
 * ,��������С����,�����ɵ�BlockingQueue�Ĵ�С��Integer.MAX_VALUE������.�������Ķ�������FIFO(�����ȳ�)˳�������
 * 
 * 3)PriorityBlockingQueue:������LinkedBlockQueue,�������������������FIFO,
 * �������ݶ������Ȼ����˳������ǹ��캯����Comparator������˳��.
 * 
 * 4)SynchronousQueue:�����BlockingQueue,����Ĳ��������Ƿź�ȡ������ɵ�.
 * 
 * 3.LinkedBlockingQueue��ArrayBlockingQueue�Ƚ�����,���Ǳ������õ����ݽṹ��һ��,
 * ����LinkedBlockingQueue������������Ҫ����ArrayBlockingQueue
 * ,�����߳������ܴ�ʱ�����ܵĿ�Ԥ���Ե���ArrayBlockingQueue.
 */

public class BlockingQueueTest {

	/** ����װƻ�������� */
	public static class Basket {
		// ����,�ܹ�����3��ƻ��
		BlockingQueue<String> basket = new ArrayBlockingQueue<String>(3);

		// ����ƻ��,��������

		public void produce() throws InterruptedException {

			// put��������һ��ƻ��,��basket����,�ȵ�basket��λ��

			basket.put("An apple");

		}

		// ����ƻ��,��������ȡ��

		public String consume() throws InterruptedException {

			// take����ȡ��һ��ƻ��,��basketΪ��,�ȵ�basket��ƻ��Ϊֹ

			return basket.take();

		}

	}

	// ���Է���

	public static void testBasket() {

		final Basket basket = new Basket();// ����һ��װƻ��������

		// ����ƻ��������

		class Producer implements Runnable {

			public void run() {

				try {

					while (true) {

						// ����ƻ��

						System.out.println("������׼������ƻ��: "
								+ System.currentTimeMillis());

						basket.produce();

						System.out.println("����������ƻ�����: "
								+ System.currentTimeMillis());

						// ����300ms

						Thread.sleep(300);

					}

				} catch (InterruptedException ex) {

				}

			}

		}

		// ����ƻ��������

		class Consumer implements Runnable {

			public void run() {

				try {

					while (true) {

						// ����ƻ��

						System.out.println("������׼������ƻ��: "
								+ System.currentTimeMillis());

						basket.consume();

						System.out.println("����������ƻ�����: "
								+ System.currentTimeMillis());

						// ����1000ms

						Thread.sleep(1000);

					}

				} catch (InterruptedException ex) {

				}

			}

		}

		ExecutorService service = Executors.newCachedThreadPool();

		Producer producer = new Producer();

		Consumer consumer = new Consumer();

		service.submit(producer);

		service.submit(consumer);

		// ��������5s��,��������ֹͣ

		try {

			Thread.sleep(5000);

		} catch (InterruptedException ex) {

		}

		service.shutdownNow();

	}

	public static void main(String[] args) {

		BlockingQueueTest.testBasket();

	}

}
