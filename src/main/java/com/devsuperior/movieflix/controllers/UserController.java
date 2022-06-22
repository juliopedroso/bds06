package com.devsuperior.movieflix.controllers;

import java.util.List;

import com.devsuperior.movieflix.dto.UserDTO;
import com.devsuperior.movieflix.services.UserService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/users")
public class UserController {

    @Autowired
    private UserService service;

    @GetMapping
    public ResponseEntity<List<UserDTO>> findAll() {
        List<UserDTO> users = service.findAll();

        return ResponseEntity.ok().body(users);
    }


    @GetMapping("/profile")
    public ResponseEntity<UserDTO> getProfile(){
        UserDTO dto = service.getProfile();

        return ResponseEntity.ok().body(dto);
    }

}
