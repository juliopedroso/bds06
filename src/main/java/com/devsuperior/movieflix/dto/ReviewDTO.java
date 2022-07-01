package com.devsuperior.movieflix.dto;

import com.devsuperior.movieflix.entities.Review;
import com.devsuperior.movieflix.entities.User;

public class ReviewDTO {

    private Long movieId;
    private String text;
    private UserDTO user;

    public ReviewDTO() {
    }

    public ReviewDTO(Long movieId, String text, User user) {
        this.movieId = movieId;
        this.text = text;
        this.user = new UserDTO(user);
    }

    public ReviewDTO(Review entity) {
        this.movieId = entity.getMovie().getId();
        this.text = entity.getText();
        this.user = new UserDTO(entity.getUser());
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

    public UserDTO getUser() {
        return user;
    }

    public void setUser(UserDTO user) {
        this.user = user;
    }

}
