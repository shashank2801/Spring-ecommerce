package com.shashank.ecommerce.service;

import java.util.List;

import org.springframework.stereotype.Service;

import com.shashank.ecommerce.model.User;

public interface UserService {
	User saveUser(User user);
	
	List<User> getAllUsers();
	
	User getUserById(int id);
	
	User updateUser(User user, Integer id);
	
	void deleteUser(Integer id);
}
