package com.javastudy.webservicejpa.services;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.javastudy.webservicejpa.entities.User;
import com.javastudy.webservicejpa.entities.vos.UserDTO;
import com.javastudy.webservicejpa.repositories.UserRepository;

@Service
public class UserService {

	@Autowired
	private UserRepository userRepository;
	
	public List<User> findAll() {
		return userRepository.findAll();
	}
	
	public User findById(Long id) {
		Optional<User> obj = userRepository.findById(id);
		return obj.get();
	}
	
	public User save(UserDTO userDTO) {
		User user = userDTO.convertToUser();
		
		return userRepository.save(user);
	}
}
