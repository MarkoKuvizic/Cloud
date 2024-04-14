package com.okta.mongodb.mongodbouth.services;

import com.okta.mongodb.mongodbouth.model.Movie;
import com.okta.mongodb.mongodbouth.repositories.MovieRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class MovieService {
    @Autowired
    MovieRepository movieRepository;
    public Optional<Movie> getMovie(Long id){
        return movieRepository.findById(id);
    }
    public List<Movie> getMovies(){ return movieRepository.findAll();}
    public void saveMovie(Movie movie){
        movieRepository.save(movie);
    }
}
