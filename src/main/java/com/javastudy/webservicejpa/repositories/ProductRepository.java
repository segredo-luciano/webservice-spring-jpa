package com.javastudy.webservicejpa.repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import com.javastudy.webservicejpa.entities.Product;

public interface ProductRepository extends JpaRepository<Product, Long> {

}
