package com.ming.s2sh.registration.action;

import java.util.List;

import javax.annotation.Resource;

import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Component;

import com.ming.s2sh.registration.model.User;
import com.ming.s2sh.registration.service.UserManager;
import com.ming.s2sh.registration.vo.UserRegisterInfo;
import com.opensymphony.xwork2.ActionSupport;
import com.opensymphony.xwork2.ModelDriven;

@Component("user")
@Scope("prototype")
public class UserAction extends ActionSupport implements ModelDriven {

	private UserRegisterInfo info = new UserRegisterInfo();
	private UserManager userManager;
	private List<User> users;
	private User user;

	public UserAction() {
		System.out.println("UserAction created successfully!");
	}
	
	public UserRegisterInfo getInfo() {
		return info;
	}

	public void setInfo(UserRegisterInfo info) {
		this.info = info;
	}

	public UserManager getUserManager() {
		return userManager;
	}

	@Resource
	public void setUserManager(UserManager userManager) {
		this.userManager = userManager;
	}
	
	public List<User> getUsers() {
		return users;
	}

	public void setUsers(List<User> users) {
		this.users = users;
	}
	
	public User getUser() {
		return user;
	}

	public void setUser(User user) {
		this.user = user;
	}
	
	@Override
	public String execute() throws Exception {
		System.out.println("Username = :: " + info.getUsername());
		User user = new User();
		user.setUsername(info.getUsername());
		user.setPassword(info.getPassword());
		if (userManager.exists(user)) {
			return "fail";
		}
		userManager.add(user);
		return "success";
	}

	@Override
	public Object getModel() {
		return info;
	}

	public String list() {
		this.users = this.userManager.getUsers();
		return "list";
	}

	public String load() {
		this.user = this.userManager.loadById(info.getId());
		return "load";
	}

}
