package designpatten;

public class StatusPatten {
}

interface StatusI {
    void printStatus();
}

class RunnableStatus implements StatusI {

    @Override
    public void printStatus() {
        System.out.println("runnable");
    }
}

class WaitStatus implements StatusI {

    @Override
    public void printStatus() {
        System.out.println("wait");
    }
}

class TerminatedStatus implements StatusI {

    @Override
    public void printStatus() {
        System.out.println("terminated");
    }
}

class ThreadStatus {
    public static StatusI runnableStatus = new RunnableStatus();
    public static StatusI waitStatus = new WaitStatus();
    public static StatusI terminatdStatus = new TerminatedStatus();
    private StatusI currentStatus;

    public ThreadStatus(Thread thread) {
        Thread.State state = thread.getState();
        currentStatus = runnableStatus;
    }

    public void printStatus() {
        currentStatus.printStatus();
    }

}
