package com.ming.s2sh.registration.service;

import java.util.List;

import com.ming.s2sh.registration.model.User;

public interface UserManager {

	public abstract boolean exists(User u) throws Exception;

	public abstract void add(User u) throws Exception;
	
	public List<User> getUsers();
	
	public User loadById(int id);

}