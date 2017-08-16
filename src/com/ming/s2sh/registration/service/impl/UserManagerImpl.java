package com.ming.s2sh.registration.service.impl;

import java.util.List;

import javax.annotation.Resource;

import org.springframework.stereotype.Component;

import com.ming.s2sh.registration.dao.UserDao;
import com.ming.s2sh.registration.model.User;
import com.ming.s2sh.registration.service.UserManager;

@Component("userManager")
public class UserManagerImpl implements UserManager {

	private UserDao userDao;

	public UserDao getUserDao() {
		return userDao;
	}

	@Resource
	public void setUserDao(UserDao userDao) {
		this.userDao = userDao;
	}

	public boolean exists(User u) throws Exception {
		return userDao.checkUserExistsWithName(u.getUsername());

	}

	public void add(User u) throws Exception {
		userDao.save(u);
	}

	public List<User> getUsers() {
		return this.userDao.getUsers();
	}

	public User loadById(int id) {
		return this.userDao.loadById(id);
	}
}
