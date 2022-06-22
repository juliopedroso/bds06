package com.devsuperior.movieflix.services;

import java.util.List;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.devsuperior.movieflix.dto.MovieDTO;
import com.devsuperior.movieflix.entities.Movie;
import com.devsuperior.movieflix.repositories.MovieRepository;

@Service
public class MovieService {

    @Autowired
    private MovieRepository repository;

    public List<MovieDTO> findAll(){
        List<Movie> movies = repository.findAll();
        
        return movies.stream().map(MovieDTO::new).collect(Collectors.toList());
    }

}
