package org.efrei.demo.dto;

import org.efrei.demo.globals.Category;
import org.efrei.demo.models.Movie;

public class CreateMovie {

    private String title;
    private Category category;

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

}
