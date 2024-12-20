package com.example.demo.Implementation;


import com.example.demo.Entity.Note;
import com.example.demo.Repositories.NoteRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service

public class NotesImpl {
    @Autowired
    private NoteRepository noteRepository;
    public Note createNote(Note note){
        return noteRepository.save(note);

    }
}
