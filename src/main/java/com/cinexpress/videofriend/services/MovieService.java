package com.cinexpress.videofriend.services;

import com.cinexpress.videofriend.models.Movie;
import com.cinexpress.videofriend.models.dtos.MovieDTO;

public interface MovieService {
    Movie addMovie(MovieDTO movieDTO);
    Movie updateMovie(Long id,MovieDTO moveDTO);
    Movie updateAvailability(Long id);
}
