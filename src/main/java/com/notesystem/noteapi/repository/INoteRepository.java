package com.notesystem.noteapi.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.notesystem.noteapi.entity.Note;

@Repository
public interface INoteRepository extends JpaRepository<Note, Integer>{
	
}
