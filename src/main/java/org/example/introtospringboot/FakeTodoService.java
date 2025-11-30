package org.example.introtospringboot;

import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;

@Service
@Component("FakeToDo")
public class FakeTodoService implements TodoService {
    @Override
    @Timer
    public String doSomething() {
        for(int i=0; i<10000000; i++) {
        }
        System.out.println("doSomething from another todo");
        return "Something";
    }
}
