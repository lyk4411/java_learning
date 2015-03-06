package madjava;

import java.util.concurrent.Executors;
import java.util.concurrent.ScheduledExecutorService;
import java.util.concurrent.TimeUnit;

/**
* Java线程：线程池-
*
* @author Administrator 2009-11-4 23:30:44
*/
public class Test4 {
        public static void main(String[] args) {
                //创建一个线程池，它可安排在给定延迟后运行命令或者定期地执行。
                ScheduledExecutorService pool = Executors.newScheduledThreadPool(2);
                //创建实现了Runnable接口对象，Thread对象当然也实现了Runnable接口
                Thread t1 = new MyThread4();
                Thread t2 = new MyThread4();
                Thread t3 = new MyThread4();
                Thread t4 = new MyThread4();
                Thread t5 = new MyThread4();
                //将线程放入池中进行执行
                pool.execute(t1);
                pool.execute(t2);
                pool.execute(t3);
                //使用延迟执行风格的方法
                pool.schedule(t4, 1000, TimeUnit.MILLISECONDS);
                pool.schedule(t5, 1000, TimeUnit.MILLISECONDS);
                //关闭线程池
                pool.shutdown();
        }
}

class MyThread4 extends Thread {
        @Override
        public void run() {
                System.out.println(Thread.currentThread().getName() + "正在执行。。。");
        }
}