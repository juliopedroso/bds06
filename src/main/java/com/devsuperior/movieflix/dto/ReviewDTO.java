package com.devsuperior.movieflix.dto;

import com.devsuperior.movieflix.entities.Review;
import com.devsuperior.movieflix.entities.User;

public class ReviewDTO {

    private long id;
    private Long movieId;
    private String text;
    private UserDTO user;

    public ReviewDTO() {
    }

    public ReviewDTO(Long id, Long movieId, String text, User user) {
        this.id = id;
        this.movieId = movieId;
        this.text = text;
        this.user = new UserDTO(user);
    }

    public ReviewDTO(Review entity) {
        id = entity.getId();
        movieId = entity.getMovie().getId();
        text = entity.getText();
        user = new UserDTO(entity.getUser());
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
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
