package com.ming.s2sh.registration.dao.impl;

import java.util.List;

import javax.annotation.Resource;

import org.springframework.orm.hibernate3.HibernateTemplate;
import org.springframework.stereotype.Component;

import com.ming.s2sh.registration.dao.UserDao;
import com.ming.s2sh.registration.model.User;

@Component("userDao")
public class UserDaoImpl implements UserDao {

	private HibernateTemplate hibernateTemplate;

	public void save(User user) {
		hibernateTemplate.save(user);

	}

	public boolean checkUserExistsWithName(String username) {
		List<User> users = hibernateTemplate.find("from User u where u.username = '" + username + "'");

		if (users != null && users.size() > 0) {
			return true;
		}
		return false;
		/*
		 * long count = (Long)hibernateTemplate.getSessionFactory()
		 * .getCurrentSession().createQuery(
		 * "select count(*) from User u where u.username = :username")
		 * .setString("username", username).uniqueResult(); if(count > 0) return
		 * true; return false;
		 */
	}

	public HibernateTemplate getHibernateTemplate() {
		return hibernateTemplate;
	}

	@Resource
	public void setHibernateTemplate(HibernateTemplate hibernateTemplate) {
		this.hibernateTemplate = hibernateTemplate;
	}

	public List<User> getUsers() {
		return (List<User>) this.hibernateTemplate.find("from User");
	}

	public User loadById(int id) {

		return (User) this.hibernateTemplate.load(User.class, id);
	}

}
