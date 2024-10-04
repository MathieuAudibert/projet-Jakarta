package org.efrei.demo.services;

import org.efrei.demo.dto.CreateMovie;
import org.efrei.demo.models.Movie;
import org.efrei.demo.repository.MovieRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class MovieService {

    private final MovieRepository repository;

    @Autowired
    public MovieService(MovieRepository repository) {
        this.repository = repository;
    }

    public List<Movie> findAll(){
        return repository.findAll();
    }

    public Movie findById(String id){
        return repository.findById(id).orElse(null);
    }


    public void deleteById(String id) {
        repository.deleteById(id);
    }

    public void create(CreateMovie createMovie) {
        Movie movie = new Movie();
        movie.setTitle(createMovie.getTitle());
        movie.setCategory(createMovie.getCategory());
        repository.save(movie);
    }

}
