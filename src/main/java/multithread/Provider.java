package multithread;

public class Provider implements Runnable {

    private Basket basket;

    public void setBasket(Basket basket) {
        this.basket = basket;
    }

    public void run() {
        int i = 1;
        while (true) {
            basket.put(i++);
        }
    }
}
