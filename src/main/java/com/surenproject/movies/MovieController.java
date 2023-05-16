package com.surenproject.movies;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@CrossOrigin(origins = "http://localhost:3000")
@RequestMapping("/api/v1/movies")
public class MovieController
{
    @Autowired
    private MovieService movieService;
    @GetMapping
    public ResponseEntity<List<Movie>> getAllMovies()
    {
        List<Movie> moviesList = movieService.getAllMovies();

        System.out.println(moviesList);

        return new ResponseEntity<List<Movie>>(moviesList, HttpStatus.OK);
    }

//    @GetMapping("/{id}")
//    public ResponseEntity<Optional<Movie>> getMovie(@PathVariable ObjectId id)
//    {
//        Optional<Movie> movie = movieService.getMovie(id);
//        return new ResponseEntity<Optional<Movie>>(movie, HttpStatus.OK);
//    }

    @GetMapping("/{imdbId}")
    public ResponseEntity<Optional<Movie>> getMovie(@PathVariable String imdbId)
    {
        Optional<Movie> movie = movieService.getMovieWithImdbId(imdbId);
        return new ResponseEntity<Optional<Movie>>(movie, HttpStatus.OK);
    }
}
