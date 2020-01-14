package com.todo.rest.service;

import com.todo.rest.entity.Todo;
import com.todo.rest.repository.TodoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Optional;

@Service
public class TodoService {

    private static List<Todo> todos = new ArrayList();
    private static long idCounter = 0;
    @Autowired
    private TodoRepository todoRepository;

    static {
        todos.add(new Todo(++idCounter, "balaji", "Learn Angular", new Date(), false));
        todos.add(new Todo(++idCounter, "balaji", "Learn Angular Material", new Date(), false));
        todos.add(new Todo(++idCounter, "balaji", "Learn Spring Boot", new Date(), false));
        todos.add(new Todo(++idCounter, "balaji", "Learn JPA", new Date(), false));
        todos.add(new Todo(++idCounter, "balaji", "Learn Git Hub", new Date(), false));
    }

    public List<Todo> findAll(String userName){
        return todoRepository.findByUserName(userName);
    }

    public Todo findById(long id){
        return todoRepository.findById(id).get();
//        for(Todo todo: todos){
//            if(todo.getId() == id){
//                return todo;
//            }
//        }
//        return null;
    }

    public void deleteTodo(long id){
        todoRepository.deleteById(id);
//        Todo todo = findById(id);
//        if(todo !=null) {
//            todos.remove(todo);
//            return todo;
//        }else{
//            return null;
//        }
    }

    public Todo saveTodo(Todo todo){
        return todoRepository.save(todo);
//        if(todo.getId()==-1){
//            todo.setId(++idCounter);
//            todos.add(todo);
//        }else{
//            deleteTodo(todo.getId());
//            todos.add(todo);
//        }
//        return todo;
    }
}
