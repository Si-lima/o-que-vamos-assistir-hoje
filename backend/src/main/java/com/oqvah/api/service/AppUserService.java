package com.oqvah.api.service;

import com.oqvah.api.model.AppUser;
import com.oqvah.api.repository.AppUserRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class AppUserService {

    private final AppUserRepository repository;

    public AppUserService(AppUserRepository repository) {
        this.repository = repository;
    }

    public AppUser createUser(AppUser user) {
        return repository.save(user);
    }

    public List<AppUser> findAllUsers() {
        return repository.findAll();
    }
}