package com.ming.s2sh.registration.dao;

import java.util.List;

import com.ming.s2sh.registration.model.User;

public interface UserDao {

	public void save(User u);

	public boolean checkUserExistsWithName(String username);

	public List<User> getUsers();

	public User loadById(int id);
}
