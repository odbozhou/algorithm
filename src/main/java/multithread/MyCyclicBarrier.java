package multithread;

import java.util.concurrent.CountDownLatch;
import java.util.concurrent.LinkedBlockingQueue;
import java.util.concurrent.ThreadPoolExecutor;
import java.util.concurrent.TimeUnit;

/**
 * 使用CountDownLatch 实现
 *
 * @author zhoubo
 * @create 2018-09-29 17:47
 */
public class MyCyclicBarrier {
    private CountDownLatch countDownLatch;
    private Runnable runnable;
    private int total;
    private int count;
    private Object countLock = new Object();
    private Object awaitLock = new Object();

    public MyCyclicBarrier(int total, Runnable runnable) {
        this.countDownLatch = new CountDownLatch(total);
        this.runnable = runnable;
        this.total = total;
    }

    public static void main(String[] args) {
        ThreadPoolExecutor threadPoolExecutor = new ThreadPoolExecutor(4, 10, 60, TimeUnit.SECONDS, new LinkedBlockingQueue<Runnable>());

        MyCyclicBarrier myCyclicBarrier = new MyCyclicBarrier(4, new Runnable() {
            @Override
            public void run() {
                System.out.println("集合完毕");
            }
        });
        threadPoolExecutor.submit(new PrepareRunnable("小明", myCyclicBarrier));
        threadPoolExecutor.submit(new PrepareRunnable("小红", myCyclicBarrier));
        threadPoolExecutor.submit(new PrepareRunnable("小黑", myCyclicBarrier));
        threadPoolExecutor.submit(new PrepareRunnable("小白", myCyclicBarrier));
        try {
            Thread.sleep(5000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        System.out.println(threadPoolExecutor.getActiveCount());
        threadPoolExecutor.shutdown();
        System.out.println("finish");
//        System.exit(1);

    }

    public void await() {
        synchronized (awaitLock) {
            count++;
            if (count == total) {
                run();
            }
        }
        countDownLatch.countDown();
        try {
            countDownLatch.await();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }

    public void run() {
        new Thread(this.runnable).start();
    }
}

class PrepareRunnable implements Runnable {

    private String name;
    private MyCyclicBarrier myCyclicBarrier;

    public PrepareRunnable(String name, MyCyclicBarrier myCyclicBarrier) {
        this.name = name;
        this.myCyclicBarrier = myCyclicBarrier;
    }

    @Override
    public void run() {
        System.out.println(name + " 准备集合");
        myCyclicBarrier.await();
        try {
            Thread.sleep(2000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        System.out.println(name + " 到了");
    }
}