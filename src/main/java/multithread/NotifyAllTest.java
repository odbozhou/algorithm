package multithread;

/**
 * notifyAll test
 *
 * @author zhoubo
 * @create 2018-09-30 11:06
 */
public class NotifyAllTest {
    public static void main(String[] args) {
        NotifyAllTest notifyAllTest = new NotifyAllTest();
        TestClass testClass = notifyAllTest.new TestClass();
        ConcreateRunnable[] concreateRunnables = {notifyAllTest.new ConcreateRunnable(testClass), notifyAllTest.new ConcreateRunnable(testClass), notifyAllTest.new ConcreateRunnable(testClass)};
        for (ConcreateRunnable concreateRunnable : concreateRunnables) {
            new Thread(concreateRunnable).start();
        }
        try {
            Thread.sleep(3000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        testClass.singalAll();
        try {
            Thread.sleep(1000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        System.out.println("finish!");

    }

    private class TestClass {
        private Object lock = new Object();

        public void await() {
            synchronized (lock) {
                try {
                    lock.wait();
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
                System.out.println(Thread.currentThread().getName() + "acquire lock");
            }
        }

        public void singalAll() {
            synchronized (lock) {
                lock.notifyAll();
            }
        }
    }

    private class ConcreateRunnable implements Runnable {

        private TestClass testClass;

        public ConcreateRunnable(TestClass testClass) {
            this.testClass = testClass;
        }

        @Override
        public void run() {
            testClass.await();
        }
    }
}


