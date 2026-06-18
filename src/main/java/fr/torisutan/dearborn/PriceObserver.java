package fr.torisutan.dearborn;

import java.util.ArrayList;
import java.util.List;

public class PriceObserver implements OrderObserver {

    private final List<Order> discountOrders = new ArrayList<>();

    @Override
    public void update(Order order) {
        if (order.getPrice() > 200.f) {
            if (discountOrders.contains(order)) {
                return;
            }
            order.setPrice(order.getPrice()-20.f);
            discountOrders.add(order);
            System.out.println("Add $20 discount to the order");
        }
    }
}
