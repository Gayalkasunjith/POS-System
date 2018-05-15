package com.spring.pos.dto;

import java.io.Serializable;

public class OrderDTO implements Serializable {

    private int id;
    private String date;
    private CustomerDTO customerDTO;

    public OrderDTO() {
    }

    public OrderDTO(int id, String date, CustomerDTO customerDTO) {
        this.id = id;
        this.date = date;
        this.customerDTO = customerDTO;
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

    public CustomerDTO getCustomerDTO() {
        return customerDTO;
    }

    public void setCustomerDTO(CustomerDTO customerDTO) {
        this.customerDTO = customerDTO;
    }

    @Override
    public String toString() {
        return "OrderDTO{" +
                "id=" + id +
                ", date='" + date + '\'' +
                ", customerDTO=" + customerDTO +
                '}';
    }
}
