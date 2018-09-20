package designpatten;

/**
 * @author zhoubo
 */
public class CandyMachine implements SaleStatus {

    public final SaleStatus haveNo25 = new HaveNo25(this);
    public final SaleStatus have25 = new Have25(this);
    public final SaleStatus noCandy = new NoCandy(this);
    public final SaleStatus saleCandy = new SaleCandy(this);

    private int candyNum = 0;

    private SaleStatus currentStatus;

    public CandyMachine(int candyNum) {
        this.candyNum = candyNum;
        this.currentStatus = haveNo25;
    }


    @Override
    public void pubInto() {
        currentStatus.pubInto();
    }

    @Override
    public void sendBack() {
        currentStatus.sendBack();
    }

    @Override
    public void turnTheCrank() {
        currentStatus.turnTheCrank();
    }

    @Override
    public void distributionOfCandy() {
        currentStatus.distributionOfCandy();
    }

    public int getCandyNum() {
        return candyNum;
    }

    public void setCandyNum() {
        candyNum--;
    }

    public void setStatus(SaleStatus saleStatus) {
        this.currentStatus = saleStatus;
    }

    public SaleStatus getStatus() {
        return currentStatus;
    }


    public static void main(String[] args) {
        CandyMachine candyMachine = new CandyMachine(1);
        candyMachine.pubInto();
        candyMachine.turnTheCrank();
        candyMachine.distributionOfCandy();
    }
}

interface SaleStatus {
    void pubInto();

    void sendBack();

    void turnTheCrank();

    void distributionOfCandy();
}

class HaveNo25 implements SaleStatus {

    private CandyMachine candyMachine;

    public HaveNo25(CandyMachine candyMachine) {
        this.candyMachine = candyMachine;
    }

    @Override
    public void pubInto() {
        System.out.println("turn into have25");
        candyMachine.setStatus(candyMachine.have25);
    }

    @Override
    public void sendBack() {
        if (candyMachine.getCandyNum() <= 0) {
            System.out.println("no candy");
            candyMachine.setStatus(candyMachine.noCandy);
            return;
        }
        if (candyMachine.getStatus() == candyMachine.haveNo25) {
            System.out.println("have no 25");
            return;
        }
        candyMachine.setStatus(candyMachine.haveNo25);
    }

    @Override
    public void turnTheCrank() {
        if (candyMachine.getCandyNum() <= 0) {
            System.out.println("no candy");
            candyMachine.setStatus(candyMachine.noCandy);
            return;
        }
        if (candyMachine.getStatus() == candyMachine.haveNo25) {
            System.out.println("have no 25");
            return;
        }

        System.out.println("turn into sale candy status");
        candyMachine.setStatus(candyMachine.saleCandy);
    }

    @Override
    public void distributionOfCandy() {
        if (candyMachine.getCandyNum() <= 0) {
            System.out.println("no candy");
            candyMachine.setStatus(candyMachine.noCandy);
            return;
        }
        if (candyMachine.getStatus() == candyMachine.haveNo25) {
            System.out.println("have no 25");
            return;
        }
        if (candyMachine.getCandyNum() == 0) {
            candyMachine.setStatus(candyMachine.noCandy);
            return;
        }
        System.out.println("distribut candy");
        candyMachine.setCandyNum();

        candyMachine.setStatus(candyMachine.haveNo25);
    }
}


class Have25 implements SaleStatus {

    private CandyMachine candyMachine;

    public Have25(CandyMachine candyMachine) {
        this.candyMachine = candyMachine;
    }

    @Override
    public void pubInto() {
        System.out.println("have 25 already!");
    }

    @Override
    public void sendBack() {

    }

    @Override
    public void turnTheCrank() {
        System.out.println("trun into Sale Candy status");
        candyMachine.setStatus(candyMachine.saleCandy);
    }

    @Override
    public void distributionOfCandy() {

    }
}

class NoCandy implements SaleStatus {

    private CandyMachine candyMachine;

    public NoCandy(CandyMachine candyMachine) {
        this.candyMachine = candyMachine;
    }

    @Override
    public void pubInto() {
        if (candyMachine.getCandyNum() <= 0) {
        }
    }

    @Override
    public void sendBack() {

    }

    @Override
    public void turnTheCrank() {

    }

    @Override
    public void distributionOfCandy() {
        System.out.println("sale candy");
        if (candyMachine.getCandyNum() >= 1) {
            candyMachine.setCandyNum();
        } else {
            candyMachine.setStatus(candyMachine.noCandy);
        }
    }
}

class SaleCandy implements SaleStatus {

    private CandyMachine candyMachine;

    public SaleCandy(CandyMachine candyMachine) {
        this.candyMachine = candyMachine;
    }

    @Override
    public void pubInto() {
        if (candyMachine.getCandyNum() <= 0) {
        }
    }

    @Override
    public void sendBack() {

    }

    @Override
    public void turnTheCrank() {

    }

    @Override
    public void distributionOfCandy() {
        System.out.println("sale candy");
        if (candyMachine.getCandyNum() >= 1) {
            candyMachine.setCandyNum();
            if (candyMachine.getCandyNum() > 0) {
                System.out.println("turn into have no 25");
                candyMachine.setStatus(candyMachine.haveNo25);
            } else {
                System.out.println("turn into no candy");
                candyMachine.setStatus(candyMachine.noCandy);
            }
        } else {
            System.out.println("turn into no candy");
            candyMachine.setStatus(candyMachine.noCandy);
        }
    }
}

