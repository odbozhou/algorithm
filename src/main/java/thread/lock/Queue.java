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
    private Lock lock = new ReentrantLock(false);
    private Condition pushCondition = lock.newCondition();
    private Condition popCondition = lock.newCondition();

    public void push(Integer x) {
        lock.lock();
        try {
            while (queues.size() == 1) {
                System.out.println(Thread.currentThread().getName() + " push " + "await");
                pushCondition.await();
            }
            queues.add(x);
            System.out.println(Thread.currentThread().getName() + " push " + x);
            pos++;
            Thread.sleep(1000);
            popCondition.signal();
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
                popCondition.await();
            }
            x = queues.get(pos - 1);
            System.out.println(Thread.currentThread().getName() + " pop " + x);
            queues.remove(pos - 1);
            pos--;
            Thread.sleep(1000);
            pushCondition.signal();
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
