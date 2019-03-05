package multithread;

public class Basket {
    //    public List<Integer> integers = new ArrayList<Integer>(10);
    public int[] ints = new int[10];
    public int pos = 0;

    public void put(int x) {
        LockManager.getLock().lock();
        if (pos < ints.length - 1) {
            pos++;
            ints[pos] = x;
            System.out.println("privide : " + ints[pos]);
            LockManager.getConditionA().signalAll();
        } else {
            try {
                LockManager.getConditionA().wait();
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
        LockManager.getLock().unlock();
    }

    public void get() {
        LockManager.getLock().lock();
        if (pos >= 0) {
            System.out.println("consume : " + ints[pos]);
            pos--;
            LockManager.getConditionA().signalAll();
        } else {
            try {
                LockManager.getConditionA().wait();
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
        LockManager.getLock().unlock();
    }
}
