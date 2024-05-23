package com.notesystem.noteapi.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class ViewController {
	
	@GetMapping("/")
	public String showMainPage() {
	    return "home.html";
	}
	
	@GetMapping("/sign-in")
	public String showSignInPage() {
		return "login.html";
	}
	
	@GetMapping("/sign-up")
	public String showSignUpPage() {
		return "register.html";
	}
}
