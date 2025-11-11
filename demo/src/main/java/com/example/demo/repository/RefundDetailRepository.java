package com.example.demo.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import com.example.demo.domain.RefundDetail;

import java.util.List;

@Repository
public interface RefundDetailRepository extends JpaRepository<RefundDetail, Integer> {
    List<RefundDetail> findByRefundId(Integer refundId);
}