package com.notesystem.noteapi.service;

import java.util.List;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import com.notesystem.noteapi.entity.Note;

public interface INoteService extends IService<Note>{
	List<Note> getAll();
	Page<Note> getAll(Pageable pageable);
}
