package com.cinexpress.videofriend.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.cinexpress.videofriend.models.Movie;
import com.cinexpress.videofriend.models.dtos.MovieDTO;
import com.cinexpress.videofriend.services.MovieService;

@RestController
@RequestMapping("/movie")
public class MovieControler {

    @Autowired
    private MovieService movieService;

    @PostMapping("")
    public ResponseEntity<Movie> addMovie(@RequestBody MovieDTO movieDTO) {
        Movie newMovie = movieService.addMovie(movieDTO);
        return new ResponseEntity<>(newMovie, HttpStatus.CREATED);
    }

    @PutMapping("/{id}")
    public ResponseEntity<Movie> updateMovie(@PathVariable Long id, @RequestBody MovieDTO movieDTO) {
        Movie updatedMovie = movieService.updateMovie(id,movieDTO);
        return new ResponseEntity<>(updatedMovie, HttpStatus.OK);
    }

    @PutMapping("/availability/{id}")
    public ResponseEntity<Movie> updateAvailability(@PathVariable Long id) {
        Movie updatedMovie = movieService.updateAvailability(id);
        return new ResponseEntity<>(updatedMovie, HttpStatus.OK);
    }
}
