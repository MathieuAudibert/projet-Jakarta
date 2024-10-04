package org.efrei.demo.models;

import jakarta.persistence.*;
import org.efrei.demo.globals.Category;

@Entity
public class Movie {

    @Id
    @GeneratedValue(strategy = GenerationType.UUID)
    private String id;

    @Column(name = "title", length = 50)
    private String title;

    @Column(name = "synopsis")
    private String synopsis;

    @Enumerated(EnumType.STRING)
    private Category category;

    public Movie(String title, Category category) {
        this.title = title;
        this.category = category;
    }

    public Movie() {
    }

    public String getId() {
        return id; // Ajout de la méthode getId()
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public Category getCategory() {
        return category;
    }

    public void setCategory(Category category) {
        this.category = category;
    }

    public String getSynopsis() {
        return synopsis;
    }

    public void setSynopsis(String synopsis) {
        this.synopsis = synopsis;
    }
}
