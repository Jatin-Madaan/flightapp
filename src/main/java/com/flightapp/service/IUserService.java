package com.flightapp.service;

import java.io.Serializable;
import java.util.List;

import com.flightapp.entities.User;
import com.flightapp.exception.UserException;

public interface IUserService{
	User getUserById(int id) throws UserException;
	User getUserByUsername(String username) throws UserException;
	User addUser(User user) throws UserException;
	List<User> getAllUsers() throws UserException;
}
