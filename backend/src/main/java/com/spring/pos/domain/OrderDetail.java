package com.spring.pos.domain;

import java.io.Serializable;
import java.util.Objects;

public class OrderDetail implements Serializable {

    private Item item;
    private Order order;
    private int soldQty;

    public OrderDetail() {
    }

    public OrderDetail(Item item, Order order, int soldQty) {
        this.item = item;
        this.order = order;
        this.soldQty = soldQty;
    }

    public Item getItem() {
        return item;
    }

    public void setItem(Item item) {
        this.item = item;
    }

    public Order getOrder() {
        return order;
    }

    public void setOrder(Order order) {
        this.order = order;
    }

    public int getSoldQty() {
        return soldQty;
    }

    public void setSoldQty(int soldQty) {
        this.soldQty = soldQty;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        OrderDetail that = (OrderDetail) o;
        return soldQty == that.soldQty &&
                Objects.equals(item, that.item) &&
                Objects.equals(order, that.order);
    }

    @Override
    public int hashCode() {

        return Objects.hash(item, order, soldQty);
    }
}
