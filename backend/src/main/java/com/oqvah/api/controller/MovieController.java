package com.oqvah.api.controller;

import com.oqvah.api.dto.MovieResponse;
import com.oqvah.api.model.Movie;
import com.oqvah.api.service.MovieService;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/movies")
public class MovieController {

    private final MovieService service;

    public MovieController(MovieService service) {
        this.service = service;
    }

    @PostMapping
    public Movie createMovie(@RequestBody Movie movie) {
        return service.createMovie(movie);
    }

    @GetMapping
    public List<MovieResponse> findAllMovies() {
        return service.findAllMovies();
    }

    @GetMapping("/{id}")
    public MovieResponse findMovieById(@PathVariable Long id) {
        return service.findMovieById(id);
    }
}