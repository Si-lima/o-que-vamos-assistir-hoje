package com.oqvah.api.controller;

import com.oqvah.api.model.AppUser;
import com.oqvah.api.service.AppUserService;

import org.springframework.web.bind.annotation.*;

import java.util.List;
import com.oqvah.api.dto.UserResponse;

@RestController
@RequestMapping("/api/users")
public class AppUserController {

    private final AppUserService service;

    public AppUserController(AppUserService service) {
        this.service = service;
    }

    @PostMapping
    public AppUser createUser(@RequestBody AppUser user) {
        return service.createUser(user);
    }

    @GetMapping
    public List<UserResponse> findAllUsers() {
        return service.findAllUsers();
    }
    @GetMapping("/{id}")
    public UserResponse findUserById(@PathVariable Long id) {
    return service.findUserById(id);
    }
}
