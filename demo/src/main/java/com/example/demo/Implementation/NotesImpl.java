package com.example.demo.Implementation;


import com.example.demo.Entity.Note;
import com.example.demo.Repositories.NoteRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

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

}
