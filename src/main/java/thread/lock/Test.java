package thread.lock;

/**
 * test
 *
 * @author zhoubo
 * @create 2018-09-12 10:25
 */
public class Test {
    public static void main(String[] args) {
        Queue queue = new Queue();
        Consumer consumer = new Consumer(queue);
        Provider provider = new Provider(queue);
        int size = 10;
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
