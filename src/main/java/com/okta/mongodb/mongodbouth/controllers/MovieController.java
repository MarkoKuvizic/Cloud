package com.okta.mongodb.mongodbouth.controllers;

import com.okta.mongodb.mongodbouth.model.Movie;
import com.okta.mongodb.mongodbouth.model.MovieDTO;
import com.okta.mongodb.mongodbouth.services.MovieService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController()
@RequestMapping("movies")
public class MovieController {
    @Autowired
    MovieService movieService;


    @PostMapping
    public ResponseEntity<Movie> postMovie(@RequestBody MovieDTO dto){
        Movie movie = new Movie();
        movie.year = dto.year;
        movie.name = dto.name;
        movie.genre = dto.genre;
        movieService.saveMovie(movie);
        return new ResponseEntity<Movie>(movie, HttpStatus.CREATED);

    }
    @GetMapping(value = "{id}")
    public ResponseEntity<Movie> getMovie(@PathVariable Long id){
        Optional<Movie> movie = movieService.getMovie(id);
        if (movie.isEmpty()){
            return new ResponseEntity<Movie>(HttpStatus.BAD_REQUEST);
        }
        return new ResponseEntity<Movie>(movie.get(), HttpStatus.OK);
    }
    @GetMapping
    public ResponseEntity<List<Movie>> getMovies(){
        return new ResponseEntity<List<Movie>>(movieService.getMovies(), HttpStatus.OK);
    }
}
