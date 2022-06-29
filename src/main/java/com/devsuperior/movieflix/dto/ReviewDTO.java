package com.devsuperior.movieflix.dto;

import com.devsuperior.movieflix.entities.Review;

public class ReviewDTO {

    private Long movieId;
    private String text;

    public ReviewDTO() {
    }

    public ReviewDTO(Long movieId, String text) {
        this.movieId = movieId;
        this.text = text;
    }

    public ReviewDTO(Review entity) {
        this.movieId = entity.getMovie().getId();
        this.text = entity.getText();
    }

    public Long getMovieId() {
        return movieId;
    }

    public void setMovieId(Long movieId) {
        this.movieId = movieId;
    }

    public String getText() {
        return text;
    }

    public void setText(String text) {
        this.text = text;
    }

}
