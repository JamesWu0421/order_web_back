package com.example.demo.service;

import com.example.demo.domain.Order;
import com.example.demo.domain.Refund;
//import com.example.demo.domain.RefundDetail;
import com.example.demo.repository.OrderRepository;
import com.example.demo.repository.RefundRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class RefundService {

    @Autowired
    private RefundRepository refundRepository;

    @Autowired
    private OrderRepository orderRepository;

    // 建立退款單
    public Refund createRefund(Integer orderId, String reason) {
        Optional<Order> orderOpt = orderRepository.findById(orderId);
        if (orderOpt.isPresent()) {
            Refund refund = new Refund();
            refund.setOrder(orderOpt.get());
            refund.setRefundReason(reason);
            refund.setRefundStatus("REQUESTED");
            return refundRepository.save(refund);
        }
        return null;
    }

    // 查全部退款單
    public List<Refund> getAllRefunds() {
        return refundRepository.findAll();
    }

    // 查訂單的退款單
    public List<Refund> getRefundsByOrderId(Integer orderId) {
        return refundRepository.findByOrderId(orderId);
    }

    // 更新退款狀態
    public Refund updateRefundStatus(Integer id, String status) {
        Optional<Refund> opt = refundRepository.findById(id);
        if (opt.isPresent()) {
            Refund refund = opt.get();
            refund.setRefundStatus(status);
            return refundRepository.save(refund);
        }
        return null;
    }
}
