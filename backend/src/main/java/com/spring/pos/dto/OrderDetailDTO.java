package com.spring.pos.dto;

import java.io.Serializable;

public class OrderDetailDTO implements Serializable {

    private int itemId;
    private int orderId;
    private int soldQty;

    public OrderDetailDTO() {
    }

    public OrderDetailDTO(int itemId, int orderId, int soldQty) {
        this.itemId = itemId;
        this.orderId = orderId;
        this.soldQty = soldQty;
    }

    public int getItemId() {
        return itemId;
    }

    public void setItemId(int itemId) {
        this.itemId = itemId;
    }

    public int getOrderId() {
        return orderId;
    }

    public void setOrderId(int orderId) {
        this.orderId = orderId;
    }

    public int getSoldQty() {
        return soldQty;
    }

    public void setSoldQty(int soldQty) {
        this.soldQty = soldQty;
    }

    @Override
    public String toString() {
        return "OrderDetailDTO{" +
                "itemId=" + itemId +
                ", orderId=" + orderId +
                ", soldQty=" + soldQty +
                '}';
    }
}
