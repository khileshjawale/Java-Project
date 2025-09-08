package com.tyss.in.MovieManagementAPI.service.serviceimpl;

import com.tyss.in.MovieManagementAPI.DAO.MovieDao;
import com.tyss.in.MovieManagementAPI.Entity.Movie;
import com.tyss.in.MovieManagementAPI.service.MovieService;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class MovieServiceImpl implements MovieService {

    private final MovieDao movieDao;

    public MovieServiceImpl(MovieDao movieDao) {
        this.movieDao = movieDao;
    }

    @Override
    public void add(Movie movie) {
        movieDao.add(movie);
    }

    @Override
    public List<Movie> getAll() {
        return movieDao.fetchAll();
    }

    @Override
    public Optional<Movie> getById(int id) {
        return Optional.ofNullable(movieDao.fetchById(id));
    }

    @Override
    public void update(int id, Movie movie) {
        movieDao.updateById(id);
    }

    @Override
    public void delete(int id) {
        movieDao.removeById(id);
    }
}
