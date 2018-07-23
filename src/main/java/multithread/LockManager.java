package multithread;

import java.util.concurrent.locks.Condition;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

public class LockManager {
    public static Lock lock = new ReentrantLock();
    public static Condition conditionA = lock.newCondition();
    public static Condition conditionB = lock.newCondition();

    public static Lock getLock() {
        return lock;
    }

    public static Condition getConditionA() {
        return conditionA;
    }

    public static Condition getConditionB() {
        return conditionB;
    }

}
