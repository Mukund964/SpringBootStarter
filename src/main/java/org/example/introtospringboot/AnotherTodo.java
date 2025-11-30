package org.example.introtospringboot;

import org.springframework.context.annotation.Primary;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;

@Service
@Component("anotherTodo")
public class AnotherTodo implements TodoService{
    @Override
    public String doSomething() {
        System.out.println("doSomething from AnotherTodo");
        return "another todo";
    }
}
