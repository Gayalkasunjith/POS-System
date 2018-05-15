package com.spring.pos.service.impl;

import com.spring.pos.domain.OrderDetail;
import com.spring.pos.repository.OrderDetailRepository;
import com.spring.pos.repository.OrderReporsitory;
import com.spring.pos.service.OrderDetailService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;

@Service
public class OrderDetailServiceImpl implements OrderDetailService {

    @Autowired
    private OrderDetailRepository orderDetailRepository;

    @Override
    @Transactional
    public boolean save(OrderDetail orderDetail) {
        OrderDetail save = orderDetailRepository.save(orderDetail);
        return save != null;
    }
}
