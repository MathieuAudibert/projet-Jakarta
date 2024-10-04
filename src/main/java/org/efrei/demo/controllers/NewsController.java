package org.efrei.demo.controllers;

import org.efrei.demo.dto.CreateNews;
import org.efrei.demo.models.News;
import org.efrei.demo.services.NewsService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/news")
public class NewsController {

    private final NewsService service;

    @Autowired
    public NewsController(NewsService service) {
        this.service = service;
    }

    @GetMapping
    public ResponseEntity<List<News>> findAll() {
        return new ResponseEntity<>(service.findAll(), HttpStatus.OK);
    }

    @PostMapping
    public ResponseEntity<?> create(@RequestBody CreateNews createNews) {
        service.create(createNews);
        return new ResponseEntity<>(HttpStatus.CREATED);
    }

}
