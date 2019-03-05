package multithread;

public class Test {

    public static void main(String[] args) {
        Basket basket = new Basket();
        Consumer consumer = new Consumer();
        consumer.setBasket(basket);
        Provider provider = new Provider();
        provider.setBasket(basket);
        new Thread(consumer).start();
        new Thread(provider).start();
    }
}
