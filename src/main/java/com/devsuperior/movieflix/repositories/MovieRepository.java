package com.devsuperior.movieflix.repositories;

import com.devsuperior.movieflix.entities.Genre;
import com.devsuperior.movieflix.entities.Movie;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

public interface MovieRepository extends JpaRepository<Movie,Long> {

    @Query("SELECT obj FROM Movie obj INNER JOIN obj.genre gen WHERE "
    + "(COALESCE(:genre) IS NULL OR gen IN :genre)")
    Page<Movie> find(Genre genre, Pageable pageable);
    
}
