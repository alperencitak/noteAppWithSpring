package com.notesystem.noteapi.controller;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Sort;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.notesystem.noteapi.entity.Note;
import com.notesystem.noteapi.service.INoteService;

@RestController
@RequestMapping("/noteapi/notes")
public class NoteController {
	
	private INoteService noteService;
	
	public NoteController(INoteService noteService) {
		this.noteService = noteService;
	}
	
	@GetMapping
	ResponseEntity<Page<Note>> getNotes(@RequestParam(name="page", defaultValue = "0") Integer page, @RequestParam(name = "pageSize", defaultValue = "5") Integer pageSize){
		return ResponseEntity.ok(noteService.getAll(PageRequest.of(page, pageSize, Sort.by("id"))));
	}
	
	@GetMapping("/{id}")
	ResponseEntity<String> getNoteById(@PathVariable(name="id") Integer id){
		return ResponseEntity.ok(noteService.getById(id).getNote());
	}
	
	@PostMapping
	ResponseEntity<Note> saveNote(@RequestBody Note note){
		return ResponseEntity.ok(noteService.save(note));
	}
	
	@PostMapping("/{id}")
	ResponseEntity<Void> deleteNote(@RequestBody Integer id){
		noteService.delete(id);
		return ResponseEntity.ok().build();
	}

}
