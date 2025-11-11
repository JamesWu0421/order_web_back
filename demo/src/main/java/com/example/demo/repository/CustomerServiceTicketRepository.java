package com.example.demo.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import com.example.demo.domain.CustomerServiceTicket;

import java.util.List;

@Repository
public interface CustomerServiceTicketRepository extends JpaRepository<CustomerServiceTicket, Integer> {
    List<CustomerServiceTicket> findByOrderId(Integer orderId);

    List<CustomerServiceTicket> findByStatus(String status);
}