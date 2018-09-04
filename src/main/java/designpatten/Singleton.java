package designpatten;

/**
 * 单例模式
 *
 * @author zhoubo
 * @create 2018-09-04 13:24
 */
public class Singleton {
    private volatile static Singleton singleton;

    private Singleton() {
    }

    public static Singleton getInstance() {
        if (null == singleton) {
            synchronized (Singleton.class) {
                if (null == singleton) {
                    return new Singleton();
                }
            }
        }
        return singleton;
    }
}
