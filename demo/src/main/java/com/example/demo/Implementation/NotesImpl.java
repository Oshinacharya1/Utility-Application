package com.example.demo.Implementation;

import com.example.demo.Entity.Note;
import com.example.demo.Repositories.NoteRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;


@Service
public class NotesImpl {

    @Autowired
    private NoteRepository noteRepository;

    public Note createNote(Note note) {
        System.out.println("saving to database");
        return noteRepository.save(note);

    }

    public List<Note> viewAllNote() {
        System.out.println("saving to database");
        return noteRepository.findAll();

    }


    public Note editNote(Long id, String title, String content) {
        Optional<Note> existingNote = noteRepository.findById(id);
        if (existingNote.isPresent()) {
            Note note = existingNote.get();
            note.setTitle(title);
            note.setContents(content);
            return noteRepository.save(note); // Save the updated note
        }
        return null; // Return null if the note does not exist
    }

    // Delete a note by ID
    public boolean deleteNote(Long id) {
        if (noteRepository.existsById(id)) {
            noteRepository.deleteById(id);
            return true;
        }
        return false; // Return false if the note does not exist
    }
}
