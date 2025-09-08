package com.tyss.in.MovieManagementAPI.DAO;

import com.tyss.in.MovieManagementAPI.Entity.Movie;

import java.util.List;

public interface MovieDao {
    public void add(Movie theMovie);
    public List<Movie> fetchAll();
    public Movie fetchById(int id);
    public void updateById(int id);
    public void removeById(int id);

}
