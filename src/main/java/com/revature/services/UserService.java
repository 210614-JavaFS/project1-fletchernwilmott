package com.revature.services;

import com.revature.models.User;
import com.revature.repos.UserDAO;
import com.revature.repos.UserDAOImpl;

public class UserService {

	private static UserDAO userDAO = new UserDAOImpl();
	
	public User findByUsername(String ersUsername) {
		return userDAO.findUsername(ersUsername);
	}

	public int login(String username, String password) {
		return userDAO.login(username, password);
	}
	
	public boolean addUser(User user) {
		return userDAO.addUser(user);
	}
	

}
