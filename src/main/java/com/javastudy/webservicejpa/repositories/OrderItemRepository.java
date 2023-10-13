package com.javastudy.webservicejpa.repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import com.javastudy.webservicejpa.entities.OrderItem;

public interface OrderItemRepository extends JpaRepository<OrderItem, Long> {

}
