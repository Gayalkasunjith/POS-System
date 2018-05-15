package com.spring.pos.repository;

import com.spring.pos.domain.Order;
import org.springframework.data.jpa.repository.JpaRepository;

public interface OrderReporsitory extends JpaRepository<Order, Integer> {
}
