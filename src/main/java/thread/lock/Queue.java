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
            while (queues.size() == 10) {
                condition.await();
            }
            queues.add(x);
            System.out.println("push " + x);
            pos++;
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
                condition.await();
            }
            x = queues.get(pos);
            System.out.println("pop " + x);
            queues.remove(pos--);
            condition.signalAll();
            return x;
        } catch (InterruptedException e) {
            e.printStackTrace();
        } finally {
            System.out.println("pop finally");
            lock.unlock();
        }
        System.out.println("last return");
        return x;
    }
}
