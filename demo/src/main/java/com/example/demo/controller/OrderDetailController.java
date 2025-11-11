package com.example.demo.controller;

import com.example.demo.domain.OrderDetail;
import com.example.demo.service.OrderDetailService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/order-details")
@CrossOrigin(origins = "*")
public class OrderDetailController {

    @Autowired
    private OrderDetailService orderDetailService;

    @GetMapping
    public List<OrderDetail> getAllOrderDetails() {
        return orderDetailService.getAllOrderDetails();
    }

    @GetMapping("/order/{orderId}")
    public List<OrderDetail> getDetailsByOrder(@PathVariable Integer orderId) {
        return orderDetailService.getDetailsByOrderId(orderId);
    }

    @PostMapping("/order/{orderId}")
    public OrderDetail createDetail(@PathVariable Integer orderId, @RequestBody OrderDetail detail) {
        return orderDetailService.createOrderDetail(orderId, detail);
    }

    @PutMapping("/{id}")
    public OrderDetail updateDetail(@PathVariable Integer id, @RequestBody OrderDetail detail) {
        return orderDetailService.updateOrderDetail(id, detail);
    }

    @DeleteMapping("/{id}")
    public void deleteDetail(@PathVariable Integer id) {
        orderDetailService.deleteOrderDetail(id);
    }
}
