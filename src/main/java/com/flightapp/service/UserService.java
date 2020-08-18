package com.flightapp.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.flightapp.dao.IUserDAO;
import com.flightapp.entities.User;

@Service
public class UserService implements IUserService {
	
	@Autowired
	IUserDAO userDAO;

	public UserService() {
		// TODO Auto-generated constructor stub
	}

	@Override
	public User getUserById(int id) {
		// TODO Auto-generated method stub
		return userDAO.getOne(id);
	}

	@Override
	public User getUserByUsername(String username) {
		// TODO Auto-generated method stub
		return userDAO.getUserByUsername(username);
	}

	@Override
	public User addUser(User user) {
		// TODO Auto-generated method stub
		return userDAO.save(user);
	}

	@Override
	public List<User> getAllUsers() {
		// TODO Auto-generated method stub
		return userDAO.findAll();
	}

}
