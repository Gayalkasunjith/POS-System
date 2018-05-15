package com.spring.pos.service.impl;

import com.spring.pos.domain.Customer;
import com.spring.pos.domain.Order;
import com.spring.pos.dto.CustomerDTO;
import com.spring.pos.dto.OrderDTO;
import com.spring.pos.repository.CustomerRepository;
import com.spring.pos.repository.OrderReporsitory;
import com.spring.pos.service.OrderService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
public class OrderServiceImpl implements OrderService {

    @Autowired
    private CustomerRepository customerRepository;

    @Autowired
    private OrderReporsitory orderReporsitory;

    @Override
    @Transactional
    public boolean save(OrderDTO orderDTO) {
        CustomerDTO customerDTO = orderDTO.getCustomerDTO();
        Customer customer = new Customer(customerDTO.getId(), customerDTO.getName(), customerDTO.getAddress(), customerDTO.getTel());
        Order order = new Order(orderDTO.getDate(), customer);
        Customer saveCustomer = customerRepository.save(customer);
        Order saveOrder = orderReporsitory.save(order);
        if (saveCustomer != null && saveOrder != null) {
            return true;
        } else {
            return false;
        }
    }
}
