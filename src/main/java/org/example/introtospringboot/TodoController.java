package org.example.introtospringboot;

import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;

@RestController
public class TodoController {
    private static List<Todo> todos;

    public TodoController(){
        todos = new ArrayList<>();
        todos.add(new Todo(1,false,"Todo 1",1));
        todos.add(new Todo(2,true,"Todo 2",2));

    }


    @GetMapping("/todos")
    public List<Todo> getTodos() {
        return todos;
    }

    @PostMapping("/todos")
    public Todo CreateTodo(@RequestBody Todo newTodo){
        todos.add(newTodo);
        return newTodo;

    }

    @PatchMapping("/todo/{id}")
    public Todo updateTodoTitle(@PathVariable int id, @RequestBody String newTitle){
        for(Todo todo : todos){
            if(id == todo.getId()){
                todo.setTitle(newTitle);
                return todo;
            }
        }
        return null;
    }

    @DeleteMapping("/todo/{id}")
    public void deleteTodo(@PathVariable int id){
        for(Todo todo : todos){
            if(todo.getId() == id){
                todos.remove(todo);
                break;
            }
        }
    }


}
