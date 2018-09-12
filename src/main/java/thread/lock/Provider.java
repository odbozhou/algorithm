package thread.lock;

import java.util.Random;

/**
 * 生产者
 *
 * @author zhoubo
 * @create 2018-09-12 9:47
 */
public class Provider implements Runnable {

    private Queue queue;

    public Provider(Queue queue) {
        this.queue = queue;
    }

    @Override
    public void run() {
        Integer x = new Random().nextInt();
        queue.push(x);
    }
}
