package com.spring.pos.service.impl;

import com.spring.pos.domain.Customer;
import com.spring.pos.domain.Item;
import com.spring.pos.domain.Order;
import com.spring.pos.domain.OrderDetail;
import com.spring.pos.dto.CustomerDTO;
import com.spring.pos.dto.ItemDTO;
import com.spring.pos.dto.OrderDTO;
import com.spring.pos.dto.OrderDetailDTO;
import com.spring.pos.repository.CustomerRepository;
import com.spring.pos.repository.ItemRepository;
import com.spring.pos.repository.OrderReporsitory;
import com.spring.pos.service.CustomerService;
import com.spring.pos.service.ItemService;
import com.spring.pos.service.OrderDetailService;
import com.spring.pos.service.OrderService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.ArrayList;
import java.util.List;

@Service
public class OrderServiceImpl implements OrderService {

    @Autowired
    private CustomerRepository customerRepository;

    @Autowired
    private OrderReporsitory orderReporsitory;

    @Autowired
    private ItemService itemService;

    @Autowired
    private OrderDetailService orderDetailService;

    @Override
    @Transactional
    public boolean save(OrderDTO orderDTO) {

        boolean flag = false;

        CustomerDTO customerDTO = orderDTO.getCustomerDTO();
        List<OrderDetail> orderDetails = new ArrayList<>();
        Order order = new Order();
        order.setDate(orderDTO.getDate());
        order.setId(orderDTO.getId());

        Customer customer = new Customer(customerDTO.getId(), customerDTO.getName(), customerDTO.getAddress(), customerDTO.getTel());
        List<OrderDetailDTO> orderDetailDTOList = orderDTO.getOrderDetailDTOList();

        for (OrderDetailDTO orderDetailDTO : orderDetailDTOList) {
            OrderDetail orderDetail = new OrderDetail();
            orderDetail.setOrder(order);
            ItemDTO itemDTO = itemService.findById(orderDetailDTO.getItemId());
            Item item = new Item(itemDTO.getId(), itemDTO.getDescription(), itemDTO.getPrice(), itemDTO.getQty());
            orderDetail.setItem(item);
            orderDetails.add(orderDetail);
        }

        customer = customerRepository.save(customer);
        order.setCustomer(customer);

        flag = placeOrder(order);

        for (OrderDetail orderDetail :
                orderDetails) {
            flag = orderDetailService.save(orderDetail);
        }
        return flag;
    }

    private boolean placeOrder(Order order) {
        Order save = orderReporsitory.save(order);
        return save != null;
    }

}
