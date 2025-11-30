package org.example.introtospringboot;

import org.springframework.stereotype.Service;

@Service
public class FakeTodoService implements TodoService {
    @Override
    public String doSomething() {
        System.out.println("doSomething from another todo");
        return "Something";
    }
}
