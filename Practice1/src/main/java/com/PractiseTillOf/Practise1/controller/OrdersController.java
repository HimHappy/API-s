package com.PractiseTillOf.Practise1.controller;

import com.PractiseTillOf.Practise1.model.OrdersData;
import com.PractiseTillOf.Practise1.service.OrderService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/orders")
public class OrdersController {
    @Autowired
    private OrderService orderService;

    @GetMapping("")
    public List<OrdersData> getComplaints(){
        return orderService.getOrdersList();
    }
    @PostMapping("")
    public OrdersData postComplaints(@RequestBody OrdersData ordersDatal){
        return orderService.postOrders(ordersDatal);
    }
}
