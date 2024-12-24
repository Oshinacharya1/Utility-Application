package com.example.demo.Controllers;

import com.example.demo.Entity.Note;
import com.example.demo.Implementation.NotesImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

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


    // Edit an existing note
    @PutMapping("/edit/{id}")
    public ResponseEntity<Note> editNote(@PathVariable Long id, @RequestBody Note updatedNote) {
        System.out.println("Request received to edit a note with ID: " + id);
        Note note = noteImpl.editNote(id, updatedNote.getTitle(), updatedNote.getContents());
        return note != null ? ResponseEntity.ok(note) : ResponseEntity.notFound().build();
    }

    // Delete a note by ID
    @DeleteMapping("/delete/{id}")
    public ResponseEntity<String> deleteNote(@PathVariable Long id) {
        System.out.println("Request received to delete a note with ID: " + id);
        boolean isDeleted = noteImpl.deleteNote(id);
        return isDeleted
                ? ResponseEntity.ok("Note deleted successfully.")
                : ResponseEntity.status(404).body("Note not found.");
    }
}

