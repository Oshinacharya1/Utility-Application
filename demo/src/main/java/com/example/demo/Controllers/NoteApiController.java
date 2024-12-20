package com.example.demo.Controllers;

import com.example.demo.Entity.Note;
import com.example.demo.Implementation.NotesImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class NoteApiController {
    @Autowired
    private NotesImpl noteImpl;

    @PostMapping("/create-note")
    public ResponseEntity<Note> create_note(@RequestBody Note note){
        return ResponseEntity.ok(noteImpl.createNote(note));

    }
}
