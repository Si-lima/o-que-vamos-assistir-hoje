package com.oqvah.api.controller;

import com.oqvah.api.model.AppUser;
import com.oqvah.api.service.AppUserService;

import org.springframework.web.bind.annotation.*;

import java.util.List;

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
    public List<AppUser> findAllUsers() {
        return service.findAllUsers();
    }
}
