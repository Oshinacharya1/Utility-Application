package com.example.demo.Controllers;

import com.example.demo.Entity.Note;
import com.example.demo.Implementation.NotesImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public class NoteApiController {
    @Autowired
    private NotesImpl noteImpl;

    @PostMapping("/createNote")
    public ResponseEntity<Note> create_note(@RequestBody Note note){
        System.out.println("Request received - contents: " + note.getContents() + "title: " + note.getTitle());
        return ResponseEntity.ok(noteImpl.createNote(note));
    }

    @GetMapping("/viewAllNote")
    public List<Note>viewAllNote(){
        System.out.println("Request received to view all notes");
        return noteImpl.viewAllNote();
    }
}
