package madjava;

import java.util.concurrent.Executors;
import java.util.concurrent.ScheduledExecutorService;
import java.util.concurrent.TimeUnit;

/**
* Java�̣߳��̳߳�-
*
* @author Administrator 2009-11-4 23:30:44
*/
public class Test4 {
        public static void main(String[] args) {
                //����һ���̳߳أ����ɰ����ڸ����ӳٺ�����������߶��ڵ�ִ�С�
                ScheduledExecutorService pool = Executors.newScheduledThreadPool(2);
                //����ʵ����Runnable�ӿڶ���Thread����ȻҲʵ����Runnable�ӿ�
                Thread t1 = new MyThread4();
                Thread t2 = new MyThread4();
                Thread t3 = new MyThread4();
                Thread t4 = new MyThread4();
                Thread t5 = new MyThread4();
                //���̷߳�����н���ִ��
                pool.execute(t1);
                pool.execute(t2);
                pool.execute(t3);
                //ʹ���ӳ�ִ�з��ķ���
                pool.schedule(t4, 1000, TimeUnit.MILLISECONDS);
                pool.schedule(t5, 1000, TimeUnit.MILLISECONDS);
                //�ر��̳߳�
                pool.shutdown();
        }
}

class MyThread4 extends Thread {
        @Override
        public void run() {
                System.out.println(Thread.currentThread().getName() + "����ִ�С�����");
        }
}