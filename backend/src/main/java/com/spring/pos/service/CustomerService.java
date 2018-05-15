package com.spring.pos.service;

import com.spring.pos.dto.CustomerDTO;

import java.util.List;

public interface CustomerService {

    boolean save(CustomerDTO customerDTO);

    List<CustomerDTO> findAll();

    CustomerDTO findById(int id);

    boolean delete(int id);
}
