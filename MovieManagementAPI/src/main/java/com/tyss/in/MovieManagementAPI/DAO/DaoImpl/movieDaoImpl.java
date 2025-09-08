package com.tyss.in.MovieManagementAPI.DAO.DaoImpl;

import com.tyss.in.MovieManagementAPI.DAO.MovieDao;
import com.tyss.in.MovieManagementAPI.Entity.Movie;
import jakarta.persistence.EntityManager;
import jakarta.persistence.Query;
import jakarta.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Scanner;

@Repository
public class movieDaoImpl implements MovieDao {
    private EntityManager theManager;

    @Autowired
    public movieDaoImpl(EntityManager theManager) {
        this.theManager = theManager;
    }

    @Override
    @Transactional
    public void add(Movie theMovie) {
        theManager.persist(theMovie);
    }

    @Override
    public List<Movie> fetchAll() {
        Query q=theManager.createQuery("Select m from Movie m");
        return q.getResultList();
    }

    @Override
    public Movie fetchById(int id) {
       return theManager.find(Movie.class,id);
    }

    @Override
    @Transactional
    public void updateById(int id) {
        Scanner sc=new Scanner(System.in);
        Movie isFound=theManager.find(Movie.class,id);
        if(isFound!=null)
        {
            System.out.println("Enter The Movie Title :-");
            isFound.setTitle(sc.nextLine());
            System.out.println("Enter The Movie Director :-");
            isFound.setDirector(sc.nextLine());
            System.out.println("Enter The Movie ReleaseYear :-");
            isFound.setReleaseYear(sc.nextInt());
            sc.nextLine();
            System.out.println("Enter The Movie Genre :-");
            isFound.setGenre(sc.nextLine());
            System.out.println("Enter The Movie Rating :-");
            isFound.setRating(sc.nextDouble());

            System.out.println("Movie Updated Successfully!");

        }
        else {
            System.out.println("Entered id is not found!");
        }
    }

    @Override
    @Transactional
    public void removeById(int id) {
        Movie isFound=theManager.find(Movie.class,id);
        if(isFound!=null)
        {
            theManager.remove(isFound);
        }
        else {
            System.out.println("Entered id is not found!");
        }
    }
}
