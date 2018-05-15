package com.spring.pos.dto;

import java.io.Serializable;

public class CustomerDTO implements Serializable {

    private int id;
    private String name;
    private String address;
    private String tel;

    public CustomerDTO() {
    }

    public CustomerDTO(int id, String name, String address, String tel) {
        this.id = id;
        this.name = name;
        this.address = address;
        this.tel = tel;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public String getTel() {
        return tel;
    }

    public void setTel(String tel) {
        this.tel = tel;
    }

    @Override
    public String toString() {
        return "CustomerDTO{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", address='" + address + '\'' +
                ", tel='" + tel + '\'' +
                '}';
    }
}
