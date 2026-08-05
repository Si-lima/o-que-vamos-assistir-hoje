package com.oqvah.api.service;

import com.oqvah.api.dto.MovieResponse;
import com.oqvah.api.model.Movie;
import com.oqvah.api.repository.MovieRepository;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class MovieService {

    private final MovieRepository repository;

    public MovieService(MovieRepository repository) {
        this.repository = repository;
    }

    public Movie createMovie(Movie movie) {
        return repository.save(movie);
    }

    public List<MovieResponse> findAllMovies() {
        return repository.findAll().stream()
                .map(movie -> new MovieResponse(
                        movie.getId(),
                        movie.getTitle(),
                        movie.getGenre(),
                        movie.getReleaseYear(),
                        movie.getCreatedAt()
                ))
                .collect(Collectors.toList());
    }

    public MovieResponse findMovieById(Long id) {

        Movie movie = repository.findById(id)
                .orElseThrow(() ->
                        new RuntimeException("Filme não encontrado"));

        return new MovieResponse(
                movie.getId(),
                movie.getTitle(),
                movie.getGenre(),
                movie.getReleaseYear(),
                movie.getCreatedAt()
        );
    }
}