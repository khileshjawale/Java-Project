package com.tyss.in.MovieManagementAPI.service;

import com.tyss.in.MovieManagementAPI.Entity.Movie;

import java.util.List;
import java.util.Optional;

public interface MovieService {

    public void add(Movie movie);
    public List<Movie> getAll();
    public Optional<Movie> getById(int id);
    public void update(int id, Movie movie);
    public void delete(int id);
}
