package com.revature.repos;

import com.revature.models.User;

public interface UserDAO {

	User findUsername(String ersUsername);
	int login(String username, String password);
	boolean addUser(User user);

}
