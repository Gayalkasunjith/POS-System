package com.spring.pos.domain;

import javax.persistence.Embeddable;
import javax.persistence.FetchType;
import javax.persistence.ManyToOne;
import java.io.Serializable;
import java.util.Objects;

@Embeddable
public class OrderDetailId implements Serializable {

    private Order order;
    private Item item;

    public OrderDetailId() {
    }

    public OrderDetailId(Order order, Item item) {
        this.order = order;
        this.item = item;
    }

    @ManyToOne(fetch = FetchType.EAGER)
    public Order getOrder() {
        return order;
    }

    public void setOrder(Order order) {
        this.order = order;
    }

    @ManyToOne(fetch = FetchType.EAGER)
    public Item getItem() {
        return item;
    }

    public void setItem(Item item) {
        this.item = item;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        OrderDetailId that = (OrderDetailId) o;
        return Objects.equals(order, that.order) &&
                Objects.equals(item, that.item);
    }

    @Override
    public int hashCode() {

        return Objects.hash(order, item);
    }
}
