package com.example.demo.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.demo.domain.Order;
import com.example.demo.repository.OrderRepository;

@Service
public class OrderService {

    @Autowired
    public OrderRepository orderRepository;

    // 新增訂單
    public Order createOrder(Order order) {
        order.setOrderStatus("PENDING");
        return orderRepository.save(order);
    }

    // 查看全部訂單
    public List<Order> getAllOrders() {
        return orderRepository.findAll();
    }

    // 依Id查
    public Optional<Order> getOrderById(Integer id) {
        return orderRepository.findById(id);
    }

    // 修改訂單狀態
    public Order updateOrderStatus(Integer id, String newStatus) {
        Optional<Order> orderOpt = orderRepository.findById(id);
        if (orderOpt.isPresent()) {
            Order order = orderOpt.get();
            order.setOrderStatus(newStatus);
            return orderRepository.save(order);
        }
        return null;
    }

    public void deleteOrder(Integer id) {
        orderRepository.deleteById(id);
    }

    public Order getLatestOrder() {
        // findTopByOrderByIdDesc() 回傳 Optional<Order>
        return orderRepository.findTopByOrderByIdDesc().orElse(null);
    }

    public List<Order> getOrdersByUserId(Integer userId) {
        return orderRepository.findByUserId(userId);
    }
}
