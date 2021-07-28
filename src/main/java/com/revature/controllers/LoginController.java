package com.revature.controllers;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.revature.services.UserService;

public class LoginController extends HttpServlet {

	private static UserService userService = new UserService();
	
	@Override
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String username = request.getParameter("userId");
		String password = request.getParameter("password");
		
		RequestDispatcher reqDispatch = null;
		PrintWriter printWriter = response.getWriter();

		// if this doesnt equal 0 it means we successfully logged in
		if(userService.login(username, password) != 0) {
			//create a new session object
			HttpSession session = request.getSession();
			session.setAttribute("username", username);
			
			//forwards to baseURI/success
			reqDispatch = request.getRequestDispatcher("success");
			reqDispatch.forward(request, response);
		}
		
		else {
			reqDispatch = request.getRequestDispatcher("index.html");
			reqDispatch.include(request, response);
			printWriter.print("<span style='color:red; text-align:center'>Invalid Username or Password</span>");
		}
	}
	
	
}
