package com.flightapp.dao;

import org.springframework.data.jpa.repository.JpaRepository;

import com.flightapp.entities.User;

public interface IUserDAO extends JpaRepository<User, Integer>{

}
