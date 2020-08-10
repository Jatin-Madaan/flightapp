package com.flightapp.entities;

import java.io.Serializable;
import java.util.HashSet;
import java.util.Set;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;

//import org.junit.Ignore;

import com.fasterxml.jackson.annotation.JsonIgnore;

@Entity
@Table(name="USER_MASTER")
public class User implements Serializable {
	private static final long serialVersionUID = 1L;

	public User() {
		// TODO Auto-generated constructor stub
	}
	
	@Id
	@Column(name="USER_ID")
	private int userId;
	
	private String username;
	
	private String email;
	
	private String password;
	
	private String phone;
	
	private String gender;
	
	private String userRole;
	
	private String userState;
	
	private Long balance = 10000L; 
	
	@OneToMany(mappedBy="user",cascade=CascadeType.ALL)
	@JsonIgnore
	private Set<Booking> bookings = new HashSet<Booking>();

	public int getUserId() {
		return userId;
	}

	public void setUserId(int userId) {
		this.userId = userId;
	}

	public String getUserName() {
		return username;
	}

	public void setUserName(String userName) {
		this.username = userName;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public String getPhone() {
		return phone;
	}

	public void setPhone(String phone) {
		this.phone = phone;
	}

	public String getGender() {
		return gender;
	}

	public void setGender(String gender) {
		this.gender = gender;
	}

	public String getUserRole() {
		return userRole;
	}

	public void setUserRole(String userRole) {
		this.userRole = userRole;
	}

	public String getUserState() {
		return userState;
	}

	public void setUserState(String userState) {
		this.userState = userState;
	}

	public String getUsername() {
		return username;
	}

	public void setUsername(String username) {
		this.username = username;
	}

	public Long getBalance() {
		return balance;
	}

	public void setBalance(Long balance) {
		this.balance = balance;
	}

	@JsonIgnore
	public Set<Booking> getBookings() {
		return bookings;
	}

	public void setBookings(Set<Booking> bookings) {
		this.bookings = bookings;
	}
	
	
}
