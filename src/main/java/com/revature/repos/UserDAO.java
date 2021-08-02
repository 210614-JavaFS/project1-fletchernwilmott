package com.revature.repos;

import com.revature.models.User;

public interface UserDAO {

	User findUsername(String ersUsername);
	int login(User user);
	boolean addUser(User user);

}
