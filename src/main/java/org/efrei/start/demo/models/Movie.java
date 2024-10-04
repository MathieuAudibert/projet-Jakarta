package org.efrei.start.demo.models;

import jakarta.persistence.*;
import org.efrei.start.demo.globals.Category;

@Entity
public class Movie {


    @Id
    @GeneratedValue(strategy = GenerationType.UUID)

    private String id;

    private String title;


    @Enumerated(EnumType.STRING)
    private Category category;

    @OneToOne
    private Actor actor;

    public String getId() {return id;}

    public void setTitle(String title) {
        this.title = title;
    }

    public void setCategory(Category category) {
        this.category = category;
    }
}
