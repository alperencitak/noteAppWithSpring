package com.notesystem.noteapi.controller;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.notesystem.noteapi.service.IUserService;

import jakarta.servlet.http.HttpSession;

@RestController
@RequestMapping("/noteapi/login")
public class LoginController {
	private IUserService userService;
	public LoginController(IUserService userService) {
		this.userService=userService;
	}
	
	public void createSession(HttpSession session, String username) {
		session.setAttribute("username", username);
	}
	
	public boolean validateUserCredentials(String username,String password) {
		if(userService.findByUsername(username)!=null && userService.findByUsername(username).getPassword().equals(password)) {
			return true;
		}
		return false;
	}
}
