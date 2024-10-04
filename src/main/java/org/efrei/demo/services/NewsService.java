package org.efrei.demo.services;

import org.efrei.demo.dto.CreateNews;
import org.efrei.demo.models.Actor;
import org.efrei.demo.models.Movie;
import org.efrei.demo.models.News;
import org.efrei.demo.repository.NewsRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.HashSet;
import java.util.List;

@Service
public class NewsService {

    private final NewsRepository newsRepository;
    private final ActorService actorService;
    private final MovieService movieService;

    @Autowired
    public NewsService(NewsRepository newsRepository, ActorService actorService, MovieService movieService) {
        this.newsRepository = newsRepository;
        this.actorService = actorService;
        this.movieService = movieService;
    }

    public void create(CreateNews createNews) {
        News news = new News();
        news.setContent(createNews.getContent());

        Movie movie = movieService.findById(createNews.getMovieId());
        if (movie != null) {
            news.getMovies().add(movie);
        } else {
            throw new RuntimeException("pas di'd " + createNews.getMovieId());
        }

        newsRepository.save(news);
    }



    public List<News> findAll() {
        return newsRepository.findAll();
    }
}
