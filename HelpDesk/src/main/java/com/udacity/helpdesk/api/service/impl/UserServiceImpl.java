package com.udacity.helpdesk.api.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.stereotype.Component;

import com.udacity.helpdesk.api.entity.User;
import com.udacity.helpdesk.api.repository.UserRepository;
import com.udacity.helpdesk.api.service.UserService;

@Component
public class UserServiceImpl implements UserService {
	
	@Autowired
	private UserRepository userRepository;

	@Override
	public User findByEmail(String email) {
		return this.userRepository.findByEmail(email);
	}

	@Override
	public User createOrUpdate(User user) {
		return this.userRepository.save(user);
	}

	@Override
	public User findById(String id) {
		return this.userRepository.findById(id).get();
	}

	@Override
	public void delete(String id) {
		this.userRepository.deleteById(id);		
	}

	@Override
	public Page<User> findAll(int page, int count) {
		PageRequest pageRequest =  PageRequest.of(page,count);
		return userRepository.findAll(pageRequest);
	}

}
