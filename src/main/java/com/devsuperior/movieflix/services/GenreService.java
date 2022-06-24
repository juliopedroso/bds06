package com.devsuperior.movieflix.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.autoconfigure.AutoConfigureOrder;
import org.springframework.stereotype.Service;

import com.devsuperior.movieflix.dto.GenreDTO;
import com.devsuperior.movieflix.entities.Genre;
import com.devsuperior.movieflix.repositories.GenreRepository;

@Service
public class GenreService {

    @Autowired
    private GenreRepository repository;

    public List<GenreDTO> findAll() {
        List<Genre> list = repository.findAll();
        return list.stream().map(GenreDTO::new).toList();
    }

}