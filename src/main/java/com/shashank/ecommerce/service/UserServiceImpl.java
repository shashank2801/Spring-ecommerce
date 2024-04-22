package com.shashank.ecommerce.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.shashank.ecommerce.model.User;
import com.shashank.ecommerce.repository.UserRepository;

@Service
public class UserServiceImpl implements UserService {
	
	@Autowired
	private UserRepository userRepository;

	@Override
	public User saveUser(User user) {
		// TODO Auto-generated method stub
		return userRepository.save(user);
	}

	@Override
	public List<User> getAllUsers() {
		// TODO Auto-generated method stub
		return userRepository.findAll();
	}
	
	@Override
	public User getUserById(int id) {
		// TODO Auto-generated method stub
		User user = userRepository.findById(id).get();
		if(user == null)
			throw new UserNotFoundException("id:"+id);
		return user;
	}

	@Override
	public User updateUser(User user, Integer id) {
		// TODO Auto-generated method stub
		User userDb = userRepository.findById(id).get();
		if(user == null)
			throw new UserNotFoundException("id:"+id);
		userDb.setName(user.getName());
		userDb.setBirthDate(user.getBirthDate());
		return userRepository.save(userDb);
	}

	@Override
	public void deleteUser(Integer id) {
		// TODO Auto-generated method stub
		userRepository.deleteById(id);
	}

	

}
