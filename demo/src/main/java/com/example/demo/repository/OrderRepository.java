package com.example.demo.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import com.example.demo.domain.Order;

import java.util.List;
import java.util.Optional;

@Repository
public interface OrderRepository extends JpaRepository<Order, Integer> {

    // 可額外自訂查詢方法
    List<Order> findByUserId(Integer userId);

    List<Order> findByOrderStatus(String orderStatus);

    Optional<Order> findTopByOrderByIdDesc();
}