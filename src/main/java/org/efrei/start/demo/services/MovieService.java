package org.efrei.start.demo.services;

import org.efrei.demo.dto.CreateMovie;
import org.efrei.demo.models.Movie;
import org.efrei.start.demo.repository.MovieRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class MovieService {

    private final MovieRepository movieRepository;

    @Autowired
    public MovieService(MovieRepository movieRepository) {
        this.movieRepository = movieRepository;
    }

    public List<Movie> findAll() {
        return movieRepository.findAll();
    }

    public Movie findById(String id) {
        return movieRepository.findById(id).orElse(null);
    }


    public void create(CreateMovie createMovie){
        Movie movie = new Movie();
        movie.setTitle(createMovie.getTitle());
        movie.setCategory(createMovie.getCategory());
        movieRepository.save(movie);
    }

    public void delebteById(String id) {
        movieRepository.deleteById(id);
    }

}
