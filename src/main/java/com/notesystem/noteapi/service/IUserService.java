package com.notesystem.noteapi.service;

import com.notesystem.noteapi.entity.User;

public interface IUserService extends IService<User>{
	User findByUsername(String username);
}
