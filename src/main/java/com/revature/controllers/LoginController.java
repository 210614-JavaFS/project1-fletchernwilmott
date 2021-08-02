package com.revature.controllers;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.revature.models.User;
import com.revature.services.UserService;

public class LoginController extends HttpServlet {

	private static UserService userService = new UserService();
	
	private ObjectMapper objectMapper = new ObjectMapper();
	
	@Override
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		User user = new User();
		
		String json = objectMapper.writeValueAsString(user);
		
		if(userService.login(user) == 1) {
			HttpSession session = request.getSession();
			session.setAttribute("username", user.getErsUsername());
			response.setStatus(201);
		}
		
		else {
			response.setStatus(406);
		}
		
	}
}