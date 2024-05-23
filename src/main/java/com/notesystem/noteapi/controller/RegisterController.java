package com.notesystem.noteapi.controller;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.notesystem.noteapi.entity.User;
import com.notesystem.noteapi.service.IUserService;

@RestController
@RequestMapping("/noteapi/register")
public class RegisterController {
	private IUserService userService;
	
	public RegisterController(IUserService userService) {
		this.userService=userService;
	}
	
	@PostMapping("/create-user")
	ResponseEntity<User> createUser(@RequestBody User user){
		return ResponseEntity.ok(userService.save(user));
	}
}
