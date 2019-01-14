package sheduler;

import java.util.concurrent.Executors;
import java.util.concurrent.ThreadPoolExecutor;

/**
 * @author junzhao
 * @date 2019/1/11 16:59
 */
public class ThreadTest {

    private static ThreadPoolExecutor executor;

    public static void main(String[] args) {
        executor = (ThreadPoolExecutor)Executors.newFixedThreadPool(10);
        for (int i = 0; i < 1000000; i++) {
            executor.execute(new MyThread());
            if(executor.getQueue().size() > 100){
                try {
                    synchronized (executor) {
                        executor.wait();
                    }
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
            System.out.println(Thread.currentThread().getName() + "  main is running   " + i);
        }
    }

    static class MyThread implements Runnable{

        @Override
        public void run() {
            try {
                Thread.sleep(1000);
                if(executor.getQueue().size() < 5){
                    synchronized (executor) {
                        executor.notifyAll();
                    }
                }
                System.err.println(Thread.currentThread().getName() + "thread running ....");
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }
}
