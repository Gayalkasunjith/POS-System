package com.spring.pos.dto;

import java.io.Serializable;
import java.util.List;

public class OrderDTO implements Serializable {

    private int id;
    private String date;
    private CustomerDTO customerDTO;
    private List<OrderDetailDTO> orderDetailDTOList;

    public OrderDTO() {
    }

    public OrderDTO(int id, String date, CustomerDTO customerDTO) {
        this.id = id;
        this.date = date;
        this.customerDTO = customerDTO;
    }

    public OrderDTO(int id, String date, CustomerDTO customerDTO, List<OrderDetailDTO> orderDetailDTOList) {
        this.id = id;
        this.date = date;
        this.customerDTO = customerDTO;
        this.orderDetailDTOList = orderDetailDTOList;
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

    public List<OrderDetailDTO> getOrderDetailDTOList() {
        return orderDetailDTOList;
    }

    public void setOrderDetailDTOList(List<OrderDetailDTO> orderDetailDTOList) {
        this.orderDetailDTOList = orderDetailDTOList;
    }

    @Override
    public String toString() {
        return "OrderDTO{" +
                "id=" + id +
                ", date='" + date + '\'' +
                ", customerDTO=" + customerDTO +
                ", orderDetailDTOList=" + orderDetailDTOList +
                '}';
    }
}
