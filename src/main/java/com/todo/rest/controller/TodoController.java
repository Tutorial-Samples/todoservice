package com.todo.rest.controller;

import com.todo.rest.entity.Todo;
import com.todo.rest.service.TodoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import java.net.URI;
import java.util.List;

@RestController
@CrossOrigin(origins = "http://localhost:4200")
public class TodoController {

    @Autowired
    private TodoService todoService;

    /**
     * Retieves all the todos for a user
     * @param userName
     * @return
     */
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

    @GetMapping("/users/{userName}/todos/{id}")
    public Todo getTodoById(@PathVariable String userName, @PathVariable long id){
        return todoService.findById(id);
        //return ResponseEntity.ok().build();
    }

    @PutMapping("/users/{userName}/todos/{id}")
    public ResponseEntity<Todo> updateTodo(
            @PathVariable String userName,
            @PathVariable long id,
            @RequestBody Todo todo){
        Todo updatedTodo = todoService.saveTodo(todo);
        return new ResponseEntity<Todo>(todo, HttpStatus.OK);
    }

    @PostMapping("/users/{userName}/todos")
    public ResponseEntity<Void> updateTodo(
            @PathVariable String userName,
            @RequestBody Todo todo){
        Todo createdTodo = todoService.saveTodo(todo);
        URI uri = ServletUriComponentsBuilder.fromCurrentRequest().path("/{id}")
                .buildAndExpand(createdTodo.getId())
                .toUri();
        return ResponseEntity.created(uri).build();
    }

}
