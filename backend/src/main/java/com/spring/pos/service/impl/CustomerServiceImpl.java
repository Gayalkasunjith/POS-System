package com.spring.pos.service.impl;

import com.spring.pos.domain.Customer;
import com.spring.pos.dto.CustomerDTO;
import com.spring.pos.repository.CustomerRepository;
import com.spring.pos.service.CustomerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.ExecutionException;


@Service
@Transactional
public class CustomerServiceImpl implements CustomerService {

    @Autowired
    private CustomerRepository customerRepository;

    @Override
    public boolean save(CustomerDTO customerDTO) {
        Customer customer = new Customer(customerDTO.getId(), customerDTO.getName(), customerDTO.getAddress(), customerDTO.getTel());
        Customer save = customerRepository.save(customer);
        try {
            if (customerDTO != null && save != null) {
                return save != null;
            } else {
                return save != null;
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return false;
    }

    @Override
    public List<CustomerDTO> findAll() {
        Iterable<Customer> allCustomers = customerRepository.findAll();
        List<CustomerDTO> customerDTOS = new ArrayList<>();
        try {
            if (allCustomers != null) {
                for (Customer customer :
                        allCustomers) {
                    CustomerDTO customerDTO = new CustomerDTO(customer.getId(), customer.getName(), customer.getAddress(), customer.getTel());
                    customerDTOS.add(customerDTO);
                }
                return customerDTOS;
            } else {
                return customerDTOS;
            }
        } catch (Exception e) {
            e.printStackTrace();
        }

        return customerDTOS;
    }

    @Override
    public CustomerDTO findById(int id) {
        Customer customer = customerRepository.findOne(id);
        CustomerDTO customerDTO = null;
        if (customer != null) {
            customerDTO = new CustomerDTO(customer.getId(), customer.getName(), customer.getAddress(), customer.getTel());
            return customerDTO;
        } else {
            return customerDTO;
        }
    }

    @Override
    public boolean delete(int id) {
        customerRepository.delete(id);
        CustomerDTO byId = findById(id);
        if (byId == null) {
            return true;
        } else {
            return false;
        }
    }
}
