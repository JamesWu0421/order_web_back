package com.example.demo.service;

import com.example.demo.domain.Order;
import com.example.demo.domain.OrderDetail;
import com.example.demo.repository.OrderDetailRepository;
import com.example.demo.repository.OrderRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class OrderDetailService {

    @Autowired
    private OrderDetailRepository orderDetailRepository;

    @Autowired
    private OrderRepository orderRepository;

    // 新增訂單明細
    public OrderDetail createOrderDetail(Integer orderId, OrderDetail detail) {
        Optional<Order> orderOpt = orderRepository.findById(orderId);
        if (orderOpt.isPresent()) {
            detail.setOrder(orderOpt.get());
            return orderDetailRepository.save(detail);
        }
        return null;
    }

    // 查全部明細
    public List<OrderDetail> getAllOrderDetails() {
        return orderDetailRepository.findAll();
    }

    // 查訂單的明細
    public List<OrderDetail> getDetailsByOrderId(Integer orderId) {
        return orderDetailRepository.findByOrderId(orderId);
    }

    // 修改明細
    public OrderDetail updateOrderDetail(Integer id, OrderDetail updated) {
        Optional<OrderDetail> opt = orderDetailRepository.findById(id);
        if (opt.isPresent()) {
            OrderDetail detail = opt.get();
            detail.setSeatId(updated.getSeatId());
            detail.setTicketPrice(updated.getTicketPrice());
            detail.setTicketType(updated.getTicketType());
            detail.setStatus(updated.getStatus());
            return orderDetailRepository.save(detail);
        }
        return null;
    }

    // 刪除明細
    public void deleteOrderDetail(Integer id) {
        orderDetailRepository.deleteById(id);
    }
}
