package com.notesystem.noteapi.service.impl;

import org.springframework.stereotype.Service;

import com.notesystem.noteapi.common.GeneralException;
import com.notesystem.noteapi.entity.User;
import com.notesystem.noteapi.repository.IUserRepository;
import com.notesystem.noteapi.service.IUserService;

@Service
public class UserService implements IUserService{
	
	private IUserRepository userRepository;
	
	public UserService(IUserRepository userRepository) {
		this.userRepository = userRepository;
	}
	
	@Override
	public User save(User user) {
		if(user.getId()==null) {
			if(user.getPassword()==null || user.getPassword().length() < 6) {
				throw new GeneralException("Invalid password!");
			}
		}
		return this.userRepository.save(user);
	}

	@Override
	public User getById(Integer id) {
		return userRepository.findById(id).orElseThrow(()-> new GeneralException("User not found"));
	}

	@Override
	public void delete(Integer id) {
		if(!userRepository.existsById(id)) {
			throw new GeneralException("User not found");
		}
		userRepository.deleteById(id);
	}

	@Override
	public User findByUsername(String username) {
		return userRepository.findByUsername(username);
	}
	
}
