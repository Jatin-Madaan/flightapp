package com.flightapp.dao;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.flightapp.entities.User;

@Repository
public interface IUserDAO extends JpaRepository<User, Integer>{
	User getUserByUsername(String username);
}
