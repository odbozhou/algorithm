package thread.lock;

/**
 * 消费者
 *
 * @author zhoubo
 * @create 2018-09-12 9:47
 */
public class Consumer implements Runnable {

    private Queue queue;

    public Consumer(Queue queue) {
        this.queue = queue;
    }

    @Override
    public void run() {
        for (int i = 0; i < Integer.MAX_VALUE; i++) {
            queue.pop();
//            System.out.println(Thread.currentThread().getName() + " return value " + queue.pop());
//            System.out.println(Thread.currentThread().getName() + " return value " + queue.pop());
        }
    }
}
