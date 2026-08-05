package com.oqvah.api.service;

import com.oqvah.api.model.AppUser;
import com.oqvah.api.repository.AppUserRepository;
import org.springframework.stereotype.Service;
import com.oqvah.api.dto.UserResponse;
import java.util.stream.Collectors;

import java.util.List;

@Service
public class AppUserService {

    private final AppUserRepository repository;

    public AppUserService(AppUserRepository repository) {
        this.repository = repository;
    }

    public AppUser createUser(AppUser user) {

    if (repository.findByEmail(user.getEmail()).isPresent()) {
        throw new RuntimeException("E-mail já cadastrado");
    }

    return repository.save(user);
    }



    public List<UserResponse> findAllUsers() {
        return repository.findAll().stream()
                .map(user -> new UserResponse(
                        user.getId(),
                        user.getName(),
                        user.getEmail(),
                        user.getCreatedAt()
                ))
                .collect(Collectors.toList());
    }
    public UserResponse findUserById(Long id) {

    AppUser user = repository.findById(id)
            .orElseThrow(() -> new RuntimeException("Usuário não encontrado"));

    return new UserResponse(
            user.getId(),
            user.getName(),
            user.getEmail(),
            user.getCreatedAt());
    }
}