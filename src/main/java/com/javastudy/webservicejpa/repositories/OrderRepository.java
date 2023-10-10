package com.javastudy.webservicejpa.repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import com.javastudy.webservicejpa.entities.Order;

public interface OrderRepository extends JpaRepository<Order, Long> {

}
