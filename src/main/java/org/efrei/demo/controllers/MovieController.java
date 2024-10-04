package org.efrei.demo.controllers;

import org.efrei.demo.dto.CreateMovie;
import org.efrei.demo.models.Movie;
import org.efrei.demo.services.MovieService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;


@RestController
@RequestMapping("/movies")
public class MovieController {
    
    private final MovieService service;
    
    @Autowired
    public MovieController(MovieService service) {
        this.service = service;
    }
    
    @GetMapping
    public ResponseEntity<List<Movie>> findAll() {
        return new ResponseEntity<>(service.findAll(), HttpStatus.OK);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<?> deleteById(@PathVariable String id) {
        Movie movie = service.findById(id);
        if (movie == null) {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
        service.deleteById(id);
        return new ResponseEntity<>(service.findById(id), HttpStatus.OK);
    }

    @PostMapping
    public ResponseEntity<?> create(@RequestBody CreateMovie createMovie) {
        service.create(createMovie);
        return new ResponseEntity<>(HttpStatus.CREATED);
    }

}
