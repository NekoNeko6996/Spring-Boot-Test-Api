package com.example.demo.controller;

import org.springframework.web.bind.annotation.*;
import java.util.ArrayList;
import java.util.List;
@RestController
@RequestMapping("/api/users")
public class UserController {

    // create list user
    private List<String> users = new ArrayList<>();

    public UserController() {
        users.add("User 1");
        users.add("User 2");
        users.add("User 3");
    }

    // GET method
    @GetMapping
    public List<String> getAllUsers() {
        return users;
    }

    // POST method
    @PostMapping
    public String createUser(@RequestBody String user) {
        users.add(user);
        return "User created: " + user;
    }

    // DELETE method
    @DeleteMapping("/{user}")
    public String deleteUser(@PathVariable String user) {
        if (users.contains(user)) {
            users.remove(user);
            return "User deleted: " + user;
        }
        return "User not found";
    }
}