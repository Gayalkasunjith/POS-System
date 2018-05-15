package com.spring.pos.controller;

import com.spring.pos.dto.CustomerDTO;
import com.spring.pos.service.CustomerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping(value = "customer")
public class CustomerController {

    @Autowired
    private CustomerService customerService;

    @PostMapping(value = "save")
    public boolean save(@RequestBody CustomerDTO customerDTO) {
        boolean save = customerService.save(customerDTO);
        return save;
    }

    @GetMapping(value = "find-all")
    public List<CustomerDTO> findAll() {
        List<CustomerDTO> allCustomers = customerService.findAll();
        return allCustomers;
    }

    @GetMapping(value = "find-by-id")
    public CustomerDTO findById(int id) {
        CustomerDTO customerDTO = customerService.findById(id);
        return customerDTO;
    }

    @DeleteMapping(value = "delete")
    public boolean delete(int id) {
        boolean delete = customerService.delete(id);
        return delete;
    }

    @PutMapping(value = "update")
    public boolean update(@RequestBody CustomerDTO customerDTO) {
        boolean update = customerService.update(customerDTO);
        return update;
    }
}