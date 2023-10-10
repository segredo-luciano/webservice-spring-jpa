package com.javastudy.webservicejpa.config;

import java.time.Instant;
import java.util.Arrays;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Profile;

import com.javastudy.webservicejpa.entities.Order;
import com.javastudy.webservicejpa.entities.User;
import com.javastudy.webservicejpa.entities.enums.OrderStatus;
import com.javastudy.webservicejpa.repositories.OrderRepository;
import com.javastudy.webservicejpa.repositories.UserRepository;

@Configuration
//same name as spring.profiles.active=test from application.properties
@Profile("test")
public class TesteConfig implements CommandLineRunner {

	@Autowired
	private UserRepository userRepository;	
	@Autowired
	private OrderRepository orderRepository;

	@Override
	public void run(String... args) throws Exception {
		User u1 = new User(null, "Maria Brown", "maria@gmail.com", "999999999", "123456");
		User u2 = new User(null, "Alex Green", "alexG@gmail.com", "888888888", "passw0rd");
		
		Order o1 = new Order(null, Instant.parse("2019-06-20T19:53:07Z"), OrderStatus.PAID, u1);
		Order o2 = new Order(null, Instant.parse("2019-07-21T03:42:10Z"), OrderStatus.WAITING_PAYMENT, u2);
		Order o3 = new Order(null, Instant.parse("2019-07-22T15:21:22Z"), OrderStatus.WAITING_PAYMENT, u1); 
		
		userRepository.saveAll(Arrays.asList(u1	, u2));
		orderRepository.saveAll(Arrays.asList(o1, o2, o3));
	}
	
	
}
