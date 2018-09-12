package thread.synchronize;/**
 * Created by jiajia on 2018/9/12.
 */

import java.util.ArrayList;
import java.util.List;

/**
 * @author jiajia
 * @version V1.0
 * @Description: synchronize 版生产者消费者
 * @date 2018/9/12 22:44
 */
public class Queue {
    private int size = 2;
    private List<Integer> queues = new ArrayList<>(size);

    synchronized public void push(Integer x) {
        while (queues.size() == size) {
            try {
                System.out.println(Thread.currentThread().getName() + " push wait");
                this.wait();
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
        try {
            Thread.sleep(1000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        queues.add(x);
        System.out.println(Thread.currentThread().getName() + " push " + x);
        this.notifyAll();
    }
    synchronized public Integer pop() {
        while (queues.size() == 0) {
            try {
                System.out.println(Thread.currentThread().getName() + " pop wait");
                this.wait();
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
        try {
            Thread.sleep(1000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        Integer x = queues.get(0);
        System.out.println(Thread.currentThread().getName() + " pop " + x);
        queues.remove(0);
        this.notifyAll();
        return x;
    }

    public static void main(String[] args) {
        Queue queue = new Queue();
        Customer consumer = new Customer(queue);
        Provider provider = new Provider(queue);
        int size = 1;
        Thread[] consumerThreads = new Thread[size];
        Thread[] providerThreads = new Thread[size];
        for (int i = 0; i < size; i++) {
            consumerThreads[i] = new Thread(consumer);
            providerThreads[i] = new Thread(provider);
        }
        for (int i = 0; i < size; i++) {
            consumerThreads[i].start();
            providerThreads[i].start();
        }
    }
}

class Customer implements Runnable{

    private Queue queue;

    public Customer(Queue queue) {
        this.queue = queue;
    }

    @Override
    public void run() {
        for (int i = 0; i < Integer.MAX_VALUE; i++) {
            queue.pop();
        }
    }
}

class Provider implements Runnable {

    private Queue queue;

    public Provider(Queue queue) {
        this.queue = queue;
    }
    @Override
    public void run() {
        for (int i = 0; i < Integer.MAX_VALUE; i++) {
            queue.push(i);
        }
    }
}