package com.javastudy.webservicejpa.services;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataIntegrityViolationException;
import org.springframework.dao.EmptyResultDataAccessException;
import org.springframework.stereotype.Service;

import com.javastudy.webservicejpa.entities.User;
import com.javastudy.webservicejpa.entities.vos.UserDTO;
import com.javastudy.webservicejpa.repositories.UserRepository;
import com.javastudy.webservicejpa.resources.exceptions.DatabaseException;
import com.javastudy.webservicejpa.services.exceptions.ResourceNotFoundException;

import jakarta.persistence.EntityNotFoundException;

@Service
public class UserService {

	@Autowired
	private UserRepository userRepository;
	
	public List<User> findAll() {
		return userRepository.findAll();
	}
	
	public User findById(Long id) {
		Optional<User> obj = userRepository.findById(id);
		return obj.orElseThrow(() -> new ResourceNotFoundException(id));
	}
	
	public User save(UserDTO userDTO) {
		User user = userDTO.convertToUser();
		
		return userRepository.save(user);
	}
	
	public void delete(Long id) {
		try {
			userRepository.deleteById(id);	
		} catch(EmptyResultDataAccessException e) {
			throw new ResourceNotFoundException(id);
		} catch(DataIntegrityViolationException de) {
			throw new DatabaseException(de.getMessage());
		}
		
	}
	
	public User update(Long id, String name, String email, String phone) {
		try {
			User existingUser = userRepository.getReferenceById(id);
			
			existingUser.setName(name);
			existingUser.setEmail(email);
			existingUser.setPhone(phone);
			
			return userRepository.save(existingUser);	
		} catch(EntityNotFoundException enfe) {
			throw new ResourceNotFoundException(id);
		}
		
	}
}
