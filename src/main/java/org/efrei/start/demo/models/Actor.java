package org.efrei.start.demo.models;

import jakarta.persistence.*;

@Entity
@Table(name = "actor")
public class Actor {
    @Id
    @GeneratedValue(strategy = GenerationType.UUID)
    private String id;

    @Column(name = "name", nullable = false)
    private String name;

    @Column(name = "firstname")
    private String firstName;

    @ManyToOne
    @JoinColumn(name = "movie_id")
    private Movie movie;




    public Actor(String name, String firstName) {
        this.name = name;
        this.firstName = firstName;
    }
    public Actor() {

    }
    public String getName() {
        return name;
    }
    public String getFirstName() {
        return firstName;
    }
    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }
    public void setName(String name) {
        this.name = name;
    }

    public void setMovie(Movie movie) {
        this.movie = movie;
    }

    public String getMovieId() {
        return movie.getId();
    }
}
