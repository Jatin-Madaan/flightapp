package com.flightapp.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.flightapp.entities.User;
import com.flightapp.service.IUserService;

@CrossOrigin("*")
@RestController
public class UserController {
	
	@Autowired IUserService userService;
	
	@RequestMapping(method = RequestMethod.GET, value = "/Users/id/{id}" )
	public User getUserById(@PathVariable int id) {
		return userService.getUserById(id);
	}
	
	@RequestMapping(method = RequestMethod.GET, value = "/Users/username/{username}" )
	public User getUserByUsername(@PathVariable String username) {
		return userService.getUserByUsername(username);
	}
	
	@RequestMapping(method = RequestMethod.POST, value = "/Users/add")
	public User addUser(@RequestBody User user) {
		return userService.addUser(user);
	}
	
	@RequestMapping(method = RequestMethod.GET, value = "/Users/all")
	public List<User> getAllUsers(){
		return userService.getAllUsers();
	}
	

}
