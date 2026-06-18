package fr.torisutan.dearborn;

public class Main {

    static void main() {
        PriceObserver priceObserver = new PriceObserver();
        QuantityObserver quantityObserver = new QuantityObserver();

        Order order = new Order(1);
        order.attach(priceObserver);
        order.attach(quantityObserver);
        order.addItem(20.f);
        order.addItem(50.f);
        order.addItem(150.f);
        order.addItem(5.f);
        order.addItem(10.f);

        System.out.println(order);
    }

}
