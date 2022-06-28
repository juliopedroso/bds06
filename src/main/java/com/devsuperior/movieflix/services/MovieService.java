package com.devsuperior.movieflix.services;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.devsuperior.movieflix.dto.MovieDTO;
import com.devsuperior.movieflix.entities.Movie;
import com.devsuperior.movieflix.repositories.MovieRepository;
import com.devsuperior.movieflix.services.exceptions.ResourceNotFoundException;

@Service
public class MovieService {

    @Autowired
    private MovieRepository repository;

    public List<MovieDTO> findAll(){
        List<Movie> movies = repository.findAll();
        
        return movies.stream().map(MovieDTO::new).collect(Collectors.toList());
    }

    public MovieDTO findById(Long id) {
        Optional<Movie> obj = repository.findById(id);
        Movie movie = obj.orElseThrow(() -> new ResourceNotFoundException("Entity not found"));

        return new MovieDTO(movie);
    }
}
