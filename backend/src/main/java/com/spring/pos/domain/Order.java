package com.spring.pos.domain;

import javax.persistence.*;
import java.io.Serializable;
import java.util.List;
import java.util.Objects;

@Entity
@Table(name = "orders")
public class Order implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "id")
    private int id;
    @Column(name = "date")
    private String date;
    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "cust_id")
    private Customer customer;
    /**
     * for bidirectional mapping
     */
    @OneToMany(fetch = FetchType.LAZY, mappedBy = "oDI.order", cascade = CascadeType.ALL)
    private List<OrderDetail> orderDetails;

    public Order() {
    }

    public Order(String date, Customer customer) {
        this.date = date;
        this.customer = customer;
    }

    public Order(String date, Customer customer, List<OrderDetail> orderDetails) {
        this.date = date;
        this.customer = customer;
        this.orderDetails = orderDetails;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getDate() {
        return date;
    }

    public void setDate(String date) {
        this.date = date;
    }

    public Customer getCustomer() {
        return customer;
    }

    public void setCustomer(Customer customer) {
        this.customer = customer;
    }

    public List<OrderDetail> getOrderDetails() {
        return orderDetails;
    }

    public void setOrderDetails(List<OrderDetail> orderDetails) {
        this.orderDetails = orderDetails;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Order order = (Order) o;
        return id == order.id &&
                Objects.equals(date, order.date) &&
                Objects.equals(customer, order.customer) &&
                Objects.equals(orderDetails, order.orderDetails);
    }

    @Override
    public int hashCode() {

        return Objects.hash(id, date, customer, orderDetails);
    }
}
