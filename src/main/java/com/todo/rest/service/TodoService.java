package com.todo.rest.service;

import com.todo.rest.entity.Todo;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

@Service
public class TodoService {

    private static List<Todo> todos = new ArrayList();
    private static long idCounter = 0;

    static {
        todos.add(new Todo(++idCounter, "balaji", "Learn Angular", new Date(), false));
        todos.add(new Todo(++idCounter, "balaji", "Learn Angular Material", new Date(), false));
        todos.add(new Todo(++idCounter, "balaji", "Learn Spring Boot", new Date(), false));
        todos.add(new Todo(++idCounter, "balaji", "Learn JPA", new Date(), false));
        todos.add(new Todo(++idCounter, "balaji", "Learn Git Hub", new Date(), false));
    }

    public List<Todo> findAll(){
        return todos;
    }

    public Todo findById(long id){
        for(Todo todo: todos){
            if(todo.getId() == id){
                return todo;
            }
        }
        return null;
    }

    public Todo deleteTodo(long id){
        Todo todo = findById(id);
        if(todo !=null) {
            todos.remove(todo);
            return todo;
        }else{
            return null;
        }
    }
}
