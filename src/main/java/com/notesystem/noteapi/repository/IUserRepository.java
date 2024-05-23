package com.notesystem.noteapi.repository;

import org.springframework.stereotype.Repository;

import com.notesystem.noteapi.entity.User;

import org.springframework.data.jpa.repository.JpaRepository;

@Repository
public interface IUserRepository extends JpaRepository<User, Integer>{
	User findByUsername(String username);
}
