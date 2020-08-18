package com.flightapp.service;

import java.io.Serializable;
import java.util.List;

import com.flightapp.entities.User;

public interface IUserService{
	User getUserById(int id);
	User getUserByUsername(String username);
	User addUser(User user);
	List<User> getAllUsers();
}
