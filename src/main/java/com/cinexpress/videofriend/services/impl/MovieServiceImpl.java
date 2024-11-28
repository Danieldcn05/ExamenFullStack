package com.cinexpress.videofriend.services.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.cinexpress.videofriend.models.Movie;
import com.cinexpress.videofriend.models.dtos.MovieDTO;
import com.cinexpress.videofriend.repository.MovieRepository;
import com.cinexpress.videofriend.services.MovieService;

@Service
public class MovieServiceImpl implements MovieService{

    @Autowired
    private MovieRepository movieRepository;

    @Override
    public Movie addMovie(MovieDTO movieDTO) {
        Movie newMovie = new Movie();

        newMovie.setTitle(movieDTO.getTitle());
        newMovie.setFormat(movieDTO.getFormat());
        newMovie.setGenre(movieDTO.getGenre());
        newMovie.setLanguage(movieDTO.getLanguage());
        newMovie.setAvailability(movieDTO.getAvailability());

        return movieRepository.save(newMovie);
    }

    @Override
    public Movie updateMovie(Long id,MovieDTO movieDTO) {
        Movie updatedMovie = movieRepository.findById(id).get();

        updatedMovie.setTitle(movieDTO.getTitle());
        updatedMovie.setFormat(movieDTO.getFormat());
        updatedMovie.setGenre(movieDTO.getGenre());
        updatedMovie.setLanguage(movieDTO.getLanguage());
        updatedMovie.setAvailability(movieDTO.getAvailability());

        return movieRepository.save(updatedMovie);
    }

    @Override
    public Movie updateAvailability(Long id) {
        Movie updatedMovie = movieRepository.findById(id).get();
        updatedMovie.setAvailability(!updatedMovie.getAvailability());
        return movieRepository.save(updatedMovie);
    }
    
}
