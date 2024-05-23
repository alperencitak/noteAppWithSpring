package com.notesystem.noteapi.service;

public interface IService <T>{
	T save(T t);
	T getById(Integer id);
	void delete(Integer id);
}
