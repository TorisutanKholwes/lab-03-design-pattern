package fr.torisutan.dearborn;

import java.util.ArrayList;
import java.util.List;

public class Order {

    private final int id;

    private double price;
    private double shippingPrice = 10.f;
    private int count;

    private final List<OrderObserver> observers = new ArrayList<>();

    public Order(int id) {
        this.id = id;
    }

    public void attach(OrderObserver observer) {
        observers.add(observer);
    }

    public void detach(OrderObserver observer) {
        observers.remove(observer);
    }

    public double getPrice() {
        return price;
    }

    public void setPrice(double price) {
        this.price = price;
    }

    public double getShippingPrice() {
        return shippingPrice;
    }

    public void setShippingPrice(double shippingPrice) {
        this.shippingPrice = shippingPrice;
    }

    public double getTotalPrice() {
        return price + shippingPrice;
    }

    public int getCount() {
        return count;
    }

    public int getId() {
        return id;
    }

    public void addItem(double price) {
        this.price += price;
        this.count++;
        System.out.format("Add item with price $%.2f\n", price);
        for (OrderObserver observer : observers) {
            observer.update(this);
        }
    }

    @Override
    public String toString() {
        return String.format("Order %d has %d items and costs $%.2f. With shipping, it costs $%.2f.\n", id, count, price, getTotalPrice());
    }
}
