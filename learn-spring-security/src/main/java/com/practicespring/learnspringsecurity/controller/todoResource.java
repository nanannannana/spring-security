package com.practicespring.learnspringsecurity.controller;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class todoResource {

    private Logger logger = LoggerFactory.getLogger((getClass()));
    private static final List<Todo> TODO_LIST = List.of(new Todo("yeji1212", "Learn AWS"), new Todo("yeji1212", "Get AWS Certified"));

    @GetMapping("/todos")
    public List<Todo> retrieveAllTodos() {
        return TODO_LIST;
    }

    @GetMapping("/user/{username}/todos")
    public Todo retrieveAllTodosForASpecificUser(@PathVariable String username) {
        return TODO_LIST.get(0);
    }

    @PostMapping("/user/{username}/todos")
    public void createTodoForSpecificUser(@PathVariable String username, @RequestBody Todo todo) {
        logger.info("Create {} for {}", todo, username);
    }

}

record Todo (String username, String description) {}