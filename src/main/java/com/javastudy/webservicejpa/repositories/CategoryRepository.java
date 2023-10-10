package com.javastudy.webservicejpa.repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import com.javastudy.webservicejpa.entities.Category;

public interface CategoryRepository extends JpaRepository<Category, Long> {

}
