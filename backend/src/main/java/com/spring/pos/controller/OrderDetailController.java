package com.spring.pos.controller;

import com.spring.pos.dto.OrderDTO;
import com.spring.pos.service.OrderDetailService;
import com.spring.pos.service.OrderService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping(value = "customer")
public class OrderDetailController {

    @Autowired
    private OrderService orderService;

    @PostMapping(value = "invoice")
    public boolean saveInvoice(@RequestBody OrderDTO orderDTO) {
        boolean save = orderService.save(orderDTO);
        return save;
    }
}
