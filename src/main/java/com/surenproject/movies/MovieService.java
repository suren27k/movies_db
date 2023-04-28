package com.surenproject.movies;

import org.bson.types.ObjectId;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class MovieService
{
    @Autowired
    private MovieRepository movieRepo;
    public List<Movie> getAllMovies()
    {
        return movieRepo.findAll();
    }

    public Optional<Movie> getMovie(ObjectId id)
    {
        return movieRepo.findById(id);
    }

    public Optional<Movie> getMovieWithImdbId(String imdbId)
    {
        return movieRepo.findMovieByImdbId(imdbId);
    }
}
