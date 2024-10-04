package org.efrei.start.demo.services;

import org.efrei.demo.dto.CreateActor;
import org.efrei.demo.models.Actor;
import org.efrei.demo.models.Movie;
import org.efrei.start.demo.repository.ActorRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ActorService {

    private final MovieService movieService;
    private final ActorRepository repository;

    @Autowired
    public ActorService(MovieService movieService, ActorRepository repository) {
        this.movieService = movieService;
        this.repository = repository;
    }


    public List<Actor> findAll(){
        // SELECT * from actor
        System.out.println(repository.findAll());
        return repository.findAll();
    }

    public void create(CreateActor createActor) {
        // INSERT INTO actor VALUES(":firstname", ":values")
        Actor actor = new Actor();
        Movie movie = movieService.findById(createActor.getMovieId());
        actor.setName(actor.getName());
        actor.setFirstName(actor.getFirstName());

        actor.setMovie(movie);
        repository.save(actor);
    }

    public Actor findById(String id) {
        // SELECT * FROM actor WERE id = :id
        return repository.findById(id).orElse(null);
    }

    public void deleteById(String id) {
        repository.deleteById(id);
    }

    public void update(String id, Actor actor) {

        //UPDATE actor SET (firstname, name) VALUES (:firstname, :name) where id = :id;
        Actor updatedActor = findById(id);
        updatedActor.setFirstName(actor.getFirstName());
        repository.save(updatedActor);
    }
}