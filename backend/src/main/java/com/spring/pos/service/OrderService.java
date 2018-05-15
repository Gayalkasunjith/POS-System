package com.spring.pos.service;

import com.spring.pos.domain.Order;
import com.spring.pos.dto.OrderDTO;

public interface OrderService {

    boolean save(OrderDTO orderDTO);
}
