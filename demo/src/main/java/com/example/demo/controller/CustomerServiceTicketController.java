package com.example.demo.controller;

import com.example.demo.domain.CustomerServiceTicket;
import com.example.demo.service.CustomerServiceTicketService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/tickets")
@CrossOrigin(origins = "*")
public class CustomerServiceTicketController {

    @Autowired
    private CustomerServiceTicketService ticketService;

    @GetMapping
    public List<CustomerServiceTicket> getAllTickets() {
        return ticketService.getAllTickets();
    }

    @GetMapping("/order/{orderId}")
    public List<CustomerServiceTicket> getTicketsByOrder(@PathVariable Integer orderId) {
        return ticketService.getTicketsByOrderId(orderId);
    }

    @PostMapping("/order/{orderId}")
    public CustomerServiceTicket createTicket(
            @PathVariable Integer orderId,
            @RequestParam String issueType,
            @RequestParam String description,
            @RequestParam Integer handledBy) {
        return ticketService.createTicket(orderId, issueType, description, handledBy);
    }

    @PutMapping("/{id}/status")
    public CustomerServiceTicket updateStatus(@PathVariable Integer id, @RequestParam String status) {
        return ticketService.updateStatus(id, status);
    }
}