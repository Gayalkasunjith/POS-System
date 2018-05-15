package com.spring.pos.domain;

import javax.persistence.*;
import java.io.Serializable;
import java.util.Objects;

@Entity
@Table(name = "order_details")
@AssociationOverrides({@AssociationOverride(name = "oDI.item", joinColumns = @JoinColumn(name = "item_id"))
        , @AssociationOverride(name = "oDI.order", joinColumns = @JoinColumn(name = "order_id"))})
public class OrderDetail implements Serializable {

    private OrderDetailId oDI = new OrderDetailId();
    private int soldQty;

    public OrderDetail() {
    }

    public OrderDetail(OrderDetailId oDI) {
        this.oDI = oDI;
    }

    public OrderDetail(OrderDetailId oDI, int soldQty) {
        this.oDI = oDI;
        this.soldQty = soldQty;
    }

    @Transient
    public OrderDetailId getoDI() {
        return oDI;
    }

    public void setoDI(OrderDetailId oDI) {
        this.oDI = oDI;
    }

    @Transient
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
                Objects.equals(oDI, that.oDI);
    }

    @Override
    public int hashCode() {

        return Objects.hash(oDI, soldQty);
    }
}
