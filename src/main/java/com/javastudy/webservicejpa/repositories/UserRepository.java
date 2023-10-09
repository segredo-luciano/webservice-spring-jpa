package com.javastudy.webservicejpa.repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import com.javastudy.webservicejpa.entities.User;

public interface UserRepository extends JpaRepository<User, Long> {

}
