package com.todo.rest.controller;

import com.todo.rest.entity.Todo;
import com.todo.rest.service.TodoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@CrossOrigin(origins = "http://localhost:4200")
public class TodoController {

    @Autowired
    private TodoService todoService;

    @GetMapping("/users/{userName}/todos")
    public List<Todo> getAllTodos(@PathVariable String userName){
        return todoService.findAll();
    }

    @DeleteMapping("/users/{userName}/todos/{id}")
    public ResponseEntity<Void> deleteTodo(@PathVariable String userName, @PathVariable long id){
        Todo todo = todoService.deleteTodo(id);
        if(todo!=null){
            return ResponseEntity.noContent().build();
        }
        return ResponseEntity.notFound().build();
    }

}
