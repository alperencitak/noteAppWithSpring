package com.notesystem.noteapi.service.impl;

import java.util.List;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import com.notesystem.noteapi.common.GeneralException;
import com.notesystem.noteapi.entity.Note;
import com.notesystem.noteapi.repository.INoteRepository;
import com.notesystem.noteapi.service.INoteService;

@Service
public class NoteService implements INoteService{
	
	private INoteRepository noteRepository;
	
	public NoteService(INoteRepository noteRepository) {
		this.noteRepository = noteRepository;
	}
	@Override
	public Note save(Note note) {
		if(note.getId()==null) {
			if(note.getNote()==null || note.getNote().length() > 2000) {
				throw new GeneralException("Invalid Note");
			}
		}
		return noteRepository.save(note);
	}

	@Override
	public Note getById(Integer id) {
		return noteRepository.findById(id).orElseThrow(()-> new GeneralException("Note does not exists"));
	}

	@Override
	public void delete(Integer id) {
		if(!noteRepository.existsById(id)) {
			throw new GeneralException("Note not found");
		}
		noteRepository.deleteById(id);
	}

	@Override
	public List<Note> getAll() {
		return noteRepository.findAll();
	}

	@Override
	public Page<Note> getAll(Pageable pageable) {
		return noteRepository.findAll(pageable);
	}

}
