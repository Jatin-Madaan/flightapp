package com.flightapp.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.flightapp.dao.IUserDAO;
import com.flightapp.entities.User;
import com.flightapp.exception.UserException;

@Service
public class UserService implements IUserService {
	
	@Autowired
	IUserDAO userDAO;

	public UserService() {
		// TODO Auto-generated constructor stub
	}

	@Override
	public User getUserById(int id) throws UserException {
		
		User user =  userDAO.getOne(id);
		if(user == null) {
			throw new UserException("No User Exist By This Id");
		}
		
		return user;
	}

	@Override
	public User getUserByUsername(String username) throws UserException {
		// TODO Auto-generated method stub
		User user =  userDAO.getUserByUsername(username);
		if(user == null) {
			throw new UserException("No user exists by this username");
		}
		return user;
	}

	@Override
	public User addUser(User user) throws UserException {
		// TODO Auto-generated method stub
		User temp = userDAO.getUserByUsername(user.getUsername());
		if(temp == null) {
			return userDAO.save(user);
		}
		else {
			throw new UserException("User Already Exists By this username");
		}
	}

	@Override
	public List<User> getAllUsers() throws UserException {
		// TODO Auto-generated method stub
		List<User> users = userDAO.findAll();
		if(users.isEmpty()) {
			throw new UserException("No users Exists");
		}
		else {
			return users;
		}
	}

}
