package org.example.introtospringboot;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.http.RequestEntity;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import tools.jackson.databind.annotation.JsonAppend;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@RestController
@RequestMapping("/api/v1")
public class TodoController {
    private static List<Todo> todos;
    private TodoRepository todoRepository;

    private TodoService todoService1;
    private TodoService todoService2;

    public TodoController(@Qualifier("FakeToDo") TodoService todoService1, @Qualifier("anotherTodo") TodoService todoService2) {
        this.todoService1 = todoService1;
        this.todoService2 = todoService2;
        todos = new ArrayList<>();
        todos.add(new Todo(1,false,"Todo 1",1));
        todos.add(new Todo(2,true,"Todo 2",2));
    }


    @GetMapping("/todos")
    public List<Todo> getTodos() {
        return todos;
    }

    @PostMapping("/todos")
    public ResponseEntity<?> CreateTodo(@RequestBody Todo newTodo){
        Map<String,Object> response = new HashMap<>();
        response.put("status",true);
        response.put("message","Calling CreateTodo method" + this.todoService2.doSomething());
        response.put("data",newTodo);
        this.todoRepository.save(newTodo);
        return ResponseEntity.status(200).body(response);

    }

    @GetMapping("/todos/{id}")
    public ResponseEntity<?> getTodo(@PathVariable int id){
        for(Todo todo : todos){
            if(todo.getId() == id){
                return ResponseEntity.ok(todo);
            }
        }
        return ResponseEntity.status(404).body("Not Found" + this.todoService1.doSomething());
    }

    @GetMapping("/todos/")
    public ResponseEntity<?> getTodos(@RequestParam Boolean isCompleted){
        for (Todo todo : todos){
            if(todo.isCompleted() == isCompleted){
                return ResponseEntity.ok(todo);
            }
        }
        return ResponseEntity.status(404).body("Not Found");
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
