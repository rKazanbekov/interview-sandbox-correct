package com.example.interview.web;

import com.example.interview.model.User;
import com.example.interview.repo.UserRepository;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/users")
public class UserController {
    private final UserRepository repo;

    public UserController(UserRepository repo) {
        this.repo = repo;
    }

    @GetMapping
    public List<User> all() {
        return repo.findAll();
    }

    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    public User create(@RequestBody User u) {
        return repo.save(u);
    }

    @GetMapping("/{id}")
    public User one(@PathVariable Long id) {
        return repo.findById(id).orElseThrow();
    }
}
