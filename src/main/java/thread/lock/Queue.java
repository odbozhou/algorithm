package thread.lock;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.locks.Condition;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

/**
 * 队列
 *
 * @author zhoubo
 * @create 2018-09-12 9:49
 */
public class Queue {

    private int size = 10;
    private int pos = 0;
    private List<Integer> queues = new ArrayList<>(size);
    private Lock lock = new ReentrantLock(true);
    private Condition condition = lock.newCondition();

    public void push(Integer x) {
        lock.lock();
        try {
            while (queues.size() == 2) {
                System.out.println(Thread.currentThread().getName() + " push " + "await");
                condition.await();
            }
            queues.add(x);
            System.out.println(Thread.currentThread().getName() + " push " + x);
            pos++;
            Thread.sleep(1000);
            condition.signalAll();
        } catch (InterruptedException e) {
            e.printStackTrace();
        } finally {
            lock.unlock();
        }
    }

    public Integer pop() {
        lock.lock();
        Integer x = null;
        try {
            while (queues.size() == 0) {
                System.out.println(Thread.currentThread().getName() + " pop " + "await");
                condition.await();
            }
            x = queues.get(pos - 1);
            System.out.println(Thread.currentThread().getName() + " pop " + x);
            queues.remove(pos - 1);
            pos--;
            Thread.sleep(1000);
            condition.signalAll();
            return x;
        } catch (InterruptedException e) {
            e.printStackTrace();
        } finally {
//            System.out.println("pop finally");
            lock.unlock();
        }
        System.out.println("last return");
        return x;
    }
}
