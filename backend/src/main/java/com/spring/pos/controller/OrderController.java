package com.spring.pos.controller;

import com.spring.pos.dto.OrderDTO;
import com.spring.pos.service.OrderService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping(value = "order")
public class OrderController {

    @Autowired
    private OrderService orderService;

    @PostMapping(value = "place")
    public boolean placeOrder(@RequestBody OrderDTO orderDTO) {
        boolean save = orderService.save(orderDTO);
        return save;
    }
}
