package org.example.introtospringboot;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import java.util.ArrayList;
import java.util.List;

@RestController
public class TodoController {
    private static List<Todo> todo;

    public TodoController(){
        todo = new ArrayList<>();
        todo.add(new Todo(1,false,"Todo 1",1));
        todo.add(new Todo(2,true,"Todo 2",2));

    }


    @GetMapping("/todos")
    public List<Todo> getTodos() {
        return todo;
    }

    @PostMapping("/todos")
    public Todo CreateTodo(@RequestBody Todo newTodo){
        todo.add(newTodo);
        return newTodo;

    }


}
