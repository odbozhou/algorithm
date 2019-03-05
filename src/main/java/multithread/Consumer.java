package multithread;

public class Consumer implements Runnable {

    private Basket basket;

    public void setBasket(Basket basket) {
        this.basket = basket;
    }

    public void run() {
        while (true) {
            basket.get();
        }
    }
}
