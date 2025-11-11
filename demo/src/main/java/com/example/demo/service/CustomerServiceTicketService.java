package com.example.demo.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.demo.domain.CustomerServiceTicket;
import com.example.demo.domain.Order;
import com.example.demo.repository.CustomerServiceTicketRepository;
import com.example.demo.repository.OrderRepository;

@Service
public class CustomerServiceTicketService {

    @Autowired
    private CustomerServiceTicketRepository ticketRepository;

    @Autowired
    private OrderRepository orderRepository;

    public CustomerServiceTicket createTicket(Integer orderId, String issueType, String description,
            Integer handledBy) {
        Optional<Order> orderOpt = orderRepository.findById(orderId);
        if (orderOpt.isPresent()) {
            CustomerServiceTicket ticket = new CustomerServiceTicket();
            ticket.setOrder(orderOpt.get());
            ticket.setIssueType(issueType);
            ticket.setDescription(description);
            ticket.setStatus("OPEN");
            ticket.setHandledBy(handledBy);
            return ticketRepository.save(ticket);
        }
        return null;
    }

    // 查全部客服單
    public List<CustomerServiceTicket> getAllTickets() {
        return ticketRepository.findAll();
    }

    // 查訂單客服單
    public List<CustomerServiceTicket> getTicketsByOrderId(Integer orderId) {
        return ticketRepository.findByOrderId(orderId);
    }

    // 更新狀態
    public CustomerServiceTicket updateStatus(Integer id, String status) {
        Optional<CustomerServiceTicket> opt = ticketRepository.findById(id);
        if (opt.isPresent()) {
            CustomerServiceTicket ticket = opt.get();
            ticket.setStatus(status);
            return ticketRepository.save(ticket);
        }
        return null;
    }

}
