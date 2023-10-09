package com.javastudy.webservicejpa.config;

import java.util.Arrays;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Profile;

import com.javastudy.webservicejpa.entities.User;
import com.javastudy.webservicejpa.repositories.UserRepository;

@Configuration
//same name as spring.profiles.active=test from application.properties
@Profile("test")
public class TesteConfig implements CommandLineRunner {

	@Autowired
	private UserRepository userRepository;

	@Override
	public void run(String... args) throws Exception {
		User u1 = new User(null, "Maria Brown", "maria@gmail.com", "999999999", "123456");
		User u2 = new User(null, "Alex Green", "alexG@gmail.com", "888888888", "passw0rd");
		
		userRepository.saveAll(Arrays.asList(u1, u2));
	}
	
	
}
