package com.PractiseTillOf.Practise1.service;

import com.PractiseTillOf.Practise1.model.OrdersData;
import com.PractiseTillOf.Practise1.repository.OrderRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class OrderService {
    @Autowired
    private OrderRepository orderRepository;

    public List<OrdersData> getOrdersList() {
        return orderRepository.findAll();
    }

    public OrdersData postOrders(OrdersData ordersData) {
        return orderRepository.save(ordersData);
    }
}
