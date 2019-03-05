package multithread;

import java.util.concurrent.locks.Condition;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

/**
 * singal all test
 *
 * @author zhoubo
 * @create 2018-09-30 10:31
 */
public class SingalAllTest {

    public static void main(String[] args) {
        TestClass testClass = new TestClass();
        Runnable[] runns = {new Runnable1(testClass), new Runnable1(testClass), new Runnable1(testClass)};
        for (Runnable runnable : runns) {

            new Thread(runnable).start();
        }

        try {
            Thread.sleep(5000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

        testClass.singalAll();

        try {
            Thread.sleep(5000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

    }


}

class Runnable1 implements Runnable {

    private TestClass testClass;

    public Runnable1(TestClass testClass) {
        this.testClass = testClass;
    }

    @Override
    public void run() {
        testClass.test();
    }
}

class TestClass {
    private Lock lock = new ReentrantLock();
    private Condition condition = lock.newCondition();
    private int n;

    public void test() {
        lock.lock();
        try {
            condition.await();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        n++;
        System.out.println(Thread.currentThread().getName() + "n = " + n);
        lock.unlock();
    }

    public void singalAll() {
        lock.lock();
        condition.signalAll();
        lock.unlock();
    }
}
