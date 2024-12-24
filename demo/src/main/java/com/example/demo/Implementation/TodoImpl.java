package com.example.demo.Implementation;

import com.example.demo.Entity.Todo;
import com.example.demo.Repositories.TodoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;


@Service
public class TodoImpl {

    @Autowired
    private TodoRepository todoRepository;

    public Todo createTodo(Todo todo) {
        System.out.println("saving to database");
        return todoRepository.save(todo);

    }

    public List<Todo> viewAllTodo() {
        System.out.println("saving to database");
        return todoRepository.findAll();

    }


    public Todo editTodo(Long id, String title, String content) {
        Optional<Todo> existingTodo = todoRepository.findById(id);
        if (existingTodo.isPresent()) {
            Todo todo = existingTodo.get();
            todo.setTitle(title);
            todo.setContents(content);
            return todoRepository.save(todo);
        }
        return null;
    }


    public boolean deleteTodo(Long id) {
        if (todoRepository.existsById(id)) {
            todoRepository.deleteById(id);
            return true;
        }
        return false;
    }
}
