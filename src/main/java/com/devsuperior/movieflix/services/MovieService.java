package com.devsuperior.movieflix.services;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import com.devsuperior.movieflix.dto.MovieDTO;
import com.devsuperior.movieflix.entities.Genre;
import com.devsuperior.movieflix.entities.Movie;
import com.devsuperior.movieflix.repositories.GenreRepository;
import com.devsuperior.movieflix.repositories.MovieRepository;
import com.devsuperior.movieflix.services.exceptions.ResourceNotFoundException;

@Service
public class MovieService {

    @Autowired
    private MovieRepository repository;
    @Autowired
    private GenreRepository genreRepository;

    public Page<MovieDTO> findAllPaged(Long genreId, Pageable pageable) {
        Genre genre = (genreId == 0 ? null : genreRepository.getOne(genreId));

        Page<Movie> movies = repository.find(genre, pageable);

        return movies.map(MovieDTO::new);
    }

    public MovieDTO findById(Long id) {
        Optional<Movie> obj = repository.findById(id);
        Movie movie = obj.orElseThrow(() -> new ResourceNotFoundException("Entity not found"));

        return new MovieDTO(movie);
    }
}
