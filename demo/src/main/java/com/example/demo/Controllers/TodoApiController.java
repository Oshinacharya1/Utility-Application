package com.example.demo.Controllers;


import com.example.demo.Entity.Todo;
import com.example.demo.Implementation.TodoImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;


@RestController
public class TodoApiController {

    @Autowired
    private TodoImpl todoImpl;

    @PostMapping("/createTodo")
    public ResponseEntity<Todo> create_Todo(@RequestBody Todo todo){
        System.out.println("Request received - contents: " + todo.getContents() + "title: " + todo.getTitle());
        return ResponseEntity.ok(todoImpl.createTodo(todo));
    }

    @GetMapping("/viewAllTodo")
    public List<Todo>viewAllTodo(){
        System.out.println("Request received to view all todo");
        return todoImpl.viewAllTodo();
    }



    @PutMapping("/edit/{id}")
    public ResponseEntity<Todo> editTodo(@PathVariable Long id, @RequestBody Todo updatedTodo) {
        System.out.println("Request received to edit a todo with ID: " + id);
        Todo todo = todoImpl.editTodo(id, updatedTodo.getTitle(), updatedTodo.getContents());
        return todo != null ? ResponseEntity.ok(todo) : ResponseEntity.notFound().build();
    }


    @DeleteMapping("/delete/{id}")
    public ResponseEntity<String> deleteTodo(@PathVariable Long id) {
        System.out.println("Request received to delete a todo with ID: " + id);
        boolean isDeleted = todoImpl.deleteTodo(id);
        return isDeleted
                ? ResponseEntity.ok("Todo deleted successfully.")
                : ResponseEntity.status(404).body("Todo not found.");
    }
}

